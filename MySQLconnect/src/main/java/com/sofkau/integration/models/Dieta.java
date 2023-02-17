package com.sofkau.integration.models;

public class Dieta {
    String idDieta;
    String nombre_dieta;
    String dosis_dieta;
    String tipo_dieta;

    public Dieta(String idDieta, String nombre_dieta, String dosis_dieta, String tipo_dieta) {
        this.idDieta = idDieta;
        this.nombre_dieta = nombre_dieta;
        this.dosis_dieta = dosis_dieta;
        this.tipo_dieta = tipo_dieta;
    }

    public Dieta() {
    }

    public String getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(String idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre_dieta() {
        return nombre_dieta;
    }

    public void setNombre_dieta(String nombre_dieta) {
        this.nombre_dieta = nombre_dieta;
    }

    public String getDosis_dieta() {
        return dosis_dieta;
    }

    public void setDosis_dieta(String dosis_dieta) {
        this.dosis_dieta = dosis_dieta;
    }

    public String getTipo_dieta() {
        return tipo_dieta;
    }

    public void setTipo_dieta(String tipo_dieta) {
        this.tipo_dieta = tipo_dieta;
    }

    @Override
    public String toString() {
        return "Dieta{" +
                "idDieta='" + idDieta + '\'' +
                ", nombre_dieta='" + nombre_dieta + '\'' +
                ", dosis_dieta='" + dosis_dieta + '\'' +
                ", tipo_dieta='" + tipo_dieta + '\'' +
                '}';
    }
}
