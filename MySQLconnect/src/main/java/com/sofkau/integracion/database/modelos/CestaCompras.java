package com.sofkau.integracion.database.modelos;

public class CestaCompras {
    private String idCestaCompras;
    private String fechaCreacion;
    private String cedulaCliente;

    public CestaCompras(String idCestaCompras, String fechaCreacion, String cedulaCliente) {
        this.idCestaCompras = idCestaCompras;
        this.fechaCreacion = fechaCreacion;
        this.cedulaCliente = cedulaCliente;
    }

    public String getIdCestaCompras() {
        return idCestaCompras;
    }

    public void setIdCestaCompras(String idCestaCompras) {
        this.idCestaCompras = idCestaCompras;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }
}
