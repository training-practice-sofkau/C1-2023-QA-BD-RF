package org.sofkau.dbZoo.clases;

public class Dieta {

    private String id_dieta;
    private String recomendaciones;
    private String id_animales;

    public Dieta(String id_dieta, String recomendaciones, String id_animales) {
        this.id_dieta = id_dieta;
        this.recomendaciones = recomendaciones;
        this.id_animales = id_animales;
    }

    public String getId_dieta() {
        return id_dieta;
    }

    public void setId_dieta(String id_dieta) {
        this.id_dieta = id_dieta;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getId_animales() {
        return id_animales;
    }

    public void setId_animales(String id_animales) {
        this.id_animales = id_animales;
    }
}
