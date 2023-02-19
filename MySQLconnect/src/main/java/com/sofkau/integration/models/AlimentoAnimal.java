package com.sofkau.integration.models;

public class AlimentoAnimal {
    private String id_alimento_animal;
    private String id_animal_alimento;

    public AlimentoAnimal(String id_alimento_animal, String id_animal_alimento) {
        this.id_alimento_animal = id_alimento_animal;
        this.id_animal_alimento = id_animal_alimento;
    }

    public AlimentoAnimal() {
    }

    public String getId_alimento_animal() {
        return id_alimento_animal;
    }

    public void setId_alimento_animal(String id_alimento_animal) {
        this.id_alimento_animal = id_alimento_animal;
    }

    public String getId_animal_alimento() {
        return id_animal_alimento;
    }

    public void setId_animal_alimento(String id_animal_alimento) {
        this.id_animal_alimento = id_animal_alimento;
    }

    @Override
    public String toString() {
        return "AlimentoAnimal{" +
                "id_alimento_animal='" + id_alimento_animal + '\'' +
                ", id_animal_alimento='" + id_animal_alimento + '\'' +
                '}';
    }
}
