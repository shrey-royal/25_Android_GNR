package com.royal.pro0;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Button btn = findViewById(R.id.btn_intent_submit);
        EditText uri = findViewById(R.id.edt_intent_text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textUrl = uri.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(textUrl));
                startActivity(intent);
            }
        });
    }
}