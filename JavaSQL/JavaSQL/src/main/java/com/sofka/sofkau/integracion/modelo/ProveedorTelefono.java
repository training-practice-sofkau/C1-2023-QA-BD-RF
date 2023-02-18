package com.sofka.sofkau.integracion.modelo;

public class ProveedorTelefono implements ITabla{
    @Override
    public String getTabla() {
        return "telefono_proveedor";
    }

    @Override
    public boolean esForanea() {
        return true;
    }

    @Override
    public String getAtributos() {
        return "idProceedor_telefono,telefono_proveedor";
    }

    @Override
    public String getValores() {
        return ""+FakerLlenar.getRandom().getFaker().phoneNumber().phoneNumber();
    }
}
