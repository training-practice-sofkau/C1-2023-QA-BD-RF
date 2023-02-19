package com.sofkau.integracion.database.modelos;

public class Domiciliario {
    private String idDomiciliario;
    private String nombreDomiciliario;
    private String numeroMatricula;
    private String idZona;

    public Domiciliario(String idDomiciliario, String nombreDomiciliario, String numeroMatricula, String idZona) {
        this.idDomiciliario = idDomiciliario;
        this.nombreDomiciliario = nombreDomiciliario;
        this.numeroMatricula = numeroMatricula;
        this.idZona = idZona;
    }

    public String getIdDomiciliario() {
        return idDomiciliario;
    }

    public void setIdDomiciliario(String idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    public String getNombreDomiciliario() {
        return nombreDomiciliario;
    }

    public void setNombreDomiciliario(String nombreDomiciliario) {
        this.nombreDomiciliario = nombreDomiciliario;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }
}
