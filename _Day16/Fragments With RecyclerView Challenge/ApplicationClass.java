package com.example.fragmentswithrecycleviewchallenge;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();

        cars = new ArrayList<Car>();
        cars.add(new Car("Volkswagen", "Polo", "Chuck Norris", "1234567890"));
        cars.add(new Car("Mercedes", "E200", "Peter Pollock", "1234255891"));
        cars.add(new Car("Nissan", "Almera", "Chris James", "0987654321"));
        cars.add(new Car("Mercedes", "E180", "John Rambo", "1357908642"));
        cars.add(new Car("Volkswagen", "Kombi", "Nelson Mandela", "1470986532"));
        cars.add(new Car("Nissan", "Navara", "Paul Bunting", "1590876432"));
    }
}
