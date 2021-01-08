package com.example.customlistviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvProducts;
    ArrayList<Product> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProducts = (ListView) findViewById(R.id.lvProducts);

        list = new ArrayList<Product>();

        Product p1 = new Product("Dell Latitude 3500", "Super luxurious laptop, only for the rich.", "Laptop", 999999.99, true);
        Product p2 = new Product("Acer Aspire", "Super mega cool laptop, only for the swag.", "Laptop", 88888.99, false);
        Product p3 = new Product("SANDISK 16 GB Cruzer", "For kids who need storage", "Memory", 1.99, true);
        Product p4 = new Product("Verbatim 1TB", "It's portable, exceptionally reliable, and fashionably thin", "Laptop", 999.99, false);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);



        ProductAdapter adapter= new ProductAdapter(this, list);
        lvProducts.setAdapter(adapter);
    }
}