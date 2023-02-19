package com.sofkau.database.interfaces;

import com.sofkau.database.clases.Cliente;
import com.sofkau.database.clases.Proveedor;

import java.util.List;

public interface I_Proveedor {
    public void insertarProveedor (Proveedor crearProveedor);
    public List<Proveedor> mostrarProveedor ();
}
