# Android Form Validation

This repository contains an Android application built with Java that demonstrates form validation techniques. The form includes validation for EditText fields (phone number, password, email, and name), as well as validation for a checkbox and radio buttons.

## Features

- **EditText Validation**: Validate phone number, password, email, and name fields.
- **Checkbox Validation**: Ensure a checkbox is checked before form submission.
- **RadioButton Validation**: Ensure a radio button is selected before form submission.


## Getting Started

### Prerequisites

- Android Studio
- Java Development Kit (JDK)

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/android-form-validation.git
    ```

2. Open the project in Android Studio.

3. Build the project and run it on an emulator or a physical device.

### Usage

1. Fill in the form fields with appropriate data:
    - **Name**: Enter a valid name.
    - **Email**: Enter a valid email address.
    - **Phone Number**: Enter a valid phone number.
    - **Password**: Enter a valid password.
2. Check the checkbox to agree to the terms and conditions.
3. Select a radio button option.
4. Submit the form to see the validation in action.

## Code Overview

### MainActivity.java

This file contains the main logic for form validation. It includes methods to validate each input field and ensure that the checkbox and radio buttons are correctly selected.

```java
public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhoneNumber, etPassword;
    private CheckBox cbAgree;
    private RadioGroup rgOptions;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etPassword = findViewById(R.id.etPassword);
        cbAgree = findViewById(R.id.cbAgree);
        rgOptions = findViewById(R.id.rgOptions);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        boolean valid = true;

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String phoneNumber = etPhoneNumber.getText().toString();
        String password = etPassword.getText().toString();

        if (name.isEmpty()) {
            etName.setError("Name is required");
            valid = false;
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Valid email is required");
            valid = false;
        }

        if (phoneNumber.isEmpty() || !Patterns.PHONE.matcher(phoneNumber).matches()) {
            etPhoneNumber.setError("Valid phone number is required");
            valid = false;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            valid = false;
        }

        if (!cbAgree.isChecked()) {
            cbAgree.setError("You must agree to the terms and conditions");
            valid = false;
        }

        if (rgOptions.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        if (valid) {
            // Proceed with form submission
            Toast.makeText(this, "Form submitted successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}
