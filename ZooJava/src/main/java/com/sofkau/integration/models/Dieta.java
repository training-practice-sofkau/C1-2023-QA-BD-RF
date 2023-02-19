package com.sofkau.integration.models;

public class Dieta {
    String idDieta;
    String nombreDieta;
    String dosisDieta;

    public Dieta() {
    }

    public Dieta(String idDieta, String nombreDieta, String dosisDieta) {
        this.idDieta = idDieta;
        this.nombreDieta = nombreDieta;
        this.dosisDieta = dosisDieta;
    }

    public String getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(String idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombreDieta() {
        return nombreDieta;
    }

    public void setNombreDieta(String nombreDieta) {
        this.nombreDieta = nombreDieta;
    }

    public String getDosisDieta() {
        return dosisDieta;
    }

    public void setDosisDieta(String dosisDieta) {
        this.dosisDieta = dosisDieta;
    }

    @Override
    public String toString() {
        return "Dieta{" +
                "idDieta='" + idDieta + '\'' +
                ", nombreDieta='" + nombreDieta + '\'' +
                ", dosisDieta='" + dosisDieta + '\'' +
                '}';
    }
}
