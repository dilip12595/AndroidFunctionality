package com.example.androidfunctionality.start_activity_for_result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfunctionality.R;

public class StartActivityForResultActivity extends AppCompatActivity {

    private EditText number1, number2;
    private TextView result;
    private Button openActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result_acticity);

        number1 = findViewById(R.id.edit_text_number1);
        number2 = findViewById(R.id.edit_text_number2);
        result = findViewById(R.id.text_view_result);
        openActivity = findViewById(R.id.button_open_activity2);

        openActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number1.getText().toString().equals("")
                    || number2.getText().toString().equals("")) {
                    Toast.makeText(StartActivityForResultActivity.this, "Please insert numbers", Toast.LENGTH_SHORT).show();
                } else {
                    int num1 = Integer.parseInt(number1.getText().toString());
                    int num2 = Integer.parseInt(number2.getText().toString());
                    Intent intent = new Intent(StartActivityForResultActivity.this, StartActivityForResult2.class);
                    intent.putExtra("number1", num1);
                    intent.putExtra("number2", num2);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int res = data.getIntExtra("result", 0);
                result.setText("Result:  " + res);
            }
            if (resultCode == RESULT_CANCELED) {
                result.setText("Nothing selected");
            }
        }
    }
}
