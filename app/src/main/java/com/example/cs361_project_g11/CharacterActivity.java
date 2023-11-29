package com.example.cs361_project_g11;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.widget.Toast;
import com.bdtopcoder.smart_slider.SliderAdapter;
import com.bdtopcoder.smart_slider.SliderItem;
import java.util.ArrayList;
import java.util.List;

public class CharacterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        ViewPager2 viewPager2 = findViewById(R.id.smartSlider);

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.character1,"image 1"));
        sliderItems.add(new SliderItem(R.drawable.character2,"Image 2"));
        sliderItems.add(new SliderItem(R.drawable.character3,"Image 3"));
        sliderItems.add(new SliderItem(R.drawable.character4,"image 4"));
        sliderItems.add(new SliderItem(R.drawable.character5,"Image 5"));
        sliderItems.add(new SliderItem(R.drawable.character6,"Image 6"));
        sliderItems.add(new SliderItem(R.drawable.character7,"image 7"));
        sliderItems.add(new SliderItem(R.drawable.character8,"Image 8"));
        sliderItems.add(new SliderItem(R.drawable.character9,"Image 9"));
        sliderItems.add(new SliderItem(R.drawable.character10,"image 10"));
        sliderItems.add(new SliderItem(R.drawable.character11,"Image 11"));
        sliderItems.add(new SliderItem(R.drawable.character12,"Image 12"));



        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2,5000));

        new SliderAdapter((position, title, view) -> {
            Toast.makeText(this, "Position: "+position+" Title: "+title, Toast.LENGTH_SHORT).show();
        });

    }
}
