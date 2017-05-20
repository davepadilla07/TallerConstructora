package com.example.david.tallerconstructora;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ApartamentosCaracteristica extends AppCompatActivity {
    private TextView cajaResultado;
    private String aux;
    private Resources res;
    private ArrayList<Apartamento> apartamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartamentos_caracteristica);

        cajaResultado=(TextView)findViewById(R.id.txtResultado1);
        res=this.getResources();

    }

    public void reporte(View v){
        int cont=0;

        apartamentos=Datos.traerApartamentos(getApplicationContext());
        for (int i = 0; i < apartamentos.size(); i++) {
            if ((apartamentos.get(i).getBalcon()==res.getString(R.string.si))&&(apartamentos.get(i).getSombra()==res.getString(R.string.si))){
                cont=cont+1;
            }

        }
        aux=res.getString(R.string.apartamento_caracteristica)+" "+cont;
        cajaResultado.setText(aux);

    }
}
