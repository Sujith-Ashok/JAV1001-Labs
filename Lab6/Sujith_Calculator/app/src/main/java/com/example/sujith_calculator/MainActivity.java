package com.example.sujith_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

    //declaring all the variables.
    private Button ButtonOne, ButtonTwo, ButtonThree, ButtonFour, ButtonFive, ButtonSix, ButtonSeven, ButtonEight, ButtonNine , ButtonZero;
    private Button ButtonDivide, ButtonMulti, ButtonSubs, ButtonAdds, ButtonEqual, ButtonDecimal, ButtonPercent, ButtonClear;
    private TextView Input;
    private TextView Result;
    private String Num1, Num2;
    private String Key ="N", InputTemp, ResultTemp;
    private Double Percent, Cal1, Cal2, CalFinal;
    private int Num1Length;
    private boolean deciCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning variables to its appropriate buttons.

        ButtonOne = findViewById(R.id.button1);
        ButtonOne.setOnClickListener(this);

        ButtonTwo = findViewById(R.id.button2);
        ButtonTwo.setOnClickListener(this);

        ButtonThree = findViewById(R.id.button3);
        ButtonThree.setOnClickListener(this);

        ButtonFour = findViewById(R.id.button4);
        ButtonFour.setOnClickListener(this);

        ButtonFive = findViewById(R.id.button5);
        ButtonFive.setOnClickListener(this);

        ButtonSix = findViewById(R.id.button6);
        ButtonSix.setOnClickListener(this);

        ButtonSeven = findViewById(R.id.button7);
        ButtonSeven.setOnClickListener(this);

        ButtonEight = findViewById(R.id.button8);
        ButtonEight.setOnClickListener(this);

        ButtonNine = findViewById(R.id.button9);
        ButtonNine.setOnClickListener(this);

        ButtonZero = findViewById(R.id.button0);
        ButtonZero.setOnClickListener(this);

        ButtonDivide = findViewById(R.id.buttonDiv);
        ButtonDivide.setOnClickListener(this);

        ButtonMulti = findViewById(R.id.buttonMul);
        ButtonMulti.setOnClickListener(this);

        ButtonSubs = findViewById(R.id.buttonSub);
        ButtonSubs.setOnClickListener(this);

        ButtonAdds = findViewById(R.id.buttonAdd);
        ButtonAdds.setOnClickListener(this);

        ButtonEqual = findViewById(R.id.buttonEqual);
        ButtonEqual.setOnClickListener(this);

        ButtonDecimal = findViewById(R.id.buttonDeci);
        ButtonDecimal.setOnClickListener(this);

        ButtonPercent = findViewById(R.id.buttonPercent);
        ButtonPercent.setOnClickListener(this);

        ButtonClear = findViewById(R.id.buttonClear);
        ButtonClear.setOnClickListener(this);

        Input = findViewById(R.id.TextInput);
        Input.setText(Input.getText().toString() + "");

        Result = findViewById(R.id.TextResult);
        Result.setText(Input.getText().toString() + "");;

    }


    //Using switch statement to find out which button was clicked.
    //based on the button clicked, The buttons 0 to 9 and decimal will add the numeric digits to the input textView.
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button3:
                Input.setText(Input.getText().toString() + "1");
                break;

            case R.id.button2:
                Input.setText(Input.getText().toString() + "2");
                break;

            case R.id.button1:
                Input.setText(Input.getText().toString() + "3");
                break;

            case R.id.button4:
                Input.setText(Input.getText().toString() + "4");
                break;

            case R.id.button5:
                Input.setText(Input.getText().toString() + "5");
                break;

            case R.id.button6:
                Input.setText(Input.getText().toString() + "6");
                break;

            case R.id.button7:
                Input.setText(Input.getText().toString() + "7");
                break;

            case R.id.button8:
                Input.setText(Input.getText().toString() + "8");
                break;

            case R.id.button9:
                Input.setText(Input.getText().toString() + "9");
                break;

            case R.id.button0:
                Input.setText(Input.getText().toString() + "0");
                break;

                //buttons Div, Mul, Sub, Add will add its functional symbol to Input TextView and also will assign unique value to variable Key.

            case R.id.buttonDiv:
                Num1 = Input.getText().toString();
                Input.setText(Input.getText().toString() + "÷");
                Key = "Div";
                break;

            case R.id.buttonMul:
                Num1 = Input.getText().toString();;
                Input.setText(Input.getText().toString() + "x");
                Key = "Mul";
                break;

            case R.id.buttonAdd:
                Num1 = Input.getText().toString();;
                Input.setText(Input.getText().toString() + "+");
                Key = "Add";
                break;

            case R.id.buttonSub:
                Num1 = Input.getText().toString();;
                Input.setText(Input.getText().toString() + "-");
                Key = "Sub";
                break;

            case R.id.buttonDeci:
                if(deciCheck == false){
                    Input.setText(Input.getText().toString() + ".");
                    deciCheck = true;
                }
                else{
                    Input.setText(Input.getText().toString());
                }

                break;

            //button Clear will resets all values in both the Input and Result TextViews to blank.
            case R.id.buttonClear:

                Input.setText("");
                Result.setText("");
                deciCheck = false;
                break;


            //the percent button calculates the percentage of Result TextView value.
            //If result is empty then it will calculate percentage of Input TextView value.

            case R.id.buttonPercent:
                ResultTemp = (Result.getText().toString());
                InputTemp = (Input.getText().toString());
                try{
//                    if(ResultTemp == "" && InputTemp == ""){
//                        Input.setText(Input.getText().toString() + "0");
//                    }
                    if(ResultTemp == ""){
                        Percent = Double.parseDouble(Input.getText().toString() + "");
                        Percent = Percent / 100.00;
                        Result.setText(Percent.toString());
                    }
                    else{
                        Percent = Double.parseDouble(Result.getText().toString() + "");
                        Percent = Percent / 100.00;
                        Result.setText(Percent.toString());

                    }
                }
                catch(Exception e){

                }

                break;

            //Button Equals uses switch condition to find the function parameter entered by user.
            //Based on the unique value of key variable, the correct condition is found and its designated arithmetic operations are done.
            //then after arithmetic operation the Key is set to default value "N".
            case R.id.buttonEqual:
//
                    switch (Key){

                        case "Div":
                            Num1Length = (Num1.length() + 1) ;
                            Num2 = ((Input.getText().toString())).substring(Num1Length);
                            Cal1 = Double.parseDouble(Num1);
                            Cal2 = Double.parseDouble(Num2);
                            CalFinal = Cal1 / Cal2;
                            Result.setText(CalFinal.toString());
                            Key = "N";
                            deciCheck = false;
                            break;

                        case "Mul":
                            Num1Length = (Num1.length() + 1) ;
                            Num2 = ((Input.getText().toString())).substring(Num1Length);
                            Cal1 = Double.parseDouble(Num1);
                            Cal2 = Double.parseDouble(Num2);
                            CalFinal = Cal1 * Cal2;
                            Result.setText(CalFinal.toString());
                            Key = "N";
                            deciCheck = false;
                            break;

                        case "Add":
                            Num1Length = (Num1.length() + 1) ;
                            Num2 = ((Input.getText().toString())).substring(Num1Length);
                            Cal1 = Double.parseDouble(Num1);
                            Cal2 = Double.parseDouble(Num2);
                            CalFinal = Cal1 + Cal2;
                            Result.setText(CalFinal.toString());
                            Key = "N";
                            deciCheck = false;
                            break;

                        case "Sub":
                            Num1Length = (Num1.length() + 1) ;
                            Num2 = ((Input.getText().toString())).substring(Num1Length);
                            Cal1 = Double.parseDouble(Num1);
                            Cal2 = Double.parseDouble(Num2);
                            CalFinal = Cal1 - Cal2;
                            Result.setText(CalFinal.toString());
                            Key = "N";
                            deciCheck = false;
                            break;
                        case "N":
                            Result.setText(Input.getText().toString());


                    }




            default:
                Input.setText("");
        }
    }
}