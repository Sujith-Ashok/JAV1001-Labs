package com.example.sujithashok_pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment_Confirmation extends AppCompatActivity implements View.OnClickListener{

    Button btnPCPast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__confirmation);

        btnPCPast = findViewById(R.id.buttonPCPast);
        btnPCPast.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){


            case R.id.buttonPCPast:
                Intent PC2 = new Intent(Payment_Confirmation.this, Previous_Orders.class);
                startActivity(PC2);
                break;

        }
    }
}