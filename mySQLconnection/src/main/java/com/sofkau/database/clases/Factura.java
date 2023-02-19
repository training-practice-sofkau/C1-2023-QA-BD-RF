package com.sofkau.database.clases;

public class Factura {
    private String codigo_factura;
    private int total;
    private String ced_domiciliario;
    private String cedula_cliente;
    private String cod_pedido;

    public Factura(String codigo_factura, int total, String ced_domiciliario, String cedula_cliente, String cod_pedido) {
        this.codigo_factura = codigo_factura;
        this.total = total;
        this.ced_domiciliario = ced_domiciliario;
        this.cedula_cliente = cedula_cliente;
        this.cod_pedido = cod_pedido;
    }

    public String getCodigo_factura() {
        return codigo_factura;
    }

    public void setCodigo_factura(String codigo_factura) {
        this.codigo_factura = codigo_factura;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCed_domiciliario() {
        return ced_domiciliario;
    }

    public void setCed_domiciliario(String ced_domiciliario) {
        this.ced_domiciliario = ced_domiciliario;
    }

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(String cod_pedido) {
        this.cod_pedido = cod_pedido;
    }
}
