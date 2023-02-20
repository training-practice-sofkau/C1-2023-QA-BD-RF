package org.sofka.model;

public class TelefonoCliente {
    private String idCliente;
     private String telefono;

    public TelefonoCliente() {
    }

    public TelefonoCliente(String idCliente, String telefono) {
        this.idCliente = idCliente;
        this.telefono = telefono;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
