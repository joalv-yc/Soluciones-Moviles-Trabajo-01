package com.example.practica01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    TextView TxResultado, TxRecomenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        TxResultado = (TextView) findViewById(R.id.TV_Resultado);
        TxRecomenda = (TextView) findViewById(R.id.txtRecomendacion);
        Intent i = getIntent();
        double altura = i.getDoubleExtra("altura",0);
        double  peso = i.getDoubleExtra("peso",0);
        double imc = (peso/Math.pow(altura,2));
        TxResultado.setText(String.valueOf(imc));

        if(imc < 18.5){
            TxRecomenda.setText("Tiene que subir de peso.");
        }
        if(imc >= 18.5 && imc < 25){
            TxRecomenda.setText("Peso ideal, esta normal.");
        }
        if(imc >= 25 && imc < 30){
            TxRecomenda.setText("Tiene sobrepeso, debe bajar un poco de peso.");
        }
        if(imc >= 30 && imc < 35){
            TxRecomenda.setText("Tiene obesidad I, debe bajar de peso.");
        }
        if(imc >= 35 && imc < 40){
            TxRecomenda.setText("Tiene obesidad II, debe bajar de peso.");
        }
        if(imc >= 40){
            TxRecomenda.setText("Tiene obesidad III, debe bajar de peso urgentemente.");
        }

    }









}