package com.royal.pro1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {

    TextView signupText;
    EditText emailInput, passwordInput;
    AppCompatButton loginBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        signupText = findViewById(R.id.signUpLink);
        loginBtn = findViewById(R.id.loginBtn);

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        signupText.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
            finish();
        });

        loginBtn.setOnClickListener(v -> loginUser());
    }

    private void loginUser() {
        String inputEmail = emailInput.getText().toString();
        String inputPassword = passwordInput.getText().toString();

        String savedEmail = sharedPreferences.getString("email", null);
        String savedPassword = sharedPreferences.getString("password", null);

        if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (savedEmail == null || savedPassword == null) {
            Toast.makeText(this, "No account found. Please register first.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (inputEmail.equals(savedEmail) && inputPassword.equals(savedPassword)) {
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class)); // Your home screen
            finish();
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}