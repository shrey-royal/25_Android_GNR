package com.royal.pro0;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class DataFlow extends AppCompatActivity {
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPhone;
    private Spinner spCourses;
    private AppCompatButton btnSubmit;
    private AppCompatButton btnClear;
    private static final String TAG = "DATA_FLOW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_flow);

        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPhone = findViewById(R.id.edt_phone);
        spCourses = findViewById(R.id.sp_courses);
        btnSubmit = findViewById(R.id.btn_submit);
        btnClear = findViewById(R.id.btn_clear);

        setupSpinner();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });

        btnClear.setOnClickListener(v -> {
            handleClear();
        });
    }

    private void setupSpinner() {
        String[] courses = {
                "Select a Course",
                "Computer Science",
                "Information Technology",
                "Electronics",
                "Mechanical Engineering",
                "Civil Engineering"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                courses
        );

//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spCourses.setAdapter(adapter);
    }

    private void handleSubmit() {
        boolean isError = false;
        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        String course = spCourses.getSelectedItem().toString();

        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Please enter your name");
            isError = true;
        }

        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Please enter your email");
            isError = true;
        }

        if (phone.isEmpty()) {
            Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Please enter your phone number");
            isError = true;
        }

        if (course.equals("Select a Course")) {
            Toast.makeText(this, "Please select a course", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Please select a course");
            isError = true;
        }

        if (isError) {
            return;
        }

        String message = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "Course: " + course;

        Log.i(TAG, "Form submitted Successfully!\n" + message);

        handleClear();
    }

    private void handleClear() {
        edtName.setText("");
        edtEmail.setText("");
        edtPhone.setText("");

        spCourses.setSelection(0);

        Toast.makeText(this,"Form cleared!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Form cleared!");
    }
}