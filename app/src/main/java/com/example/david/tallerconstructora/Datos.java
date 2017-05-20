package com.example.david.tallerconstructora;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by DAVID on 19/05/2017.
 */

public class Datos {
    public static ArrayList<Apartamento> traerApartamentos(Context contexto){

        ArrayList<Apartamento> apartamentos = new ArrayList<>();

        SQLiteDatabase db;
        String sql,numero,piso,nomenclatura,caracteristica,tamaño,precio;
        Apartamento p;

        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db=aux.getReadableDatabase();

        sql="select * from Apartamentos";
        Cursor c=db.rawQuery(sql,null);

        if (c.moveToFirst()){
            do{

                numero=c.getString(0);
                piso=c.getString(1);
                nomenclatura=c.getString(2);
                caracteristica=c.getString(3);
                tamaño=c.getString(4);
                precio=c.getString(5);
                p=new Apartamento(numero,piso,nomenclatura,caracteristica,tamaño,precio);
                apartamentos.add(p);

            }while(c.moveToNext());
        }

        db.close();

        return apartamentos;

    }

    public static Apartamento buscarApartamento(Context contexto, String num, String pis){

        SQLiteDatabase db;
        String sql,numero,piso,nomenclatura,caracteristica,tamaño,precio;
        Apartamento p=null;

        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db=aux.getReadableDatabase();

        sql="select * from Apartamentos where"+" numero='"+num+"',"+" piso='"+pis+"'";
        Cursor c=db.rawQuery(sql,null);

        if (c.moveToFirst()){

            numero=c.getString(0);
            piso=c.getString(1);
            nomenclatura=c.getString(2);
            caracteristica=c.getString(3);
            tamaño=c.getString(4);
            precio=c.getString(5);
            p=new Apartamento(numero,piso,nomenclatura,caracteristica,tamaño,precio);

        }

        db.close();

        return p;

    }

}
