package com.example.task21;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.inputName);

        Button startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                if ( name.matches("")==false)
                {
                    Intent intent = new Intent(getApplicationContext(),FirstQuiz.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                    finish();
                }


            }
        });
        Intent intent1 = getIntent();
        String name = intent1.getStringExtra("name");
        inputName.setText(name);
    }


}