package com.example.mynewschool;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class ContactUs extends AppCompatActivity {

    EditText etName, etRollNumber, etEmail, etPhone,etMessage,etAddress;
    Button btnSubmit, btnViewData;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactform);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Contact Form");
        }
        myDb = new DatabaseHelper(this);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etMessage=findViewById(R.id.etMessage);
        etPhone = findViewById(R.id.etPhone);
        btnSubmit = findViewById(R.id.btnSubmit);
        etAddress=findViewById(R.id.etAddress);

        // Handle Submit Button Click
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
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
    private void insertData() {
        String name = etName.getText().toString();
        String message=etMessage.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        String address=etAddress.getText().toString();
        if (name.isEmpty() ||  email.isEmpty() || phone.isEmpty() || message.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            SQLiteDatabase db = myDb.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.COL_2, name);
            contentValues.put(DatabaseHelper.COL_3, email);
            contentValues.put(DatabaseHelper.COL_4, phone);
            contentValues.put(DatabaseHelper.COL_5, message);
            contentValues.put(DatabaseHelper.COL_6, address);

            long result = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
            if (result == -1) {
                Toast.makeText(this, "Data insertion failed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etRollNumber.setText("");
                etEmail.setText("");
                etPhone.setText("");
            }
        }
    }
}
