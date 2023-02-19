package com.sofkau.integration.models;

public  class especie {
    String idEspecie;
    String nombreEspecie;

    public especie() {
    }

    public especie(String idEspecie, String nombreEspecie) {
        this.idEspecie = idEspecie;
        this.nombreEspecie = nombreEspecie;
    }

    public String getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(String idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    @Override
    public String toString() {
        return "especie{" +
                "idEspecie='" + idEspecie + '\'' +
                ", nombreEspecie='" + nombreEspecie + '\'' +
                '}';
    }
}
