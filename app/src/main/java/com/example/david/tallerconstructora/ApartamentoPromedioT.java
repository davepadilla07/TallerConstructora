package com.example.david.tallerconstructora;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ApartamentoPromedioT extends AppCompatActivity {
    private TextView cajaResultado;
    private String aux;
    private Resources res;
    private ArrayList<Apartamento> apartamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartamento_promedio_t);

        cajaResultado=(TextView)findViewById(R.id.txtResultado2);
        res=this.getResources();

    }

    public void reporte(View v){
        int cont=0;
        int prom=0;
        String tamaño="";


        apartamentos=Datos.traerApartamentos(getApplicationContext());

        for (int i = 0; i < apartamentos.size(); i++) {
            cont=cont+Integer.parseInt(apartamentos.get(i).getTamaño());
            }
        }





    }

