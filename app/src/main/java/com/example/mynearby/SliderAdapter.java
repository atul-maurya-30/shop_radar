package com.example.mynearby;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

    private final List<Integer> imageList;  // List of images (represented as Integer resource IDs)

    // Constructor to initialize the image list
    public SliderAdapter(List<Integer> imageList) {
        this.imageList = imageList;
    }

    // Inflate the slider_item layout and return a SliderViewHolder
    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, parent, false);
        return new SliderViewHolder(view);
    }

    // Bind the image resource to the ImageView in the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        // Get the image resource at the current position
        int imageResId = imageList.get(position);
        // Set the image resource to the ImageView
        holder.imageView.setImageResource(imageResId);
    }

    // Return the total number of items in the image list
    @Override
    public int getItemCount() {
        return imageList.size();
    }

    // ViewHolder class to hold the ImageView
    public static class SliderViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public SliderViewHolder(View itemView) {
            super(itemView);
            // Initialize the ImageView
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
