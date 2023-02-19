package com.sofkau.integracion.database.modelos;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Zona {
    private String idZona;
    private String codigoPostal;

    public Zona(String idZona, String codigoPostal) {
        this.idZona = idZona;
        this.codigoPostal = codigoPostal;
    }

    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
