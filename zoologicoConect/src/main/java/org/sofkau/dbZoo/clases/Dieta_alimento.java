package org.sofkau.dbZoo.clases;

public class Dieta_alimento {
    private String id_dietas;
    private String id_aliments;

    public Dieta_alimento(String id_dietas, String id_aliments) {
        this.id_dietas = id_dietas;
        this.id_aliments = id_aliments;
    }

    public String getId_dietas() {
        return id_dietas;
    }

    public void setId_dietas(String id_dietas) {
        this.id_dietas = id_dietas;
    }

    public String getId_aliments() {
        return id_aliments;
    }

    public void setId_aliments(String id_aliments) {
        this.id_aliments = id_aliments;
    }
}
