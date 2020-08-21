package com.example.androidfunctionality.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidfunctionality.R;

public class MainAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anim);

        findViewById(R.id.btnMain).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent= new Intent(MainAnimationActivity.this, ActivityAnim1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}