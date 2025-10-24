package com.dani.ejercicio5componentes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Secundaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secundaria);
        Intent intent = getIntent();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Boton para volver a la MainActivity
        Button button3 = findViewById(R.id.button3);
        Button button5 = findViewById(R.id.button5);



        RatingBar ratingBar = findViewById(R.id.ratingBar2);

        //Para que guarde las estrellas del rating bar
        float estrellas = getIntent().getFloatExtra("numEstrellas", 0f);
        ratingBar.setRating(estrellas);

       // Toast.makeText(Secundaria.this, "El rating de la rating bar es: ", Toast.LENGTH_SHORT).show();

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Secundaria.this, (getString(R.string.rating) + ratingBar.getRating()), Toast.LENGTH_SHORT).show();
            }
        });

        //Boton para volver a la MainActivity
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Secundaria.this, MainActivity.class);
                intent.putExtra("numEstrellas2", ratingBar.getRating());
                Toast.makeText(Secundaria.this, "Vuelvo a la Main Activity", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        //Boton para ir a la Terciaria
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Secundaria.this, Terciaria.class);
                startActivity(intent);
                Toast.makeText(Secundaria.this, "Actividad Terciaria", Toast.LENGTH_SHORT).show();
            }
        });

        //ActionBar donde aparece la flecha para volver a la MainActivity
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Secundaria");
        actionBar.setSubtitle("Ejercicio 3");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().setNavigationBarColor(getColor(R.color.yellow));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "Vuelvo a la Main activity", Toast.LENGTH_SHORT).show();
            getOnBackPressedDispatcher().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}


