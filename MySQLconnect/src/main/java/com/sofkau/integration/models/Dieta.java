package com.sofkau.integration.models;

public class Dieta {
    private String id_dieta;
    private String tipo_alimento;
    private String dosis;

    public Dieta(String id_dieta, String tipo_alimento, String dosis) {
        this.id_dieta = id_dieta;
        this.tipo_alimento = tipo_alimento;
        this.dosis = dosis;
    }

    public Dieta() {
    }

    public String getId_dieta() {
        return id_dieta;
    }

    public void setId_dieta(String id_dieta) {
        this.id_dieta = id_dieta;
    }

    public String getTipo_alimento() {
        return tipo_alimento;
    }

    public void setTipo_alimento(String tipo_alimento) {
        this.tipo_alimento = tipo_alimento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    @Override
    public String toString() {
        return "Dieta{" +
                "id_dieta='" + id_dieta + '\'' +
                ", tipo_alimento='" + tipo_alimento + '\'' +
                ", dosis='" + dosis + '\'' +
                '}';
    }
}
