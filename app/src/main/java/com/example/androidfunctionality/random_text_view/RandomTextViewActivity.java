package com.example.androidfunctionality.random_text_view;

import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidfunctionality.R;

import java.util.Random;

public class RandomTextViewActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_text_view);

        textView = findViewById(R.id.textView);

        timer();
    }

    private void timer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                Random random = new Random();

                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);

                int random_width = random.nextInt(metrics.widthPixels -
                    textView.getWidth());
                int random_height = random.nextInt(metrics.heightPixels -
                    textView.getHeight());

//                if (random_width > (metrics.widthPixels - 100)) {
//                    random_width -= 50;
//                }
//
//                if (random_height > (metrics.heightPixels - 200)) {
//                    random_height -= 50;
//                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                layoutParams.width = metrics.widthPixels;
                layoutParams.height = metrics.heightPixels;

                if(random_width>0 && random_height>0) {

                    layoutParams.setMargins(random_width, random_height, 0, 0);
                    textView.setLayoutParams(layoutParams);
                }

                handler.postDelayed(this, 1000);
            }
        });
    }
}
