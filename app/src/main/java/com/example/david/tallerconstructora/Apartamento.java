package com.example.david.tallerconstructora;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by DAVID on 19/05/2017.
 */

public class Apartamento {
    private String numero;
    private String piso;
    private String nomenclatura;
    private String balcon;
    private String sombra;
    private String tamaño;
    private String precio;

    public Apartamento(String numero, String piso, String nomenclatura, String balcon, String sombra, String tamaño, String precio) {
        this.numero = numero;
        this.piso = piso;
        this.nomenclatura = nomenclatura;
        this.balcon = balcon;
        this.sombra = sombra;
        this.tamaño = tamaño;
        this.precio = precio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public String getBalcon() {
        return balcon;
    }

    public void setBalcon(String balcon) {
        this.balcon = balcon;
    }

    public String getSombra() {
        return sombra;
    }

    public void setSombra(String sombra) {
        this.sombra = sombra;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void guardar(Context contexto){

        SQLiteDatabase db;
        String sql;

        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,4);
        db=aux.getWritableDatabase();

        sql="INSERT INTO Apartamentos values('"
                +this.getNumero()+"','"
                +this.getPiso()+"','"
                +this.getNomenclatura()+"','"
                +this.getBalcon()+"','"
                +this.getSombra()+"','"
                +this.getTamaño()+"','"
                +this.getPrecio()+"')";

        db.execSQL(sql);

        db.close();
    }

    public void eliminar(Context contexto){

        SQLiteDatabase db;
        String sql;

        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,4);
        db=aux.getWritableDatabase();

        sql="DELETE FROM Apartamentos where"+" numero='"+this.getNumero()+"',"+" piso='"+this.getPiso()+"'";

        db.execSQL(sql);

        db.close();
    }

    public void modificar(Context contexto){

        SQLiteDatabase db;
        String sql;

        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,4);
        db=aux.getWritableDatabase();

        sql="UPDATE Apartamentos"+" SET numero='"
                +this.getNumero()+"',"
                +" piso='"+this.getPiso()+"',"
                +" nomenclatura='"+this.getNomenclatura()+"',"
                +" balcon='"+this.getBalcon()+"',"
                +" sombra='"+this.getSombra()+"',"
                +" tamaño='"+this.getTamaño()+"',"
                +" precio='"+this.getPrecio()+"',"
                +" where"+" numero='"+this.getNumero()+"',"
                +" piso='"+this.getPiso()+"'";

        db.execSQL(sql);

        db.close();

    }
}
