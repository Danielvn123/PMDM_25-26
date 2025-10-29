package com.dani.recycledview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorCoche extends RecyclerView.Adapter<AdaptadorCoche.CeldaCochesJava>{

    List<Coche> coches;

    public AdaptadorCoche(List<Coche> coches){
        this.coches = coches;
    }

    @NonNull
    @Override
    public CeldaCochesJava onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celda=LayoutInflater.from(parent.getContext()).inflate(R.layout.celdacoche, parent,false);
        CeldaCochesJava celdaCochesJava = new CeldaCochesJava(celda);
        return celdaCochesJava;

        //return new CeldaCochesJava(LayoutInflater.from(parent.getContext()).inflate(R.layout.celdacoche, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CeldaCochesJava holder, int position) {
        Coche coche = coches.get(position);
        holder.foto.setImageResource(coche.getImagen());
        holder.modelo.setText(coche.getModelo());
        holder.marca.setText(coche.getMarca());
    }

    @Override
    public int getItemCount() {
        return coches.size();
    }

    public class CeldaCochesJava extends RecyclerView.ViewHolder{
        TextView modelo, marca;
        ImageView foto;

        public CeldaCochesJava(@NonNull View itemView) {
            super(itemView);
            this.modelo=itemView.findViewById(R.id.tvmodelo);
            this.marca=itemView.findViewById(R.id.tvmarca);
            this.foto=itemView.findViewById(R.id.imageView);
        }
        public TextView getModelo() {
            return modelo;
        }

        public void setModelo(TextView modelo) {
            this.modelo = modelo;
        }

        public TextView getMarca() {
            return marca;
        }

        public void setMarca(TextView marca) {
            this.marca = marca;
        }

        public ImageView getFoto() {
            return foto;
        }

        public void setFoto(ImageView foto) {
            this.foto = foto;
        }
    }
}
