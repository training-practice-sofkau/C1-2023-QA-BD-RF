package com.sofkau.integration.models;

public class InformeAnimal {
    private String id_informe;
    private String fecha_peso;
    private String peso_registrado;
    private String detalles;
    private String id_animal_informe;
    private String id_entrenador_informe;

    public InformeAnimal(String id_informe, String fecha_peso, String peso_registrado, String detalles, String id_animal_informe, String id_entrenador_informe) {
        this.id_informe = id_informe;
        this.fecha_peso = fecha_peso;
        this.peso_registrado = peso_registrado;
        this.detalles = detalles;
        this.id_animal_informe = id_animal_informe;
        this.id_entrenador_informe = id_entrenador_informe;
    }

    public InformeAnimal() {
    }

    public String getId_informe() {
        return id_informe;
    }

    public void setId_informe(String id_informe) {
        this.id_informe = id_informe;
    }

    public String getFecha_peso() {
        return fecha_peso;
    }

    public void setFecha_peso(String fecha_peso) {
        this.fecha_peso = fecha_peso;
    }

    public String getPeso_registrado() {
        return peso_registrado;
    }

    public void setPeso_registrado(String peso_registrado) {
        this.peso_registrado = peso_registrado;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getId_animal_informe() {
        return id_animal_informe;
    }

    public void setId_animal_informe(String id_animal_informe) {
        this.id_animal_informe = id_animal_informe;
    }

    public String getId_entrenador_informe() {
        return id_entrenador_informe;
    }

    public void setId_entrenador_informe(String id_entrenador_informe) {
        this.id_entrenador_informe = id_entrenador_informe;
    }

    @Override
    public String toString() {
        return "InformeAnimal{" +
                "id_informe='" + id_informe + '\'' +
                ", fecha_peso='" + fecha_peso + '\'' +
                ", peso_registrado='" + peso_registrado + '\'' +
                ", detalles='" + detalles + '\'' +
                ", id_animal_informe='" + id_animal_informe + '\'' +
                ", id_entrenador_informe='" + id_entrenador_informe + '\'' +
                '}';
    }
}
