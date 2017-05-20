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
        String sql,numero,piso,nomenclatura,balcon,sombra,tamaño,precio;
        Apartamento p;

        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,4);
        db=aux.getReadableDatabase();

        sql="select * from Apartamentos";
        Cursor c=db.rawQuery(sql,null);

        if (c.moveToFirst()){
            do{

                numero=c.getString(0);
                piso=c.getString(1);
                nomenclatura=c.getString(2);
                balcon=c.getString(3);
                sombra=c.getString(4);
                tamaño=c.getString(5);
                precio=c.getString(6);
                p=new Apartamento(numero,piso,nomenclatura,balcon,sombra,tamaño,precio);
                apartamentos.add(p);

            }while(c.moveToNext());
        }

        db.close();

        return apartamentos;

    }

    public static Apartamento buscarApartamento(Context contexto, String num, String pis){

        SQLiteDatabase db;
        String sql,numero,piso,nomenclatura,balcon,sombra,tamaño,precio;
        Apartamento p=null;

        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,4);
        db=aux.getReadableDatabase();

        sql="select * from Apartamentos where"+" numero='"+num+"',"+" piso='"+pis+"'";
        Cursor c=db.rawQuery(sql,null);

        if (c.moveToFirst()){

            numero=c.getString(0);
            piso=c.getString(1);
            nomenclatura=c.getString(2);
            balcon=c.getString(3);
            sombra=c.getString(4);
            tamaño=c.getString(5);
            precio=c.getString(6);
            p=new Apartamento(numero,piso,nomenclatura,balcon,sombra,tamaño,precio);

        }

        db.close();

        return p;

    }

}
