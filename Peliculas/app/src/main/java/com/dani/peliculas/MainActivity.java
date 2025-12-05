package com.dani.peliculas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
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
    ArrayList<Pelicula> peliculas = new ArrayList<>();
    ArrayList<Integer> seleccionGuardada = new ArrayList<>();

    GridLayoutManager gridLayoutManager;
    boolean vista = false;
    ActionBar actionBar;

    boolean mostrandoFavoritos = false;

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

        SharedPreferences prefs = getSharedPreferences("favoritos", MODE_PRIVATE);

        for (Pelicula p : peliculas) {
            boolean fav = prefs.getBoolean(p.getTitulo(), false);
            p.setFavorita(fav);
        }

        Datos datos = new Datos();
        peliculas = datos.rellenaPeliculas();

        AdaptadorPelicula adaptadorPelicula = new AdaptadorPelicula(peliculas);
        RecyclerView rvpelis = findViewById(R.id.rvpelis);
        rvpelis.setAdapter(adaptadorPelicula);

        gridLayoutManager = new GridLayoutManager(this, 1);
        //GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this,2, LinearLayoutManager.HORIZONTAL,false);
        rvpelis.setLayoutManager(gridLayoutManager);

        //Creamos el actionBar y dps ponemos que en el subtitulo salga el numero de peliculas que hay
        actionBar = getSupportActionBar();
        actionBar.setSubtitle(String.valueOf(peliculas.toArray().length));
        getWindow().setNavigationBarColor(getColor(R.color.blue));

        //Para quitar la ActionBar al pulsar el floatingActionButton
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(v -> {
            if (actionBar != null) {
                if (actionBar.isShowing()) {
                    actionBar.hide();
                } else {
                    actionBar.show();
                }
            }
        });
    }
    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    ArrayList<Integer> seleccionadas = result.getData().getIntegerArrayListExtra("seleccionadas");
                    if (seleccionadas != null) {
                        seleccionGuardada = seleccionadas;
                        for (Integer pos : seleccionadas) {
                            if (pos >= 0 && pos < peliculas.size()) {
                                Pelicula peli = peliculas.get(pos);
                            }
                        }
                    }
                }
            }
    );

    private ArrayList<Pelicula> obtenerFavoritas() {
        ArrayList<Pelicula> favoritas = new ArrayList<>();

        for (Pelicula p : peliculas) {
            if (p.getFavorita()) {
                favoritas.add(p);
            }
        }

        return favoritas;
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
            Intent intentFavoritos = new Intent(MainActivity.this, VerFavoritos.class);
            intentFavoritos.putIntegerArrayListExtra("marcadas", seleccionGuardada);
            launcher.launch(intentFavoritos);
            return true;
        } else if (id == R.id.manadir) {
            Intent intent = new Intent(this, NuevaPelicula.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.mvista) {
            vista = !vista;

            gridLayoutManager.setSpanCount(vista ? 2 : 1);
            gridLayoutManager.requestLayout();  // fuerza el relayout sin necesidad del adapter

            // Actualiza icono según estado
            if (vista) {
                item.setIcon(R.drawable.vista_2);
            } else {
                item.setIcon(R.drawable.vista_1);
            }
        } else if (id == R.id.mverfav) {

            RecyclerView rvpelis = findViewById(R.id.rvpelis);

            if (!mostrandoFavoritos) {
                ArrayList<Pelicula> favoritas = obtenerFavoritas();

                AdaptadorPelicula adaptadorFavoritos = new AdaptadorPelicula(favoritas);
                rvpelis.setAdapter(adaptadorFavoritos);

                actionBar.setTitle("Favoritos (" + favoritas.size() + ")");
                mostrandoFavoritos = true;

            } else {
                AdaptadorPelicula adaptadorCompleto = new AdaptadorPelicula(peliculas);
                rvpelis.setAdapter(adaptadorCompleto);

                actionBar.setTitle("Películas (" + peliculas.size() + ")");
                mostrandoFavoritos = false;
            }

            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}