package com.example.mynewschool;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Events");
        }

        RecyclerView eventsRecyclerView = findViewById(R.id.eventsRecyclerView);

        // Sample data
        List<Event> eventList = new ArrayList<>();
        eventList.add(new Event("Annual Day Celebration", "15 March 2025", "Celebrate the school's achievements with cultural programs."));
        eventList.add(new Event("Sports Day", "10 February 2025", "A day filled with sports and activities."));
        eventList.add(new Event("Science Exhibition", "5 January 2025", "Showcase innovative science projects by students."));
        eventList.add(new Event("Art & Craft Workshop", "20 December 2024", "Hands-on creative workshop for all grades."));

        EventAdapter adapter = new EventAdapter(eventList, this::onEventClick);
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventsRecyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        // Handle the back button click
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // This will navigate back to the previous activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void onEventClick(Event event) {
        Toast.makeText(this, "Clicked: " + event.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
