package com.sofkau.integration.models;

public class Dieta_alimento {
    String idDieta;
    String idAlimento;

    public Dieta_alimento(String idDieta, String idAlimento) {
        this.idDieta = idDieta;
        this.idAlimento = idAlimento;
    }

    public Dieta_alimento() {
    }

    public String getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(String idDieta) {
        this.idDieta = idDieta;
    }

    public String getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(String idAlimento) {
        this.idAlimento = idAlimento;
    }

    @Override
    public String toString() {
        return "Dieta_alimento{" +
                "idDieta='" + idDieta + '\'' +
                ", idAlimento='" + idAlimento + '\'' +
                '}';
    }
}
