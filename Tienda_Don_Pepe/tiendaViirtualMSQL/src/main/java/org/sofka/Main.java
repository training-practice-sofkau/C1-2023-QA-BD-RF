package org.sofka;

import org.sofka.repository.*;

import java.sql.SQLException;

public class Main {
    private static CategoriaRepository categoriaRepository;
    private static ZonaPostalRepository zonaPostalRepository;
    private static ClienteRepository clienteRepository;
    private static DireccionClienteRepository direccionClienteRepository;
    private static TelefonoClienteRepository telefonoClienteRepository;

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        // Genera registros de categorias
//        categoriaRepository = new CategoriaRepository();
//        categoriaRepository.generateData();

        // Genera registros de estado de pedidos
//           zonaPostalRepository=new ZonaPostalRepository();
//           zonaPostalRepository.generateData();

        // Genera registros de cliente
        clienteRepository = new ClienteRepository();
        clienteRepository.generateData();

        // Genera registros de direccion de clientes
        direccionClienteRepository = new DireccionClienteRepository();
        direccionClienteRepository.generateData();

        //Genera registros de telefono cliente
        telefonoClienteRepository = new TelefonoClienteRepository();
        telefonoClienteRepository.generateData();


    }
}