package org.sofka.model;

public class Domiciliario {

    private String id;
    private String nombre;

    private String matricula;

    private String zonaReparto;
    private String idZonapostal;


    public Domiciliario() {
    }

    public Domiciliario(String id, String nombre, String matricula, String zonaReparto, String idZonapostal) {
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
        this.zonaReparto = zonaReparto;
        this.idZonapostal = idZonapostal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getZonaReparto() {
        return zonaReparto;
    }

    public void setZonaReparto(String zonaReparto) {
        this.zonaReparto = zonaReparto;
    }

    public String getIdZonapostal() {
        return idZonapostal;
    }

    public void setIdZonapostal(String idZonapostal) {
        this.idZonapostal = idZonapostal;
    }
}


