package com.example.david.tallerconstructora;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ApartamentoMayorT extends AppCompatActivity {
    private TextView cajaResultado,cajaResultado1;
    private String aux,aux1;
    private Resources res;
    private ArrayList<Apartamento> apartamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartamento_mayor_t);

        cajaResultado=(TextView)findViewById(R.id.txtResultado3);
        cajaResultado1=(TextView)findViewById(R.id.txtResultado4);
        res=this.getResources();
    }

    public void reporte(View v){
        int cont,cont1;
        String nomenclatura="",tamaño="";


        apartamentos=Datos.traerApartamentos(getApplicationContext());
        cont=Integer.parseInt(apartamentos.get(0).getTamaño());
        for (int i = 1; i < apartamentos.size(); i++) {
            cont1=Integer.parseInt(apartamentos.get(i).getTamaño());
            if (cont<cont1){
                nomenclatura = apartamentos.get(i).getNomenclatura();
                tamaño = apartamentos.get(i).getTamaño();
            }

        }
        aux=res.getString(R.string.nomenclatura)+" "+res.getString(R.string.es)+" "+nomenclatura;
        cajaResultado.setText(aux);
        aux1=res.getString(R.string.tamaño)+" "+res.getString(R.string.es)+" "+tamaño;
        cajaResultado1.setText(aux1);

    }
}
