package com.example.project;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button mySecondButton;
    TextView secondTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mySecondButton = findViewById(R.id.secondActivityButton);
        secondTextView = findViewById(R.id.secondActivityText);
        final String name = getIntent().getExtras().getString("name");
        secondTextView.setText(name);
        mySecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToMain();
            }
        });
    }
    void goBackToMain(){
        finish();
    }
}
