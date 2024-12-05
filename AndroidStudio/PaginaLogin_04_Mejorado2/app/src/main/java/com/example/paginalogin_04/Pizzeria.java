package com.example.paginalogin_04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.paginalogin_04.modelo.entidad.Pizza;
import com.example.paginalogin_04.modelo.entidad.Usuario;
import com.example.paginalogin_04.modelo.negocio.GestorPizza;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria extends AppCompatActivity {
    public final static String K_USUARIO = "nombre";
    GestorPizza gp = new GestorPizza();

    double precioTamanio = 0.0;
    double precio = 0.0;
    double precioIngredientes = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Usuario usuario =
                (Usuario)getIntent().getSerializableExtra(MainActivity.K_USUARIO2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria);

        TextView t1 = findViewById(R.id.nombreUsuario);
        t1.setText(usuario.getNombre());



        RadioGroup rgroup = findViewById(R.id.rgGrupo1);
        String tamanioPizza = null;
        List<String> listaIngredientes = new ArrayList<>();
        usuario.setPizza(new Pizza());


        rgroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            if (checkedId == R.id.radiusBig) {
                usuario.getPizza().setTamanio("Grande");
                precioTamanio = 15.00;
            } else if (checkedId == R.id.radiusMed) {
                usuario.getPizza().setTamanio("Mediana");
                precioTamanio = 10.00;
            } else if (checkedId == R.id.radiusSmall) {
                usuario.getPizza().setTamanio("Pequeña");
                precioTamanio = 5.00;
            }
        });

        Button calcularPrecio = findViewById(R.id.preciobutton);
        CheckBox cb1 = findViewById(R.id.cb1);
        CheckBox cb2 = findViewById(R.id.cb2);
        CheckBox cb3 = findViewById(R.id.cb3);
        CheckBox cb4 = findViewById(R.id.cb4);

        calcularPrecio.setOnClickListener(view -> {
            EditText direccion = findViewById(R.id.direccion);
            String direc = direccion.getText().toString();
            usuario.setDireccion(direc);
            if (cb1.isChecked()){
                listaIngredientes.add("Pepperoni");
            }
            if(cb2.isChecked()){
                listaIngredientes.add("Jamon");
            }
            if(cb3.isChecked()){
                listaIngredientes.add("Aceitunas");
            }
            if(cb4.isChecked()){
                listaIngredientes.add("Pinia");
            }
            usuario.getPizza().setListaIngredientes(listaIngredientes);
            double precioFinal = gp.calcularPrecio(usuario.getPizza());
            usuario.getPizza().setPrecio(precioFinal);
            Intent intent = new Intent(Pizzeria.this, ResultsActivity.class);
            intent.putExtra(K_USUARIO, usuario);
            intent.putStringArrayListExtra("ingredientes", (ArrayList<String>) listaIngredientes);
            startActivity(intent);

        });


    }
}