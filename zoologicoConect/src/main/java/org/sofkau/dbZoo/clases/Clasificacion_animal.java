package org.sofkau.dbZoo.clases;

public class Clasificacion_animal {

    private String id_animales;
    private String clasificacion;

    public Clasificacion_animal(String id_animales, String clasificacion) {
        this.id_animales = id_animales;
        this.clasificacion = clasificacion;
    }

    public String getId_animales() {
        return id_animales;
    }

    public void setId_animales(String id_animales) {
        this.id_animales = id_animales;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
