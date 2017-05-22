package com.example.david.tallerconstructora;

import android.content.DialogInterface;
import android.support.annotation.BoolRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    //private EditText cajaNumero;
    private Spinner comboNumero;
    //private EditText cajaPiso;
    private Spinner comboPiso;
    private ArrayAdapter<String> adapter,adapter1;
    private String[] opc,opc1;
    private EditText cajaNomenclatura;
    private CheckBox chkBalcon;
    private CheckBox chkSombra;
    private EditText cajaTamaño;
    private EditText cajaPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        /*cajaNumero=(EditText)findViewById(R.id.txtNumero);
        cajaPiso=(EditText)findViewById(R.id.txtPiso);*/
        cajaNomenclatura=(EditText)findViewById(R.id.txtNomenclatura);
        cajaTamaño=(EditText)findViewById(R.id.txtTamaño);
        cajaPrecio=(EditText)findViewById(R.id.txtPrecio);

        chkBalcon=(CheckBox) findViewById(R.id.chkBalcon);
        chkSombra=(CheckBox) findViewById(R.id.chkSombra);

        comboNumero=(Spinner)findViewById(R.id.cmbNumero);
        comboPiso=(Spinner)findViewById(R.id.cmbPiso);

        opc=this.getResources().getStringArray(R.array.opcionesnumero);
        opc1=this.getResources().getStringArray(R.array.opcionespiso);

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);
        adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc1);

        comboNumero.setAdapter(adapter);
        comboPiso.setAdapter(adapter1);

    }

    public Boolean validar(){
        /*if (cajaNumero.getText().toString().isEmpty()){
            cajaNumero.setError(getResources().getString(R.string.error1));
            cajaNumero.requestFocus();
            return false;
        }
        if (cajaPiso.getText().toString().isEmpty()){
            cajaPiso.setError(getResources().getString(R.string.error2));
            cajaPiso.requestFocus();
            return false;
        }*/
        if (cajaNomenclatura.getText().toString().isEmpty()){
            cajaNomenclatura.setError(getResources().getString(R.string.error3));
            cajaNomenclatura.requestFocus();
            return false;
        }
        if (cajaTamaño.getText().toString().isEmpty()){
            cajaTamaño.setError(getResources().getString(R.string.error4));
            cajaTamaño.requestFocus();
            return false;
        }
        if (cajaPrecio.getText().toString().isEmpty()){
            cajaPrecio.setError(getResources().getString(R.string.error5));
            cajaPrecio.requestFocus();
            return false;
        }


        return true;
    }

    public void limpiar(){
        /*cajaNumero.setText("");
        cajaPiso.setText("");*/
        comboNumero.setSelection(0);
        comboPiso.setSelection(0);
        cajaNomenclatura.setText("");
        cajaTamaño.setText("");
        cajaPrecio.setText("");
        chkBalcon.setChecked(false);
        chkSombra.setChecked(false);
        cajaNomenclatura.requestFocus();
    }

    public void guardar(View v){
        String numero,piso,nomenclatura,balcon,sombra,tamaño,precio;
        Apartamento p;
        if (validar()){

            numero=comboNumero.getSelectedItem().toString();
            piso=comboPiso.getSelectedItem().toString();
            nomenclatura=cajaNomenclatura.getText().toString();
            tamaño=cajaTamaño.getText().toString();
            precio=cajaPrecio.getText().toString();

            if (chkBalcon.isChecked()){
                balcon=getResources().getString(R.string.si);
            }else{
                balcon=getResources().getString(R.string.no);
            }
            if (chkSombra.isChecked()){
                sombra=getResources().getString(R.string.si);
            }else{
                sombra=getResources().getString(R.string.no);
            }

            p=new Apartamento(numero,piso,nomenclatura,balcon,sombra,tamaño,precio);
            p.guardar(getApplicationContext());

            Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje1),Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

    /*public boolean validarAlBuscar(){
        if (cajaNumero.getText().toString().isEmpty()){
            cajaNumero.setError(getResources().getString(R.string.error1));
            cajaNumero.requestFocus();
            return false;
        }
        if (cajaPiso.getText().toString().isEmpty()){
            cajaPiso.setError(getResources().getString(R.string.error2));
            cajaPiso.requestFocus();
            return false;
        }
        return true;
    }*/

    public void borrar(View v){limpiar();}

    public void buscar(View v){
        Apartamento p;
        String balcon,sombra;
        //if (validarAlBuscar()){
            p=Datos.buscarApartamento(getApplicationContext(),comboNumero.getSelectedItem().toString(),comboPiso.getSelectedItem().toString());
            if (p!=null){
                cajaNomenclatura.setText(p.getNomenclatura());
                cajaTamaño.setText(p.getTamaño());
                cajaPrecio.setText(p.getPrecio());

                balcon=p.getBalcon();
                if(balcon.contains(getResources().getString(R.string.si)))chkBalcon.setChecked(true);
                else chkBalcon.setChecked(false);

                sombra=p.getBalcon();
                if(sombra.contains(getResources().getString(R.string.si)))chkSombra.setChecked(true);
                else chkSombra.setChecked(false);
            }
        //}
    }

    public void eliminar (View v){
        Apartamento p;

        //if (validarAlBuscar()){
            p=Datos.buscarApartamento(getApplicationContext(),comboNumero.getSelectedItem().toString(),comboPiso.getSelectedItem().toString());
            if (p!=null){

                AlertDialog.Builder ventana=new AlertDialog.Builder(this);
                ventana.setTitle(getResources().getString(R.string.confirmacion));
                ventana.setMessage(getResources().getString(R.string.mensaje3));
                ventana.setPositiveButton(getResources().getString(R.string.confirmar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int witch) {
                        Apartamento p;
                        p=Datos.buscarApartamento(getApplicationContext(),comboNumero.getSelectedItem().toString(),comboPiso.getSelectedItem().toString());

                        p.eliminar(getApplicationContext());
                        limpiar();
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje2),Toast.LENGTH_SHORT).show();
                    }
                });

                ventana.setNegativeButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        cajaNomenclatura.requestFocus();
                    }
                });
                ventana.show();

            }
        //}
    }

    public void modificar(View v){
        String numero,piso,nomenclatura,balcon,sombra,tamaño,precio;
        Apartamento p,p2;
        //if (validarAlBuscar()){
            p=Datos.buscarApartamento(getApplicationContext(),comboNumero.getSelectedItem().toString(),comboPiso.getSelectedItem().toString());
            if (p!=null) {

                numero = comboNumero.getSelectedItem().toString();
                piso = comboPiso.getSelectedItem().toString();
                nomenclatura = cajaNomenclatura.getText().toString();
                tamaño = cajaTamaño.getText().toString();
                precio = cajaPrecio.getText().toString();

                balcon=p.getBalcon();
                if(balcon.contains(getResources().getString(R.string.si)))chkBalcon.setChecked(true);
                else chkBalcon.setChecked(false);

                sombra=p.getBalcon();
                if(sombra.contains(getResources().getString(R.string.si)))chkSombra.setChecked(true);
                else chkSombra.setChecked(false);

                p2 = new Apartamento(numero, piso, nomenclatura, balcon, sombra, tamaño, precio);
                p2.guardar(getApplicationContext());

                Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje4),Toast.LENGTH_SHORT).show();
                limpiar();
            }
        //}
    }

}
