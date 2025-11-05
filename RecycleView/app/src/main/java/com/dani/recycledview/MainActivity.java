package com.dani.recycledview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Coche> coches;
        public  List<Coche> rellenarCoches() {
            coches = new ArrayList<>();
            coches.add(new Coche(R.drawable.toyota_corolla_angularrear,"Toyota", "Corolla", 120, 5, 21000));
            coches.add(new Coche(R.drawable.ford_focus_angularfront, "Ford", "Focus", 125, 5, 19500));
            coches.add(new Coche(R.drawable.volkswagen_golf_angularrear,"Volkswagen", "Golf", 150, 5, 25000));
            coches.add(new Coche(R.drawable.hq720,"Seat", "León", 130, 5, 22000));
            coches.add(new Coche(R.drawable.peugeot_308_gt_premium_front_view___,"Peugeot", "308", 115, 5, 20500));
            coches.add(new Coche(R.drawable.fa_261000000_renault_clio_2019_front_view_4x,"Renault", "Clio", 90, 5, 17000));
            coches.add(new Coche(R.drawable.bmw_1_series_mc_design_hero_desktop,"BMW", "Serie 1", 190, 3, 31000));
            coches.add(new Coche(R.drawable.audi_a3_2013_front_6d7aa588,"Audi", "A3", 200, 3, 33000));
            coches.add(new Coche(R.drawable.mercedes_benz_a_class_2019_front_df7f5971,"Mercedes", "Clase A", 180, 5, 34000));
            coches.add(new Coche(R.drawable.kiaceed,"Kia", "Ceed", 110, 5, 18500));
            coches.add(new Coche(R.drawable.hyundai_i30_2021_05_angle__exterior__rear__silver,"Hyundai", "i30", 120, 5, 19000));
            coches.add(new Coche(R.drawable.mazda3_turbo_awd_front_three_quarter_b_ak,"Mazda", "3", 150, 5, 23000));
            coches.add(new Coche(R.drawable.hondacivic,"Honda", "Civic", 182, 5, 27000));
            coches.add(new Coche(R.drawable.asta, "Opel", "Astra", 130, 5, 21000));
            coches.add(new Coche(R.drawable.fiattipo_2, "Fiat", "Tipo", 100, 5, 17000));
            coches.add(new Coche(R.drawable.c4, "Citroën", "C4", 130, 5, 20000));
            coches.add(new Coche(R.drawable.pulsar,"Nissan", "Pulsar", 115, 5, 19500));
            coches.add(new Coche(R.drawable.octavia, "Skoda", "Octavia", 150, 5, 23000));
            coches.add(new Coche(R.drawable.v40,"Volvo", "V40", 190, 5, 31000));
            coches.add(new Coche(R.drawable.mini_cooper_cooper_s_fwd_angular_front_exterior_view_100762864_l, "Mini", "Cooper", 136, 3, 26000));
            return coches;
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

        coches=rellenarCoches();
        AdaptadorCoche adaptadorCoche = new AdaptadorCoche(coches);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setAdapter(adaptadorCoche);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
       // GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this,2, LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(gridLayoutManager);
    }
}