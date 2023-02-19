package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Factura;

import java.util.List;

public interface IFactura {

    public void insertFactura (Factura crearFactura);
    public List<Factura> mostrarFactura ();
}
