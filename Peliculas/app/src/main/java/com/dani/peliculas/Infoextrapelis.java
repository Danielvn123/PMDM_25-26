package com.dani.peliculas;

import android.content.Intent;
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

        Datos datos = new Datos();
        ArrayList<Pelicula> peliculas = datos.rellenaPeliculas();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().setNavigationBarColor(getColor(R.color.blue));

        //Para que la salga la informacion propia de la pelicula
      //  Pelicula pelicula = (Pelicula) getIntent().getSerializableExtra("pelicula_seleccionada");

            actionBar.setDisplayHomeAsUpEnabled(true);

            TextView tvsinopsis = findViewById(R.id.tvsinospis);
            ImageView ivPortada = findViewById(R.id.imageView3);

            int pos = getIntent().getIntExtra("pos",-1);
            if(pos >= 0 && pos < peliculas.size()) {
                Pelicula pelicula = peliculas.get(pos);

                ivPortada.setImageResource(pelicula.getPortada());
                tvsinopsis.setText(pelicula.getSinopsis());
                actionBar.setTitle(pelicula.getTitulo());

            //Para que al pulsar la portada de la pelicula entre en la peli en youtube
            ivPortada.setOnClickListener(view -> {

                String url = "https://www.youtube.com/watch?v=" + pelicula.getIdYoutube();
                Intent intent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse(url));
                startActivity(intent);
            });
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
