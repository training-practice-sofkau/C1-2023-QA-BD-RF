package org.sofkau.dbZoo.clases;

public class Alimento {
    private String id_alimento;
    private String nombre;
    private String dosis;

    public Alimento(String id_alimento, String nombre, String dosis) {
        this.id_alimento = id_alimento;
        this.nombre = nombre;
        this.dosis = dosis;
    }

    public String getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(String id_alimento) {
        this.id_alimento = id_alimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
}
