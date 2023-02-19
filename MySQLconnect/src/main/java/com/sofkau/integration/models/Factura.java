package com.sofkau.integration.models;

import java.util.Date;

public class Factura {
    private int idFactura;
    private int idEmpleado;
    private double valor;
    private Date fechaFactura;

    public Factura(int idFactura, int idEmpleado, double valor, Date fechaFactura) {
        this.idFactura = idFactura;
        this.idEmpleado = idEmpleado;
        this.valor = valor;
        this.fechaFactura = fechaFactura;
    }


    public Factura() {
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }
}
