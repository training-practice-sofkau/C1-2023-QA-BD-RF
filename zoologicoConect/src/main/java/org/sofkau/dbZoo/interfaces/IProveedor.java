package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Proveedor;

import java.util.List;

public interface IProveedor {

    public void insertProveedor (Proveedor crearProveedor);
    public List<Proveedor> mostrarProveedor ();
}
