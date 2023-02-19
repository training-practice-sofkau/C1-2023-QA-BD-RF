package com.sofkau.integracion.database.modelos;

public class ProductoCesta {
    private String nombreProducto;
    private String idCestaCompra;
    private int unidadesSeleccionadas;

    public ProductoCesta(String nombreProducto, String idCestaCompra, int unidadesSeleccionadas) {
        this.nombreProducto = nombreProducto;
        this.idCestaCompra = idCestaCompra;
        this.unidadesSeleccionadas = unidadesSeleccionadas;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getIdCestaCompra() {
        return idCestaCompra;
    }

    public void setIdCestaCompra(String idCestaCompra) {
        this.idCestaCompra = idCestaCompra;
    }

    public int getUnidadesSeleccionadas() {
        return unidadesSeleccionadas;
    }

    public void setUnidadesSeleccionadas(int unidadesSeleccionadas) {
        this.unidadesSeleccionadas = unidadesSeleccionadas;
    }
}
