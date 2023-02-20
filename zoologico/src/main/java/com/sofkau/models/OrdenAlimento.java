package com.sofkau.models;

public class OrdenAlimento {
    private String ordenCompraId;
    private String alimentoId;

    public OrdenAlimento() {
    }

    public OrdenAlimento(String ordenCompraId, String alimentoId) {
        this.ordenCompraId = ordenCompraId;
        this.alimentoId = alimentoId;
    }

    public String getOrdenCompraId() {
        return ordenCompraId;
    }

    public void setOrdenCompraId(String ordenCompraId) {
        this.ordenCompraId = ordenCompraId;
    }

    public String getAlimentoId() {
        return alimentoId;
    }

    public void setAlimentoId(String alimentoId) {
        this.alimentoId = alimentoId;
    }
}
