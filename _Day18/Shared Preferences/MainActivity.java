package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvWelcome;
    EditText etName;
    Button btnSubmit;

    //package name plus '.Name'
    public static final String MY_PREFS_FILENAME = "com.example.sharedpreferences.Names";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);
        etName = findViewById(R.id.etName);
        btnSubmit = findViewById(R.id.btnSubmit);

        //connection to file
        //calls preferences
        SharedPreferences prefs= getSharedPreferences(MY_PREFS_FILENAME, MODE_PRIVATE);
        //if the user key does not exist it will use ""
        String user = prefs.getString("user", "");

        tvWelcome.setText("Welcome to my app " + user + "!");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                tvWelcome.setText("Welcome to my app " + name + "!");

                //Creates new file:
                //Mode private only allows people with the specific file to access its data
                //edits preferences
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_FILENAME, MODE_PRIVATE).edit();
               //variable key name is user, data value is name
                editor.putString("user", name);
                editor.commit();
            }
        });

    }
}