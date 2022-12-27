package com.example.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //создание нововго экрана без xml:
        TextView textView = new TextView(this); //
        textView.setText("Hello Android!");
        //textView.setText("Hello my new Android!"); //этот текст заменит предыдущий
        textView.setTextSize(22); //устанавливает размер текста
        setContentView(textView); //выводит текст
    }
}