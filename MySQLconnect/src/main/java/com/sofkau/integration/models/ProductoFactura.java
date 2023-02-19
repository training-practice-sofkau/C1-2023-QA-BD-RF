package com.sofkau.integration.models;


public class ProductoFactura {
    private String ref;
    private int idFactura;

    public ProductoFactura(String ref, int idFactura) {
        this.ref = ref;
        this.idFactura = idFactura;
    }

    public ProductoFactura() {
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
}
