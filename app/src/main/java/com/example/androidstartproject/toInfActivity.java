package com.example.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class toInfActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_inf);

        textView = (TextView) findViewById(R.id.tv);
        String str = getIntent().getStringExtra("et");
        textView.setText(str);
    }
}