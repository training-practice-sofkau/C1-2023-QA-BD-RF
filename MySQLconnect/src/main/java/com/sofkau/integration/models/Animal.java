package com.sofkau.integration.models;

public class Animal {
    private String id_animal;
    private String nombre;
    private String clase;
    private String especie;
    private String fecha_nacimiento;
    private String id_dieta_animal;

    public Animal(String id_animal, String nombre, String clase, String especie, String fecha_nacimiento, String id_dieta_animal) {
        this.id_animal = id_animal;
        this.nombre = nombre;
        this.clase = clase;
        this.especie = especie;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_dieta_animal = id_dieta_animal;
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

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getId_dieta_animal() {
        return id_dieta_animal;
    }

    public void setId_dieta_animal(String id_dieta_animal) {
        this.id_dieta_animal = id_dieta_animal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id_animal='" + id_animal + '\'' +
                ", nombre='" + nombre + '\'' +
                ", clase='" + clase + '\'' +
                ", especie='" + especie + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", id_dieta_animal='" + id_dieta_animal + '\'' +
                '}';
    }
}
