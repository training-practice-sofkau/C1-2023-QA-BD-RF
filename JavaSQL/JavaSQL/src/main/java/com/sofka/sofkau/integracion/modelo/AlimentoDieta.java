package com.sofka.sofkau.integracion.modelo;

public class AlimentoDieta implements ITabla{
    @Override
    public String getTabla() {
        return "alimento_dieta";
    }

    @Override
    public boolean esForanea() {
        return true;
    }

    @Override
    public String getAtributos() {
        return "idAnimal_dieta,idDieta_animal";
    }

    @Override
    public String getValores() {
        return FakerLlenar.getRandom().getRand().nextInt(48)+1
                +","+FakerLlenar.getRandom().getRand().nextInt(49)+1;
    }
}
