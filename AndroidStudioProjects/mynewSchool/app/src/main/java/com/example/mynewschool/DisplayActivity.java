package com.example.mynewschool;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DisplayActivity extends AppCompatActivity {

    ListView listView;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Display Contacts");
        }
        listView = findViewById(R.id.listView);
        myDb = new DatabaseHelper(this);

        displayData();
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
    private void displayData() {
        // Query with aliasing ID as _id
        Cursor cursor = myDb.getReadableDatabase().rawQuery("SELECT ID AS _id, NAME, EMAIL, PHONE, MESSAGE, ADDRESS FROM " + DatabaseHelper.TABLE_NAME, null);


        String[] from = {DatabaseHelper.COL_2, DatabaseHelper.COL_3, DatabaseHelper.COL_4, DatabaseHelper.COL_5, DatabaseHelper.COL_6};
        int[] to = {R.id.name, R.id.email, R.id.phone, R.id.message, R.id.address};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_item, cursor, from, to, 0);
        listView.setAdapter(adapter);
    }


}
