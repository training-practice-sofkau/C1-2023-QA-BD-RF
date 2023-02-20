package com.sofkau.models;

public class Zona {
    private int codigoPostal;
    private String nombre;
    private String barrio;

    public Zona() {
    }

    public Zona( int codigoPostal,String nombre, String barrio) {
        this.codigoPostal=codigoPostal;
        this.nombre = nombre;
        this.barrio = barrio;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigo_postal) {
        this.codigoPostal = codigo_postal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "codigoPostal=" + codigoPostal +
                ", nombre='" + nombre + '\'' +
                ", barrio='" + barrio + '\'' +
                '}';
    }
}

