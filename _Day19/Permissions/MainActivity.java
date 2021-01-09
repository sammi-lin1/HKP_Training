package com.example.permissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnPermissions;
    private static final int UNIQUE_REQUEST_CODE = 29389;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        btnPermissions = (Button) findViewById(R.id.btnPermissions);

        btnPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                        PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            UNIQUE_REQUEST_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "Permission granted! Thank you!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == UNIQUE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Thank you permission granted!", Toast.LENGTH_SHORT).show();
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setMessage("This permission is important to save a file to the phone! Please permit it!")
                        .setTitle("Important permission required!");

                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                    UNIQUE_REQUEST_CODE);
                        }
                    });

                    dialog.setNegativeButton("NO THANKS", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "Cannot be done!", Toast.LENGTH_SHORT).show();
                        }
                    });

                    dialog.show();
                }
                else {
                    Toast.makeText(this, "We will never show this to you again", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}