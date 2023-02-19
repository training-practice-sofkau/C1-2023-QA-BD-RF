package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Alimento;

import java.util.List;

public interface IAlimento {

    public void insertAlimento (Alimento crearAlimento);
    public List<Alimento> mostrarAlimento ( );
}
