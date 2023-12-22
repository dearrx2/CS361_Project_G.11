package com.example.cs361_project_g11;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs361_project_g11.R;

import java.util.Calendar;

public class SetTimeActivity extends AppCompatActivity {

    private TextView selectedTimeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);

        selectedTimeTextView = findViewById(R.id.chooseTimeButton);
        Button chooseTimeButton = findViewById(R.id.chooseTimeButton);

        chooseTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });
    }

    private void showTimePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        // Do something with the selected time
                        String selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
                        selectedTimeTextView.setText(selectedTime);
                    }
                },
                hour,
                minute,
                true);

        timePickerDialog.show();
    }
}
