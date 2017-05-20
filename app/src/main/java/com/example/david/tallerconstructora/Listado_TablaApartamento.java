package com.example.david.tallerconstructora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Listado_TablaApartamento extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Apartamento> apartamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado__tabla_apartamento);

        tabla=(TableLayout)findViewById(R.id.tblApartamentos);

        apartamentos=Datos.traerApartamentos(getApplicationContext());

        for (int i = 0; i < apartamentos.size(); i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);
            TextView c6 = new TextView(this);

            c1.setText(" "+apartamentos.get(i).getNumero());
            c2.setText(" "+apartamentos.get(i).getPiso());
            c3.setText(" "+apartamentos.get(i).getNomenclatura());
            c4.setText(" "+apartamentos.get(i).getCaracteristica());
            c5.setText(" "+apartamentos.get(i).getTamaño());
            c6.setText(" "+apartamentos.get(i).getPrecio());

            //Agregar columbas
            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            fila.addView(c5);
            fila.addView(c6);

            //Agregar filas
            tabla.addView(fila);
        }

    }
}
