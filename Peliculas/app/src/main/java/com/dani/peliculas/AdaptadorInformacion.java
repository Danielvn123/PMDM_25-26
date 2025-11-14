package com.dani.peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class AdaptadorInformacion extends RecyclerView.Adapter<AdaptadorInformacion.CeldaInformacionJava> {

    List<Pelicula> peliculas;
    public AdaptadorInformacion(List<Pelicula> peliculas) { this.peliculas = peliculas;
    }

    //Este atributo nos permite controlar el número del elemento que ha sido seleccionado
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
        holder.fecha.setText(String.valueOf(pelicula.getFecha()));

        //Establece el color de fondo de un elemento dependiendo si este está seleccionado o no.
        if (selectedPos == position) {
            holder.itemView.setBackgroundResource(R.color.seleccionado);
        } else {
            holder.itemView.setBackgroundResource(R.color.lightblue);
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
        ImageView portada, clasi;

        public CeldaInformacionJava(@NonNull View itemView) {
            super(itemView);
            this.titulo = itemView.findViewById(R.id.titulo);
            this.director = itemView.findViewById(R.id.director);
            this.portada = itemView.findViewById(R.id.imageView);
            this.clasi = itemView.findViewById(R.id.imageView2);
            this.duracion = itemView.findViewById(R.id.tvduracion);
            this.sala = itemView.findViewById(R.id.tvsala);
            this.fecha = itemView.findViewById(R.id.tvfecha);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int posPulsada=getAdapterPosition();
                    setSelectedPos(posPulsada);

                    //Para que al pulsar una pelicula salga en el textView el nombre de la pelicula
                    if (selectedPos>RecyclerView.NO_POSITION) {

                        MainActivity activity = (MainActivity) view.getContext();
                        TextView tvTitulo = activity.findViewById(R.id.textViewtitulo);
                        tvTitulo.setText(peliculas.get(selectedPos).getTitulo());

                        //Para que al pulsar otra vez en una pelicula el nombre del textView desaparezca
                    }else{

                        MainActivity activity = (MainActivity) view.getContext();
                        TextView tvTitulo = activity.findViewById(R.id.textViewtitulo);
                        tvTitulo.setText(" ");

                    }
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

