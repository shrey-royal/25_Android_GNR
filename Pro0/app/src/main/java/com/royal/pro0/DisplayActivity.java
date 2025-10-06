package com.royal.pro0;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);
        TextView addressTextView = findViewById(R.id.addressTextView);
        RadioButton radioMaleDisplay = findViewById(R.id.radioMaleDisplay);
        RadioButton radioFemaleDisplay = findViewById(R.id.radioFemaleDisplay);
        RadioButton radioOtherDisplay = findViewById(R.id.radioOtherDisplay);
        Button backButton = findViewById(R.id.backButton);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");
        String gender = intent.getStringExtra("gender");

        nameTextView.setText("Name: " + name);
        emailTextView.setText("Email: " + email);
        phoneTextView.setText("Phone: " + phone);
        addressTextView.setText("Address: " + address);

        switch (gender) {
            case "Male":
                radioMaleDisplay.setChecked(true);
                break;
            case "Female":
                radioFemaleDisplay.setChecked(true);
                break;
            case "Other":
                radioOtherDisplay.setChecked(true);
                break;
        }

        backButton.setOnClickListener(v -> finish());
    }
}