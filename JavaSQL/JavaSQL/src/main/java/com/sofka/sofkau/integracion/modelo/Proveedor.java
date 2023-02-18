package com.sofka.sofkau.integracion.modelo;

public class Proveedor implements ITabla{
    @Override
    public String getTabla() {
        return "proveedor";
    }

    @Override
    public boolean esForanea() {
        return false;
    }

    @Override
    public String getAtributos() {
        return "nombre";
    }

    @Override
    public String getValores() {
        return FakerLlenar.getRandom().getFaker().name().fullName()+"";
    }
}
