package com.example.task21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondQuizActivity extends AppCompatActivity {
    Integer totalPoints = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_quiz);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        totalPoints = intent.getIntExtra("totalPoints",0);



        Button answerButton4 = findViewById(R.id.answerButton4);
        Button answerButton5 = findViewById(R.id.answerButton5);
        Button answerButton6 = findViewById(R.id.answerButton6);

        Button submitButton2 = findViewById(R.id.submitButton2);


        answerButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton5.setEnabled(true);
                answerButton6.setEnabled(true);
                answerButton4.setEnabled(false);

                answerButton4.setBackgroundColor(Color.GRAY);
                answerButton5.setBackgroundColor(0xD37BA2);
                answerButton6.setBackgroundColor(0xD37BA2);

            }
        });
        answerButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton4.setEnabled(true);
                answerButton6.setEnabled(true);
                answerButton5.setEnabled(false);

                answerButton5.setBackgroundColor(Color.GRAY);
                answerButton4.setBackgroundColor(0xD37BA2);
                answerButton6.setBackgroundColor(0xD37BA2);

            }
        });
        answerButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton5.setEnabled(true);
                answerButton4.setEnabled(true);
                answerButton6.setEnabled(false);

                answerButton6.setBackgroundColor(Color.GRAY);
                answerButton5.setBackgroundColor(0xD37BA2);
                answerButton4.setBackgroundColor(0xD37BA2);
            }
        });

        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (answerButton4.isEnabled()==false)
                {
                    totalPoints=totalPoints+1;
                    answerButton4.setBackgroundColor(Color.GREEN);

                }
                if (answerButton5.isEnabled()==false)
                {

                    answerButton4.setBackgroundColor(Color.GREEN);
                    answerButton5.setBackgroundColor(Color.RED);


                }if (answerButton6.isEnabled()==false)
                {

                    answerButton4.setBackgroundColor(Color.GREEN);
                    answerButton6.setBackgroundColor(Color.RED);


                }
                answerButton4.setEnabled(false);
                answerButton5.setEnabled(false);
                answerButton6.setEnabled(false);

                submitButton2.setText("Next");
                submitButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent(getApplicationContext(),ThirdQuizActitvity.class);
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