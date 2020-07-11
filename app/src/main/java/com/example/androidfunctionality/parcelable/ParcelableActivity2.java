package com.example.androidfunctionality.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidfunctionality.R;

public class ParcelableActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView title = findViewById(R.id.title);
        TextView subTitle = findViewById(R.id.subTitle);

        Item item = getIntent().getParcelableExtra("Item");
        assert item != null;
        title.setText(item.getTitle());
        subTitle.setText(item.getSubTitle());
    }
}