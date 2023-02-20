package org.sofka;

import org.sofka.repository.*;

import java.sql.SQLException;

public class Main {
    private static CategoriaRepository categoriaRepository;
    private static ZonaPostalRepository zonaPostalRepository;
    private static ClienteRepository clienteRepository;
    private static DireccionClienteRepository direccionClienteRepository;
    private static TelefonoClienteRepository telefonoClienteRepository;
    private static EstadoPedidoRepository estadoPedidoRepository;
    private static TipoPagoRepository tipoPagoRepository;
    private static DomiciliarioRepository domiciliarioRepository;
    private static ProveedorRepository proveedorRepository;
    private static TelefonoProveedorRepository telefonoProveedorRepository;
    private static ProductoRepository productoRepository;

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        // Genera registros de categorias
//        categoriaRepository = new CategoriaRepository();
//        categoriaRepository.generateData();

        // Genera registros de estado de pedidos
//           zonaPostalRepository=new ZonaPostalRepository();
//           zonaPostalRepository.generateData();

        // Genera registros de cliente
//        0

        // Genera registros de direccion de clientes
//        direccionClienteRepository = new DireccionClienteRepository();
//        direccionClienteRepository.generateData();

        //Genera registros de telefono cliente
//        telefonoClienteRepository = new TelefonoClienteRepository();
//        telefonoClienteRepository.generateData();

        // Genera registros de estado de pedido
//           estadoPedidoRepository=new EstadoPedidoRepository();
//           estadoPedidoRepository.generateData();

         //Generar registros domiciliarios
//           domiciliarioRepository = new DomiciliarioRepository();
//           domiciliarioRepository.generateData();

        // Genera registros de tipo de pago
//           tipoPagoRepository=new TipoPagoRepository();
//           tipoPagoRepository.generateData();

        //Genera registros de proveedor
//        00

        //Genera telefono proveedor
//        telefonoProveedorRepository = new TelefonoProveedorRepository();
//        telefonoProveedorRepository.generateData();

        // Generar registros de productos
        productoRepository = new ProductoRepository();
        productoRepository.generateData();
    }
}