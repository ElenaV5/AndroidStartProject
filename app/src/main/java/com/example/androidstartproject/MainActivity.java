package com.example.androidstartproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQ_C = 1;
    EditText et;
    TextView tv;

    ActivityResultLauncher<Intent> mStartActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    tv.setText(intent.getStringExtra("tv"));
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);



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

        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);

        Button btn1 = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.button:
                intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this, toInfActivity.class);
                String eText = et.getText().toString();
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this, ComeBackActivity.class);
                //startActivityForResult(intent, REQ_C); //устаревшее, сейчас не используется!
                mStartActivityForResult.launch(intent);
                break;
        }
    }

    /*@Override //устаревшее, не работает в Android X
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_OK:
                tv.setText(data.getStringExtra("et"));
                break;
        }
    }*/
}