package com.royal.pro0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormSubmitIntent0 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_submit_intent0);

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        EditText editTextAddress = findViewById(R.id.editTextAddress);
        RadioGroup genderRadioGroup = findViewById(R.id.genderRadioGroup);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String phone = editTextPhone.getText().toString();
                String address = editTextAddress.getText().toString();

                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                    Toast.makeText(FormSubmitIntent0.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                if (selectedGenderId == -1) {
                    Toast.makeText(FormSubmitIntent0.this, "Please select a gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedGender = findViewById(selectedGenderId);
                String gender = selectedGender.getText().toString();

                Intent intent = new Intent(FormSubmitIntent0.this, DisplayActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("phone", phone);
                intent.putExtra("address", address);
                intent.putExtra("gender", gender);
                startActivity(intent);
            }
        });

    }
}