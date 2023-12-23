// FocusActivity.java
package com.example.cs361_project_g11;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class FocusActivity extends AppCompatActivity {

    private TextView countdownTextView;
    private MediaPlayer mediaPlayer;
    private View stopButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);

        countdownTextView = findViewById(R.id.countdownTimer);
        mediaPlayer = MediaPlayer.create(this, R.raw.soft_rain_ambient);
        mediaPlayer.setLooping(false);

        stopButton = findViewById(R.id.stop_button); // Initialize the stop button

        // Set a click listener for the stop button
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopCountdown();
            }
        });

        String selectedTime = getIntent().getStringExtra("SELECTED_TIME");
        Toast.makeText(this, "Selected Time: " + selectedTime, Toast.LENGTH_SHORT).show();

        String[] timeParts = selectedTime.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        long totalTimeInMillis = (hours * 60 + minutes) * 60 * 1000;

        startCountdown(totalTimeInMillis);
    }

    private void startCountdown(long totalTimeInMillis) {
        new CountDownTimer(totalTimeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long hours = millisUntilFinished / (60 * 60 * 1000);
                long remainingMillis = millisUntilFinished % (60 * 60 * 1000);
                long minutes = remainingMillis / (60 * 1000);
                long seconds = (remainingMillis % (60 * 1000)) / 1000;

                countdownTextView.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            }

            @Override
            public void onFinish() {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }

                countdownTextView.setText("Focus session completed!");
                saveFocusSessionToDatabase(getIntent().getStringExtra("SELECTED_TIME"), getIntent().getStringExtra("WORK_FOCUS"));
                navigateToHistoryPage();
            }
        }.start();

        // Start playing audio when the activity starts
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    private void stopCountdown() {
        // Stop the countdown timer
        // Save the focus session details to the database
        saveFocusSessionToDatabase(getIntent().getStringExtra("SELECTED_TIME"), getIntent().getStringExtra("WORK_FOCUS"));
        navigateToHistoryPage();
    }

    private void saveFocusSessionToDatabase(String selectedTime, String workFocus) {
        FocusSession focusSession = new FocusSession();
        focusSession.selectedTime = selectedTime;
        focusSession.workFocus = workFocus;

        MyApp.database.focusSessionDao().insert(focusSession);
    }

    private void navigateToHistoryPage() {
        // Navigate to the history page
        Intent intent = new Intent(FocusActivity.this, HistoryActivity.class);
        startActivity(intent);

        // Finish the current activity (optional)
        finish();
    }
}
