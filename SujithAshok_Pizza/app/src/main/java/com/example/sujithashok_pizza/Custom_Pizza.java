package com.example.sujithashok_pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Custom_Pizza extends AppCompatActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    private Button btnCustNext, btnAMHome;
    private TextView selectCustPizza;
    public SharedPreferences orderPrice;
    private String selectedTemp;
    private RadioGroup sizeRadioGrp;
    private float finalPrice = 14, check1,check2,check3,check4,check5;
    private CheckBox ExtCheese, parCheese, garlicHerb, bbqSauce, cheChipotle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom__pizza);


        btnAMHome = findViewById(R.id.buttonAMHome);
        btnAMHome.setOnClickListener(this);

        btnCustNext = findViewById(R.id.btnCustNext);
        btnCustNext.setOnClickListener(this);

        selectCustPizza = findViewById(R.id.textViewSelected);

        sizeRadioGrp = findViewById(R.id.RGSize);
        sizeRadioGrp.setOnCheckedChangeListener(this);

        ExtCheese = findViewById(R.id.checkBoxEC);
        parCheese = findViewById(R.id.checkBoxPC);
        garlicHerb = findViewById(R.id.checkBoxGH);
        bbqSauce = findViewById(R.id.checkBoxBS);
        cheChipotle = findViewById(R.id.checkBoxCC);

        ExtCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ExtCheese.isChecked()){
                    check1 = 1;
                }
                else{
                    check1 = 0;
                }
            }
        });
        parCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(parCheese.isChecked()){
                    check2 = 1;
                }
                else{
                    check2 = 0;
                }
            }
        });
        garlicHerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(garlicHerb.isChecked()){
                    check3 = 0;
                }
                else{
                    check3 = 0;
                }
            }
        });
        bbqSauce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbqSauce.isChecked()){
                    check4 = 2;
                }
                else{
                    check4 = 0;
                }
            }
        });
        cheChipotle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cheChipotle.isChecked()){
                    check5 = 2;
                }
                else{
                    check5 = 0;
                }
            }
        });
        orderPrice = getSharedPreferences("PriceTotal", Context.MODE_PRIVATE);


        SharedPreferences PizzaSelect = getApplicationContext().getSharedPreferences("PizzaApp", Context.MODE_PRIVATE);
        selectedTemp = PizzaSelect.getString("PizzaName2", "");
        selectCustPizza.setText(selectedTemp);



    }

    @Override
    public void onCheckedChanged(RadioGroup RBSize, int checkedId) {
        switch (checkedId) {
            case R.id.RBsmall:
                finalPrice = 14;
                break;
            case R.id.RBMedium:
                finalPrice = 17;
                ;
                break;
            case R.id.RBLarge:
                finalPrice = 21;
                ;
                break;
        }


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.buttonAMHome:
                Intent Cust1 = new Intent(Custom_Pizza.this, MainActivity.class);
                startActivity(Cust1);
                break;

            case R.id.btnCustNext:

                finalPrice = finalPrice + check1 + check2 + check3 + check4 + check5;

                Intent Cust2 = new Intent(Custom_Pizza.this, Order_Confirmation.class);
                startActivity(Cust2);
                break;


        }


        SharedPreferences.Editor priceSave = orderPrice.edit();
        priceSave.putFloat("price", finalPrice);

        priceSave.commit();
    }


}