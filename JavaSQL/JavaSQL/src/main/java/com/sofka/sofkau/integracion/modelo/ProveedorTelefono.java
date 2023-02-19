package com.sofka.sofkau.integracion.modelo;

public class ProveedorTelefono implements ITabla{
    @Override
    public String getTabla() {
        return "telefono_proveedor";
    }
    @Override
    public String getAtributos() {
        return "idProveedor_telefono,telefono_proveedor";
    }

    @Override
    public String getValores() {
        return "'"+(FakerLlenar.getRandom().getRand().nextInt(48)+1)+"'"+","+"'"+FakerLlenar.getRandom().getFaker().phoneNumber().cellPhone()+"'";
    }
}
