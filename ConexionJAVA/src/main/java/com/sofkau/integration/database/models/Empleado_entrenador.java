package com.sofkau.integration.database.models;

public class Empleado_entrenador {

    private String id_empleado_entrenador ;
    private String nombre_empleado_entrenador;
    private String telefono_empleado_entrnador;

    public Empleado_entrenador(String id_empleado_entrenador, String nombre_empleado_entrenador, String telefono_empleado_entrnador){
        this.id_empleado_entrenador=id_empleado_entrenador;
        this.nombre_empleado_entrenador=  nombre_empleado_entrenador;
        this.telefono_empleado_entrnador= telefono_empleado_entrnador;
    }
    public Empleado_entrenador(){}
    public String getId_empleado_entrenador() {
        return id_empleado_entrenador;
    }

    public void setId_empleado_entrenador(String id_empleado_entrenador) {
        this.id_empleado_entrenador = id_empleado_entrenador;
    }

    public String getNombre_empleado_entrenador() {
        return nombre_empleado_entrenador;
    }

    public void setNombre_empleado_entrenador(String nombre_empleado_entrenador) {
        this.nombre_empleado_entrenador = nombre_empleado_entrenador;
    }

    public String getTelefono_empleado_entrnador() {
        return telefono_empleado_entrnador;
    }

    public void setTelefono_empleado_entrnador(String telefono_empleado_entrnador) {
        this.telefono_empleado_entrnador = telefono_empleado_entrnador;
    }

    @Override
    public String toString() {
        return "Empleado_entrenador{" +
                "id_empleado_entrenador='" + id_empleado_entrenador + '\'' +
                ", nombre_empleado_entrenador='" + nombre_empleado_entrenador + '\'' +
                ", telefono_empleado_entrnador='" + telefono_empleado_entrnador + '\'' +
                '}';
    }
}
