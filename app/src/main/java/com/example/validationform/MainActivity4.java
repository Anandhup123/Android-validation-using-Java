package com.example.validationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    RadioButton sol1,sol2,sol3,common;
    Button btn;
    RadioGroup RadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        sol1 = findViewById(R.id.sol1);
        sol2 = findViewById(R.id.sol2);
        sol3 = findViewById(R.id.sol3);

        RadioGroup = findViewById(R.id.radioGroup);


        int Radioids = RadioGroup.getCheckedRadioButtonId();

        btn = findViewById(R.id.submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Radioids == -1){
                    Toast.makeText(MainActivity4.this, "Seleect any Answer", Toast.LENGTH_SHORT).show();
                }

                common = findViewById(Radioids);

                if(common.equals("7")){
                    Toast.makeText(MainActivity4.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity4.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}