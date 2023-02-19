package com.sofkau.integration.database.models;

public class Empleado_veterinario {

    private String id_empleado_veterinario;
    private String nombre_empleado_veterinario;
    private String telefono_empleado_veterinario;

    public Empleado_veterinario(String id_empleado_veterinario, String nombre_empleado_veterinario, String telefono_empleado_veterinario){
        this.id_empleado_veterinario=id_empleado_veterinario;
        this.nombre_empleado_veterinario=nombre_empleado_veterinario;
        this.telefono_empleado_veterinario=telefono_empleado_veterinario;
    }

    public Empleado_veterinario(){}

    public String getId_empleado_veterinario() {
        return id_empleado_veterinario;
    }

    public void setId_empleado_veterinario(String id_empleado_veterinario) {
        this.id_empleado_veterinario = id_empleado_veterinario;
    }

    public String getNombre_empleado_veterinario() {
        return nombre_empleado_veterinario;
    }

    public void setNombre_empleado_veterinario(String nombre_empleado_veterinario) {
        this.nombre_empleado_veterinario = nombre_empleado_veterinario;
    }

    public String getTelefono_empleado_veterinario() {
        return telefono_empleado_veterinario;
    }

    public void setTelefono_empleado_veterinario(String telefono_empleado_veterinario) {
        this.telefono_empleado_veterinario = telefono_empleado_veterinario;
    }
}
