package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Dieta_alimento;

import java.util.List;

public interface IDieta_Alimento {

    public void insertDieta_Alimento (Dieta_alimento crearDieta_alimento);
    public List<Dieta_alimento> mostrarDietaAlimento ();
}
