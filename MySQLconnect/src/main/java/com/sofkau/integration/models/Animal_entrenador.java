package com.sofkau.integration.models;

public class Animal_entrenador {

    String idAnimal;
    String idEntrenador;

    public Animal_entrenador(String idAnimal, String idEntrenador) {
        this.idAnimal = idAnimal;
        this.idEntrenador = idEntrenador;
    }

    public Animal_entrenador() {
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(String idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    @Override
    public String toString() {
        return "Animal_entrenador{" +
                "idAnimal='" + idAnimal + '\'' +
                ", idEntrenador='" + idEntrenador + '\'' +
                '}';
    }
}
