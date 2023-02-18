package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.models.*;
import com.sofkau.integration.database.mysql.MySqlOperation;
import com.sofkau.integration.database.mysql.MySqlQuerys;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {

    private static final String SERVER="localhost";
    private static final String DATA_BASE_NAME="zoologico";
    private static final String USER="root";
    private static final String PASSWORD="admin1234";

//    private static final String SELECT_ALL_FROM_ANIMALES=String.format("select * from %s.animal",DATA_BASE_NAME);
//    private  static final String INSERT_ANIMAL = "INSERT INTO animal values('A11','James','macho','2','Mono','D002');";
    private static final MySqlOperation mySqlOperation= new MySqlOperation();




    private static Faker faker = new Faker();


    public static void main(String[] args) throws SQLException{
        openConnection();
        insertarVeterinario();
        insertarDieta();
        insertarAnimal();
        insertarEntrenador();
        insertarProveedor();
        insertarAlimento();
        insertarFactura();
        insertarLogistico();
        insertarOrdenCompra();
        insertarDieta_Alimento();
        insertarInformePeso();
        insertarInforme_Veterinario();
        insertarProveedor_Alimento();
        insertarProveedor_Telefono();

//        closeConnection();

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

    private static void insertarVeterinario(){

        for (int i = 1; i < 51; i++) {
            Veterinario vet = new Veterinario();
            vet.setId("V"+i);
            vet.setName(faker.name().firstName());
            vet.setTel(faker.phoneNumber().cellPhone().toString());

            mySqlOperation.setSqlStatement("insert into veterinario values('"+vet.getId()+"','"+vet.getName()+"','"+vet.getTel()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarDieta(){

        for (int i = 1; i < 51; i++) {
            Dieta diet = new Dieta();
            diet.setId_dieta("D"+i);
            diet.setNombre_dieta(faker.funnyName().name());
            diet.setDosis(faker.numerify("##"));
            diet.setDosis(diet.getDosis()+"g/dia");
            diet.setVeterinario_id("V"+i);

            mySqlOperation.setSqlStatement("insert into dieta values('"+diet.getId_dieta()+"','"+diet.getNombre_dieta()+"','"+diet.getDosis()+"','"+diet.getVeterinario_id()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarAnimal(){

        for (int i = 1; i < 51; i++) {
            Animal animal = new Animal();
            animal.setId_animal("A"+i);
            animal.setNombre(faker.funnyName().name());
            animal.setSexo_animal(faker.dog().gender());
            int min = 1;
            int max = 15;
            Random rand = new Random();
            int randomNumber = min + rand.nextInt(max - min + 1);
            animal.setEdad(Integer.toString(randomNumber));
            animal.setTipo_especie(faker.witcher().monster());
            animal.setDieta_id("D"+i);

            mySqlOperation.setSqlStatement("insert into animal values('"+animal.getId_animal()+"','"+animal.getNombre()+"','"+animal.getSexo_animal()
                    +"','"+animal.getEdad()+"','"+animal.getTipo_especie()+"','"+animal.getDieta_id()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarEntrenador(){

        for (int i = 1; i < 51; i++) {
            Entrenador trainer = new Entrenador();
            trainer.setId_entrenador("E"+i);
            trainer.setNombre(faker.name().fullName());
            trainer.setTelefono(faker.phoneNumber().cellPhone().toString());

            mySqlOperation.setSqlStatement("insert into entrenador values('"+trainer.getId_entrenador()+"','"+trainer.getNombre()+"','"+trainer.getTelefono()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarProveedor(){

        for (int i = 1; i < 51; i++) {
            Proveedor prov = new Proveedor();
            prov.setId_proveedor("P"+i);
            prov.setNombre(faker.name().fullName());
            prov.setDireccion(faker.address().streetAddress());
            mySqlOperation.setSqlStatement("insert into proveedor values('"+prov.getId_proveedor()+"','"+prov.getNombre()+"'," +
                    "'"+prov.getDireccion()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarAlimento() {
        for (int i = 1; i < 51; i++) {
            Alimento ali = new Alimento();
            ali.setId_alimento("ALI" + i);
            ali.setNombre(faker.food().ingredient());
            ali.setTipo(faker.food().spice());
            ali.setCantidad(faker.number().numberBetween(1, 100)+"kg");
            mySqlOperation.setSqlStatement("INSERT INTO alimento VALUES ('" + ali.getId_alimento() + "', '" + ali.getNombre() +
                    "', '" + ali.getTipo() + "', '" + ali.getCantidad() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarFactura() {
        for (int i = 1; i < 51; i++) {
            Factura fac = new Factura();
            fac.setId_factura("F" + i);
            fac.setFecha(String.valueOf(faker.date().between(Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            fac.setDetalle((faker.commerce().productName()));
            fac.setTotal(Integer.toString(faker.number().numberBetween(100000, 2000000)));
            fac.setProveedor_id_o("P"+i);
            mySqlOperation.setSqlStatement("INSERT INTO factura VALUES ('" + fac.getId_factura() + "', '" + fac.getFecha() +
                    "', '"+fac.getDetalle()+"', '" + fac.getTotal() + "', '" + fac.getProveedor_id_o() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarLogistico() {
        for (int i = 1; i < 51; i++) {
            Logistico log = new Logistico();
            log.setId_logistico("L" + i);
            log.setNombre(faker.name().firstName());
            log.setTelefono(faker.phoneNumber().cellPhone().toString());
            mySqlOperation.setSqlStatement("INSERT INTO logistico VALUES ('" + log.getId_logistico() + "', '" + log.getNombre() +
                    "', '" + log.getTelefono() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarOrdenCompra() {
        for (int i = 1; i < 51; i++) {
            Orden_compra oc = new Orden_compra();
            oc.setId_orden("OC" + i);
            oc.setFecha(String.valueOf(faker.date().between(Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            oc.setDetalle(faker.lorem().sentence());
            oc.setLogistico_id_p("L"+i);
            oc.setProveedor_id_l("P" + i);
            mySqlOperation.setSqlStatement("INSERT INTO orden_compra VALUES ('" + oc.getId_orden() + "', '" + oc.getFecha() +
                    "', '" + oc.getDetalle() + "', '" + oc.getLogistico_id_p() + "', '" + oc.getProveedor_id_l() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    //Metodo para relacionar una dieta y un alimento
    private static void insertarDieta_Alimento() {
        for (int i = 1; i < 51; i++) {
            String dieta_id = "D"+i;
            String alimento_id = "ALI"+i;
            mySqlOperation.setSqlStatement("INSERT INTO dieta_alimento VALUES ('" +dieta_id+ "', '" +alimento_id+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarInformePeso() {
        for (int i = 1; i < 51; i++) {
            Informe_Peso ip = new Informe_Peso();
            ip.setId_informe("IP" + i);
            ip.setFecha(String.valueOf(faker.date().between(Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            ip.setPeso(faker.number().numberBetween(100, 500) + " kg");
            ip.setDetalle(faker.lorem().sentence());
            ip.setEntrenador_id("E" +i);
            ip.setAnimal_id("A" + i);
            mySqlOperation.setSqlStatement("INSERT INTO informe_peso VALUES ('" + ip.getId_informe() + "', '" + ip.getFecha() +
                    "', '" + ip.getPeso() + "', '" + ip.getDetalle() + "', '" + ip.getEntrenador_id() + "', '" + ip.getAnimal_id() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    //Este metodo es para la tabla intermedia entre informe y veterinario
    private static void insertarInforme_Veterinario() {
        for (int i = 1; i < 51; i++) {
            String informe_peso_id = "IP"+i;
            String veterinario_id = "V"+i;
            mySqlOperation.setSqlStatement("INSERT INTO informe_veterinario VALUES ('" +informe_peso_id+ "', '" +veterinario_id+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    //Este metodo es para la tabla intermedia entre proveedor y alimento
    private static void insertarProveedor_Alimento() {
        for (int i = 1; i < 51; i++) {
            String proveedor_id = "P"+i;
            String alimento_id = "ALI"+i;
            mySqlOperation.setSqlStatement("INSERT INTO proveedor_alimento VALUES ('" +proveedor_id+ "', '" +alimento_id+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    //Este metodo es para crear los numeros de telefonos de los proveedores
    private static void insertarProveedor_Telefono() {
        for (int i = 1; i < 51; i++) {
            String proveedor_id = "P"+faker.number().numberBetween(1, 51);
            String telefono = (faker.phoneNumber().cellPhone().toString());
            mySqlOperation.setSqlStatement("INSERT INTO telefono_proveedor VALUES ('" +proveedor_id+ "', '" +telefono+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

}