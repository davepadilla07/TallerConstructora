package com.example.david.tallerconstructora;

/**
 * Created by DAVID on 19/05/2017.
 */

public class Apartamento {
    private String numero;
    private String piso;
    private String nomenclatura;
    private String caracteristica;
    private String tamaño;
    private String precio;

    public Apartamento(String numero, String piso, String nomenclatura, String caracteristica, String tamaño, String precio) {
        this.numero = numero;
        this.piso = piso;
        this.nomenclatura = nomenclatura;
        this.caracteristica = caracteristica;
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

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
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
}