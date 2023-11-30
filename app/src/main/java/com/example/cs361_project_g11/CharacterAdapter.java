package com.example.cs361_project_g11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private List<SliderItem> sliderItems;

    public CharacterAdapter(List<SliderItem> sliderItems) {
        this.sliderItems = sliderItems;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        SliderItem sliderItem = sliderItems.get(position);
        holder.imageView.setImageResource(sliderItem.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.characterImage);
        }
    }

    public static class SliderItem {
        private int imageResourceId;
        private String title;

        public SliderItem(int imageResourceId, String title) {
            this.imageResourceId = imageResourceId;
            this.title = title;
        }

        public int getImageResourceId() {
            return imageResourceId;
        }

        public String getTitle() {
            return title;
        }
    }
}
