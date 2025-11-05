package com.dani.peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
    public class AdaptadorPelicula extends RecyclerView.Adapter<AdaptadorPelicula.CeldaPeliculasJava>{

        List<Pelicula> peliculas;

        public AdaptadorPelicula(List<Pelicula> peliculas){
            this.peliculas = peliculas;
        }

        @NonNull
        @Override
        public CeldaPeliculasJava onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View celda= LayoutInflater.from(parent.getContext()).inflate(R.layout.celdapeliculas, parent,false);
            CeldaPeliculasJava celdaPeliculasJava = new CeldaPeliculasJava(celda);
            return celdaPeliculasJava;

            //return new CeldaPeliculasJava(LayoutInflater.from(parent.getContext()).inflate(R.layout.celdapeliculas, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull CeldaPeliculasJava holder, int position) {
            Pelicula pelicula = peliculas.get(position);
            holder.foto.setImageResource(pelicula.getPortada());
            holder.titulo.setText(pelicula.getTitulo());
            holder.director.setText(pelicula.getDirector());
        }

        @Override
        public int getItemCount() {
            return peliculas.size();
        }

        public class CeldaPeliculasJava extends RecyclerView.ViewHolder{
            TextView titulo, director;
            ImageView foto;

            public CeldaPeliculasJava(@NonNull View itemView) {
                super(itemView);
                this.titulo=itemView.findViewById(R.id.tvtitulo);
                this.director=itemView.findViewById(R.id.tvdirector);
                this.foto=itemView.findViewById(R.id.imageView);
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

            public ImageView getFoto() {
                return foto;
            }

            public void setFoto(ImageView foto) {
                this.foto = foto;
            }
        }
    }

