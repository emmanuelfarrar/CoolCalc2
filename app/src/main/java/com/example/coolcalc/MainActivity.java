package com.example.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends Activity {

    //views
    TextView resultsView;       //result

    //enum for operations
    public enum Operation {
        ADD,SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    //global variables
    String runningNumber = "";
    String leftValueStr = "";           //container to hold first set of values
    String rightValueStr = "";          //container to hold second set of values
    Operation currentOperation;         //container for enum operation
    int result = 0;                     //result container


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Event listeners variables, linked them to ids
        Button oneBtn = findViewById(R.id.oneBtn);
        Button twoBtn = findViewById(R.id.twoBtn);
        Button threeBtn = findViewById(R.id.threeBtn);
        Button fourBtn = findViewById(R.id.fourBtn);
        Button fiveBtn = findViewById(R.id.fiveBtn);
        Button sixBtn = findViewById(R.id.sixBtn);
        Button sevenBtn = findViewById(R.id.sevenBtn);
        Button eightBtn = findViewById(R.id.eightBtn);
        Button nineBtn = findViewById(R.id.nineBtn);
        Button zeroBtn = findViewById(R.id.zeroBtn);

        ImageButton calcBtn = findViewById(R.id.calcBtn);
        ImageButton divideBtn = findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = findViewById(R.id.multiplyBtn);
        ImageButton subtractBtn = findViewById(R.id.subtractBtn);
        ImageButton addBtn = findViewById(R.id.addBtn);

        Button clearBtn = findViewById(R.id.clearBtn);

        resultsView = findViewById(R.id.resultsText);

        resultsView.setText(""); //Clears the textView when the app is launched.

        //Setting OnclickListener
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });

        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftValueStr = "";
                rightValueStr = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                resultsView.setText("0");
            }
        });

    }

    //METHODS

    //method to store running number
        /*function used to take in a number and then add the number to the end of the
            runningNumber var
         */
    void numberPressed(int number) {
        runningNumber += String.valueOf(number);
        resultsView.setText(runningNumber);
    }

    /* CORE CODE METHOD
        - if currentOperation is not null, if runningNumber is not empty assign value
         in runningNumber to rightValueStr. Following this runningNumber is empty

         Switch statement:
         - Switch currentOperation set result to calculate per the button accordingly

         - setting leftValueStr to the result so things move from...
         rVs >> result >> lVs >> resultsView

         - currentOperation is always being set to what the user wants it to be

         Else
         (should be ran the first time this method is called)
         - set lVs to what runningNumber is, empty runningNumber, currentOperation is what operation
         the user chooses.

     */
    void processOperation(Operation operation){
        if (currentOperation != null){
            if (runningNumber != ""){
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;

                }

                leftValueStr = String.valueOf(result);
                resultsView.setText(leftValueStr);
            }

        } else {
            leftValueStr = runningNumber;
            runningNumber = "";

    }
        currentOperation = operation;
    }
}
