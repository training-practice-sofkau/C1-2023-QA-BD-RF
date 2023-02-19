package org.sofkau.dbZoo.clases;

public class Entrenador {

    private String id_entrenador;
    private String nombre;
    private String telefono;
    private String id_veterinarios;

    public Entrenador(String id_entrenador, String nombre, String telefono, String id_veterinarios) {
        this.id_entrenador = id_entrenador;
        this.nombre = nombre;
        this.telefono = telefono;
        this.id_veterinarios = id_veterinarios;
    }

    public String getId_entrenador() {
        return id_entrenador;
    }

    public void setId_entrenador(String id_entrenador) {
        this.id_entrenador = id_entrenador;
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

    public String getId_veterinarios() {
        return id_veterinarios;
    }

    public void setId_veterinarios(String id_veterinarios) {
        this.id_veterinarios = id_veterinarios;
    }
}
