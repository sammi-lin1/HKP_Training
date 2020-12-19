package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("tag", "In onCreate"); //deep
        Log.w("tag", "In onCreate"); //warning
        Log.i("tag", "In onCreate"); //information
        Log.e("tag", "In onCreate"); //error
    }
}