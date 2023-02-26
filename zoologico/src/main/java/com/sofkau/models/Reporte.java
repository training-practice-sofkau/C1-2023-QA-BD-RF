package com.sofkau.models;

public class Reporte {

    private String id;
    private String pesoAnimal;
    private String fecha;
    private String animalId;
    private String entrenadorId;


    public Reporte() {
    }

    public Reporte(String id, String pesoAnimal, String fecha, String animalId, String entrenadorId) {
        this.id = id;
        this.pesoAnimal = pesoAnimal;
        this.fecha = fecha;
        this.animalId = animalId;
        this.entrenadorId = entrenadorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPesoAnimal() {
        return pesoAnimal;
    }

    public void setPesoAnimal(String pesoAnimal) {
        this.pesoAnimal = pesoAnimal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getEntrenadorId() {
        return entrenadorId;
    }

    public void setEntrenadorId(String entrenadorId) {
        this.entrenadorId = entrenadorId;
    }
}
