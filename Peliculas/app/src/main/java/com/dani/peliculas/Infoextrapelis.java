package com.dani.peliculas;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Infoextrapelis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_infoextrapelis);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().setNavigationBarColor(getColor(R.color.blue));

        //Para que la salga la informacion propia de la pelicula
        Pelicula pelicula = (Pelicula) getIntent().getSerializableExtra("pelicula_seleccionada");

        if (pelicula != null) {
            TextView tvTitulo = findViewById(R.id.textView9);
            ImageView ivPortada = findViewById(R.id.imageView3);

            ivPortada.setImageResource(pelicula.getPortada());
            actionBar.setTitle(pelicula.getTitulo());
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getOnBackPressedDispatcher().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
