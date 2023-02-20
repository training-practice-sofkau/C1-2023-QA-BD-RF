package org.sofka.model;

public class TipoPago {
  private  String tipoPago;
 private  String numerotarjeta;
  private String fechaCaducidad;

    public TipoPago() {
    }

    public TipoPago(String tipoPago, String numerotarjeta, String fechaCaducidad) {
        this.tipoPago = tipoPago;
        this.numerotarjeta = numerotarjeta;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getNumerotarjeta() {
        return numerotarjeta;
    }

    public void setNumerotarjeta(String numerotarjeta) {
        this.numerotarjeta = numerotarjeta;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
}
