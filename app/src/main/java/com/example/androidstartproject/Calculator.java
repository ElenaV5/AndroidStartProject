package com.example.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    private static final String LogcatTag = "CALCULATOR_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.buttonCalc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LogcatTag, "Button have been pushed");
                calculateAnswer();
            }
        });

    }

    private void calculateAnswer() {
        EditText numbOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numbTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);
        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton subtract = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiple = (RadioButton) findViewById(R.id.multiple);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);
        TextView answer = (TextView) findViewById(R.id.result);

        Log.d(LogcatTag, "All views have been founded");

        float numbone = Integer.parseInt(numbOne.getText().toString());
        float numbtwo = Integer.parseInt(numbTwo.getText().toString());

        Log.d(LogcatTag, "Successfully grabbed data from input fields");
        Log.d(LogcatTag, "numbone is: " + numbone + " ; " + "numbtwo is: " + numbtwo);

        float solution = 0;

        if(add.isChecked()){
            Log.d(LogcatTag, "Operation is add");
            solution = numbone + numbtwo;
        }
        if (subtract.isChecked()) {
            Log.d(LogcatTag, "Operation is subtract");
            solution = numbone - numbtwo;
        }
        if (multiple.isChecked()) {
            Log.d(LogcatTag, "Operation is multiple");
            solution = numbone * numbtwo;
        }
        if (divide.isChecked()) {
            Log.d(LogcatTag, "Operation is divide");
            if (numbtwo == 0) {
                Toast.makeText(this, "Number two cannot be zero", Toast.LENGTH_LONG).show();
                return;
            }
            solution = numbone / numbtwo;
        }
        Log.d(LogcatTag, "The result of operations is: " + solution);

        answer.setText("The answer is " + solution);
    }
}