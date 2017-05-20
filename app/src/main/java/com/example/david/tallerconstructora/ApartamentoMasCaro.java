package com.example.david.tallerconstructora;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ApartamentoMasCaro extends AppCompatActivity {
    private TextView cajaResultado;
    private String aux;
    private Resources res;
    private ArrayList<Apartamento> apartamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartamento_mas_caro);

        cajaResultado=(TextView)findViewById(R.id.txtResultado2);
        res=this.getResources();

    }

    public void reporte(View v){
        int cont,cont1;
        String piso="";


        apartamentos=Datos.traerApartamentos(getApplicationContext());
        cont=Integer.parseInt(apartamentos.get(0).getPrecio());
        for (int i = 1; i < apartamentos.size(); i++) {
            cont1=Integer.parseInt(apartamentos.get(i).getPrecio());
            if (cont<cont1){
                piso = apartamentos.get(i).getPiso();
            }

        }
        aux=res.getString(R.string.apartamento_mas_caro)+" "+res.getString(R.string.es)+" "+piso;
        cajaResultado.setText(aux);

    }
}
