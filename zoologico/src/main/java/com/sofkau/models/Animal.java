package com.sofkau.models;

public class Animal {
    private String id;
    private String especie;
    private String dietaId;

    public Animal() {
    }

    public Animal(String id, String especie, String dietaId) {
        this.id = id;
        this.especie = especie;
        this.dietaId = dietaId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDietaId() {
        return dietaId;
    }

    public void setDietaId(String dietaId) {
        this.dietaId = dietaId;
    }
}
