package com.dani.peliculas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Pelicula> peliculas;
    public  List<Pelicula> rellenarPeliculas() {
        peliculas = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        Pelicula akira=new Pelicula("Akira","Otomo",170,cal.getTime(),"Gran vía",R.drawable.pg13,R.drawable.akira );
        Pelicula dune=new Pelicula("Dune","Lynch",180,cal.getTime(),"Gran vía",R.drawable.g,R.drawable.dune );
        Pelicula a2001=new Pelicula("2001","Kubric",130,cal.getTime(),"Plaza elíptica",R.drawable.pg,R.drawable.d2001 );
        Pelicula ia=new Pelicula("IA","Spielberg",140,cal.getTime(),"Travesia",R.drawable.r,R.drawable.ia );
        Pelicula matrix=new Pelicula("Matrix","Lana Wachowski, Lilly Wachowski",136,cal.getTime(),"Gran vía",R.drawable.pg13,R.drawable.matrix );
        Pelicula br=new Pelicula("Blade Runner","Ridley Scott",117,cal.getTime(),"Plaza elíptica",R.drawable.pg,R.drawable.blade );
        Pelicula inte=new Pelicula("Interstellar","Christopher Nolan ",169,cal.getTime(),"Travesia",R.drawable.g,R.drawable.interstellar );
        Pelicula alien=new Pelicula("Alien","Ridley Scott",117,cal.getTime(),"Plaza elíptica",R.drawable.pg13,R.drawable.alien );
        Pelicula st=new Pelicula("Star Trek","J. J. Abrams",128,cal.getTime(),"Travesia",R.drawable.pg,R.drawable.startrek);
        Pelicula martian=new Pelicula("The Martian","Ridley Scotts",151,cal.getTime(),"Gran vía",R.drawable.pg13,R.drawable.martian);
        return peliculas;
    }

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

        peliculas=rellenarPeliculas();
        AdaptadorPelicula adaptadorPelicula = new AdaptadorPelicula(peliculas);
        RecyclerView rvpelis = findViewById(R.id.rvpelis);
        rvpelis.setAdapter(adaptadorPelicula);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        // GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this,2, LinearLayoutManager.HORIZONTAL,false);
        rvpelis.setLayoutManager(gridLayoutManager);
    }
}