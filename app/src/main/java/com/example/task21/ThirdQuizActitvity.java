package com.example.task21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdQuizActitvity extends AppCompatActivity {
    Integer totalPoints = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_quiz_actitvity);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        totalPoints = intent.getIntExtra("totalPoints",0);

        Button answerButton7 = findViewById(R.id.answerButton7);
        Button answerButton8 = findViewById(R.id.answerButton8);
        Button answerButton9 = findViewById(R.id.answerButton9);

        Button submitButton3 = findViewById(R.id.submitButton3);



        answerButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton8.setEnabled(true);
                answerButton9.setEnabled(true);
                answerButton7.setEnabled(false);

                answerButton7.setBackgroundColor(Color.GRAY);
                answerButton8.setBackgroundColor(0xD37BA2);
                answerButton9.setBackgroundColor(0xD37BA2);

            }
        });
        answerButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton7.setEnabled(true);
                answerButton9.setEnabled(true);
                answerButton8.setEnabled(false);

                answerButton8.setBackgroundColor(Color.GRAY);
                answerButton7.setBackgroundColor(0xD37BA2);
                answerButton9.setBackgroundColor(0xD37BA2);

            }
        });
        answerButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton8.setEnabled(true);
                answerButton7.setEnabled(true);
                answerButton9.setEnabled(false);

                answerButton9.setBackgroundColor(Color.GRAY);
                answerButton8.setBackgroundColor(0xD37BA2);
                answerButton7.setBackgroundColor(0xD37BA2);
            }
        });

        submitButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (answerButton7.isEnabled()==false)
                {
                    totalPoints=totalPoints+1;
                    answerButton7.setBackgroundColor(Color.GREEN);

                }
                if (answerButton8.isEnabled()==false)
                {

                    answerButton7.setBackgroundColor(Color.GREEN);
                    answerButton8.setBackgroundColor(Color.RED);


                }if (answerButton9.isEnabled()==false)
                {

                    answerButton7.setBackgroundColor(Color.GREEN);
                    answerButton9.setBackgroundColor(Color.RED);


                }
                answerButton7.setEnabled(false);
                answerButton8.setEnabled(false);
                answerButton9.setEnabled(false);

                submitButton3.setText("Next");
                submitButton3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent(getApplicationContext(),FourthQuizActivity.class);
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