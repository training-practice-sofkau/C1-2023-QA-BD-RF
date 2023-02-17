package com.sofkau.integration.models;

public class Animal {

    String idAnimal;
    String nombre_animal;
    String Especie;
    String idDieta;

    public Animal(String idAnimal, String nombre_animal, String especie, String idDieta) {
        this.idAnimal = idAnimal;
        this.nombre_animal = nombre_animal;
        Especie = especie;
        this.idDieta = idDieta;
    }

    public Animal() {
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre_animal() {
        return nombre_animal;
    }

    public void setNombre_animal(String nombre_animal) {
        this.nombre_animal = nombre_animal;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String especie) {
        Especie = especie;
    }

    public String getIdDieta() {
        return idDieta;
    }
    public void setIdDieta(String idDieta) {
        this.idDieta = idDieta;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "idAnimal='" + idAnimal + '\'' +
                ", nombre_animal='" + nombre_animal + '\'' +
                ", Especie='" + Especie + '\'' +
                ", idDieta='" + idDieta + '\'' +
                '}';
    }
}
