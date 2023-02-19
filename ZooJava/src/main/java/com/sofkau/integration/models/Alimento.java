package com.sofkau.integration.models;

public class Alimento {

    String idAlimento;
    String nombreAlimento;
    String tipoAlimento;

    public Alimento() {
    }

    public Alimento(String idAlimento, String nombreAlimento, String tipoAlimento) {
        this.idAlimento = idAlimento;
        this.nombreAlimento = nombreAlimento;
        this.tipoAlimento = tipoAlimento;
    }

    public String getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(String idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public void setNombreAlimento(String nombreAlimento) {
        this.nombreAlimento = nombreAlimento;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "idAlimento='" + idAlimento + '\'' +
                ", nombreAlimento='" + nombreAlimento + '\'' +
                ", tipoAlimento='" + tipoAlimento + '\'' +
                '}';
    }
}
