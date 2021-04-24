package com.example.sujithashok_pizza;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private Button  btn1, btn2, btn3, btn7;
    public SharedPreferences PizzaSelect;
    private String selectPizza;
    private TextView PizzaName1, PizzaName2, PizzaName3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.buttonPizza3);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.buttonOne);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.buttonTwo);
        btn3.setOnClickListener(this);


        btn7 = findViewById(R.id.buttonPrevious);
        btn7.setOnClickListener(this);

        PizzaName1 = findViewById(R.id.textViewPizza1);
        PizzaName2 = findViewById(R.id.textViewPizza2);
        PizzaName3 = findViewById(R.id.textViewPizza3);

        PizzaSelect = getSharedPreferences("PizzaApp", Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonOne:
                selectPizza = (PizzaName1.getText().toString());

                Intent a = new Intent(MainActivity.this, Custom_Pizza.class);
                startActivity(a);

                break;
            case R.id.buttonTwo:
                selectPizza = (PizzaName2.getText().toString());

                Intent b = new Intent(MainActivity.this, Custom_Pizza.class);
                startActivity(b);
                break;

            case R.id.buttonPizza3:
                selectPizza = (PizzaName3.getText().toString());

                Intent f = new Intent(MainActivity.this, Custom_Pizza.class);
                startActivity(f);
                break;

            case R.id.buttonPrevious:
                selectPizza = "No orders yet";
                Intent e = new Intent(MainActivity.this, Previous_Orders.class);
                startActivity(e);
                break;


        }

        SharedPreferences.Editor pizzaSave = PizzaSelect.edit();

        pizzaSave.putString("PizzaName2",selectPizza);
        //pizzaSave.putFloat("price", //price)

        pizzaSave.commit();
    }
}