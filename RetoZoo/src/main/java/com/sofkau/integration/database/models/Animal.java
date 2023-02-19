package com.sofkau.integration.database.models;

public class Animal {

    String id_animal;
    String nombre;
    String sexo_animal;
    String edad;
    String tipo_especie;
    String dieta_id;

    public Animal(String id_animal, String nombre, String sexo_animal, String edad, String tipo_especie, String dieta_id) {
        this.id_animal = id_animal;
        this.nombre = nombre;
        this.sexo_animal = sexo_animal;
        this.edad = edad;
        this.tipo_especie = tipo_especie;
        this.dieta_id = dieta_id;
    }

    public Animal() {
    }

    public String getId_animal() {
        return id_animal;
    }

    public void setId_animal(String id_animal) {
        this.id_animal = id_animal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo_animal() {
        return sexo_animal;
    }

    public void setSexo_animal(String sexo_animal) {
        this.sexo_animal = sexo_animal;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTipo_especie() {
        return tipo_especie;
    }

    public void setTipo_especie(String tipo_especie) {
        this.tipo_especie = tipo_especie;
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
                "id_animal='" + id_animal + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sexo_animal='" + sexo_animal + '\'' +
                ", edad='" + edad + '\'' +
                ", tipo_especie='" + tipo_especie + '\'' +
                ", dieta_id='" + dieta_id + '\'' +
                '}';
    }
}
