package com.sofkau.integracion.database.modelos;

public class TelefonoCliente {
    private String cedulaCliente;
    private String telefoCliente;

    public TelefonoCliente(String cedulaCliente, String telefoCliente) {
        this.cedulaCliente = cedulaCliente;
        this.telefoCliente = telefoCliente;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getTelefoCliente() {
        return telefoCliente;
    }

    public void setTelefoCliente(String telefoCliente) {
        this.telefoCliente = telefoCliente;
    }
}
