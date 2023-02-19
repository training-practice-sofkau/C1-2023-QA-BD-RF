package com.sofkau.database.interfaces;

import com.sofkau.database.clases.CarritoDeCompra;
import com.sofkau.database.clases.Categoria;

import java.util.List;

public interface I_CarritoDeCompra {
    public void insertarCarritoCompra (CarritoDeCompra crearCarritoCompra);
    public List<CarritoDeCompra> mostrarCarritoCompra ();

    public CarritoDeCompra obtenerCarrito(int id_carrito);
}
