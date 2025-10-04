package com.royal.pro0;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class CustomComponents extends AppCompatActivity {

    enum ToastType {
        SUCCESS, ERROR, WARNING, INFO
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btnSuccess;
        Button btnError;
        Button btnWarning;
        Button btnInfo;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_components);

        btnSuccess = findViewById(R.id.btnSuccess);
        btnError = findViewById(R.id.btnError);
        btnWarning = findViewById(R.id.btnWarning);
        btnInfo = findViewById(R.id.btnInfo);

        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast("Success!", "Operation completed successfully", ToastType.SUCCESS);
            }
        });

        btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast("Error!", "Something went wrong", ToastType.ERROR);
            }
        });

        btnWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast("Warning!", "Please check your input", ToastType.WARNING);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast("Info", "This is an information message", ToastType.INFO);
            }
        });
    }

    private void showCustomToast(String title, String message, ToastType type) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View layout = inflater.inflate(R.layout.custom_toast, null);

        ImageView toastIcon = layout.findViewById(R.id.toastIcon);
        TextView toastTitle = layout.findViewById(R.id.toastTitle);
        TextView toastMessage = layout.findViewById(R.id.toastMessage);

        toastTitle.setText(title);
        toastMessage.setText(message);

        switch (type) {
            case SUCCESS:
                toastIcon.setImageResource(android.R.drawable.ic_dialog_info);
                toastIcon.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_green_dark));
                break;

            case ERROR:
                toastIcon.setImageResource(android.R.drawable.ic_dialog_alert);
                toastIcon.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_red_dark));
                break;

            case WARNING:
                toastIcon.setImageResource(android.R.drawable.ic_dialog_info);
                toastIcon.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_orange_dark));
                break;

            case INFO:
                toastIcon.setImageResource(android.R.drawable.ic_dialog_info);
                toastIcon.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
                break;

        }

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
//        toast.setGravity(Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, 100);
        toast.show();
    }
}
