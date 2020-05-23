package com.example.myexam.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.myexam.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
   new Handler().postDelayed(new Runnable() {
       @Override
       public void run() {
Intent intent = new Intent(SplashActivity.this,MainActivity.class);
 startActivity(intent);
 finish();
       }
   },5000);


    }
}
