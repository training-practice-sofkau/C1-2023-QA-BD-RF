package com.sofkau.models;

public class Domiciliario {
    private int ID;
    private String nombre;
    private String matricula_furgoneta;
    private int codigo_postal;

    public Domiciliario() {
    }

    public Domiciliario(int ID, String nombre, String matricula_furgoneta, int codigo_postal) {
        this.ID = ID;
        this.nombre = nombre;
        this.matricula_furgoneta = matricula_furgoneta;
        this.codigo_postal = codigo_postal;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula_furgoneta() {
        return matricula_furgoneta;
    }

    public void setMatricula_furgoneta(String matricula_furgoneta) {
        this.matricula_furgoneta = matricula_furgoneta;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    @Override
    public String toString() {
        return "Domiciliario{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", matricula_furgoneta='" + matricula_furgoneta + '\'' +
                ", codigo_postal=" + codigo_postal +
                '}';
    }
}
