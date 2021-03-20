package com.simongeorgeasmar.bmi_calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtWeight;
    EditText edtHeight;
    TextView txtViewAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupOnCreate();
    }

    private void setupOnCreate() {
        edtWeight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        txtViewAns = findViewById(R.id.txtViewAns);
    }


    public void btn_onClick(View view) {
        double weight = Double.parseDouble(edtWeight.getText().toString());
        double height = Double.parseDouble(edtHeight.getText().toString());

        double bmi = weight/Math.pow(height,2);

        String category = "";

        if(bmi<15){
            category="Very severely underweight";
        } else if(bmi>=15 && bmi<=16) {
            category = "Severely underweight";
        } else if(bmi>16 && bmi<=18.5){
            category = "Underweight";
        } else if(bmi>18.5 && bmi<=25){
            category = "Normal";
        } else if(bmi>25 && bmi<=30){
            category = "Overweight";
        } else if(bmi>30 && bmi<=35){
            category = "Moderately obese";
        } else if(bmi>35 && bmi<=40){
            category = "Severely obese";
        } else if(bmi>40){
            category = "Very severely obese";
        }

        String output = "BMI = " + bmi +"\nCategory: " +category;

        txtViewAns.setText(output);

        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(),0);

        Toast.makeText(this, "BMI Calculated", Toast.LENGTH_SHORT).show();


    }
}