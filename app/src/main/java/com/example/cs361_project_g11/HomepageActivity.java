package com.example.cs361_project_g11;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Log.d("HomepageActivity", "onCreate");
        View start_button = findViewById(R.id.start_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomepageActivity.this, SetTimeActivity.class));
            }
        });

        CardView cardView = findViewById(R.id.cardView);
        ImageView avatarImageView = findViewById(R.id.avatarImageView);
        TextView nameTextView = findViewById(R.id.nameTextView);


        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String characterTitle = preferences.getString("selectedCharacterTitle", "Character Name");
        String enteredName = preferences.getString("enteredName", "Default Name");


        avatarImageView.setImageResource(getImageResourceByTitle(characterTitle));
        nameTextView.setText(enteredName);
    }

    private int getImageResourceByTitle(String title) {
        switch (title) {
            case "Image 1":
                return R.drawable.character1;
            case "Image 2":
                return R.drawable.character2;
            case "Image 3":
                return R.drawable.character3;
            case "Image 4":
                return R.drawable.character4;
            case "Image 5":
                return R.drawable.character5;
            case "Image 6":
                return R.drawable.character6;
            case "Image 7":
                return R.drawable.character7;
            case "Image 8":
                return R.drawable.character8;
            case "Image 9":
                return R.drawable.character9;
            case "Image 10":
                return R.drawable.character10;
            case "Image 11":
                return R.drawable.character11;
            case "Image 12":
                return R.drawable.character12;
            default:
                return R.drawable.ic_launcher_foreground; // Default image
        }
    }
}
