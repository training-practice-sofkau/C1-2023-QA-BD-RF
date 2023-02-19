package com.sofka.sofkau.integracion.modelo;

public class Veterinario implements ITabla{
    @Override
    public String getTabla() {
        return "veterinario";
    }
    @Override
    public String getAtributos() {
        return "nombre";
    }
    @Override
    public String getValores() {
        return "'"+FakerLlenar.getRandom().getFaker().name().fullName()+" "+"'";
    }
}
