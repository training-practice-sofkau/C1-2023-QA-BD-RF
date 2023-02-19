package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Alimento;
import org.sofkau.dbZoo.clases.Dieta;

import java.util.List;

public interface IDieta {

    public void insertDieta (Dieta crearDieta);
    public List<Dieta> mostrarDieta ();
}
