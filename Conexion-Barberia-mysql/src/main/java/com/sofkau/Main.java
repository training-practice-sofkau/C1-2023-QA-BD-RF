package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.mysql.ConexionMysql;
import com.sofkau.mysql.model.*;
import com.sofkau.mysql.repository.*;

import java.sql.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        try (Connection conn = ConexionMysql.getConnection()) {

            IRepository<Producto> repositoryProducto = new ProductoRepositoryImpl();
            IRepository<Cliente> repositoryCliente = new ClienteRepositoryImpl();
            IRepository<Cita> repositoryCita = new CitaRepositoryImpl();
            IRepository<Empleado> repositoryEmpleado = new EmpleadoRepositoryImpl();
            IRepository<Ventas> repositoryVentas = new VentaRepositoryImpl();
            IRepository<Servicios> repositoryServicios = new ServiciosRepositoryImpl();

            System.out.println("=========== insertar producto ==============");

            for (int i = 1; i <= 50; i++) {

                Empleado empleadonew = new Empleado();

                empleadonew.setCedula(String.valueOf(faker.number().numberBetween(1000000000,1999999999)));
                empleadonew.setNombre(faker.name().firstName());
                empleadonew.setEspecialidad(faker.job().title());
                repositoryEmpleado.save(empleadonew);

                Producto productonew = new Producto();
                productonew.setNombre("Producto marca "+faker.funnyName().name());
                productonew.setCantidad(faker.number().numberBetween(1,100));
                productonew.setPrecio((double) faker.number().numberBetween(200,1733));
                productonew.setProveedor(faker.name().firstName());
                repositoryProducto.save(productonew);

                Cliente clientenew = new Cliente();
                clientenew.setCedula(String.valueOf(faker.number().numberBetween(1000000000,1999999999)));
                clientenew.setNombre(faker.name().firstName());
                clientenew.setProfesion(faker.job().title());
                clientenew.setTelefono(faker.phoneNumber().subscriberNumber(8));
                clientenew.setCorreo(faker.internet().emailAddress());
                clientenew.setDireccion(faker.address().streetAddress());
                clientenew.setEdad(faker.number().numberBetween(10,60));
                repositoryCliente.save(clientenew);

                Cita citanew = new Cita();
                citanew.setCliente(i);
                citanew.setEmpleado(i);
                citanew.setFechaHora(new Date());
                repositoryCita.save(citanew);

                Ventas ventasnew = new Ventas();
                ventasnew.setFecha(new Date());
                ventasnew.setClienteId(i);
                ventasnew.setProductoId(i);
                ventasnew.setEmpleadoId(i);
                ventasnew.setLigaGanancia((double) faker.number().numberBetween(266,678));
                repositoryVentas.save(ventasnew);

                Servicios serviciosnew = new Servicios();
                serviciosnew.setFecha(new Date());
                serviciosnew.setCliente_id(i);
                serviciosnew.setEmpleado_id(i);
                serviciosnew.setDuracion_procedimiento(faker.number().numberBetween(10,30));
                serviciosnew.setProductos_consumidos("champu: "+ faker.funnyName().name());
                repositoryServicios.save(serviciosnew);
                System.out.println(serviciosnew.toString());


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}