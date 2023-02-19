package org.sofka.model;

public class Categoria {

    private String idCategoria ;
    private String nombreCategoria;
    private String almacenamiento;
    private String observacioes;

    public Categoria() {
    }

    public Categoria(String idCategoria, String nombreCategoria, String almacenamiento, String observacioes) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.almacenamiento = almacenamiento;
        this.observacioes = observacioes;
    }


    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getObservacioes() {
        return observacioes;
    }

    public void setObservacioes(String observacioes) {
        this.observacioes = observacioes;
    }

}

