package com.dani.peliculas;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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

    int selectedPos = RecyclerView.NO_POSITION;
    public int getSelectedPos() {
        return selectedPos;
    }
    public void setSelectedPos ( int nuevaPos){
        // Si se pulsa sobre el elemento marcado
        if (nuevaPos == this.selectedPos) {
            // Se establece que no hay una posición marcada
            this.selectedPos = RecyclerView.NO_POSITION;
            // Se avisa al adaptador para que desmarque esa posición
            notifyItemChanged(nuevaPos);
        } else { // El elemento pulsado no está marcado
            if (this.selectedPos >= 0) { // Si ya hay otra posición marcada
                // Se desmarca
                notifyItemChanged(this.selectedPos);
            }
            // Se actualiza la nueva posición a la posición pulsada
            this.selectedPos = nuevaPos;
            // Se marca la nueva posición
            notifyItemChanged(nuevaPos);
        }
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

        //Establece el color de fondo de un elemento dependiendo si este está seleccionado o no.
        if (selectedPos == position) {
            holder.itemView.setBackgroundResource(R.color.seleccionado);
        } else {
            holder.itemView.setBackgroundResource(R.color.white);
        }
        //Para que salga la pelicula favorita al entrar en este nuevo recycledview
        holder.checkBox.setChecked(pelicula.getFavorita());
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class CeldaFavoritosJava extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView director;

        CheckBox checkBox;

        public CeldaFavoritosJava(@NonNull View itemView) {
            super(itemView);
            this.titulo = itemView.findViewById(R.id.tvtitulo3);
            this.director = itemView.findViewById(R.id.tvdirector3);
            this.checkBox = itemView.findViewById(R.id.checkBox);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int pos = getAdapterPosition();
                    checkBox.setChecked(!checkBox.isChecked());
                }
            });
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
        public CheckBox getCheckBox() {
            return checkBox;
        }

        public void setCheckBox(CheckBox checkBox) {
            this.checkBox = checkBox;
        }
    }
}

