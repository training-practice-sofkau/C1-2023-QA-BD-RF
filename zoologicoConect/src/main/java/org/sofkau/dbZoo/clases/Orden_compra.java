package org.sofkau.dbZoo.clases;

public class Orden_compra {

    private String id_orden;
    private String fecha;
    private String nombre_alimento;
    private String cantidad;
    private String id_logisticos;
    private String id_proveedors;
    private String onservaciones;

    public Orden_compra(String id_orden,
                        String fecha,
                        String nombre_alimento,
                        String cantidad,
                        String id_logisticos,
                        String id_proveedors,
                        String onservaciones) {
        this.id_orden = id_orden;
        this.fecha = fecha;
        this.nombre_alimento = nombre_alimento;
        this.cantidad = cantidad;
        this.id_logisticos = id_logisticos;
        this.id_proveedors = id_proveedors;
        this.onservaciones = onservaciones;
    }

    public String getId_orden() {
        return id_orden;
    }

    public void setId_orden(String id_orden) {
        this.id_orden = id_orden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre_alimento() {
        return nombre_alimento;
    }

    public void setNombre_alimento(String nombre_alimento) {
        this.nombre_alimento = nombre_alimento;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getId_logisticos() {
        return id_logisticos;
    }

    public void setId_logisticos(String id_logisticos) {
        this.id_logisticos = id_logisticos;
    }

    public String getId_proveedors() {
        return id_proveedors;
    }

    public void setId_proveedors(String id_proveedors) {
        this.id_proveedors = id_proveedors;
    }

    public String getOnservaciones() {
        return onservaciones;
    }

    public void setOnservaciones(String onservaciones) {
        this.onservaciones = onservaciones;
    }
}
