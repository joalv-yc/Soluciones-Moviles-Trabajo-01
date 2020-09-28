package com.example.practica01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    boolean estadoboton;
    TextView ET_ayuda, TextAltura, TextPeso, buidoma, buayuda, bucalcular;
    EditText ET_Altura, ET_Peso, ET_haltura, ET_hpeso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET_Altura = (EditText)findViewById(R.id.edt_alt);
        ET_Peso = (EditText)findViewById(R.id.edt_peso);
        ET_ayuda = (TextView)findViewById(R.id.TV_ayuda);
        ET_haltura = (EditText)findViewById(R.id.edt_alt);
        ET_hpeso = (EditText)findViewById(R.id.edt_peso);
        buidoma = (TextView)findViewById(R.id.ET_idioma);
        buayuda = (TextView)findViewById(R.id.button3);
        bucalcular = (TextView)findViewById(R.id.button2);

        TextAltura = (TextView)findViewById(R.id.ET_Altura);
        TextPeso = (TextView)findViewById(R.id.ET_peso);


        findViewById(R.id.TV_ayuda).setOnClickListener(this);

    }


    public void CalcularOnClick(View v){
        try{
            double peso = Double.parseDouble(ET_Peso.getText().toString());
            double altura = Double.parseDouble(ET_Altura.getText().toString());

            Intent i = new Intent(this, Resultado.class);
            i.putExtra("peso",peso);
            i.putExtra("altura",altura);

            startActivity(i);
        } catch (Exception e){
            Toast.makeText(this, "Error en el ingreso de datos", Toast.LENGTH_SHORT).show();

        }

    }


    @Override
    public void onClick(View v) {
        if(ET_ayuda.getVisibility() == View.GONE)
        {
            ET_ayuda.setVisibility(View.VISIBLE);
        }
        else {
            ET_ayuda.setVisibility(View.GONE);
        }
    }

    public void IdiomaOnClick(View v) {
        if (estadoboton == true){
            TextPeso.setText("Weight");
            TextAltura.setText("Height");
            ET_ayuda.setText("You have to enter in the blank boxes both the height of the user and their weight and then click on the Calculate button and see their muscle mass index.");
            ET_haltura.setHint("Enter height");
            ET_hpeso.setHint("Enter weight");
            buidoma.setText("English");
            buayuda.setText("Help");
            bucalcular.setText("Calculate");
            estadoboton = false;
        }
        else{
            TextPeso.setText("Peso");
            TextAltura.setText("Altura");
            ET_ayuda.setText("Se tiene que ingresar en los recuadros en blanco tanto como la altura del usuario como su peso para luego dar en el boton Calcular/Calculate y ver su índice de masa muscular.");
            ET_haltura.setHint("Ingresar altura");
            ET_hpeso.setHint("Ingresar peso");
            buidoma.setText("Ingles");
            buayuda.setText("Ayuda");
            bucalcular.setText("Calcular");
            estadoboton = true;
        }
    }




}