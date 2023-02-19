package com.sofkau.database.interfaces;

import com.sofkau.database.clases.Categoria;
import com.sofkau.database.clases.Cliente;

import java.util.List;

public interface I_Cliente {
    public void insertarCliente (Cliente crearCliente);

    List<Cliente> mostrarCliente();
    public Cliente obtenerCliente (String ced_cliente);
}
