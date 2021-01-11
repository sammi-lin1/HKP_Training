package com.example.testapp;

import android.app.Application;

import com.backendless.Backendless;

public class TestApplication extends Application {
    public static final String APPLICATION_ID = "D03DF73F-DB80-D3F8-FF5D-A4DBFBEB4200";
    public static final String API_KEY = "F75BC62D-2240-44FF-9716-5D9B52D552EF";
    public static final String SERVER_URL = "https://api.backendless.com";


    @Override
    public void onCreate() {
        super.onCreate();
        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APPLICATION_ID,
                API_KEY );
    }
}
