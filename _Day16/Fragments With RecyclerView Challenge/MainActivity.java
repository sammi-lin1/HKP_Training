package com.example.fragmentswithrecycleviewchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked{
    Button btnCar, btnOwner;
    ImageView ivMake;
    TextView tvModel, tvName, tvTel;
    FragmentManager fragmentManager;
    Fragment buttonFrag, listFrag, carFrag, ownerFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connects variables to .xml values
        btnCar = findViewById(R.id.btnCar);
        btnOwner = findViewById(R.id.btnOwner);
        ivMake = findViewById(R.id.ivMake);
        tvModel = findViewById(R.id.tvModel);
        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);

        fragmentManager = getSupportFragmentManager();

        listFrag = fragmentManager.findFragmentById(R.id.listFrag);
        buttonFrag = fragmentManager.findFragmentById(R.id.buttonFrag);
        carFrag = fragmentManager.findFragmentById(R.id.carFrag);
        ownerFrag = fragmentManager.findFragmentById(R.id.ownerFrag);

        fragmentManager.beginTransaction()
                .show(buttonFrag)
                .show(listFrag)
                .show(carFrag)
                .hide(ownerFrag)
                .commit();

        btnOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .hide(carFrag)
                        .show(ownerFrag)
                        .commit();
            }
        });

        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .show(carFrag)
                        .hide(ownerFrag)
                        .commit();
            }
        });

        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {
        tvName.setText(ApplicationClass.cars.get(index).getOwnerName());
        tvModel.setText(ApplicationClass.cars.get(index).getModel());
        tvTel.setText(ApplicationClass.cars.get(index).getOwnerTel());

        if(ApplicationClass.cars.get(index).getMake().equals("Volkswagen")) {
            ivMake.setImageResource(R.drawable.volkswagen);
        }
        else if(ApplicationClass.cars.get(index).getMake().equals("Nissan")) {
            ivMake.setImageResource(R.drawable.nissan);
        }
        else {
            ivMake.setImageResource(R.drawable.mercedes);
        }
    }
}