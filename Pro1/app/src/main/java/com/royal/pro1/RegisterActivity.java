package com.royal.pro1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class RegisterActivity extends AppCompatActivity {

    TextView loginLink;
    EditText fullNameInput, emailInput, passwordInput, confirmPasswordInput;
    CheckBox termsCheckbox;
    AppCompatButton signUpBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullNameInput = findViewById(R.id.fullNameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        termsCheckbox = findViewById(R.id.termsCheckbox);
        loginLink = findViewById(R.id.loginLink);
        signUpBtn = findViewById(R.id.signUpBtn);

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        loginLink.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

        signUpBtn.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String fullName = fullNameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String confirmPassword = confirmPasswordInput.getText().toString();

        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!termsCheckbox.isChecked()) {
            Toast.makeText(this, "Please agree to the terms", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("fullName", fullName);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();

        Toast.makeText(this, "Registered Succesfully!", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }
}