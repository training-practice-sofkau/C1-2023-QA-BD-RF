package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Proveedor_factura;

import java.util.List;

public interface IProveedor_factura {

    public void insertProveedorFactura (Proveedor_factura crearProveedorFactura);
    public List<Proveedor_factura> mostrarProveedorFactura ();
}
