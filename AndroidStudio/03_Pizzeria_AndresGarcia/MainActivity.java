package com.example.a03_pizzeria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    double precioTamanio = 0.0;
    double precio = 0.0;
    double precioIngredientes = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nombre = findViewById(R.id.nombre);
        EditText direccion = findViewById(R.id.direccion);

        RadioGroup rgroup = findViewById(R.id.rgGrupo1);


        rgroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            if (checkedId == R.id.radiusBig) {
                precioTamanio = 15.00;
            } else if (checkedId == R.id.radiusMed) {
                precioTamanio = 10.00;
            } else if (checkedId == R.id.radiusSmall) {
                precioTamanio = 5.00;
            }
        });

        Button calcularPrecio = findViewById(R.id.preciobutton);
        CheckBox cb1 = findViewById(R.id.cb1);
        CheckBox cb2 = findViewById(R.id.cb2);
        CheckBox cb3 = findViewById(R.id.cb3);
        CheckBox cb4 = findViewById(R.id.cb4);
        TextView precioText = findViewById(R.id.resultado);

        calcularPrecio.setOnClickListener(view -> {
            int contador = 0;
            if (cb1.isChecked()){
                contador++;
            }
            if(cb2.isChecked()){
                contador++;
            }
            if(cb3.isChecked()){
                contador++;
            }
            if(cb4.isChecked()){
                contador++;
            }
            for(int i = 0;i<contador;i++){
                precio= precio +2;
            }
            precio = precioTamanio + precio;
            precioText.setText("Precio a pagar : " +precio);
            precio = 0;
        });


    }
}