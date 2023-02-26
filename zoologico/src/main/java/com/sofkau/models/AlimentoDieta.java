package com.sofkau.models;

public class AlimentoDieta {
    private String alimentoId;
    private String dietaId;


    public AlimentoDieta() {
    }

    public AlimentoDieta(String alimentoId, String dietaId) {
        this.alimentoId = alimentoId;
        this.dietaId = dietaId;
    }

    public String getAlimentoId() {
        return alimentoId;
    }

    public void setAlimentoId(String alimentoId) {
        this.alimentoId = alimentoId;
    }

    public String getDietaId() {
        return dietaId;
    }

    public void setDietaId(String dietaId) {
        this.dietaId = dietaId;
    }
}
