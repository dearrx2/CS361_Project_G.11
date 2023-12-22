
package com.example.cs361_project_g11;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FocusActivity extends AppCompatActivity {

    private TextView countdownTextView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);

        countdownTextView = findViewById(R.id.countdownTimer);

        // Create and start the MediaPlayer with looping
        mediaPlayer = MediaPlayer.create(this, R.raw.soft_rain_ambient);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

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
                // Calculate hours, minutes, and seconds from millisUntilFinished
                long hours = millisUntilFinished / (60 * 60 * 1000);
                long remainingMillis = millisUntilFinished % (60 * 60 * 1000);
                long minutes = remainingMillis / (60 * 1000);
                long seconds = (remainingMillis % (60 * 1000)) / 1000;

                // Update the countdownTextView with the remaining time
                countdownTextView.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            }

            @Override
            public void onFinish() {
                // Stop and release the MediaPlayer when the countdown finishes
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }

                countdownTextView.setText("Focus session completed!");
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
