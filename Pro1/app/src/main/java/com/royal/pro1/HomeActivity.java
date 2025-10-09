package com.royal.pro1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class HomeActivity extends AppCompatActivity {

    TextView nameText, emailText, passwordText;
    AppCompatButton logoutBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        logoutBtn = findViewById(R.id.logoutBtn);

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        String fullName = sharedPreferences.getString("fullName", "N/A");
        String email = sharedPreferences.getString("email", "N/A");
        String password = sharedPreferences.getString("password", "N/A");

        nameText.setText(fullName);
        emailText.setText(email);
        passwordText.setText(password);

        logoutBtn.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
        });
    }
}