package com.example.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Calculator extends AppCompatActivity {

    private static final String LogcatTag = "CALCULATOR_ACTIVITY";
    private static final String LifecycleTag = "LIFECYCLE";

    Button btnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifecycleTag,"I'm onCreate(), and I'm started");
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.buttonCalc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LogcatTag, "Button have been pushed");
                try {
                    calculateAnswer();
                } catch (Exception e){
                    //прерывание:
                    //e.printStackTrace();
                    //Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    //finish();

                    //востановление:
                    e.printStackTrace();
                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    dropFields();
                }
                /*catch (IOException e){
                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    finish();
                }
                catch (ArithmeticException e){
                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    finish();
                }*/

                Intent i = new Intent(Calculator.this, MainActivity.class); // создание интента
                //startActivity(i); //запуск интента
            }
        });

        btnIntent = (Button) findViewById(R.id.simpleAct);

        /*btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Первый способ интента:
                Intent i = new Intent(Calculator.this, MainActivity.class); // создание интента
                startActivity(i); //запуск интента
            }
        });*/
    }








    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifecycleTag, "I'm onStart(), and I'm started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LifecycleTag, "I'm onStop() and I'm started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LifecycleTag,"I'm onDestroy() and I'm started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LifecycleTag, "I'm onPause() and I'm started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifecycleTag, "I'm onResume() and I'm started");
    }

    private void dropFields(){
        EditText numbOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numbTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);
        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton subtract = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiple = (RadioButton) findViewById(R.id.multiple);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        numbOne.setText("0"); //инициализация полей
        numbTwo.setText("0");
        add.setChecked(true);

        TextView answer = (TextView) findViewById(R.id.result);
        answer.setText("How we have problems. Try again later.");
    }

    private void calculateAnswer() throws ArithmeticException, IOException {
        EditText numbOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numbTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);
        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton subtract = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiple = (RadioButton) findViewById(R.id.multiple);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        numbOne.setText("0"); //инициализация полей
        numbTwo.setText("0");
        add.setChecked(true);

        TextView answer = (TextView) findViewById(R.id.result);

        Log.d(LogcatTag, "All views have been founded");

 /*       try {
            //int a = 25 / 0;
            throw new ArithmeticException("I'm generated exception");
        } catch (ArithmeticException e){
            //e.printStackTrace(); //выводит сообщение в логах
            Toast.makeText(this, "There's a problem inside the app!", Toast.LENGTH_SHORT).show(); //выведет сообщение пользователю
            finish(); //завершит активность специально!
        } //обработка исключения деления на 0
*/


        float numbone = 0;
        float numbtwo = 0;
        String num1 = numbOne.getText().toString();
        String num2 = numbTwo.getText().toString();
        if(!num1.equals("") && num1 != null) {
            numbone = Integer.parseInt(numbOne.getText().toString());
        }
        if(!num2.equals("") && num2 != null) {
            numbtwo = Integer.parseInt(numbTwo.getText().toString());
        }

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

        switch ((int) Math.random()*2){
            case 0 : throw new ArithmeticException("I'm generated arithmetical exception");
            case 1 : throw new IOException("I'm generated IO exception");
        }


    }
}