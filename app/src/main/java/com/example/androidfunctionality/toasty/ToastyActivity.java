package com.example.androidfunctionality.toasty;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.androidfunctionality.R;

import es.dmoral.toasty.Toasty;

public class ToastyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toasty);
    }

    public void showToast(View v) {
        switch (v.getId()) {
            case R.id.button_error:
                Toasty.error(this, "This is an error Toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_success:
                Toasty.success(this, "This is a success Toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_info:
                Toasty.info(this, "This is an info Toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_warning:
                Toasty.warning(this, "This is a warning Toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_normal:
                Toasty.normal(this, "This is a normal Toast", Toast.LENGTH_SHORT, ContextCompat.getDrawable(this, R.drawable.ic_search)).show();
                break;
        }
    }
}
