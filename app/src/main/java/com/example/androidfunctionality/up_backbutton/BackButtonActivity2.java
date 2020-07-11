package com.example.androidfunctionality.up_backbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidfunctionality.R;

public class BackButtonActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_button2);

        getSupportActionBar().setTitle("Back Button 2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /*i have done this by using manifest file i have declared parent activity name in this activity*/
//    // to make back button click action (
//    @Override
//    public boolean onNavigateUp() {
//        finish();
//        return true;
//    }
}
