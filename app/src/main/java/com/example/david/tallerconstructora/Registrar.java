package com.example.david.tallerconstructora;

import android.support.annotation.BoolRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

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
            new AlertDialog.Builder(this).setMessage(getResources().getString(R.string.error6)).setCancelable(true).show();
            return false;
        }


        return true;
    }

}
