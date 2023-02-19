package org.sofkau.dbZoo.clases;

public class Emp_logistico {
    private String id_logistico;
    private String nombre;
    private String correo;

    public Emp_logistico(String id_logistico, String nombre, String correo) {
        this.id_logistico = id_logistico;
        this.nombre = nombre;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
