package com.sofkau.integration.models;

public class TelefonoCliente {


    private int idCliente;
    private String numero;


    public TelefonoCliente(int idCliente, String numero) {
        this.idCliente = idCliente;
        this.numero = numero;
    }

    public TelefonoCliente() {
    }

    // Getters
    public int getIdCliente() {
        return idCliente;
    }

    public String getNumero() {
        return numero;
    }

    // Setters
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
