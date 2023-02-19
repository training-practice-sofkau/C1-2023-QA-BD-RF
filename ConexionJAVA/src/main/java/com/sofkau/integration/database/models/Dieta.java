package com.sofkau.integration.database.models;

public class Dieta {

    private String id_dieta ;
    private String tipo_dieta ;
    private String dosis;

    public Dieta(String id_dieta, String tipo_dieta, String dosis) {
        this.id_dieta = id_dieta;
        this.tipo_dieta = tipo_dieta;
        this.dosis = dosis;
    }
    public Dieta(){}

    public String getId_dieta() {
        return id_dieta;
    }

    public void setId_dieta(String id_dieta) {
        this.id_dieta = id_dieta;
    }

    public String getTipo_dieta() {
        return tipo_dieta;
    }

    public void setTipo_dieta(String tipo_dieta) {
        this.tipo_dieta = tipo_dieta;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
}
