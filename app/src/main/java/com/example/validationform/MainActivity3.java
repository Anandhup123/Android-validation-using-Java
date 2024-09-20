package com.example.validationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button btn;
    CheckBox confirm;
    RadioButton male,female,others;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn = findViewById(R.id.submitting);

        confirm =findViewById(R.id.confirm);

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        others = findViewById(R.id.others);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(confirm.isChecked()){
                    String Gender="";

                    if(male.isChecked()){
                        Gender = "Male";
                    } else if (female.isChecked()) {
                        Gender = "Female";
                    } else if (others.isChecked()) {
                        Gender = "Others";
                    }else {
                        Gender = "Please Select any Gender ";
                    }
                    Toast.makeText(MainActivity3.this, Gender, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity3.this, MainActivity4.class);
                    startActivity(i);
                }else {
                    Toast.makeText(MainActivity3.this, "Please confirm the terms and Conditions", Toast.LENGTH_SHORT).show();
                }
             }
        });


    }
}