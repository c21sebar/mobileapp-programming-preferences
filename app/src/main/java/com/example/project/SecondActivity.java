package com.example.project;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button mySecondButton;
    TextView secondTextView;
    Button save;
    EditText editText;

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mySecondButton = findViewById(R.id.secondActivityButton);
        secondTextView = findViewById(R.id.secondActivityText);
        save = findViewById(R.id.secondActivityButtonSave);
        editText = findViewById(R.id.secondActivityEditText);

        final String name = getIntent().getExtras().getString("name");
        secondTextView.setText(name);

        myPreferenceRef = getSharedPreferences("SharedPreference", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        String read = myPreferenceRef.getString("Reference","Saknar Data");
        secondTextView.setText(read);
        mySecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToMain();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondTextView.setText(editText.getText());
                myPreferenceEditor.putString("Reference", secondTextView.getText().toString());
                myPreferenceEditor.apply();

            }
        });
    }
    void goBackToMain(){
        finish();
    }
}
