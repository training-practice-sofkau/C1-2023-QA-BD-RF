package com.sofkau.database.clases;

public class Domiciliario {
    private String cedula_domiciliario;
    private String nombre;
    private String num_matricula;

    public Domiciliario(String cedula_domiciliario, String nombre, String num_matricula) {
        this.cedula_domiciliario = cedula_domiciliario;
        this.nombre = nombre;
        this.num_matricula = num_matricula;
    }

    public String getCedula_domiciliario() {
        return cedula_domiciliario;
    }

    public void setCedula_domiciliario(String cedula_domiciliario) {
        this.cedula_domiciliario = cedula_domiciliario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(String num_matricula) {
        this.num_matricula = num_matricula;
    }
}
