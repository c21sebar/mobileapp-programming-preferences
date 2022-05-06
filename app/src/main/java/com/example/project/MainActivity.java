package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Button nextActivity;
    Button save;
    TextView text;
    EditText editText;
    String textToNext;
    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nextActivity = findViewById(R.id.button2);
        save = findViewById(R.id.button);
        text = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        myPreferenceRef = getPreferences(MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();
        String read = myPreferenceRef.getString("Reference","Saknar Data");
        text.setText(read);

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            toSecondActivity();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            text.setText(editText.getText());
            textToNext = editText.getText().toString();
            myPreferenceEditor.putString("Reference", text.getText().toString());
            myPreferenceEditor.apply();

            }
        });
    }

    void toSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("extra", "" + textToNext);
        startActivity(intent);

    }

}
