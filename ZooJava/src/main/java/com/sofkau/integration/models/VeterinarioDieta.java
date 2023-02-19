package com.sofkau.integration.models;

public class VeterinarioDieta {
    String idVeterinarioDieta;
    String dietaVeterinarioId;

    public VeterinarioDieta() {
    }

    public VeterinarioDieta(String idVeterinarioDieta, String dietaVeterinarioId) {
        this.idVeterinarioDieta = idVeterinarioDieta;
        this.dietaVeterinarioId = dietaVeterinarioId;
    }

    public String getIdVeterinarioDieta() {
        return idVeterinarioDieta;
    }

    public void setIdVeterinarioDieta(String idVeterinarioDieta) {
        this.idVeterinarioDieta = idVeterinarioDieta;
    }

    public String getDietaVeterinarioId() {
        return dietaVeterinarioId;
    }

    public void setDietaVeterinarioId(String dietaVeterinarioId) {
        this.dietaVeterinarioId = dietaVeterinarioId;
    }

    @Override
    public String toString() {
        return "VeterinarioDieta{" +
                "idVeterinarioDieta='" + idVeterinarioDieta + '\'' +
                ", dietaVeterinarioId='" + dietaVeterinarioId + '\'' +
                '}';
    }
}
