package com.sofkaU.integration.database.models;

public class ClienteTelefono {
    Integer idCliente;
    String telefono;

    public ClienteTelefono(Integer idCliente, String telefono) {
        this.idCliente = idCliente;
        this.telefono = telefono;
    }

    public ClienteTelefono() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ClienteTelefono{" +
                "idCliente=" + idCliente +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
