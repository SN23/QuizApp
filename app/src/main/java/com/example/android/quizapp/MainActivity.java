package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList questions = new ArrayList();

    TextView questionTextView;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioGroup radioGroup;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    EditText writtenAns;

    int currentPosition = 0;
    String selectedAns = "";
    int correctAns = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTextView = (TextView) findViewById(R.id.Question);
        questions.add(getResources().getString(R.string.question1));
        questions.add(getResources().getString(R.string.question2));
        questions.add(getResources().getString(R.string.question3));
        questions.add(getResources().getString(R.string.question4));
        questions.add(getResources().getString(R.string.question5));

        questionTextView.setText(questions.get(currentPosition).toString());
        radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        radioButton1.setText(getResources().getString(R.string.q1Incorrect1));
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton2.setText(getResources().getString(R.string.q1Incorrect2));
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton3.setText(getResources().getString(R.string.q1Incorrect3));
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton4.setText(getResources().getString(R.string.q1correct));
        writtenAns = (EditText) findViewById(R.id.writtenAns);
        writtenAns.setVisibility(View.INVISIBLE);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox1.setVisibility(View.INVISIBLE);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox2.setVisibility(View.INVISIBLE);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox3.setVisibility(View.INVISIBLE);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox4.setVisibility(View.INVISIBLE);


    }

    public void nextQuestion(View view) {
        if (currentPosition == 4) {
            checkAnswer(currentPosition);
            currentPosition++;
        }
        if (currentPosition < 4) {
            checkAnswer(currentPosition);
            currentPosition++;
            changeAnswerSelection();
            questionTextView.setText(questions.get(currentPosition).toString());
        }
        radioGroup.clearCheck();
    }

    public void getScore(View view) {
        double percentCorrect = correctAns / 5;
        Toast.makeText(getApplicationContext(), "Percent: " + percentCorrect, Toast.LENGTH_LONG);
    }

    public String getSelectedAns() {
        writtenAns = (EditText) findViewById(R.id.writtenAns);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.radioButton:
                        selectedAns = "ans1";
                        break;
                    case R.id.radioButton2:
                        selectedAns = "ans2";

                    case R.id.radioButton3:
                        selectedAns = "ans3";

                    case R.id.radioButton4:
                        selectedAns = "ans4";
                        break;
                }
            }
        });

        radioGroup.clearCheck();
        if (!(writtenAns.getText().toString().equals(""))) {
            selectedAns = writtenAns.getText().toString();
        }

        
        return selectedAns;
    }

    public void changeAnswerSelection() {

        if (currentPosition == 0) {
            radioButton1.setText(getResources().getString(R.string.q1Incorrect1));
            radioButton2.setText(getResources().getString(R.string.q1Incorrect2));
            radioButton3.setText(getResources().getString(R.string.q1Incorrect3));
            radioButton4.setText(getResources().getString(R.string.q1correct));
        }

        if (currentPosition == 1) {
            radioButton1.setVisibility(View.INVISIBLE);
            radioButton2.setVisibility(View.INVISIBLE);
            radioButton3.setVisibility(View.INVISIBLE);
            radioButton4.setVisibility(View.INVISIBLE);
            writtenAns.setVisibility(View.VISIBLE);
        }

        if (currentPosition == 2) {
            radioButton1.setVisibility(View.INVISIBLE);
            radioButton2.setVisibility(View.INVISIBLE);
            radioButton3.setVisibility(View.INVISIBLE);
            radioButton4.setVisibility(View.INVISIBLE);
            writtenAns.setVisibility(View.INVISIBLE);
            checkBox1.setVisibility(View.VISIBLE);
            checkBox2.setVisibility(View.VISIBLE);
            checkBox3.setVisibility(View.VISIBLE);
            checkBox4.setVisibility(View.VISIBLE);

            checkBox1.setText(getResources().getString(R.string.q3correct1));
            checkBox2.setText(getResources().getString(R.string.q3correct2));
            checkBox3.setText(getResources().getString(R.string.q3correct3));
            checkBox4.setText(getResources().getString(R.string.q3Incorrect));

        }

        if (currentPosition == 3) {
            radioButton1.setVisibility(View.VISIBLE);
            radioButton2.setVisibility(View.VISIBLE);
            radioButton3.setVisibility(View.VISIBLE);
            radioButton4.setVisibility(View.VISIBLE);
            writtenAns.setVisibility(View.INVISIBLE);
            checkBox1.setVisibility(View.INVISIBLE);
            checkBox2.setVisibility(View.INVISIBLE);
            checkBox3.setVisibility(View.INVISIBLE);
            checkBox4.setVisibility(View.INVISIBLE);

            radioButton1.setText(getResources().getString(R.string.q4correct1));
            radioButton2.setText(getResources().getString(R.string.q4Incorrect1));
            radioButton3.setText(getResources().getString(R.string.q4Incorrect2));
            radioButton4.setText(getResources().getString(R.string.q4Incorrect3));
        }

        if (currentPosition == 4) {
            radioButton1.setText(getResources().getString(R.string.q5Incorrect1));
            radioButton2.setText(getResources().getString(R.string.q5Incorrect2));
            radioButton3.setText(getResources().getString(R.string.q5Incorrect3));
            radioButton4.setText(getResources().getString(R.string.q5correct));
        }
    }


    public void checkAnswer(int currentPosition) {

        if (currentPosition == 0) {
            if (getSelectedAns().equals("ans4")) {
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                correctAns++;
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
            }
        }

        if (currentPosition == 1) {
            if (selectedAns.equalsIgnoreCase("Nismo")) {
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                correctAns++;
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
            }
        }

        if (currentPosition == 2) {
            if (selectedAns.equals("correct")) {
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                correctAns++;
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
            }
        }

        if (currentPosition == 3) {
            if (selectedAns.equals("ans1")) {
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                correctAns++;
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
            }
        }

        if (currentPosition == 4) {
            if (selectedAns.equals("ans4")) {
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                correctAns++;
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
            }
        }
    }
}