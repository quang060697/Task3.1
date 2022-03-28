package com.example.task21;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstQuiz extends AppCompatActivity {
    Integer totalPoints = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_quiz);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Button answerButton1 = findViewById(R.id.answerButton1);
        Button answerButton2 = findViewById(R.id.answerButton2);
        Button answerButton3 = findViewById(R.id.answerButton3);

        Button submitButton = findViewById(R.id.submitButton2);

        TextView welcomeTextView = findViewById(R.id.welcomeTextView);

        welcomeTextView.setText("Welcome "+name);



        answerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton2.setEnabled(true);
                answerButton3.setEnabled(true);
                answerButton1.setEnabled(false);

                answerButton1.setBackgroundColor(Color.GRAY);
                answerButton2.setBackgroundColor(0xD37BA2);
                answerButton3.setBackgroundColor(0xD37BA2);

            }
        });
        answerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton1.setEnabled(true);
                answerButton3.setEnabled(true);
                answerButton2.setEnabled(false);

                answerButton2.setBackgroundColor(Color.GRAY);
                answerButton1.setBackgroundColor(0xD37BA2);
                answerButton3.setBackgroundColor(0xD37BA2);

            }
        });
        answerButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton2.setEnabled(true);
                answerButton1.setEnabled(true);
                answerButton3.setEnabled(false);

                answerButton3.setBackgroundColor(Color.GRAY);
                answerButton2.setBackgroundColor(0xD37BA2);
                answerButton1.setBackgroundColor(0xD37BA2);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerButton1.isEnabled()==false)
                {
                    totalPoints=0;
                    answerButton1.setBackgroundColor(Color.RED);
                    answerButton3.setBackgroundColor(Color.GREEN);


                }
                if (answerButton2.isEnabled()==false)
                {
                    totalPoints=0;
                    answerButton3.setBackgroundColor(Color.GREEN);
                    answerButton2.setBackgroundColor(Color.RED);


                }if (answerButton3.isEnabled()==false)
                {
                    totalPoints=1;
                    answerButton3.setBackgroundColor(Color.GREEN);


                }
                answerButton1.setEnabled(false);
                answerButton2.setEnabled(false);
                answerButton3.setEnabled(false);

                submitButton.setText("Next");
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent(getApplicationContext(),SecondQuizActivity.class);
                        intent1.putExtra("name",name);
                        intent1.putExtra("totalPoints",totalPoints);
                        startActivity(intent1);
                        finish();
                    }
                });

            }
        });



    }
}