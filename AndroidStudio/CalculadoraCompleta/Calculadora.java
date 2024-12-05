package com.example.calculadoraconstraint;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculadora extends AppCompatActivity {



    boolean pulsado = false;
    boolean suma = false;
    boolean resta = false;
    boolean division = false;
    boolean multiplicacion = false;
    Double numero1 = null;
    Double numero2 = null;
    private String promptActual = "";
    private double num1 = 0.0;
    private double num2 = 0.0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String usuario = getIntent().getStringExtra(MainActivity.U_NOMBRE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora_main);

        TextView display = findViewById(R.id.display); // Asegúrate de que tienes un TextView con este id en tu layout

        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);
        Button btnAdd = findViewById(R.id.btn_sumar);
        Button btnEqual = findViewById(R.id.btn_equal);
        Button btnClear = findViewById(R.id.btn_clear);
        Button btnrestar = findViewById(R.id.btn_restar);
        Button btnmultiplicar = findViewById(R.id.btn_multiply);
        Button btndividir = findViewById(R.id.btn_divide);
        TextView saludo = findViewById(R.id.saludo);
        saludo.setText("Hola, " + usuario);

        // Los botones numéricos deben concatenar los números al texto en display
        btn0.setOnClickListener(view -> {
            if(pulsado == true){
                promptActual = "";
            }
            promptActual += "0";
            display.setText(promptActual);
        });
        btn1.setOnClickListener(view -> {
            if(pulsado == true){
                promptActual = "";
            }
            pulsado = false;
            promptActual += "1";
            display.setText(promptActual);

        });
        btn2.setOnClickListener(view -> {
            if(pulsado == true){
                promptActual = "";
            }
            pulsado = false;
            promptActual += "2";
            display.setText(promptActual);
        });
        btn3.setOnClickListener(view -> {
            if(pulsado == true){
                promptActual = "";
            }
            pulsado = false;
            promptActual += "3";
            display.setText(promptActual);
        });
        btn4.setOnClickListener(view -> {
            if(pulsado == true){
                promptActual = "";
            }
            pulsado = false;
            promptActual += "4";
            display.setText(promptActual);
        });
        btn5.setOnClickListener(view -> {
            if(pulsado == true){
                promptActual = "";
            }
            pulsado = false;
            promptActual += "5";
            display.setText(promptActual);
        });
        btn6.setOnClickListener(view -> {
            if(pulsado == true){
                promptActual = "";
            }
            pulsado = false;
            promptActual += "6";
            display.setText(promptActual);
        });
        btn7.setOnClickListener(view -> {
            if(pulsado == true){
                promptActual = "";
            }
            pulsado = false;
            promptActual += "7";
            display.setText(promptActual);
        });
        btn8.setOnClickListener(view -> {
            if(pulsado == true){
                promptActual = "";
            }
            pulsado = false;
            promptActual += "8";
            display.setText(promptActual);
        });
        btn9.setOnClickListener(view -> {
            if(pulsado == true){
                promptActual = "";
            }
            pulsado = false;
            promptActual += "9";
            display.setText(promptActual);
        });


        btnAdd.setOnClickListener(view -> {

            if (!promptActual.isEmpty()) {
                num1 = Double.parseDouble(promptActual);
                promptActual = "";
                operator = "+";
            }
        });
        btnrestar.setOnClickListener(view -> {
            if (!promptActual.isEmpty()) {
                num1 = Double.parseDouble(promptActual);
                promptActual = "";
                operator = "-";
            }
        });
        btndividir.setOnClickListener(view -> {
            if (!promptActual.isEmpty()) {
                num1 = Double.parseDouble(promptActual);
                promptActual = "";
                operator = "/";
            }
        });
        btnmultiplicar.setOnClickListener(view -> {
            if (!promptActual.isEmpty()) {
                num1 = Double.parseDouble(promptActual);
                promptActual = "";
                operator = "*";
            }
        });

        btnEqual.setOnClickListener(view -> {
            if (!promptActual.isEmpty() && !operator.isEmpty()) {
                num2 = Double.parseDouble(promptActual);
                double result = 0.0;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                }

                display.setText(String.valueOf(result));
                promptActual = String.valueOf(result);
                operator = "";
            }
            pulsado = true;
        });

        btnClear.setOnClickListener(view -> {
            promptActual = "";
            num1 = 0.0;
            num2 = 0.0;
            operator = "";
            display.setText("0");
        });
    }
}
