package com.example.mynewschool;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    DrawerLayout drawerLayout;
    ImageButton imageButtonToggle;
    NavigationView navigationView;

    private ViewPager2 viewPager2; // Use this class-level variable
    private int currentPage = 0;  // Track the current page in the ViewPager
    private final int totalPages = 4; // Total number of pages (images) in the slider
    private final int delay = 3000; // Delay between auto scrolls (in milliseconds)
    private final int pageChangeInterval = 5000; // Time interval between auto scrolls in milliseconds
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewPager2
        viewPager2 = findViewById(R.id.bannerSlider); // Use the class-level variable
        BannerAdapter adapter = new BannerAdapter();
        viewPager2.setAdapter(adapter);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns
        List<GridItem> items = new ArrayList<>();
        items.add(new GridItem(R.drawable.laboratory, "Laboratories"));
        items.add(new GridItem(R.drawable.football, "Outdoor Sports"));
        items.add(new GridItem(R.drawable.indoorgames, "Indoor Sports"));
        items.add(new GridItem(R.drawable.smartclasses, "Smart Classes"));

        GridAdapter gridAdapter = new GridAdapter(items);
        recyclerView.setAdapter(gridAdapter);

        // Initialize Handler and Runnable for auto-scrolling
        handler = new Handler(Looper.getMainLooper());
        runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage == totalPages) {
                    currentPage = 0; // Reset to the first page if we're at the last page
                }
                viewPager2.setCurrentItem(currentPage++, true); // Change to the next page
                handler.postDelayed(this, pageChangeInterval); // Re-run the runnable after the delay
            }
        };

        handler.postDelayed(runnable, delay); // Start the auto-scroll

        // Initialize DrawerLayout and NavigationView
        drawerLayout = findViewById(R.id.main);
        imageButtonToggle = findViewById(R.id.buttonDrawer);
        navigationView = findViewById(R.id.navigationView);

        imageButtonToggle.setOnClickListener(v -> drawerLayout.open()); // Open the drawer when button is clicked

        // Handle navigation item selections
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            int itemId = menuItem.getItemId();

            if (itemId == R.id.navMenu) {
                Toast.makeText(MainActivity.this, "Home Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            } else if (itemId == R.id.navAbout) {
                Toast.makeText(MainActivity.this, "About Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AboutPage.class);
                startActivity(intent);
            }
            else if (itemId == R.id.navContact) {
                Toast.makeText(MainActivity.this, "Contact Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ContactUs.class);
                startActivity(intent);
            }
            else if (itemId == R.id.contactList) {
                Toast.makeText(MainActivity.this, "Contact Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
            else if (itemId == R.id.navGallery) {
                Toast.makeText(MainActivity.this, "Gallery Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
            else if (itemId == R.id.navGallery) {
                Toast.makeText(MainActivity.this, "Gallery Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
            else if (itemId == R.id.navPrg) {
                Toast.makeText(MainActivity.this, "Gallery Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(intent);
            }


            drawerLayout.close(); // Close the drawer after selection
            return true;
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);  // Stop the auto-scrolling when the activity is destroyed
    }
}
