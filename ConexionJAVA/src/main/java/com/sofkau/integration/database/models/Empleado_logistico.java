package com.sofkau.integration.database.models;

public class Empleado_logistico {

    private String id_empleado_logistico;
    private String nombre_empleado_logistico;
    private String telefono;

    public Empleado_logistico(String id_empleado_logistico, String nombre_empleado_logistico, String telefono) {
        this.id_empleado_logistico = id_empleado_logistico;
        this.nombre_empleado_logistico = nombre_empleado_logistico;
        this.telefono = telefono;
    }
    public Empleado_logistico(){}

    public String getId_empleado_logistico() {
        return id_empleado_logistico;
    }

    public void setId_empleado_logistico(String id_empleado_logistico) {
        this.id_empleado_logistico = id_empleado_logistico;
    }

    public String getNombre_empleado_logistico() {
        return nombre_empleado_logistico;
    }

    public void setNombre_empleado_logistico(String nombre_empleado_logistico) {
        this.nombre_empleado_logistico = nombre_empleado_logistico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
