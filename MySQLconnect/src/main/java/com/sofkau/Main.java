package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.mysql.MySqlOperation;
import com.sofkau.integration.models.*;

import java.sql.SQLException;



public class Main {

    private static final String INSERT_ANIMAL = "insert into Animal VALUES('A11', 'perro', 'felino', 'D02')";
    private static final String SERVER = "localhost";
    private static final String DATA_BASE_NAME = "zoo_santafe";
    private static final String USER = "root";
    private static final String PASSWORD = "Elvelo0820";
    private static final String SELECT_ALL_FROM_ANIMALES = String.format("select * from %s.animal", DATA_BASE_NAME);
    private static final MySqlOperation mySqlOperation = new MySqlOperation();

    private static Faker faker = new Faker();



    public static void main(String[] args) throws SQLException {

        openConnection();
        insertarVeterinario_Dieta();
        closeConnection();

    }

    private static void inserIntoAnimal() {
        mySqlOperation.setSqlStatement(INSERT_ANIMAL);
        mySqlOperation.executeSqlStatementVoid();
    }

    public static void openConnection() {
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }

    public static void setSelectAllFromAnimales() throws SQLException {
        mySqlOperation.setSqlStatement(SELECT_ALL_FROM_ANIMALES);
        mySqlOperation.executeSqlStatement();
        mySqlOperation.printResulset();
    }

    public static void closeConnection() {
        mySqlOperation.close();

    }

    private static void insertarVeterinario() {

        for (int i = 1; i < 4; i++) {
            Veterinario veterinario = new Veterinario();
            veterinario.setIdVeterinario("vet" + i);
            veterinario.setNombre_veterinario(faker.name().firstName());
            veterinario.setTelefono(faker.phoneNumber().phoneNumber());
            mySqlOperation.setSqlStatement("INSERT INTO veterinario VALUES ('" + veterinario.getIdVeterinario() + "', '"
                    + veterinario.getNombre_veterinario() + "', '" + veterinario.getTelefono() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarAlimento() {
        for (int i = 1; i < 4; i++) {
            Alimento alimento = new Alimento();
            alimento.setIdAlimento("alim" + i);
            alimento.setNombre_alimento(faker.food().ingredient());
            alimento.setTipo_alimento(faker.food().spice());
            alimento.setDosis_alimento(faker.food().measurement());
            mySqlOperation.setSqlStatement("INSERT INTO alimento VALUES('" + alimento.getIdAlimento() + "','" + alimento.getNombre_alimento()
                    + "','" + alimento.getTipo_alimento() + "','" + alimento.getDosis_alimento() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    private static void insertarDieta() {
        for (int i = 1; i < 4; i++) {
            Dieta dieta = new Dieta();
            dieta.setIdDieta("diet" + i);
            dieta.setNombre_dieta(faker.food().dish());
            dieta.setDosis_dieta(faker.food().measurement());
            dieta.setTipo_dieta(faker.animal().name());
            mySqlOperation.setSqlStatement("INSERT INTO dieta VALUES('" + dieta.getIdDieta() + "','" + dieta.getNombre_dieta()
                    + "','" + dieta.getDosis_dieta() + "','" + dieta.getTipo_dieta() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarEntrenador() {
        for (int i = 1; i < 4; i++) {
            Entrenador entrenador = new Entrenador();
            entrenador.setIdEntrenador("entr" + i);
            entrenador.setNombre_eentrenador(faker.name().firstName());
            entrenador.setTelefono_entrenador(faker.phoneNumber().cellPhone());
            mySqlOperation.setSqlStatement("INSERT INTO entrenador VALUES('" + entrenador.getIdEntrenador() + "','" + entrenador.getNombre_eentrenador()
                    + "','" + entrenador.getTelefono_entrenador() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    private static void insertarProveedor() {
        for (int i = 1; i < 4; i++) {
            Proveedores proveedor = new Proveedores();
            proveedor.setIdProveedores("prov" + i);
            proveedor.setNombre_proveedor(faker.company().name());
            proveedor.setTelefono_proveedor(faker.phoneNumber().phoneNumber());
            mySqlOperation.setSqlStatement("INSERT INTO proveedores VALUES('" + proveedor.getIdProveedores() + "','" + proveedor.getNombre_proveedor()
                    + "','" + proveedor.getTelefono_proveedor() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarLogista() {
        for (int i = 1; i < 4; i++) {
            Logista logista = new Logista();
            logista.setIdlogista("log" + i);
            logista.setNombre_logista(faker.name().fullName());
            logista.setTelefono_logista(faker.phoneNumber().phoneNumber());
            mySqlOperation.setSqlStatement("INSERT INTO logista VALUES('" + logista.getIdlogista() + "','" + logista.getNombre_logista()
                    + "','" + logista.getTelefono_logista() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    private static void insertarAnimal() {
        for (int i = 1; i < 4; i++) {
            Animal animal = new Animal();
            animal.setIdAnimal("anim" + i);
            animal.setNombre_animal(faker.animal().name());
            animal.setEspecie(faker.animal().name().strip());
            animal.setIdDieta("diet" + i);
            mySqlOperation.setSqlStatement("INSERT INTO animal VALUES('" + animal.getIdAnimal() + "','" + animal.getNombre_animal()
                    + "','" + animal.getEspecie() + "','" + animal.getIdDieta() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    private static void insertarAnimalEntrenador() {
        for (int i = 1; i <= 5; i++) {
            Animal_entrenador animal_entrenador = new Animal_entrenador();
            animal_entrenador.setIdAnimal("ani" + i);
            animal_entrenador.setIdEntrenador("entr" + (i % 3 + 1));

            mySqlOperation.setSqlStatement("insert into animal_entrenador values('" + animal_entrenador.getIdAnimal() + "','" + animal_entrenador.getIdEntrenador() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    private static void insertarDietaAlimento() {
        for (int i = 1; i <= 10; i++) {
            Dieta_alimento dieta_alimento = new Dieta_alimento();
            dieta_alimento.setIdDieta("diet" + (i % 3 + 1));
            dieta_alimento.setIdAlimento("alim" + (i % 4 + 1));

            mySqlOperation.setSqlStatement("insert into dieta_alimento values('" + dieta_alimento.getIdDieta() + "','" + dieta_alimento.getIdAlimento() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarInforme() {
        for (int i = 1; i < 4; i++) {
            Informe informe = new Informe();
            informe.setIdInforme("inf" + i);
            informe.setPeso_animal(faker.number().numberBetween(1, 100) + " kg");
            informe.setEdad_animal(faker.number().numberBetween(1, 10) + " años");
            informe.setIdAnimal("ani" + faker.number().numberBetween(1, 3));
            informe.setIdEntrenador("entr" + faker.number().numberBetween(1, 3));
            mySqlOperation.setSqlStatement("INSERT INTO informe VALUES('" + informe.getIdInforme() + "','" + informe.getPeso_animal()
                    + "','" + informe.getEdad_animal() + "','" + informe.getIdAnimal() + "','" + informe.getIdEntrenador() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    private static void insertarEntrenador_Veterinario(){

        for (int i = 1; i < 4; i++) {
            Entrenador_veterinario ev = new Entrenador_veterinario();
            ev.setIdEntrenador("entr"+i);
            ev.setIdVeterinario("vet"+i);
            mySqlOperation.setSqlStatement("insert into entrenador_veterinario values('"+ev.getIdEntrenador()+"','"+ev.getIdVeterinario()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarProveedoresAlimento() {
        for (int i = 1; i <= 3; i++) {
            Proveedores_alimento proveedoresAlimento = new Proveedores_alimento();
            proveedoresAlimento.setIdProveedores("prov" + i);
            proveedoresAlimento.setIdAlimento("ali" + i);

            mySqlOperation.setSqlStatement("insert into proveedores_alimento values('"
                    + proveedoresAlimento.getIdProveedores() + "','"
                    + proveedoresAlimento.getIdAlimento() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarVeterinario_Dieta() {
        for (int i = 1; i < 4; i++) {
            Veterinario_dieta vetDieta = new Veterinario_dieta();
            vetDieta.setIdVeterinario("vet" + i);
            vetDieta.setIdDieta("dieta" + i);
            mySqlOperation.setSqlStatement("INSERT INTO veterinario_dieta VALUES ('" + vetDieta.getIdVeterinario() + "', '" + vetDieta.getIdDieta() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }



//  private static void insertarFactura() {
//        for (int i = 1; i < 4; i++) {
//            Factura factura = new Factura();
//            factura.setIdFactura("fact" + i);
//            factura.setPrecio_factura(faker.commerce().price(10.0, 100.0));
//            factura.setCantidad_factura(faker.number().numberBetween(1, 10));
//            factura.setIdProveedores("prov" + i);
//            mySqlOperation.setSqlStatement("INSERT INTO factura VALUES('" + factura.getIdFactura() + "','" + factura.getPrecio_factura()
//                    + "','" + factura.getCantidad_factura() + "','" + factura.getIdProveedores() + "');");
//            mySqlOperation.executeSqlStatementVoid();
//        }


}






