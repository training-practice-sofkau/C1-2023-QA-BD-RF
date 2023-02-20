package com.sofkau.models;

public class Pedido {
    private int ID;
    private String fecha_caducidad;
    private String numero_tarjeta;
    private String fecha_pedido;
    private String direccion_entrega;
    private String importe_total_pedido;
    private int id_cliente;
    private int id_domiciliario;

    public Pedido() {
    }

    public Pedido(int ID, String fecha_caducidad, String numero_tarjeta, String fecha_pedido,
                  String direccion_entrega, String importe_total_pedido, int id_cliente, int id_domiciliario) {
        this.ID = ID;
        this.fecha_caducidad = fecha_caducidad;
        this.numero_tarjeta = numero_tarjeta;
        this.fecha_pedido = fecha_pedido;
        this.direccion_entrega = direccion_entrega;
        this.importe_total_pedido = importe_total_pedido;
        this.id_cliente = id_cliente;
        this.id_domiciliario = id_domiciliario;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public void setDireccion_entrega(String direccion_entrega) {
        this.direccion_entrega = direccion_entrega;
    }

    public String getImporte_total_pedido() {
        return importe_total_pedido;
    }

    public void setImporte_total_pedido(String importe_total_pedido) {
        this.importe_total_pedido = importe_total_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_domiciliario() {
        return id_domiciliario;
    }

    public void setId_domiciliario(int id_domiciliario) {
        this.id_domiciliario = id_domiciliario;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "ID=" + ID +
                ", fecha_caducidad='" + fecha_caducidad + '\'' +
                ", numero_tarjeta='" + numero_tarjeta + '\'' +
                ", fecha_pedido='" + fecha_pedido + '\'' +
                ", direccion_entrega='" + direccion_entrega + '\'' +
                ", importe_total_pedido='" + importe_total_pedido + '\'' +
                ", id_cliente=" + id_cliente +
                ", id_domiciliario=" + id_domiciliario +
                '}';
    }
}
