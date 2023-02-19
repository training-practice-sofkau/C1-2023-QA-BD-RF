package com.sofkau.integration.database.models;

public class Informe_Peso {

    String id_informe;
    String fecha;
    String peso;
    String detalle;
    String entrenador_id;
    String animal_id;

    public Informe_Peso(String id_informe, String fecha, String peso, String detalle, String entrenador_id, String animal_id) {
        this.id_informe = id_informe;
        this.fecha = fecha;
        this.peso = peso;
        this.detalle = detalle;
        this.entrenador_id = entrenador_id;
        this.animal_id = animal_id;
    }

    public Informe_Peso() {
    }

    public String getId_informe() {
        return id_informe;
    }

    public void setId_informe(String id_informe) {
        this.id_informe = id_informe;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEntrenador_id() {
        return entrenador_id;
    }

    public void setEntrenador_id(String entrenador_id) {
        this.entrenador_id = entrenador_id;
    }

    public String getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(String animal_id) {
        this.animal_id = animal_id;
    }
}
