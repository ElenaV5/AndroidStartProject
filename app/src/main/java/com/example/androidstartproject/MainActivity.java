package com.example.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*TextView textView = (TextView) findViewById(R.id.normal);
        textView.setText("Text from Java code");
        textView.setTextColor(Color.RED); //в запущенном приложении изменится вид одного из текстовых полей!*/

        //TextView textView = (TextView) findViewById(R.id.header);
        //textView.setText("Hello from Java!");


        //создание нововго экрана без xml:
        /*TextView textView = new TextView(this); //
        textView.setText("Hello Android!");
        //textView.setText("Hello my new Android!"); //этот текст заменит предыдущий
        textView.setTextSize(22); //устанавливает размер текста
        setContentView(textView); //выводит текст*/

        //привязка по направляющим
        /*ConstraintLayout constraintLayout = new ConstraintLayout(this);

        TextView textView = new TextView(this);
        textView.setText("Hello ANDROID!");
        textView.setTextSize(26);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID; //привязка к левому краю
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID; // привязка к верхнему краю
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID; // привязка к правому краю - текст будет посередине

        textView.setLayoutParams(layoutParams);

        constraintLayout.addView(textView);

        setContentView(constraintLayout);*/


    }
}