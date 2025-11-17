package com.dani.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Datos datos = new Datos();
        ArrayList<Pelicula> peliculas = datos.rellenaPeliculas();
        AdaptadorPelicula adaptadorPelicula = new AdaptadorPelicula(peliculas);
        RecyclerView rvpelis = findViewById(R.id.rvpelis);
        rvpelis.setAdapter(adaptadorPelicula);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        //GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this,2, LinearLayoutManager.HORIZONTAL,false);
        rvpelis.setLayoutManager(gridLayoutManager);

        //Creamos el actionBar y dps ponemos que en el subtitulo salga el numero de peliculas que hay
        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle(String.valueOf(peliculas.toArray().length));
        getWindow().setNavigationBarColor(getColor(R.color.blue));

        //Para quitar la ActionBar al pulsar el floatingActionButton
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (actionBar.isShowing()) {
                    actionBar.hide();
                } else {
                    actionBar.show();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    //Para que salgan los mensajes de que pulse las opciones del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.minformación) {
            Intent intent = new Intent(this, Informacionpelis.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.mfavoritos) {
            Intent intent = new Intent(this, VerFavoritos.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.manadir) {
            Intent intent = new Intent(this, NuevaPelicula.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.mvista) {
            return true;
        } else if (id == R.id.mverfav) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}