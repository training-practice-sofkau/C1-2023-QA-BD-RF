package com.sofkau.integration.models;

public class Alimento {
    String idAlimento;
    String nombre_alimento;
    String tipo_alimento;
    String dosis_alimento;

    public Alimento(String idAlimento, String nombre_alimento, String tipo_alimento, String dosis_alimento) {
        this.idAlimento = idAlimento;
        this.nombre_alimento = nombre_alimento;
        this.tipo_alimento = tipo_alimento;
        this.dosis_alimento = dosis_alimento;
    }

    public String getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(String idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNombre_alimento() {
        return nombre_alimento;
    }

    public void setNombre_alimento(String nombre_alimento) {
        this.nombre_alimento = nombre_alimento;
    }

    public String getTipo_alimento() {
        return tipo_alimento;
    }

    public void setTipo_alimento(String tipo_alimento) {
        this.tipo_alimento = tipo_alimento;
    }

    public String getDosis_alimento() {
        return dosis_alimento;
    }

    public void setDosis_alimento(String dosis_alimento) {
        this.dosis_alimento = dosis_alimento;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "idAlimento='" + idAlimento + '\'' +
                ", nombre_alimento='" + nombre_alimento + '\'' +
                ", tipo_alimento='" + tipo_alimento + '\'' +
                ", dosis_alimento='" + dosis_alimento + '\'' +
                '}';
    }
}
