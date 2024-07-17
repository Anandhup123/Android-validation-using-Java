package com.example.validationform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button btn;
    RadioButton male,female,others;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn = findViewById(R.id.submit);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        others = findViewById(R.id.others);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!male.isChecked() && !female.isChecked() && !others.isChecked()){
                    Toast.makeText(MainActivity3.this, "please any gender", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity3.this, "successfull...!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}