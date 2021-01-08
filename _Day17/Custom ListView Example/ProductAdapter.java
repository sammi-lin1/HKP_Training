package com.example.customlistviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    private final Context context;
    private final ArrayList<Product> values;

    public ProductAdapter(@NonNull Context context, ArrayList<Product> list) {
        super(context, R.layout.row_layout, list);
        this.context = context;
        values = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);

        TextView tvProduct = (TextView) rowView.findViewById(R.id.tvProduct);
        TextView tvPrice = (TextView) rowView.findViewById(R.id.tvPrice);
        TextView tvDescription = (TextView) rowView.findViewById(R.id.tvDescription);

        ImageView ivProduct = (ImageView) rowView.findViewById(R.id.ivProduct);
        ImageView ivSale = (ImageView) rowView.findViewById(R.id.ivSale);

        tvProduct.setText(values.get(position).getTitle());
        tvPrice.setText("R" + values.get(position).getPrice());
        tvDescription.setText(values.get(position).getDescription());

        if(values.get(position).getSale()) {
            ivSale.setImageResource((R.drawable.on_sale_big));
        }
        else {
            ivSale.setImageResource((R.drawable.best_price));
        }

        if(values.get(position).getType().equals("Laptop")) {
            ivProduct.setImageResource((R.drawable.laptop));
        }
        else if(values.get(position).getType().equals("Memory")) {
            ivProduct.setImageResource((R.drawable.memory));
        }
        else if(values.get(position).getType().equals("Screen")) {
            ivProduct.setImageResource((R.drawable.screen));
        }
        else {
            ivProduct.setImageResource((R.drawable.hdd));
        }

        return rowView;
    }
}
