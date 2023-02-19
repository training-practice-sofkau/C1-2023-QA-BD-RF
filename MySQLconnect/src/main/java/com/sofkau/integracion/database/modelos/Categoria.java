package com.sofkau.integracion.database.modelos;

public class Categoria {
    private String nombreCategoria;
    private String condiciones;
    private String observaciones;

    public Categoria(String nombreCategoria, String condiciones, String observaciones) {
        this.nombreCategoria = nombreCategoria;
        this.condiciones = condiciones;
        this.observaciones = observaciones;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
