package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Tipo_alimento;

import java.util.List;

public interface ITipo_alimento {
    public void insertTipoAlimento (Tipo_alimento crearTipoAlimento);
    public List<Tipo_alimento> mostrarTipoAlimento ();
}
