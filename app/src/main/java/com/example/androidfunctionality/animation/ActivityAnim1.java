package com.example.androidfunctionality.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidfunctionality.R;

public class ActivityAnim1 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim1);

        findViewById(R.id.btn1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent= new Intent(ActivityAnim1.this, ActivityAnim2.class);
        startActivity(intent);
    }
}