package com.example.cs361_project_g11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class CharacterChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_choose);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        ArrayList<Integer> imageList = new ArrayList<>();

        // Add resource identifiers for your drawable images
        imageList.add(R.drawable.character1);
        imageList.add(R.drawable.character2);


        ImageAdapter adapter = new ImageAdapter(CharacterChooseActivity.this, imageList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onClick(ImageView imageView, Integer resourceId) {
                Intent intent = new Intent(CharacterChooseActivity.this, ImageViewActivity.class);
                intent.putExtra("image", resourceId);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(CharacterChooseActivity.this, imageView, "image");
                startActivity(intent, options.toBundle());
            }
        });

    }
}
