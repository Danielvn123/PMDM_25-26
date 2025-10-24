package com.dani.ejercicio5componentes;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Terciaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_terciaria);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    //ActionBar donde aparece la flecha para volver a la MainActivity
    ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Terciaria");
        actionBar.setSubtitle("Ejercicio 4");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().setNavigationBarColor(getColor(R.color.yellow));
    }
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
        Toast.makeText(this, "Vuelvo a la actividad secundaria", Toast.LENGTH_SHORT).show();
        getOnBackPressedDispatcher().onBackPressed();
    }
    return super.onOptionsItemSelected(item);
    }
}
