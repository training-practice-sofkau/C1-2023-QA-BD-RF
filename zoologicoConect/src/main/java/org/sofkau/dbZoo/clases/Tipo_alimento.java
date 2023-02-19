package org.sofkau.dbZoo.clases;

public class Tipo_alimento {

    private String id_aliment;
    private String tipo;

    public Tipo_alimento(String id_aliment, String tipo) {
        this.id_aliment = id_aliment;
        this.tipo = tipo;
    }

    public String getId_aliment() {
        return id_aliment;
    }

    public void setId_aliment(String id_aliment) {
        this.id_aliment = id_aliment;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
