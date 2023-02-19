package com.sofkaU;

import com.github.javafaker.Faker;
import com.sofkaU.integration.database.models.*;
import com.sofkaU.integration.database.mysql.MySqlOperation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    /**
     * Credenciales para ingresar a la base de datos.
     */
    private static final String SERVER="localhost:3307";
    private static final String DATA_BASE_NAME="barberia";
    private static final String USER="root";
    private static final String PASSWORD="admi";

    private static final MySqlOperation mySqlOperation= new MySqlOperation();
    private static Faker faker = new Faker();

    public static void main(String[] args) {
        openConnection();
        //insertarProveedor();
        //insertarProducto();
        //insertarInsumo();
        //insertarCliente();
       // insertarClienteTelefono();
       //insertarClienteProfesion();
        //insertarCita();
        //insertarServicio();
        //insertarEmpleado();
        //insertarEspecialidadEmpleado();
        //insertarServicioEmpleado();
       // insertarCotizacion();
        //insertarVenta();
        servicioInsumo();


    }
    public static void openConnection(){
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }

    public static void closeConnection(){
        mySqlOperation.close();

    }

    /**
     * Método para insertar datos en tabla Proveedor.
     */
    private static void insertarProveedor(){

        for (int i = 1; i < 300; i++) {

            Proveedor prov = new Proveedor();
            prov.setNit(i);
            prov.setNombre(faker.company().name());
            prov.setDireccion(faker.address().streetAddress());
            mySqlOperation.setSqlStatement("insert into proveedor values("+prov.getNit()+",'"+prov.getNombre()+"', '"+prov.getDireccion()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    /**
     * Método para insertar datos en tabla Producto
     */
    private static void insertarProducto(){

        for (int i = 1; i < 300; i++) {

            Producto prod = new Producto();
            prod.setREF(i);
            prod.setNombre(faker.funnyName().name());
            prod.setCantidad(faker.random().nextInt(12,90));
            prod.setPrecioCompra(faker.number().randomDouble(1,12900,180000));
            prod.setPrecioVenta(faker.number().randomDouble(1,180000,200000));
            prod.setNITproveedor(i);

            mySqlOperation.setSqlStatement("insert into producto values("+prod.getREF()+",'"+prod.getNombre()+"', "+prod.getCantidad()+","+prod.getPrecioCompra()+","+prod.getPrecioVenta()+","+prod.getNITproveedor()+");");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    /**
     * Método para insertar datos en tabla insumos
     */
    private static void insertarInsumo(){

        for (int i = 1; i < 500; i++) {

            Insumo insumo= new Insumo();
            insumo.setREF(i);
            insumo.setNombre(faker.funnyName().name());
            insumo.setCantidad(faker.random().nextInt(12,90));
            insumo.setPrecioCompra(faker.number().randomDouble(1,12900,180000));
            insumo.setNITProveedor(i);

            mySqlOperation.setSqlStatement("insert into insumo values("+insumo.getREF()+",'"+insumo.getNombre()+"',"+insumo.getCantidad()+","+insumo.getPrecioCompra()+","+insumo.getNITProveedor()+");");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    /**
     * Método para insertar datos en tabla cliente
     */
    private static void insertarCliente(){

        for (int i = 1; i < 500; i++) {

            Cliente cli= new Cliente();
            cli.setId(i);
            cli.setNombre(faker.name().fullName());
            cli.setCedula(faker.number().digits(8));
            cli.setCorreo(faker.name().username()+"@gmail.com");
            cli.setEdad(faker.number().digits(2));
            cli.setDireccion(faker.address().streetAddress());


            mySqlOperation.setSqlStatement("insert into cliente values("+cli.getId()+",'"+cli.getNombre()+"','"+cli.getCedula()+"','"+cli.getCorreo()+"','"+cli.getEdad()+"','"+cli.getDireccion()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    /**
     * Método para insertar datos en tabla telefonoCliente
     */

    private static void insertarClienteTelefono(){

        for (int i = 1; i < 300; i++) {

            ClienteTelefono tel = new ClienteTelefono();
            tel.setIdCliente(i);
            tel.setTelefono(faker.number().digits(10));
            mySqlOperation.setSqlStatement("insert into telefonocliente values("+tel.getIdCliente()+",'"+tel.getTelefono()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    /**
     * Método para insertar datos en tabla profesioncliente
     */
    private static void insertarClienteProfesion(){

        for (int i = 1; i < 300; i++) {

            ClienteProfesion prof = new ClienteProfesion();
            prof.setIdCliente(i);
            prof.setProfesion(faker.job().title());
            mySqlOperation.setSqlStatement("insert into profesioncliente values("+prof.getIdCliente()+",'"+prof.getProfesion()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    /**
     * Método para insertar datos en tabla cita
     */

    private static void insertarCita(){

        for (int i = 1; i < 50; i++) {

            Cita cita = new Cita();
            cita.setId(i);
            cita.setIdCliente(i);
            cita.setFecha("2023-03-"+i);
            cita.setHora("13:"+i);

            mySqlOperation.setSqlStatement("insert into cita values("+cita.getId()+","+cita.getIdCliente()+",'"+cita.getFecha()+"','"+cita.getHora()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    /**
     * Método para insertar datos en tabla servicio
     */
    private static void insertarServicio() {

        for (int i = 1; i < 30; i++) {
            Servicio serv = new Servicio();
            serv.setId(i);
            serv.setIdCita(i);
            serv.setPrecio(faker.number().randomDouble(1, 25000, 55000));
            serv.setDescripcion(faker.lorem().characters(15, 45));
            serv.setFecha("2023-03-" + i);
            serv.setDuracion(faker.number().randomDouble(2, 30, 120));



            mySqlOperation.setSqlStatement("insert into servicio values(" + serv.getId() + "," + serv.getIdCita() + "," + serv.getPrecio() + ",'" +serv.getDescripcion() + "','" + serv.getFecha() + "'," + serv.getDuracion() + ");");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    /**
     * Método para insertar datos en tabla empleado
     */
    private static void insertarEmpleado() {

        for (int i = 1; i < 51; i++) {
            Empleado emp = new Empleado();
            emp.setId(i);
            emp.setCedula(faker.number().digits(10));
            emp.setNombre(faker.funnyName().name());

            mySqlOperation.setSqlStatement("insert into empleado values(" + emp.getId() + ",'" + emp.getCedula() + "','"+emp.getNombre()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    /**
     * Método para insertar datos en tabla especialidadEmpleado
     */
    private static void insertarEspecialidadEmpleado(){

        for (int i = 1; i < 51; i++) {

            EmpleadoEspecialidad esp= new EmpleadoEspecialidad();
            esp.setId(i);
            esp.setEspecialidad(faker.job().seniority());
            mySqlOperation.setSqlStatement("insert into especialidadempleado values("+esp.getId()+",'"+esp.getEspecialidad()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    /**
     * Método para insertar datos en tabla servicioempleado
     */
    private static void insertarServicioEmpleado(){

        for (int i = 1; i < 51; i++) {

            EmpleadoServicio servicio= new EmpleadoServicio();
            servicio.setIdServicio(i);
            servicio.setIdEmpleado(i);

            mySqlOperation.setSqlStatement("insert into servicioempleado values("+servicio.getIdServicio()+","+servicio.getIdEmpleado()+");");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    /**
     * Método para insertar datos en tabla cotización
     */
    private static void insertarCotizacion(){

        for (int i = 1; i < 51; i++) {

            Cotizacion cotizacion = new Cotizacion();
            cotizacion.setId(i);
            cotizacion.setDescripcion("Descripcion: "+i);
            cotizacion.setIdCliente(i+1);
            cotizacion.setIdEmpleado(i);

            mySqlOperation.setSqlStatement("insert into cotizacion values("+cotizacion.getId()+",'"+cotizacion.getDescripcion()+"',"+cotizacion.getIdCliente()+","+cotizacion.getIdEmpleado()+");");
            mySqlOperation.executeSqlStatementVoid();
        }

    }
    /**
     * Método para insertar datos en tabla venta
     */
    private static void insertarVenta(){

        for (int i = 1; i < 51; i++) {

            Venta venta = new Venta();
            venta.setId(i);
            venta.setValorTotal(faker.number().randomDouble(1,80000,365000));
            venta.setLiga(faker.number().randomDouble(1, 5000,35000));
            venta.setFecha(String.valueOf(faker.date().between(Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            venta.setIdProducto(i);
            venta.setIdCotizacion(i);
            venta.setCantidad(faker.random().nextInt(1,10));

            mySqlOperation.setSqlStatement("insert into venta values("+venta.getId()+","+venta.getValorTotal()+","+venta.getLiga()+",'"+venta.getFecha()+"',"+venta.getIdProducto()+","+venta.getIdCotizacion()+","+venta.getIdProducto()+");");
            mySqlOperation.executeSqlStatementVoid();
        }

    }
    /**
     * Método para insertar datos en tabla servicioinsumo
     */
   private  static void servicioInsumo() {
       for (int i = 30; i < 60; i++){
           ServicioInsumo si = new ServicioInsumo();
           si.setIdServicio(i);
           si.setREFinsumo(i);

           mySqlOperation.setSqlStatement("insert into servicioinsumo values("+si.getIdServicio()+","+si.getREFinsumo()+");");
           mySqlOperation.executeSqlStatementVoid();

       }

   }
















}