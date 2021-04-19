package com.example.sujith_dice_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, View.OnKeyListener, RadioGroup.OnCheckedChangeListener, View.OnTouchListener {

    private Button Roll, RollTwice, Clear;
    private TextView Result, LastFive;
    private EditText CustomDice;
    private ToggleButton CustomToggle;
    private RadioGroup DiceRadioGrp;
    private int numOfSides = 4, customNumOfSides = 0, Roll1, Roll2;
    private String special = "N", ResultText, firstRoll = "Y", lastResult, toSave, savedRolls;
    private SharedPreferences lastResultSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Roll = findViewById(R.id.btnRoll);
        Roll.setOnClickListener(this);
        RollTwice = findViewById(R.id.btnRollTwice);
        RollTwice.setOnClickListener(this);
        Clear = findViewById(R.id.btnClear);
        Clear.setOnClickListener(this);

        Result = findViewById(R.id.textResult);
        LastFive = findViewById(R.id.textLast);

        CustomDice = findViewById(R.id.textCustom);
        CustomDice.setOnKeyListener(this);
        CustomDice.setOnTouchListener(this);

        CustomToggle = findViewById(R.id.TBCustom);


        DiceRadioGrp = findViewById(R.id.radioGroup);
        DiceRadioGrp.setOnCheckedChangeListener(this);

        lastResultSave = getSharedPreferences("DiceApp", Context.MODE_PRIVATE);


        SharedPreferences lastResultSave = getApplicationContext().getSharedPreferences("DiceApp",Context.MODE_PRIVATE);
        savedRolls = lastResultSave.getString("LastFive", "");
        LastFive.setText(savedRolls);

    }

    public int roll(int numSides){
        int Sides = numSides;
        int randomNum = (int) ((Math.random() * Sides) + 1);
        return randomNum;
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        switch (view.getId()) {
            case R.id.textCustom:
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    InputMethodManager imm = (InputMethodManager) this.getSystemService(this.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(CustomDice.getWindowToken(), 0);
                    CustomDice.setFocusable(false);   //removes cursor from edit text
                }
                break;
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.textCustom:
                CustomDice.setFocusableInTouchMode(true);
                break;
        }
        return false;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.RB4:
                numOfSides = 4;
                break;
            case R.id.RB6:
                numOfSides = 6;
                ;
                break;
            case R.id.RB8:
                numOfSides = 8;
                ;
                break;
            case R.id.RB10:
                numOfSides = 10;
                ;
                break;
            case R.id.RB12:
                numOfSides = 12;
                ;
                break;
            case R.id.RB20:
                numOfSides = 20;
                ;
                break;
            case R.id.RB10M:
                numOfSides = 10;
                special = "M";
                ;
                break;
            case R.id.RB10S:
                numOfSides = 10;
                special = "S";
                ;
                break;
        }

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRoll:

                if (CustomToggle.isChecked()) {
                    customNumOfSides = Integer.parseInt(CustomDice.getText().toString());
                    Roll1 = roll(customNumOfSides);
                    Result.setText(String.valueOf(Roll1));
                    lastResult = (Result.getText().toString());
                }
                else{

                    if(special == "M"){
                        Roll1 = roll(numOfSides);
                        Result.setText(String.valueOf(Roll1) + "0" );
                        lastResult = (Result.getText().toString());
                    }
                    else if(special == "S"){
                        Roll1 = (int) ((Math.random() * numOfSides)) ;
                        Result.setText(String.valueOf(Roll1));
                        lastResult = (Result.getText().toString());
                    }
                    else{
                        Roll1 = roll(numOfSides);
                        Result.setText(String.valueOf(Roll1));
                        lastResult = (Result.getText().toString());
                    }

                }

                if(firstRoll == "Y"){
                    LastFive.setText(String.valueOf(lastResult));
                }
                else{
                    ResultText = (LastFive.getText().toString());
                    LastFive.setText(ResultText + ", " + lastResult );
                }

                firstRoll = "N";
                toSave = (LastFive.getText().toString());
                break;

            case R.id.btnRollTwice:

                if (CustomToggle.isChecked()) {
                    customNumOfSides = Integer.parseInt(CustomDice.getText().toString());
                    Roll1 = roll(customNumOfSides);
                    Roll2 = roll(customNumOfSides);
                    Result.setText(String.valueOf(Roll1) + ", " + String.valueOf(Roll2));
                    lastResult = (Result.getText().toString());
                }
                else{

                    if(special == "M"){
                        Roll1 = roll(numOfSides);
                        Roll2 = roll(numOfSides);
                        Result.setText(String.valueOf(Roll1) + "0" + ", " + String.valueOf(Roll2) + "0" );
                        lastResult = (Result.getText().toString());
                    }
                    else if(special == "S"){
                        Roll1 = (int) ((Math.random() * numOfSides));
                        Roll2 = (int) ((Math.random() * numOfSides)) ;
                        Result.setText(String.valueOf(Roll1) + ", " + String.valueOf(Roll2));
                        lastResult = (Result.getText().toString());;
                    }
                    else{
                        Roll1 = roll(numOfSides);
                        Roll2 = roll(numOfSides);
                        Result.setText(String.valueOf(Roll1) + ", " + String.valueOf(Roll2));
                        lastResult = (Result.getText().toString());;
                    }

                }

                if(firstRoll == "Y"){
                    LastFive.setText(String.valueOf(lastResult));
                }
                else{
                    ResultText = (LastFive.getText().toString());
                    LastFive.setText(ResultText + ", " + lastResult );
                }

                firstRoll = "N";
                toSave = (LastFive.getText().toString());
                break;

            case R.id.btnClear:

                LastFive.setText("");
                firstRoll = "Y";
                break;

        }

        SharedPreferences.Editor resultSave = lastResultSave.edit();

            resultSave.putString("LastFive",toSave);

            resultSave.commit();
    }


}

