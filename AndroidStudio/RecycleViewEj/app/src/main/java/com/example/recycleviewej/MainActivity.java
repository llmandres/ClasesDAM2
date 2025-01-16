package com.example.recycleviewej;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewej.adaptador.AdaptadorJuegos;
import com.example.recycleviewej.entidad.Juego;
import com.example.recycleviewej.entidad.listaJuegos;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewJuegos;
    private AdaptadorJuegos adaptadorJuegos;
    private Button nuevoJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincular el RecyclerView con el XML
        recyclerViewJuegos = findViewById(R.id.recyclerViewJuegos);
        recyclerViewJuegos.setHasFixedSize(true);
        recyclerViewJuegos.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar la lista de juegos y configurar el adaptador
        listaJuegos.getInstance().inicializar();
        List<Juego> listaJuego = listaJuegos.getInstance().getListaJuegos();
        adaptadorJuegos = new AdaptadorJuegos(listaJuego);
        recyclerViewJuegos.setAdapter(adaptadorJuegos);
        nuevoJuego = findViewById(R.id.nuevoJuego);
        nuevoJuego.setOnClickListener(v->{
            Intent intent = new Intent(v.getContext(), EditActivity.class);


            intent.putExtra("position", -1);


            v.getContext().startActivity(intent);

        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Refrescar los datos del adaptador
        if (recyclerViewJuegos.getAdapter() != null) {
            recyclerViewJuegos.getAdapter().notifyDataSetChanged();
        }
    }
}

