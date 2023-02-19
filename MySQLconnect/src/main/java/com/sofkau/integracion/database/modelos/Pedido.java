package com.sofkau.integracion.database.modelos;

public class Pedido {
    private String codigoPedido;
    private String fechaPedido;
    private String direccionEntrega;
    private int importeTotal;
    private String datosDePago;
    private String cedulaCliente;
    private String idDomiciliario;
    private String idCestaCompras;

    public Pedido(String codigoPedido, String fechaPedido,
                  String direccionEntrega, int importeTotal,
                  String datosDePago, String cedulaCliente,
                  String idDomiciliario, String idCestaCompras) {
        this.codigoPedido = codigoPedido;
        this.fechaPedido = fechaPedido;
        this.direccionEntrega = direccionEntrega;
        this.importeTotal = importeTotal;
        this.datosDePago = datosDePago;
        this.cedulaCliente = cedulaCliente;
        this.idDomiciliario = idDomiciliario;
        this.idCestaCompras = idCestaCompras;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public int getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(int importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getDatosDePago() {
        return datosDePago;
    }

    public void setDatosDePago(String datosDePago) {
        this.datosDePago = datosDePago;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getIdDomiciliario() {
        return idDomiciliario;
    }

    public void setIdDomiciliario(String idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    public String getIdCestaCompras() {
        return idCestaCompras;
    }

    public void setIdCestaCompras(String idCestaCompras) {
        this.idCestaCompras = idCestaCompras;
    }
}
