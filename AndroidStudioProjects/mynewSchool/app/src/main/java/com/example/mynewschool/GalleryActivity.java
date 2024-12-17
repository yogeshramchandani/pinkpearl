package com.example.mynewschool;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Gallery");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show the back button
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerViewGallery);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 3 columns in the grid

        // Prepare the image data (replace with actual image resources)
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.image1); // Add your drawable resources
        imageList.add(R.drawable.image2);
        imageList.add(R.drawable.image3);
        imageList.add(R.drawable.football);
        imageList.add(R.drawable.indoorgames);
        imageList.add(R.drawable.annualfunction);
        imageList.add(R.drawable.image1); // Add your drawable resources
        imageList.add(R.drawable.image2);
        imageList.add(R.drawable.image3);
        imageList.add(R.drawable.football);
        imageList.add(R.drawable.indoorgames);
        imageList.add(R.drawable.annualfunction);
        imageList.add(R.drawable.image1); // Add your drawable resources
        imageList.add(R.drawable.image2);
        imageList.add(R.drawable.image3);
        imageList.add(R.drawable.football);

        // Set up the adapter
        GalleryAdapter adapter = new GalleryAdapter(imageList);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Close the activity and go back to the previous screen
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
