package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Alimento;
import org.sofkau.dbZoo.clases.Alimento_logistico;

import java.util.List;

public interface IAlimento_logistico {

    public void insertAlimento_logistico (Alimento_logistico crearAlimento_logistico);
    public List<Alimento_logistico> mostrarAlimento_logistico ();
}
