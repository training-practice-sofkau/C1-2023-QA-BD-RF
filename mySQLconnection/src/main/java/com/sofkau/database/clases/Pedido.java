package com.sofkau.database.clases;

import java.sql.Date;

public class Pedido {
    private String codigo_pedido;
    private Date fecha;
    private String num_tarjeta;
    private Date fecha_caducidad;
    private int id_carrito;

    public Pedido(String codigo_pedido, Date fecha, String num_tarjeta, Date fecha_caducidad, int id_carrito) {
        this.codigo_pedido = codigo_pedido;
        this.fecha = fecha;
        this.num_tarjeta = num_tarjeta;
        this.fecha_caducidad = fecha_caducidad;
        this.id_carrito = id_carrito;
    }

    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }
}
