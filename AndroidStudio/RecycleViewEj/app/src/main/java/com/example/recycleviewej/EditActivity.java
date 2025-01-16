package com.example.recycleviewej;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.recycleviewej.entidad.Juego;
import com.example.recycleviewej.entidad.listaJuegos;

import java.util.List;

public class EditActivity extends AppCompatActivity {
    private Button finish;
    private EditText nombreJuegoEdit, companiaJuegoEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit);


        nombreJuegoEdit = findViewById(R.id.nombreJuegoEdit);
        companiaJuegoEdit = findViewById(R.id.companiaJuegoEdit);
        finish = findViewById(R.id.finish);


        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);  // Recibir la posición
        List<Juego> listJuegos = listaJuegos.getInstance().getListaJuegos();


        if (position != -1) {
            Juego juego = listJuegos.get(position);
            nombreJuegoEdit.setText(juego.getNombre());
            companiaJuegoEdit.setText(juego.getCompania());

            finish.setOnClickListener(v -> {
                String nuevoNombre = nombreJuegoEdit.getText().toString();
                String nuevaCompania = companiaJuegoEdit.getText().toString();

                if (nuevoNombre.isEmpty() || nuevaCompania.isEmpty()) {

                    Toast.makeText(EditActivity.this, "Por favor, ingrese todos los campos.", Toast.LENGTH_SHORT).show();
                    return;
                }


                juego.setNombre(nuevoNombre);
                juego.setCompania(nuevaCompania);

                setResult(RESULT_OK);


                finish();
            });
        } else {

            finish.setOnClickListener(v -> {
                String nuevoNombre = nombreJuegoEdit.getText().toString();
                String nuevaCompania = companiaJuegoEdit.getText().toString();

                if (nuevoNombre.isEmpty() || nuevaCompania.isEmpty()) {

                    Toast.makeText(EditActivity.this, "Por favor, ingrese todos los campos.", Toast.LENGTH_SHORT).show();
                    return;
                }


                Juego nuevoJuego = new Juego();
                nuevoJuego.setNombre(nuevoNombre);
                nuevoJuego.setCompania(nuevaCompania);
                nuevoJuego.setId(listJuegos.size() + 1);


                listJuegos.add(nuevoJuego);


                setResult(RESULT_OK);


                finish();
            });
        }
    }
}

