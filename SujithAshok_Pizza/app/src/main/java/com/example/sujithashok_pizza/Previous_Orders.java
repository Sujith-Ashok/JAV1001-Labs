package com.example.sujithashok_pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Previous_Orders extends AppCompatActivity
        implements View.OnClickListener{

    private String selectedPizzaTemp, orderTemp;
    private Button addOrders, btnPastHome;
    private TextView pastOr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous__orders);

        pastOr = findViewById(R.id.tvGetOrder);

        SharedPreferences PizzaSelect = getApplicationContext().getSharedPreferences("PizzaApp", Context.MODE_PRIVATE);
        selectedPizzaTemp = PizzaSelect.getString("PizzaName2", "");
        pastOr.setText(selectedPizzaTemp);

        addOrders = findViewById(R.id.buttonEnter);
        addOrders.setOnClickListener(this);

        btnPastHome = findViewById(R.id.buttonOCHome);
        btnPastHome.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.buttonEnter:
                pastOr.setText("");
                break;

            case R.id.buttonOCHome:
                Intent past = new Intent(Previous_Orders.this, MainActivity.class);
                startActivity(past);
                break;
        }
    }
}