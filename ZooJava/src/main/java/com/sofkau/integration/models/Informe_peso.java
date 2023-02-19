package com.sofkau.integration.models;

public class Informe_peso {
    String idInforme;
    String pesoAnimal;
    String entrenadorId;
    String veterinarioId;
    String animalId;

    public Informe_peso() {
    }

    public Informe_peso(String idInforme, String pesoAnimal, String entrenadorId, String veterinarioId, String animalId) {
        this.idInforme = idInforme;
        this.pesoAnimal = pesoAnimal;
        this.entrenadorId = entrenadorId;
        this.veterinarioId = veterinarioId;
        this.animalId = animalId;
    }

    public String getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(String idInforme) {
        this.idInforme = idInforme;
    }

    public String getPesoAnimal() {
        return pesoAnimal;
    }

    public void setPesoAnimal(String pesoAnimal) {
        this.pesoAnimal = pesoAnimal;
    }

    public String getEntrenadorId() {
        return entrenadorId;
    }

    public void setEntrenadorId(String entrenadorId) {
        this.entrenadorId = entrenadorId;
    }

    public String getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(String veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    @Override
    public String toString() {
        return "Informe_peso{" +
                "idInforme='" + idInforme + '\'' +
                ", pesoAnimal='" + pesoAnimal + '\'' +
                ", entrenadorId='" + entrenadorId + '\'' +
                ", veterinarioId='" + veterinarioId + '\'' +
                ", animalId='" + animalId + '\'' +
                '}';
    }
}
