package com.sofkau.integration.models;

public class Alimento_Dieta {
    String dietaAlimentoId;
    String alimento_Dieta_ID;

    public Alimento_Dieta() {
    }

    public Alimento_Dieta(String dietaAlimentoId, String alimento_Dieta_ID) {
        this.dietaAlimentoId = dietaAlimentoId;
        this.alimento_Dieta_ID = alimento_Dieta_ID;
    }

    public String getDietaAlimentoId() {
        return dietaAlimentoId;
    }

    public void setDietaAlimentoId(String dietaAlimentoId) {
        this.dietaAlimentoId = dietaAlimentoId;
    }

    public String getAlimento_Dieta_ID() {
        return alimento_Dieta_ID;
    }

    public void setAlimento_Dieta_ID(String alimento_Dieta_ID) {
        this.alimento_Dieta_ID = alimento_Dieta_ID;
    }

    @Override
    public String toString() {
        return "Alimento_Dieta{" +
                "dietaAlimentoId='" + dietaAlimentoId + '\'' +
                ", alimento_Dieta_ID='" + alimento_Dieta_ID + '\'' +
                '}';
    }
}
