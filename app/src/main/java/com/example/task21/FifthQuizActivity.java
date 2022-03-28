package com.example.task21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FifthQuizActivity extends AppCompatActivity {
    Integer totalPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_quiz);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        totalPoints = intent.getIntExtra("totalPoints",0);

        Button answerButton13 = findViewById(R.id.answerButton13);
        Button answerButton14 = findViewById(R.id.answerButton14);
        Button answerButton15 = findViewById(R.id.answerButton15);

        Button submitButton5 = findViewById(R.id.submitButton5);


        answerButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton14.setEnabled(true);
                answerButton15.setEnabled(true);
                answerButton13.setEnabled(false);

                answerButton13.setBackgroundColor(Color.GRAY);
                answerButton14.setBackgroundColor(0xD37BA2);
                answerButton15.setBackgroundColor(0xD37BA2);

            }
        });

        answerButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton13.setEnabled(true);
                answerButton15.setEnabled(true);
                answerButton14.setEnabled(false);

                answerButton14.setBackgroundColor(Color.GRAY);
                answerButton13.setBackgroundColor(0xD37BA2);
                answerButton15.setBackgroundColor(0xD37BA2);

            }
        });
        answerButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton14.setEnabled(true);
                answerButton13.setEnabled(true);
                answerButton15.setEnabled(false);

                answerButton15.setBackgroundColor(Color.GRAY);
                answerButton14.setBackgroundColor(0xD37BA2);
                answerButton13.setBackgroundColor(0xD37BA2);
            }
        });

        submitButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (answerButton13.isEnabled()==false)
                {
                    totalPoints=totalPoints+1;
                    answerButton13.setBackgroundColor(Color.GREEN);

                }
                if (answerButton14.isEnabled()==false)
                {

                    answerButton13.setBackgroundColor(Color.GREEN);
                    answerButton14.setBackgroundColor(Color.RED);


                }if (answerButton15.isEnabled()==false)
                {

                    answerButton13.setBackgroundColor(Color.GREEN);
                    answerButton15.setBackgroundColor(Color.RED);


                }
                answerButton13.setEnabled(false);
                answerButton14.setEnabled(false);
                answerButton15.setEnabled(false);

                submitButton5.setText("Next");
                submitButton5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent(getApplicationContext(),ResultActivity.class);
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