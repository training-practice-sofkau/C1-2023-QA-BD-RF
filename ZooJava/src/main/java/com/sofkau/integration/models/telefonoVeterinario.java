package com.sofkau.integration.models;


public class telefonoVeterinario {

    String idtelefonoVeterinario;
    String numero;

    public telefonoVeterinario() {
    }

    public telefonoVeterinario(String idtelefonoVeterinario, String numero) {
        this.idtelefonoVeterinario = idtelefonoVeterinario;
        this.numero = numero;
    }

    public String getIdtelefonoVeterinario() {
        return idtelefonoVeterinario;
    }

    public void setIdtelefonoVeterinario(String idtelefonoVeterinario) {
        this.idtelefonoVeterinario = idtelefonoVeterinario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "telefonoVeterinario{" +
                "idtelefonoVeterinario='" + idtelefonoVeterinario + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}