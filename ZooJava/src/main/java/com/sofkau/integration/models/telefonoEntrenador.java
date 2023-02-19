package com.sofkau.integration.models;

public class telefonoEntrenador {
    String idtelefonoEntrenador;
    String numero;

    public telefonoEntrenador() {
    }

    public telefonoEntrenador(String idtelefonoEntrenador, String numero) {
        this.idtelefonoEntrenador = idtelefonoEntrenador;
        this.numero = numero;
    }

    public String getIdtelefonoEntrenador() {
        return idtelefonoEntrenador;
    }

    public void setIdtelefonoEntrenador(String idtelefonoEntrenador) {
        this.idtelefonoEntrenador = idtelefonoEntrenador;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "telefonoEntrenador{" +
                "idtelefonoEntrenador='" + idtelefonoEntrenador + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
