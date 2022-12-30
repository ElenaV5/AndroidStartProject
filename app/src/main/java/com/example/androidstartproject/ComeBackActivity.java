package com.example.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.BreakIterator;

public class ComeBackActivity extends AppCompatActivity {

    EditText et;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_back);

        et = (EditText) findViewById(R.id.backTV);
        button = (Button) findViewById(R.id.sendBack);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("tv", et.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}