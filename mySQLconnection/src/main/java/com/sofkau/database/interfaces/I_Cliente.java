package com.sofkau.database.interfaces;

import com.sofkau.database.clases.Categoria;
import com.sofkau.database.clases.Cliente;

import java.util.List;

public interface I_Cliente {
    public void insertarCliente (Cliente crearCliente);
    public List<Cliente> mostrarCliente ();
}
