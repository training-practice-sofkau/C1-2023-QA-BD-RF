package com.sofkau.database.clases;

public class Zona {
    private String cod_postal;
    private String nombre;

    public Zona(String cod_postal, String nombre) {
        this.cod_postal = cod_postal;
        this.nombre = nombre;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
