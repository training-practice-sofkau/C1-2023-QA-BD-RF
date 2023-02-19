package org.sofkau.dbZoo.clases;

public class Veterinario {

    private String id_veterinario;
    private String nombre;
    private String telefono;

    public Veterinario(String id_veterinario, String nombre, String telefono) {
        this.id_veterinario = id_veterinario;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(String id_veterinario) {
        this.id_veterinario = id_veterinario;
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
