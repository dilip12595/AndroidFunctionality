package com.example.androidfunctionality.parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidfunctionality.R;

import java.util.ArrayList;

public class ParcelableActivity extends AppCompatActivity {

    private ArrayList<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        itemList = new ArrayList<>();
        itemList.add(new Item("Dilip","jaiswal"));
        itemList.add(new Item("Rajeev","prasad"));
        itemList.add(new Item("Rajdeep","mahto"));
        itemList.add(new Item("Dheeraj","tiari"));
        itemList.add(new Item("Rocky","thakur"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        Adapter adapter = new Adapter(itemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(ParcelableActivity.this, ParcelableActivity2.class);
                intent.putExtra("Item", itemList.get(position));
                startActivity(intent);
            }
        });

    }
}