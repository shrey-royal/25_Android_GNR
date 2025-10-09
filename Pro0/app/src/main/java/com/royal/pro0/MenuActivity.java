package com.royal.pro0;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView tvContext = findViewById(R.id.tvContext);
        Button btnPopup = findViewById(R.id.btnPopup);

        registerForContextMenu(tvContext);

        btnPopup.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(this, v);
            popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.popup_edit) {
                    Toast.makeText(this, "Edit clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }
                if (item.getItemId() == R.id.popup_delete) {
                    Toast.makeText(this, "Delete clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            });
            popupMenu.show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_settings) {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (item.getItemId() == R.id.menu_help) {
            Toast.makeText(this, "Help clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select an Action");
        menu.add(0, v.getId(), 0, "Share");
        menu.add(0, v.getId(), 1, "Copy");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("Share")) {
            Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle().equals("Copy")) {
            Toast.makeText(this, "Copy clicked", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}