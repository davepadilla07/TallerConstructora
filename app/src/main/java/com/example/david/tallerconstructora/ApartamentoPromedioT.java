package com.example.david.tallerconstructora;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ApartamentoPromedioT extends AppCompatActivity {
    private TextView cajaResultado5;
    private Spinner comboPisoP;
    private ArrayAdapter<String> adapter;
    private String [] opcP;
    private String aux;

    private ArrayList<Apartamento> apartamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartamento_promedio_t);

        cajaResultado5=(TextView)findViewById(R.id.txtResultado5);
        comboPisoP=(Spinner)findViewById(R.id.cmbPisoP);
        opcP=this.getResources().getStringArray(R.array.opcionespiso);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opcP);

        comboPisoP.setAdapter(adapter);

    }

    public void reporte(View v){
        int cont=0;


        apartamentos=Datos.traerApartamentos(getApplicationContext());

        for (int i = 0; i < apartamentos.size(); i++) {

            if (comboPisoP.getSelectedItem().equals(getResources().getString(R.string.op1))){
                cont=cont+Integer.parseInt(apartamentos.get(i).getTamaño());
            }

            aux=getResources().getString(R.string.promedio)+" "+getResources().getString(R.string.es)+" "+cont/3;
            cajaResultado5.setText(aux);
            if (comboPisoP.getSelectedItem().equals(getResources().getString(R.string.op2))){
                cont=cont+Integer.parseInt(apartamentos.get(i).getTamaño());
            }

            aux=getResources().getString(R.string.promedio)+" "+getResources().getString(R.string.es)+" "+cont/3;
            cajaResultado5.setText(aux);
            if (comboPisoP.getSelectedItem().equals(getResources().getString(R.string.op3))){
                cont=cont+Integer.parseInt(apartamentos.get(i).getTamaño());
            }

            aux=getResources().getString(R.string.promedio)+" "+getResources().getString(R.string.es)+" "+cont/3;
            cajaResultado5.setText(aux);
            if (comboPisoP.getSelectedItem().equals(getResources().getString(R.string.op4))){
                cont=cont+Integer.parseInt(apartamentos.get(i).getTamaño());
            }

            aux=getResources().getString(R.string.promedio)+" "+getResources().getString(R.string.es)+" "+cont/3;
            cajaResultado5.setText(aux);
            if (comboPisoP.getSelectedItem().equals(getResources().getString(R.string.op5))){
                cont=cont+Integer.parseInt(apartamentos.get(i).getTamaño());
            }

            aux=getResources().getString(R.string.promedio)+" "+getResources().getString(R.string.es)+" "+cont/3;
            cajaResultado5.setText(aux);
        }

        

        }

    }

