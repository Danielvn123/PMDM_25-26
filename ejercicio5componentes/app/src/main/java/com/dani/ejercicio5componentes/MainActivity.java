package com.dani.ejercicio5componentes;

import android.os.Bundle;
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
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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

        //Aqui ponemos la accion del radiogroup que al pulsar salga un texto de que se marco
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if (checkedId== R.id.radioButton) {
                    radioButton.setChecked(true);
                    Toast.makeText(MainActivity.this, "RadioButton2", Toast.LENGTH_SHORT).show();

                }else {
                    radioButton2.setChecked(true);
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

    }
    }
