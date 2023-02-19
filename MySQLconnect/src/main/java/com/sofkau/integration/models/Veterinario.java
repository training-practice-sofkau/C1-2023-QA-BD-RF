package com.sofkau.integration.models;

public class Veterinario {
    String idVeterinario;
    String nombre_veterinario;
    String telefono;

    public Veterinario(String idVeterinario, String nombre_veterinario, String telefono) {
        this.idVeterinario = idVeterinario;
        this.nombre_veterinario = nombre_veterinario;
        this.telefono = telefono;
    }

    public Veterinario() {
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNombre_veterinario() {
        return nombre_veterinario;
    }

    public void setNombre_veterinario(String nombre_veterinario) {
        this.nombre_veterinario = nombre_veterinario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
