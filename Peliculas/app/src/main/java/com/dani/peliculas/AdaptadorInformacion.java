package com.dani.peliculas;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
public class AdaptadorInformacion extends RecyclerView.Adapter<AdaptadorInformacion.CeldaInformacionJava> {

    List<Pelicula> peliculas;

    public AdaptadorInformacion(List<Pelicula> peliculas) {
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
    public CeldaInformacionJava onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celda = LayoutInflater.from(parent.getContext()).inflate(R.layout.celdapeliculasinfo, parent, false);
        CeldaInformacionJava celdaInformacionJava = new CeldaInformacionJava(celda);
        return celdaInformacionJava;

        //return new CeldaPeliculasJava(LayoutInflater.from(parent.getContext()).inflate(R.layout.celdapeliculas, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CeldaInformacionJava holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.portada.setImageResource(pelicula.getPortada());
        holder.clasi.setImageResource(pelicula.getClasi());
        holder.titulo.setText(pelicula.getTitulo());
        holder.director.setText(pelicula.getDirector());
        holder.duracion.setText(String.valueOf(pelicula.getDuracion()));
        holder.sala.setText(pelicula.getSala());
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        holder.fecha.setText(dateformat.format(pelicula.getFecha()));

        //Para poner el corazon rojo cuando la peli sea favorita
        if(pelicula.getFavorita()){
            holder.favorita.setVisibility(View.VISIBLE);
        }else{
            holder.favorita.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class CeldaInformacionJava extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView director;
        TextView duracion;
        TextView sala;

        TextView fecha;
        ImageView portada, clasi, favorita;

        public CeldaInformacionJava(@NonNull View itemView) {
            super(itemView);
            this.titulo = itemView.findViewById(R.id.titulo);
            this.director = itemView.findViewById(R.id.tvdirector);
            this.portada = itemView.findViewById(R.id.imageView);
            this.clasi = itemView.findViewById(R.id.imageView2);
            this.duracion = itemView.findViewById(R.id.tvduracion);
            this.sala = itemView.findViewById(R.id.tvsala);
            this.fecha = itemView.findViewById(R.id.tvfecha);
            this.favorita = itemView.findViewById(R.id.ivcorazon);

            itemView.setOnClickListener(view -> {
                int posPulsada = getAdapterPosition();
                setSelectedPos(posPulsada);

                if (posPulsada != RecyclerView.NO_POSITION) {
                    // Obtener la película pulsada
                    Pelicula peliculaSeleccionada = peliculas.get(posPulsada);

                    // Crear Intent y pasar la película
                    Intent intent = new Intent(view.getContext(), Infoextrapelis.class);
                    intent.putExtra("pelicula_seleccionada", peliculaSeleccionada);
                    view.getContext().startActivity(intent);
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

        public TextView getDuracion() {
            return duracion;
        }

        public void setDuracion(TextView duracion) {
            this.duracion = duracion;
        }

        public TextView getSala() {
            return sala;
        }

        public void setSala(TextView sala) {
            this.sala = sala;
        }

        public TextView getFecha() {
            return fecha;
        }

        public void setFecha(TextView fecha) {
            this.fecha = fecha;
        }
        public ImageView getFavorita() {
            return favorita;
        }

        public void setFavorita(ImageView favorita) {
            this.favorita = favorita;
        }

    }
}