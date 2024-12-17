package com.example.mynewschool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private final List<GridItem> itemList;

    public GridAdapter(List<GridItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        GridItem item = itemList.get(position);
        holder.itemImage.setImageResource(item.getImageResId());
        holder.itemText.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemText;

        public GridViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);  // Correctly reference the ImageView
            itemText = itemView.findViewById(R.id.itemText);    // Correctly reference the TextView
        }
    }
}
