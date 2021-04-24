package com.example.sujithashok_pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Order_Confirmation extends AppCompatActivity
        implements View.OnClickListener{

    private TextView price, tax, totalPrice;
    private float pricetemp, taxTemp, totalTemp;
    private Button btnOCPay, btnOCHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__confirmation);

        btnOCPay = findViewById(R.id.buttonOCPay);
        btnOCPay.setOnClickListener(this);


        btnOCHome = findViewById(R.id.buttonOCHome);
        btnOCHome.setOnClickListener(this);

        price = findViewById(R.id.textViewFinPrice);
        tax = findViewById(R.id.textViewTax);
        totalPrice = findViewById(R.id.textViewTotal);

        SharedPreferences PizzaSelect = getApplicationContext().getSharedPreferences("PriceTotal", Context.MODE_PRIVATE);
        pricetemp = PizzaSelect.getFloat("price", Float.parseFloat("0.00"));
        price.setText(String.valueOf(pricetemp));

        totalTemp  = Float.parseFloat(price.getText().toString());

        taxTemp = (float) (totalTemp * 0.13);

        tax.setText(String.valueOf(taxTemp));

        totalTemp = totalTemp + taxTemp;

        totalPrice.setText(String.valueOf(totalTemp));




    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonOCPay:
                Intent OC1 = new Intent(Order_Confirmation.this, Payment_Confirmation.class);
                startActivity(OC1);
                break;

            case R.id.buttonOCHome:
                Intent OC2 = new Intent(Order_Confirmation.this, MainActivity.class);
                startActivity(OC2);
                break;

        }
    }
}
