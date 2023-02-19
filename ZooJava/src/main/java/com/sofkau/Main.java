package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.mysql.MySqlOperation;
import com.sofkau.integration.models.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {
    private static final String SERVER="localhost";
    private static final String DATA_BASE_NAME="zoologico";
    private static final String USER="root";
    private static final String PASSWORD="12345";
    private static final MySqlOperation mySqlOperation = new MySqlOperation();

    private static Faker faker = new Faker();


    public static void main(String[] args) throws SQLException {
        openConnection();
        insertarAlimento();
        insertarDieta();
        insertarEntrenador();
        insertarVeterinario();
        insertarProveedor();
        insertarespecie();
        insertarEmpleadoLogistico();
        insertarAlimento_Dieta();
        insertarAnimal();
        insertarOrdenCompra();
        insertarInforme_peso();
        insertarFactura();
        insertartelefono_logistico();
        insertartelefonoEntrenador();
        insertartelefonoproveedor();
        insertartelefonoVeterinario();
        insertarVeterinarioDieta();
    }

    public static void openConnection() {
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }


    public static void closeConnection() {
        mySqlOperation.close();

    }

    private static void insertarAlimento(){

        for (int i = 1; i < 51; i++) {
            Alimento alimento = new Alimento();
            alimento.setIdAlimento("Ali" + i);
            alimento.setNombreAlimento(faker.food().ingredient());
            alimento.setTipoAlimento(faker.food().spice());
            mySqlOperation.setSqlStatement("insert into alimento values('"+alimento.getIdAlimento()+"','"+alimento.getNombreAlimento()+
                    "','"+alimento.getTipoAlimento()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarDieta(){

        for (int i = 1; i < 51; i++) {
            Dieta dieta = new Dieta();
            dieta.setIdDieta("D"+ i);
            dieta.setNombreDieta(faker.name().name());
            dieta.setDosisDieta(faker.numerify("##"));
            dieta.setDosisDieta(dieta.getDosisDieta() + "Kilos/dia");

            mySqlOperation.setSqlStatement("insert into dieta values('"+dieta.getIdDieta()+"','"+dieta.getNombreDieta()+"','"
                    +dieta.getDosisDieta()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarEntrenador(){

        for (int i = 1; i < 51; i++) {
            Entrenador trainer = new Entrenador();
            Entrenador entrenador = new Entrenador();
            entrenador.setIdEntrenador("EME" + i);
            entrenador.setNombreEntrenador(faker.name().firstName());
            mySqlOperation.setSqlStatement("insert into entrenador values('"+entrenador.getIdEntrenador()+
                    "','"+entrenador.getNombreEntrenador()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarVeterinario(){

        for (int i = 1; i < 51; i++) {
            Veterinario vet = new Veterinario();
            Veterinario veterinario = new Veterinario();
            veterinario.setIdVeterinario("V"+ i);
            veterinario.setNombreVeterinario(faker.name().firstName());
            mySqlOperation.setSqlStatement("insert into veterinario values('"+veterinario.getIdVeterinario()+"','"
                    +veterinario.getNombreVeterinario()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarProveedor(){

        for (int i = 1; i < 51; i++) {
            Proveedor prov = new Proveedor();
            Proveedor proveedor = new Proveedor();
            proveedor.setIdproveedor("PRO"+ i);
            proveedor.setNombreProveedor(faker.name().firstName());
            mySqlOperation.setSqlStatement("insert into proveedor values('"+proveedor.getIdproveedor()+"','"+proveedor.getNombreProveedor()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarespecie(){

        for (int i = 1; i < 51; i++) {
            Entrenador trainer = new Entrenador();
            especie especies = new especie();
            especies.setIdEspecie("E" + i);
            especies.setNombreEspecie(faker.witcher().monster());
            mySqlOperation.setSqlStatement("insert into especie values('"+especies.getIdEspecie()+
                    "','"+especies.getNombreEspecie()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarEmpleadoLogistico() {
        for (int i = 1; i < 51; i++) {
            EmpleadoLogistico empleadoLogistico = new EmpleadoLogistico();
            empleadoLogistico.setIdEmpleadoLogistico("EM"+ i);
            empleadoLogistico.setNombreLogistico(faker.name().firstName());
            mySqlOperation.setSqlStatement("INSERT INTO empleadologistico VALUES ('" + empleadoLogistico.getIdEmpleadoLogistico()
                    + "', '" + empleadoLogistico.getNombreLogistico() +"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarAlimento_Dieta(){
        for (int i = 1; i < 51; i++) {
            String dietaAlimentoId = "D"+ i;
            String alimento_Dieta_ID = "Ali"+i;

            mySqlOperation.setSqlStatement("insert into alimento_dieta values('" +dietaAlimentoId+ "', '" +alimento_Dieta_ID+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    private static void insertarAnimal(){

        for (int i = 1; i < 51; i++) {
            Animal animal = new Animal();
            animal.setIdAnimal("A" + i);
            animal.setNombreAnimal(faker.animal().name());
            animal.setEspecie_id("E" + i);
            animal.setDieta_id("D"+ i);
            mySqlOperation.setSqlStatement("insert into animal values('"+animal.getIdAnimal()+"','"+animal.getNombreAnimal()+
                    "','"+animal.getEspecie_id()+"','"+animal.getDieta_id()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    private static void insertarOrdenCompra() {
        for (int i = 1; i < 51; i++) {
            OrdenesCompra ordenesCompra = new OrdenesCompra();
            ordenesCompra.setIdOrdenesCompra("ORD"+ i);
            ordenesCompra.setNombreOrden(faker.lorem().sentence());
            ordenesCompra.setFechaOrden(String.valueOf(faker.date().between(Date.from
                    (LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            ordenesCompra.setDescripcion(faker.lorem().sentence());
            ordenesCompra.setOrdenProveedorId("PRO" +i);
            ordenesCompra.setLogisticoIdOrden("EM"+ i);
            mySqlOperation.setSqlStatement("INSERT INTO orden_compra VALUES ('" + ordenesCompra.getIdOrdenesCompra()+ "', '" +
                    ordenesCompra.getNombreOrden() +"', '" + ordenesCompra.getFechaOrden()+ "', '" + ordenesCompra.getDescripcion()
                    + "', '" + ordenesCompra.getOrdenProveedorId() + "', '" + ordenesCompra.getLogisticoIdOrden()+ "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarInforme_peso() {
        for (int i = 1; i < 51; i++) {
            Informe_peso informePeso = new Informe_peso();
            informePeso.setIdInforme("IN"+ i);
            informePeso.setPesoAnimal(faker.number().numberBetween(10, 50) + " kg");
            String entrenadorId = "EME" + i;
            String veterinarioId ="V" + i;
            String animalId = "A"+ i;
            mySqlOperation.setSqlStatement("INSERT INTO informe_peso VALUES ('" + informePeso.getIdInforme() + "', '" + informePeso.getPesoAnimal() +
                    "', '" + entrenadorId + "', '" + veterinarioId + "', '" + animalId + "', '"
                    + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarFactura() {
        for (int i = 1; i < 51; i++) {
            Factura fac = new Factura();
            Factura factura = new Factura();
            factura.setIdFactura("FA"+ i);
            factura.setId_alimento_factura("Ali"+ i);
            factura.setCantidad(Integer.toString(faker.number().numberBetween(1, 20)));
            factura.setPrecio((Integer.toString(faker.number().numberBetween(100000, 2000000))));
            factura.setProveedorIdFactura("PRO"+ i);
            mySqlOperation.setSqlStatement("INSERT INTO factura VALUES ('" + factura.getIdFactura() + "', '" + factura.getId_alimento_factura() +
                    "', '"+factura.getCantidad()+"', '" + factura.getPrecio() + "', '" + factura.getProveedorIdFactura() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    private static void insertartelefono_logistico() {
        for (int i = 1; i < 51; i++) {
            String logisticoId = "EM"+ i;
            String numero = (faker.phoneNumber().cellPhone().toString());
            mySqlOperation.setSqlStatement("INSERT INTO telefono_logistico VALUES ('" +logisticoId+ "', '" +numero+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertartelefonoEntrenador() {
        for (int i = 1; i < 51; i++) {
            String idtelefonoEntrenador = "EME"+ i;
            String numero = (faker.phoneNumber().cellPhone().toString());
            mySqlOperation.setSqlStatement("INSERT INTO telefonoentrenador VALUES ('" +idtelefonoEntrenador+ "', '" +numero+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertartelefonoproveedor() {
        for (int i = 1; i < 51; i++) {
            String proveedorIdTelefono = "PRO"+ i;
            String numero = (faker.phoneNumber().cellPhone().toString());
            mySqlOperation.setSqlStatement("INSERT INTO telefonoproveedor VALUES ('" +proveedorIdTelefono+ "', '" +numero+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertartelefonoVeterinario() {
        for (int i = 1; i < 51; i++) {
            String idtelefonoVeterinario = "V"+ i;
            String numero = (faker.phoneNumber().cellPhone().toString());
            mySqlOperation.setSqlStatement("INSERT INTO zoologico.telefonoveterinario VALUES ('" +idtelefonoVeterinario+ "', '" +numero+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    private static void insertarVeterinarioDieta() {
        for (int i = 1; i < 51; i++) {
            String idVeterinarioDieta = "V" + i;
            String dietaVeterinarioId = "D" + i;

            mySqlOperation.setSqlStatement("INSERT INTO veterinariodieta VALUES ('" +idVeterinarioDieta+ "', '" +dietaVeterinarioId+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }













}