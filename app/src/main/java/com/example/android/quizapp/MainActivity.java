package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double correctAns = 0;
    int i = 0;

    RadioGroup radioGroupQ1;
    RadioGroup radioGroupQ4;
    RadioGroup radioGroupQ5;

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;

    EditText writtenAns;
    String selectedAnsQ1 = "";
    String selectedAnsQ4 = "";
    String selectedAnsQ5 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSelectedAns();
    }


    public void getScore(View view) {
        if (i < 1) {
            checkAns();
            i++;
        }
        double percentCorrect = (correctAns / 5) * 100;
        Toast.makeText(getApplicationContext(), "Percent: " + percentCorrect + "%", Toast.LENGTH_LONG).show();

    }

    public void getSelectedAns() {

        radioGroupQ1 = (RadioGroup) findViewById(R.id.radioGroupQ1);
        radioGroupQ1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton4Q1) {
                    selectedAnsQ1 = "correct";
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Answer ", Toast.LENGTH_LONG).show();
                }

            }
        });

        radioGroupQ4 = (RadioGroup) findViewById(R.id.radioGroupQ4);
        radioGroupQ4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.radioButtonQ4:
                        selectedAnsQ4 = "correct";
                        break;
                }
            }
        });

        radioGroupQ5 = (RadioGroup) findViewById(R.id.radioGroupQ5);
        radioGroupQ5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton3Q5:
                        selectedAnsQ5 = "correct";
                        break;
                }
            }
        });

    }


    public void checkAns() {


        if (selectedAnsQ1.equals("correct")) {
            correctAns++;
        }

        if (selectedAnsQ4.equals("correct")) {
            correctAns++;
        }

        if (selectedAnsQ5.equals("correct")) {
            correctAns++;
        }
        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);

        if (checkBox1.isChecked() == true && checkBox2.isChecked() == true && checkBox3.isChecked() == true && checkBox4.isChecked() == false) {
            correctAns++;
        }

        writtenAns = (EditText) findViewById(R.id.writtenAns);

        if ((writtenAns.getText().toString().equalsIgnoreCase("Nismo"))) {
            correctAns++;
        }


    }
}