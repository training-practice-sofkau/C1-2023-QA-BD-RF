package com.sofkau.integration.database.models;

public class Animal {

    private String id_animal ;
    private String especie ;
    private String edad ;
    private String id_dieta_a;

    public Animal(String id_animal, String especie, String edad, String id_dieta_a) {
        this.id_animal = id_animal;
        this.especie = especie;
        this.edad = edad;
        this.id_dieta_a = id_dieta_a;
    }

    public Animal(){}

    public String getId_animal() {
        return id_animal;
    }

    public void setId_animal(String id_animal) {
        this.id_animal = id_animal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getId_dieta_a() {
        return id_dieta_a;
    }

    public void setId_dieta_a(String id_dieta_a) {
        this.id_dieta_a = id_dieta_a;
    }
}
