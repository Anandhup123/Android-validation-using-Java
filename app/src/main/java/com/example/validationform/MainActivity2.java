package com.example.validationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText name,email,password,phone;
    RadioButton male,female,others;
    CheckBox check;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.txtname);
        email = findViewById(R.id.txtemail);
        password = findViewById(R.id.txtpassword);
        phone = findViewById(R.id.txtphone);

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        others = findViewById(R.id.others);

        check =findViewById(R.id.check);

        btn  = findViewById(R.id.submit);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (error()){
                    Toast.makeText(MainActivity2.this, "Validation Sucessfull...!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private Boolean error(){
        if (name.getText().toString().trim().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty()
                || phone.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this, "Edit Text should not be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(phone.getText().toString().length() != 10){
            Toast.makeText(MainActivity2.this, "Phone number should be 10 digits", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
            Toast.makeText(MainActivity2.this, "Invalid Email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!password.getText().toString().matches("^[a-zA-Z0-9]{8}$")){
            Toast.makeText(MainActivity2.this, "Password must be exactly 8 characters long and include only letters and numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!male.isChecked() && !female.isChecked() && !others.isChecked()){
            Toast.makeText(MainActivity2.this, "Please Select a Gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!check.isChecked()){
            Toast.makeText(MainActivity2.this, "Please accept the Terms and Conditions", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}