package com.example.recycleviewej.adaptador;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewej.EditActivity;
import com.example.recycleviewej.MainActivity;
import com.example.recycleviewej.R;
import com.example.recycleviewej.entidad.Juego;

import java.util.List;

public class AdaptadorJuegos extends RecyclerView.Adapter<AdaptadorJuegos.ViewHolder> {
    private List<Juego> listaJuegos;

    public AdaptadorJuegos(List<Juego> listaJuegos){
        this.listaJuegos = listaJuegos;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView nombre;
        private TextView compania;
        private Button botonEditar;
        private Button botonEliminar;


        public ViewHolder(View v) {
            super(v);
            id = v.findViewById(R.id.id);
            nombre = v.findViewById(R.id.nombreJuego);
            compania = v.findViewById(R.id.companiaJuego);

            botonEditar = v.findViewById(R.id.botonEditar);
            botonEliminar = v.findViewById(R.id.botonEliminar);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.juegos, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Juego juegoActual = listaJuegos.get(position);

        holder.id.setText(String.valueOf(juegoActual.getId()));
        holder.nombre.setText(juegoActual.getNombre());
        holder.compania.setText(juegoActual.getCompania());


        holder.botonEditar.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), EditActivity.class);

            intent.putExtra("id", listaJuegos.get(position).getId());
            intent.putExtra("nombre", listaJuegos.get(position).getNombre());
            intent.putExtra("compania", listaJuegos.get(position).getCompania());

            intent.putExtra("position", position);

            v.getContext().startActivity(intent);
        });


        holder.botonEliminar.setOnClickListener(v -> {

            listaJuegos.remove(position);
            notifyDataSetChanged();
        });

    }


    @Override
    public int getItemCount() {
        return listaJuegos.size();
    }
}
