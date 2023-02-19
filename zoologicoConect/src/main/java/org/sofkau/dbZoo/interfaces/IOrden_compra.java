package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Orden_compra;

import java.util.List;

public interface IOrden_compra {

    public void insertOrden_compra (Orden_compra crearOrden_compra);
    public List<Orden_compra> mostrarOrden_compra ();
}
