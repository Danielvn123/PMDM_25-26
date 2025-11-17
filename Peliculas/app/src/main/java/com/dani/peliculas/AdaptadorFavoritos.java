package com.dani.peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class AdaptadorFavoritos extends RecyclerView.Adapter<AdaptadorFavoritos.CeldaFavoritosJava> {

    List<Pelicula> peliculas;

    public AdaptadorFavoritos(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @NonNull
    @Override
    public CeldaFavoritosJava onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celda = LayoutInflater.from(parent.getContext()).inflate(R.layout.celdapeliculasfavoritos, parent, false);
        CeldaFavoritosJava celdaFavoritosJava = new CeldaFavoritosJava(celda);
        return celdaFavoritosJava;

        //return new CeldaPeliculasJava(LayoutInflater.from(parent.getContext()).inflate(R.layout.celdapeliculas, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CeldaFavoritosJava holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.titulo.setText(pelicula.getTitulo());
        holder.director.setText(pelicula.getDirector());

    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class CeldaFavoritosJava extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView director;

        public CeldaFavoritosJava(@NonNull View itemView) {
            super(itemView);
            this.titulo = itemView.findViewById(R.id.tvtitulo3);
            this.director = itemView.findViewById(R.id.tvdirector3);

        }

        public TextView getTitulo() {
            return titulo;
        }

        public void setTitulo(TextView titulo) {
            this.titulo = titulo;
        }

        public TextView getDirector() {
            return director;
        }

        public void setDirector(TextView director) {
            this.director = director;
        }

    }
}

