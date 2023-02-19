package com.sofkau;

import com.sofkau.integration.database.MySqlConnector;

import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        MySqlConnector connector = new MySqlConnector(
                "db_barberia",
                "root",
                "Qwerty12345"
        );
        connector.connect();

        Barberia barberia = new Barberia (connector, 50);

        boolean running = true;
        Scanner entrada = new Scanner(System.in);

        while (running){
            System.out.println("Ingresa una opción");
            System.out.println("1. Llenar proveedores");
            System.out.println("2. Llenar productos");
            System.out.println("3. llenar clientes");
            System.out.println("4. llenar servicios");
            System.out.println("5. llenar empleados");
            System.out.println("6. llenar teléfono proveedor");
            System.out.println("7. llenar teléfono cliente");
            System.out.println("8. llenar compra");
            System.out.println("9. llenar venta");
            System.out.println("10. llenar citas");
            System.out.println("11. llenar historial servicio");
            System.out.println("12. Salir");

            int opcion = entrada.nextInt();

            switch (opcion){
                case 1:
                    barberia.llenarProveedores();
                    break;
                case 2:
                    barberia.llenarProductos();
                    break;
                case 3:
                    barberia.llenarClientes();
                    break;
                case 4:
                    barberia.llenarServicios();
                    break;
                case 5:
                    barberia.llenarEmpleados();
                    break;
                case 6:
                    barberia.llenarTelefonoProveedor();
                    break;
                case 7:
                    barberia.llenarTelefonoCliente();
                    break;
                case 8:
                    barberia.llenarCompra();
                    break;
                case 9:
                    barberia.llenarVenta();
                    break;
                case 10:
                    barberia.llenarCita();
                    break;
                case 11:
                    barberia.llenarHistorialServicio();
                    break;
                case 12:
                    System.out.println("¡Hasta luego!");
                    running = false;
                    break;
                default: break;
            }
        }

        connector.closeConnection();
    }
}
