package com.sofkau.integration.models;

public class Compra {
    private String ref;
    private int idCliente;

    public Compra(String ref, int idCliente) {
        this.ref = ref;
        this.idCliente = idCliente;
    }

    public Compra() {
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
