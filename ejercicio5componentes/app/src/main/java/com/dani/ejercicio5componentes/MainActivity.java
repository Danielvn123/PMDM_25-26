package com.dani.ejercicio5componentes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        //Declaramos variables de los botones
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button4 = findViewById(R.id.button4);
        ImageButton imageButton = findViewById(R.id.imageButton);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);

        //Declaramos variables de los checkbox
        CheckBox checkbox4 = findViewById(R.id.checkBox4);
        CheckBox checkbox5 = findViewById(R.id.checkBox5);
        CheckBox checkbox6 = findViewById(R.id.checkBox6);

        //Declaramos variables de los radioButton
        RadioButton radioButton = findViewById(R.id.radioButton);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);

        //Declaramos variables del switch
        Switch switch1 = findViewById(R.id.switch1);

        //Declaramos variable del seekbar
        SeekBar seekBar = findViewById(R.id.seekBar);

        //Declaramos variable del rating bar
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        //Declaramos variable del email
        EditText editText = findViewById(R.id.editTextTextEmailAddress);

        //Declaramos variables del textview
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView7 = findViewById(R.id.textView7);

        //Declaramos variable de radiogroup
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        ActionBar actionBar = getSupportActionBar();

        //Aqui ponemos la acción del togglebutton para que al pulsarlo se activo o desactive el checkbox6
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkbox6.setChecked(!isChecked);

                    /*if (isChecked) {
                        checkBox6.setChecked(true);
                    } else {
                        checkBox6.setChecked(false);
                        }
                */
            }
        });

        //Aqui ponemos la acción del switch1 para que al pulsarlo ponga Activado y al despulsarlo ponga Desactivado
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView7.setText("Activo");
                } else {
                    textView7.setText("Desactivo");
                }
            }
        });

        //Aqui ponemos la acción del boton primero para que al pulsarlo desactive todo lo que este activado
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                toggleButton.setChecked(false);
                checkbox4.setChecked(false);
                checkbox5.setChecked(false);
                checkbox6.setChecked(false);
                radioButton.setChecked(false);
                radioButton2.setChecked(false);
                switch1.setChecked(false);
                seekBar.setProgress(0);
                ratingBar.setRating(0);
                editText.setText(null);
            }
        });

        //Aqui ponemos la acción del botón con imagen para que al pulsar el texto se convierta en un contador

      /*  int contador = 0;

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkbox5.isChecked()) {
                    if (textView2.equals(@string/textView2))
                    contador++;
                }else{

                }
                }
        });
*/


        //Aqui ponemos la accion del radiogroup que al pulsar salga un texto de que se marco
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if (radioButton.isChecked()) {
                    Toast.makeText(MainActivity.this, "RadioButton2", Toast.LENGTH_SHORT).show();

                } else if (radioButton.isChecked()) {
                    Toast.makeText(MainActivity.this, "RadioButton1", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Aqui ponemos la acción de la rakingbar  que al desplazar la barra suba el numero del texview acorde con la barra.
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView5.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        float estrellas = getIntent().getFloatExtra("numEstrellas", 0f);
        ratingBar.setRating(estrellas);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSec = new Intent(MainActivity.this, Secundaria.class);
                intentSec.putExtra("numEstrellas", ratingBar.getRating());
                Toast.makeText(MainActivity.this, "Actividad Secundaria", Toast.LENGTH_SHORT).show();
                startActivity(intentSec);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, (getString(R.string.rating) + ratingBar.getRating()), Toast.LENGTH_SHORT).show();
            }
        });

        //Boton creado para que al pulsar el boton volver esconda la actionbar y al volver a pulsar se vuleva a enseñar
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (actionBar.isShowing()) {
                    actionBar.hide();
                } else {
                    actionBar.show();
                }
            }
        });

        // Para que me aparezca lo de titulo y subtitulo más la imagen
        actionBar.setTitle("Primaria");
        actionBar.setSubtitle("Subtitulo");

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getWindow().setNavigationBarColor(getColor(R.color.yellow));

        actionBar.setLogo(android.R.drawable.ic_menu_camera);
    }
        //Para crear el menu
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu_principal, menu);
            return true;
        }

        //Para que salgan los mensajes de que pulse las opciones del menu
        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            int id = item.getItemId();
            if (id == R.id.mnuevo) {
                Intent intent = new Intent(this, Terciaria.class);
                Toast.makeText(this, "Nuevo", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            } else if (id == R.id.mborrar) {
                TextView textView = findViewById(R.id.textView);
                TextView textView2 = findViewById(R.id.textView2);
                TextView textView3 = findViewById(R.id.textView3);
                TextView textView4 = findViewById(R.id.textView4);
                TextView textView5 = findViewById(R.id.textView6);
                TextView textView7 = findViewById(R.id.textView7);
                SeekBar seekBar = findViewById(R.id.seekBar);
                textView.setText("");
                textView2.setText("");
                textView3.setText("");
                textView4.setText("");
                textView5.setText("");
                textView7.setText("");
                seekBar.setProgress(0);
                Toast.makeText(this, "Borrar", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.meditar) {
                EditText editText = findViewById(R.id.editTextTextEmailAddress);
                editText.setText("");
                Toast.makeText(this, "Editar", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.submenu) {
                Toast.makeText(this, "Submenu", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.Opcion1) {
                Toast.makeText(this, "Opcion1", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.Opcion2) {
                Toast.makeText(this, "Opcion2", Toast.LENGTH_SHORT).show();
                return true;
            }
            ;
            return super.onOptionsItemSelected(item);
        }
    }






