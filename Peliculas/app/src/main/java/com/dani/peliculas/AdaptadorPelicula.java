package com.dani.peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
    public class AdaptadorPelicula extends RecyclerView.Adapter<AdaptadorPelicula.CeldaPeliculasJava> {

        List<Pelicula> peliculas;

        public AdaptadorPelicula(List<Pelicula> peliculas) {
            this.peliculas = peliculas;
        }

        @NonNull
        @Override
        public CeldaPeliculasJava onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View celda = LayoutInflater.from(parent.getContext()).inflate(R.layout.celdapeliculas, parent, false);
            CeldaPeliculasJava celdaPeliculasJava = new CeldaPeliculasJava(celda);
            return celdaPeliculasJava;

            //return new CeldaPeliculasJava(LayoutInflater.from(parent.getContext()).inflate(R.layout.celdapeliculas, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull CeldaPeliculasJava holder, int position) {
            Pelicula pelicula = peliculas.get(position);
            holder.portada.setImageResource(pelicula.getPortada());
            holder.clasi.setImageResource(pelicula.getClasi());
            holder.titulo.setText(pelicula.getTitulo());
            holder.director.setText(pelicula.getDirector());
        }

        @Override
        public int getItemCount() {
            return peliculas.size();
        }

        public class CeldaPeliculasJava extends RecyclerView.ViewHolder {
            TextView titulo, director;
            ImageView portada, clasi;

            public CeldaPeliculasJava(@NonNull View itemView) {
                super(itemView);
                this.titulo = itemView.findViewById(R.id.tvtitulo);
                this.director = itemView.findViewById(R.id.tvdirector);
                this.portada = itemView.findViewById(R.id.imageView);
                this.clasi = itemView.findViewById(R.id.imageView2);
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

            public ImageView getPortada() {
                return portada;
            }

            public void setPortada(ImageView portada) {
                this.portada = portada;
            }

            public ImageView getClasi() {
                return clasi;
            }

            public void setClasi(ImageView clasi) {
                this.clasi = clasi;
            }

//            private View.OnClickListener listener;
//            public void setOnClickListener(View.OnClickListener listener) {
//                this.listener = listener;
//            }
//            public void onClick(View v){
//                Toast.makeText(itemView.getContext(),peliculas.getTitulo(), Toast.LENGTH_SHORT).show();
//
//                MainActivity ma = (MainActivity) itemView.getContext();
//
//                ma.getSupportActionBar().setTitle((peliculas.getTitulo());
//                TextView tv = ma.findViewById(R.id.textViewtitulo);
//                tv.setText(peliculas.getTitulo);
//
//                ((MainActivity)((MainActivity) itemView.getContext()).getSupportActionBar().setTitle(pelicula.getTitulo));
//                ((MainActivity)((MainActivity) itemView.getContext()).getSupportActionBar().setTitle(pelicula.getTitulo));
//                ((TextView)((MainActivity)itemView.getContext()).findViewById(R.id.textViewtitulo)).setText(peliculas.getTitulo);
//
//            }
        }
    }

