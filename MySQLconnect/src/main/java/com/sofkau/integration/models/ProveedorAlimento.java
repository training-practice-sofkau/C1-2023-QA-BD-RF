package com.sofkau.integration.models;

public class ProveedorAlimento {
    private String id_proveedor_alimento;
    private String id_alimento_proveedor;

    public ProveedorAlimento(String id_proveedor_alimento, String id_alimento_proveedor) {
        this.id_proveedor_alimento = id_proveedor_alimento;
        this.id_alimento_proveedor = id_alimento_proveedor;
    }

    public ProveedorAlimento() {
    }

    public String getId_proveedor_alimento() {
        return id_proveedor_alimento;
    }

    public void setId_proveedor_alimento(String id_proveedor_alimento) {
        this.id_proveedor_alimento = id_proveedor_alimento;
    }

    public String getId_alimento_proveedor() {
        return id_alimento_proveedor;
    }

    public void setId_alimento_proveedor(String id_alimento_proveedor) {
        this.id_alimento_proveedor = id_alimento_proveedor;
    }

    @Override
    public String toString() {
        return "proveedor_alimento{" +
                "id_proveedor_alimento='" + id_proveedor_alimento + '\'' +
                ", id_alimento_proveedor='" + id_alimento_proveedor + '\'' +
                '}';
    }
}
