package com.example.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Event listeners
        Button oneBtn = findViewById(R.id.oneBtn);
        Button twoBtn = findViewById(R.id.twoBtn);


        ImageButton calcBtn = findViewById(R.id.calcBtn);


    }
}
