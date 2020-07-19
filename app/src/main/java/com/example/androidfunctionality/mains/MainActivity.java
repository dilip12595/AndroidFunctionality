package com.example.androidfunctionality.mains;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidfunctionality.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MainsData> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = this;

        // the following is to prevent the app from re-starting when launcher is clicked and app is in background
        if (!isTaskRoot()
            && getIntent().hasCategory(Intent.CATEGORY_LAUNCHER)
            && getIntent().getAction() != null
            && getIntent().getAction().equals(Intent.ACTION_MAIN)) {

            finish();
            return;
        }

        data();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);
        Adapter adapter = new Adapter(listData, context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void data() {
        listData = new ArrayList<>();
        listData.add(new MainsData("How to use the search view widget to filter a recycler view in real time.", MainsType.FIRST));
        listData.add(new MainsData("Toasty example.", MainsType.SECOND));
        listData.add(new MainsData("Array list to custom object to shared preference.", MainsType.THIRD));
        listData.add(new MainsData("Layout_dodgeinsetedges and layout_instedge.", MainsType.FOURTH));
        listData.add(new MainsData("UP/BACK button in appbar.", MainsType.FIFTH));
        listData.add(new MainsData("Option menu.", MainsType.SIXTH));
        listData.add(new MainsData("Popup menu.", MainsType.SEVENTH));
        listData.add(new MainsData("Random text view in relative layout.", MainsType.EIGHT));
        listData.add(new MainsData("Uses of startActivityForResult method.", MainsType.NINE));
        listData.add(new MainsData("Uses of Parcelable.", MainsType.TEN));
        listData.add(new MainsData("Execute code on first start only.", MainsType.ELEVEN));
    }

}
