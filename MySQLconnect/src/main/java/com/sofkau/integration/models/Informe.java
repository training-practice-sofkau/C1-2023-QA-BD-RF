package com.sofkau.integration.models;

public class Informe {
    String idInforme;
    String peso_animal;
    String edad_animal;
    String idAnimal;
    String idEntrenador;

    public Informe(String idInforme, String peso_animal, String edad_animal, String idAnimal, String idEntrenador) {
        this.idInforme = idInforme;
        this.peso_animal = peso_animal;
        this.edad_animal = edad_animal;
        this.idAnimal = idAnimal;
        this.idEntrenador = idEntrenador;
    }

    public Informe() {
    }
    public String getIdInforme() {
        return idInforme;
    }
    public void setIdInforme(String idInforme) {
        this.idInforme = idInforme;
    }

    public String getPeso_animal() {
        return peso_animal;
    }

    public void setPeso_animal(String peso_animal) {
        this.peso_animal = peso_animal;
    }

    public String getEdad_animal() {
        return edad_animal;
    }

    public void setEdad_animal(String edad_animal) {
        this.edad_animal = edad_animal;
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
        return "Informe{" +
                "idInforme='" + idInforme + '\'' +
                ", peso_animal='" + peso_animal + '\'' +
                ", edad_animal='" + edad_animal + '\'' +
                ", idAnimal='" + idAnimal + '\'' +
                ", idEntrenador='" + idEntrenador + '\'' +
                '}';
    }
}
