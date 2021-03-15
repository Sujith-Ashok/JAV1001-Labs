package com.example.sujith_basketballscoringapp;

import androidx.appcompat.app.AppCompatActivity;

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
implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, View.OnKeyListener, View.OnTouchListener{

    //declaring variables to use in multiple methods
    private Button BtnPlus, BtnMinus;
    private TextView ScoreA, ScoreB;
    private EditText TeamAName, TeamBName;
    private ToggleButton TeamToggle;
    private RadioGroup RadioGrp;
    private int Points, ScoreTemp, NewScore ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up buttons, text views, toggle button, radio group, radio buttons, and Edit Texts
        BtnPlus = findViewById(R.id.buttonPlus);
        BtnPlus.setOnClickListener(this);
        BtnMinus = findViewById(R.id.buttonMinus);
        BtnMinus.setOnClickListener(this);


        ScoreA = findViewById(R.id.textViewScoreA);
        ScoreB = findViewById(R.id.textViewScoreB);


        TeamToggle = findViewById(R.id.toggleButton);
        RadioGrp = findViewById(R.id.radioScore);
        RadioGrp.setOnCheckedChangeListener(this);


        TeamAName = findViewById(R.id.editTextNameA);
        TeamAName.setOnKeyListener(this);
        TeamAName.setOnTouchListener(this);


        TeamBName = findViewById(R.id.editTextNameB);
        TeamBName.setOnKeyListener(this);
        TeamBName.setOnTouchListener(this);


        Points = 1;
        }


        //this hides the keyboard on clicking Enter
    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        switch (view.getId()){
            case R.id.editTextNameA:
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    InputMethodManager imm = (InputMethodManager) this.getSystemService(this.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(TeamAName.getWindowToken(), 0);
                    TeamAName.setFocusable(false);   //removes cursor from edit text
                }
                break;

            case R.id.editTextNameB:
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    InputMethodManager imm = (InputMethodManager) this.getSystemService(this.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(TeamBName.getWindowToken(), 0);
                    TeamBName.setFocusable(false);
                }
                break;
        }
        return false;
    }

    //makes cursor visible again when clicking edit text
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.editTextNameA:
                TeamAName.setFocusableInTouchMode(true);
                break;
            case R.id.editTextNameB:
                TeamBName.setFocusableInTouchMode(true);
                break;
        }

        return false;
    }



    //Assigning score to be added to variable points based checked radio button
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case R.id.radioButtonOne:
                Points = 1;
            break;
            case R.id.radioButtonTwo:
                Points = 2;
                break;
            case R.id.radioButtonThree:
                Points = 3;
                break;
        }
    }

    //uses switch statement to find out which button is pressed plus or minus
    //then check for toggle button on or off, based on toggle button status the score is updated to its appropriate team

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonPlus:
                if(TeamToggle.isChecked()){
                    ScoreTemp = Integer.parseInt(ScoreA.getText().toString());
                    NewScore = ScoreTemp + Points;
                    ScoreA.setText(String.valueOf(NewScore));
                }
                else{
                    ScoreTemp = Integer.parseInt(ScoreB.getText().toString());
                    NewScore = ScoreTemp + Points;
                    ScoreB.setText(String.valueOf(NewScore));
                }
                break;

            case R.id.buttonMinus:
                if(TeamToggle.isChecked()){
                    ScoreTemp = Integer.parseInt(ScoreA.getText().toString());

                    //checks if the score is already 0. if yes, then the new score will be updated as 0
                    if(ScoreTemp <= 0)
                    {
                        NewScore = 0;
                    }
                    else{
                        NewScore = ScoreTemp - Points;
                    }

                    //checks if the new score after minus is 0 or less.if yes, then the new score will be updated as 0
                    if(NewScore <= 0){
                        NewScore = 0;
                    }
                    ScoreA.setText(String.valueOf(NewScore));
                }
                else{
                    ScoreTemp = Integer.parseInt(ScoreB.getText().toString());
                    if(ScoreTemp <= 0)
                    {
                        NewScore = 0;
                    }
                    else{
                        NewScore = ScoreTemp - Points;
                    }

                    if(NewScore <= 0){
                        NewScore = 0;
                    }
                    ScoreB.setText(String.valueOf(NewScore));
                }
                break;
        }
    }


}