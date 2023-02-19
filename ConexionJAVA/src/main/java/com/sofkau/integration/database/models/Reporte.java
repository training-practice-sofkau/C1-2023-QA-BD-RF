package com.sofkau.integration.database.models;

public class Reporte {

    private String id_reporte ;
    private String peso_ultimo ;
    private String fecha_ultimo_peso ;
    private String detalles ;
    private String id_empleado_entrenador_r ;
    private String id_animal_r;

    public Reporte(String id_reporte, String peso_ultimo, String fecha_ultimo_peso, String detalles, String id_empleado_entrenador_r, String id_animal_r) {
        this.id_reporte = id_reporte;
        this.peso_ultimo = peso_ultimo;
        this.fecha_ultimo_peso = fecha_ultimo_peso;
        this.detalles = detalles;
        this.id_empleado_entrenador_r = id_empleado_entrenador_r;
        this.id_animal_r = id_animal_r;
    }

    public Reporte(){}

    public String getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(String id_reporte) {
        this.id_reporte = id_reporte;
    }

    public String getPeso_ultimo() {
        return peso_ultimo;
    }

    public void setPeso_ultimo(String peso_ultimo) {
        this.peso_ultimo = peso_ultimo;
    }

    public String getFecha_ultimo_peso() {
        return fecha_ultimo_peso;
    }

    public void setFecha_ultimo_peso(String fecha_ultimo_peso) {
        this.fecha_ultimo_peso = fecha_ultimo_peso;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getId_empleado_entrenador_r() {
        return id_empleado_entrenador_r;
    }

    public void setId_empleado_entrenador_r(String id_empleado_entrenador_r) {
        this.id_empleado_entrenador_r = id_empleado_entrenador_r;
    }

    public String getId_animal_r() {
        return id_animal_r;
    }

    public void setId_animal_r(String id_animal_r) {
        this.id_animal_r = id_animal_r;
    }
}
