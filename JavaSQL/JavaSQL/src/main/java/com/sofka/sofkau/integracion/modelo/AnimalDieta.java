package com.sofka.sofkau.integracion.modelo;
public class AnimalDieta implements ITabla{
    @Override
    public String getTabla() {
        return "animal_dieta";
    }
    @Override
    public boolean esForanea() {
        return true;
    }

    @Override
    public String getAtributos() {
        return "idAlimento_dieta,idDieta_alimento";
    }

    @Override
    public String getValores() {
        return FakerLlenar.getRandom().getRand().nextInt(48)+1
                +","+FakerLlenar.getRandom().getRand().nextInt(49)+1;
    }
}
