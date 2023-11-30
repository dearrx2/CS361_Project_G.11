package com.example.cs361_project_g11;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class CharacterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        List<CharacterAdapter.SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character1, "Image 1"));
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character2, "Image 2"));
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character3, "Image 3"));
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character4, "Image 4"));
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character5, "Image 5"));
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character6, "Image 6"));
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character7, "Image 7"));
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character8, "Image 8"));
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character9, "Image 9"));
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character10, "Image 10"));
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character11, "Image 11"));
        sliderItems.add(new CharacterAdapter.SliderItem(R.drawable.character12, "Image 12"));

        ViewPager2 viewPager = findViewById(R.id.smartSlider);
        CharacterAdapter characterAdapter = new CharacterAdapter(sliderItems);
        viewPager.setAdapter(characterAdapter);

        EditText nameEditText = findViewById(R.id.name);
        Button letsGoButton = findViewById(R.id.myButton);

        letsGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharacterAdapter.SliderItem selectedCharacter = sliderItems.get(viewPager.getCurrentItem());
                String selectedCharacterTitle = selectedCharacter.getTitle();
                String enteredName = nameEditText.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("selectedCharacterTitle", selectedCharacterTitle);
                editor.putString("enteredName", enteredName);
                editor.apply();


            }
        });
    }
}
