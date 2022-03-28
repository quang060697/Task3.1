package com.example.task21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Integer totalPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        totalPoints = intent.getIntExtra("totalPoints",0);

        Button newQuizButton = findViewById(R.id.newQuizButton);
        Button finishButton = findViewById(R.id.finishButton);


        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView scoreTextView = findViewById(R.id.scoreTextView);

        nameTextView.setText("Congratulations " + name );
        scoreTextView.setText(totalPoints + "/5");

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        newQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                intent1.putExtra("name",name);
                startActivity(intent1);
                finish();
            }
        });

    }
}