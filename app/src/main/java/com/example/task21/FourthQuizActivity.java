package com.example.task21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourthQuizActivity extends AppCompatActivity {
    Integer totalPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_quiz);
        
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        totalPoints = intent.getIntExtra("totalPoints",0);

        Button answerButton10 = findViewById(R.id.answerButton10);
        Button answerButton11 = findViewById(R.id.answerButton11);
        Button answerButton12 = findViewById(R.id.answerButton12);

        Button submitButton4 = findViewById(R.id.submitButton4);




        answerButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton11.setEnabled(true);
                answerButton12.setEnabled(true);
                answerButton10.setEnabled(false);

                answerButton10.setBackgroundColor(Color.GRAY);
                answerButton11.setBackgroundColor(0xD37BA2);
                answerButton12.setBackgroundColor(0xD37BA2);

            }
        });
        answerButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton10.setEnabled(true);
                answerButton12.setEnabled(true);
                answerButton11.setEnabled(false);

                answerButton11.setBackgroundColor(Color.GRAY);
                answerButton10.setBackgroundColor(0xD37BA2);
                answerButton12.setBackgroundColor(0xD37BA2);

            }
        });
        answerButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButton11.setEnabled(true);
                answerButton10.setEnabled(true);
                answerButton12.setEnabled(false);

                answerButton12.setBackgroundColor(Color.GRAY);
                answerButton11.setBackgroundColor(0xD37BA2);
                answerButton10.setBackgroundColor(0xD37BA2);
            }
        });

        submitButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (answerButton10.isEnabled()==false)
                {
                    answerButton10.setBackgroundColor(Color.RED);
                    answerButton11.setBackgroundColor(Color.GREEN);


                }
                if (answerButton11.isEnabled()==false)
                {
                    totalPoints=totalPoints+1;
                    answerButton11.setBackgroundColor(Color.GREEN);


                }if (answerButton12.isEnabled()==false)
                {

                    answerButton11.setBackgroundColor(Color.GREEN);
                    answerButton12.setBackgroundColor(Color.RED);


                }
                answerButton10.setEnabled(false);
                answerButton11.setEnabled(false);
                answerButton12.setEnabled(false);

                submitButton4.setText("Next");
                submitButton4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent(getApplicationContext(),FifthQuizActivity.class);
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