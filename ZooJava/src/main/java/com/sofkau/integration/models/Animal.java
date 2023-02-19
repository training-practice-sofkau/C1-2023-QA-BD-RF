package com.sofkau.integration.models;

public class Animal {

    String idAnimal;
    String nombreAnimal;
    String especie_id;
    String dieta_id;

    public Animal() {
    }

    public Animal(String idAnimal, String nombreAnimal, String especie_id, String dieta_id) {
        this.idAnimal = idAnimal;
        this.nombreAnimal = nombreAnimal;
        this.especie_id = especie_id;
        this.dieta_id = dieta_id;
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public String getEspecie_id() {
        return especie_id;
    }

    public void setEspecie_id(String especie_id) {
        this.especie_id = especie_id;
    }

    public String getDieta_id() {
        return dieta_id;
    }

    public void setDieta_id(String dieta_id) {
        this.dieta_id = dieta_id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "idAnimal='" + idAnimal + '\'' +
                ", nombreAnimal='" + nombreAnimal + '\'' +
                ", especie_id='" + especie_id + '\'' +
                ", dieta_id='" + dieta_id + '\'' +
                '}';
    }
}
