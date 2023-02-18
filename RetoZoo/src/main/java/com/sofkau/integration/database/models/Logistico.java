package com.sofkau.integration.database.models;

public class Logistico {
     String id_logistico;
     String nombre;
     String telefono;

    public Logistico(String id_logistico, String nombre, String telefono) {
        this.id_logistico = id_logistico;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Logistico() {
    }

    public String getId_logistico() {
        return id_logistico;
    }

    public void setId_logistico(String id_logistico) {
        this.id_logistico = id_logistico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

