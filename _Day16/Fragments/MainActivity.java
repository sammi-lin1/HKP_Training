package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected{
    TextView tvDescription;
    ArrayList<String> descriptions = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById((R.id.tvDescription));
        descriptions.add("Description for item 1");
        descriptions.add("Description for item 2");
        descriptions.add("Description for item 3");
    }

    //this method connects to fragment_list
    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(descriptions.get(index));
    }
}