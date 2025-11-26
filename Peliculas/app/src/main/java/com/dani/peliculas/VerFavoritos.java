package com.dani.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VerFavoritos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ver_favoritos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Datos datos = new Datos();
        ArrayList<Pelicula> peliculas = datos.rellenaPeliculas();

        //ActionBar donde aparece la flecha para volver a la MainActivity
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Peliculas");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().setNavigationBarColor(getColor(R.color.blue));

        ArrayList titulos = new ArrayList<>();
        for (Pelicula pelicula : peliculas){
            titulos.add(pelicula.getTitulo() + "\n" + pelicula.getDirector());
        }

        ListView listView = findViewById(R.id.lview);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, titulos);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        ArrayList<Integer> marcadas = getIntent().getIntegerArrayListExtra("marcadas");

        if (marcadas != null) {
            for (int i = 0; i < marcadas.size(); i++) {
                listView.setItemChecked(marcadas.get(i), true);
            }
        }
        listView.setItemChecked(2,true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (item.getItemId() == android.R.id.home) {
            getOnBackPressedDispatcher().onBackPressed();
        } else if (id == R.id.bguardar) {

            ListView lview = findViewById(R.id.lview);
            ArrayList seleccionadas = new ArrayList<>();

            for (int i = 0; i < lview.getCount(); i++) {
                if (lview.isItemChecked(i)) {
                    seleccionadas.add(i);
                }
            }

                Intent intent = new Intent();
                intent.putIntegerArrayListExtra("seleccionadas", seleccionadas);
                setResult(RESULT_OK, intent);
                finish();
            }
        return super.onOptionsItemSelected(item);
    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_secundario, menu);
        return true;

    }
}