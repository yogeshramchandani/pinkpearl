package com.example.mynewschool;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Set a delay for the splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // After the delay, open the MainActivity (or your desired activity)
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();  // Finish the SplashActivity so the user can't navigate back to it
            }
        }, 3000); // 3 seconds delay
    }
}
