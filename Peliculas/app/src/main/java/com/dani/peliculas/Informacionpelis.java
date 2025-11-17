package com.dani.peliculas;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Informacionpelis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_informacion_pelis);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });

            Datos datos = new Datos();
            ArrayList<Pelicula> peliculas = datos.rellenaPeliculas();
            AdaptadorInformacion adaptadorInformacion = new AdaptadorInformacion(peliculas);
            RecyclerView rvinfopelis = findViewById(R.id.rvinfopelis);
            rvinfopelis.setAdapter(adaptadorInformacion);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
            //GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this,2, LinearLayoutManager.HORIZONTAL,false);
            rvinfopelis.setLayoutManager(gridLayoutManager);

        //ActionBar donde aparece la flecha para volver a la MainActivity
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Peliculas");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().setNavigationBarColor(getColor(R.color.blue));
    }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
                if (item.getItemId() == android.R.id.home) {
                 getOnBackPressedDispatcher().onBackPressed();
                }
                return super.onOptionsItemSelected(item);
        }
}