// SetTimeActivity.java
package com.example.cs361_project_g11;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SetTimeActivity extends AppCompatActivity {

    private EditText focusText;
    private EditText timeHr;
    private EditText timeMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);

        focusText = findViewById(R.id.focusText);
        timeHr = findViewById(R.id.timeHr);
        timeMin = findViewById(R.id.timeMin);

        Button buttonFocus = findViewById(R.id.buttonFocus);

        buttonFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get selected time and work focus
                String selectedTime = timeHr.getText().toString() + ":" + timeMin.getText().toString();
                String workFocus = focusText.getText().toString();

                // Pass data to FocusActivity
                Intent intent = new Intent(SetTimeActivity.this, FocusActivity.class);
                intent.putExtra("SELECTED_TIME", selectedTime);
                intent.putExtra("WORK_FOCUS", workFocus);
                startActivity(intent);
            }
        });
    }
}
