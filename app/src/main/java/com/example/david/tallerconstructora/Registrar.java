package com.example.david.tallerconstructora;

import android.content.DialogInterface;
import android.support.annotation.BoolRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    private EditText cajaNumero;
    private EditText cajaPiso;
    private EditText cajaNomenclatura;
    private CheckBox chkBalcon;
    private CheckBox chkSombra;
    private CheckBox chkNinguna;
    private EditText cajaTamaño;
    private EditText cajaPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        cajaNumero=(EditText)findViewById(R.id.txtNumero);
        cajaPiso=(EditText)findViewById(R.id.txtPiso);
        cajaNomenclatura=(EditText)findViewById(R.id.txtNomenclatura);
        cajaTamaño=(EditText)findViewById(R.id.txtTamaño);
        cajaPrecio=(EditText)findViewById(R.id.txtPrecio);

        chkBalcon=(CheckBox)findViewById(R.id.chkBalcon);
        chkSombra=(CheckBox)findViewById(R.id.chkSombra);
        chkNinguna=(CheckBox)findViewById(R.id.chkNinguna);

    }

    public Boolean validar(){
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
        if ((!chkBalcon.isChecked())&&(!chkSombra.isChecked())&&(!chkNinguna.isChecked())){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.error6),Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }

    public void limpiar(){
        cajaNumero.setText("");
        cajaPiso.setText("");
        cajaNomenclatura.setText("");
        cajaTamaño.setText("");
        cajaPrecio.setText("");
        chkBalcon.setChecked(false);
        chkSombra.setChecked(false);
        chkNinguna.setChecked(false);
        cajaNumero.requestFocus();
    }

    public void guardar(View v){
        String numero,piso,nomenclatura,caracteristica="",tamaño,precio;
        Apartamento p;
        if (validar()){

            numero=cajaNumero.getText().toString();
            piso=cajaPiso.getText().toString();
            nomenclatura=cajaNomenclatura.getText().toString();
            tamaño=cajaTamaño.getText().toString();
            precio=cajaPrecio.getText().toString();

            if (chkBalcon.isChecked()){
                caracteristica=getResources().getString(R.string.balcon)+",";
            }
            if (chkSombra.isChecked()){
                caracteristica=getResources().getString(R.string.sombra)+",";
            }
            if (chkNinguna.isChecked()){
                caracteristica=getResources().getString(R.string.ninguna)+", ";
            }

            caracteristica=caracteristica.substring(0,caracteristica.length()-2);
            p=new Apartamento(numero,piso,nomenclatura,caracteristica,tamaño,precio);
            p.guardar(getApplicationContext());

            Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje1),Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

    public boolean validarAlBuscar(){
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
    }

    public void borrar(View v){limpiar();}

    public void buscar(View v){
        Apartamento p;
        String caracteristica;
        if (validarAlBuscar()){
            p=Datos.buscarApartamento(getApplicationContext(),cajaNumero.getText().toString(),cajaPiso.getText().toString());
            if (p!=null){
                cajaNomenclatura.setText(p.getNomenclatura());
                cajaTamaño.setText(p.getTamaño());
                cajaPrecio.setText(p.getPrecio());

                caracteristica=p.getCaracteristica();
                if(caracteristica.contains(getResources().getString(R.string.balcon)))chkBalcon.setChecked(true);
                if(caracteristica.contains(getResources().getString(R.string.sombra)))chkSombra.setChecked(true);
                if(caracteristica.contains(getResources().getString(R.string.ninguna)))chkNinguna.setChecked(true);
            }
        }
    }

    public void eliminar (View v){
        Apartamento p;
        String pasatiempos;
        if (validarAlBuscar()){
            p=Datos.buscarApartamento(getApplicationContext(),cajaNumero.getText().toString(),cajaPiso.getText().toString());
            if (p!=null){

                AlertDialog.Builder ventana=new AlertDialog.Builder(this);
                ventana.setTitle(getResources().getString(R.string.confirmacion));
                ventana.setMessage(getResources().getString(R.string.mensaje3));
                ventana.setPositiveButton(getResources().getString(R.string.confirmar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int witch) {
                        Apartamento p;
                        p=Datos.buscarApartamento(getApplicationContext(), cajaNumero.getText().toString(), cajaPiso.getText().toString());

                        p.eliminar(getApplicationContext());
                        limpiar();
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje2),Toast.LENGTH_SHORT).show();
                    }
                });

                ventana.setNegativeButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        cajaNumero.requestFocus();
                    }
                });
                ventana.show();

            }
        }
    }

    public void modificar(View v){
        String numero,piso,nomenclatura,caracteristica="",tamaño,precio;
        Apartamento p,p2;
        if (validarAlBuscar()){
            p=Datos.buscarApartamento(getApplicationContext(),cajaNumero.getText().toString(),cajaPiso.getText().toString());
            if (p!=null) {

                numero = cajaNumero.getText().toString();
                piso = cajaPiso.getText().toString();
                nomenclatura = cajaNomenclatura.getText().toString();
                tamaño = cajaTamaño.getText().toString();
                precio = cajaPrecio.getText().toString();

                if (chkBalcon.isChecked()) {
                    caracteristica = getResources().getString(R.string.balcon) + ",";
                }
                if (chkSombra.isChecked()) {
                    caracteristica = getResources().getString(R.string.sombra) + ",";
                }
                if (chkNinguna.isChecked()) {
                    caracteristica = getResources().getString(R.string.ninguna) + ", ";
                }

                caracteristica = caracteristica.substring(0, caracteristica.length() - 2);
                p2 = new Apartamento(numero, piso, nomenclatura, caracteristica, tamaño, precio);
                p2.guardar(getApplicationContext());

                Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje4),Toast.LENGTH_SHORT).show();
                limpiar();
            }
        }
    }

}
