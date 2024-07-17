package com.example.validationform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etEmail, etPhone, etPassword;
    private RadioGroup radioGroupGender;
    private CheckBox cbTerms;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);

        radioGroupGender = findViewById(R.id.radioGroupGender);

        cbTerms = findViewById(R.id.cbTerms);
        btnSubmit = findViewById(R.id.btnSubmit);

        addTextWatchers();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }

    private void addTextWatchers() {
        etName.addTextChangedListener(new GenericTextWatcher(etName));
        etEmail.addTextChangedListener(new GenericTextWatcher(etEmail));
        etPhone.addTextChangedListener(new GenericTextWatcher(etPhone));
        etPassword.addTextChangedListener(new GenericTextWatcher(etPassword));
    }

    private void validateForm() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        boolean isTermsChecked = cbTerms.isChecked();

        // Reset all backgrounds to default
        etName.setBackgroundResource(R.drawable.default_background);
        etEmail.setBackgroundResource(R.drawable.default_background);
        etPhone.setBackgroundResource(R.drawable.default_background);
        etPassword.setBackgroundResource(R.drawable.default_background);

        // Validate name
        if (TextUtils.isEmpty(name)) {
            etName.setError("Name is required");
            etName.setBackgroundResource(R.drawable.background);
            etName.requestFocus();
            return;
        }

        // Validate email
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Valid email is required");
            etEmail.setBackgroundResource(R.drawable.background);
            etEmail.requestFocus();
            return;
        }

        // Validate phone number (example: 10 digits)
        if (TextUtils.isEmpty(phone) || !Patterns.PHONE.matcher(phone).matches()) {
            etPhone.setError("Valid phone number is required");
            etPhone.setBackgroundResource(R.drawable.background);
            etPhone.requestFocus();
            return;
        }

        // Validate password (example: minimum 8 characters)
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password is required");
            etPassword.setBackgroundResource(R.drawable.background);
            etPassword.requestFocus();
            return;
        }
        if (password.length() != 8) {
            etPassword.setError("Password should contain 8 characters");
            etPassword.setBackgroundResource(R.drawable.background);
            etPassword.requestFocus();
            return;
        }

        // Validate gender selection
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate terms and conditions checkbox
        if (!isTermsChecked) {
            Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        // If all validations pass
        Toast.makeText(this, "Form submitted successfully!", Toast.LENGTH_SHORT).show();
    }


    private class GenericTextWatcher implements TextWatcher {
        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void afterTextChanged(Editable editable) {
            view.setBackgroundResource(R.drawable.default_background);
            if (view instanceof EditText) {
                ((EditText) view).setError(null);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // No action needed
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // No action needed
        }
    }
}
