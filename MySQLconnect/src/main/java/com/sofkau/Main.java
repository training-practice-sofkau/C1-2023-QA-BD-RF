package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.mysql.MySqlOperation;
import com.sofkau.integration.models.*;

import java.sql.SQLException;
import java.util.stream.IntStream;


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
        insertarVeterinarioDieta();
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
        for (int i = 1; i <= 50; i++) {
            Veterinario veterinario = new Veterinario();
            veterinario.setIdVeterinario("vet" + i);
            veterinario.setNombre_veterinario(faker.name().fullName());
            veterinario.setTelefono(faker.phoneNumber().cellPhone());
            mySqlOperation.setSqlStatement("insert into veterinario values('" +
                    veterinario.getIdVeterinario() + "','" + veterinario.getNombre_veterinario()
                    + "','" + veterinario.getTelefono() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    private static void insertarAlimento() {
        for (int i = 1; i <= 50; i++) {
            Alimento alimento = new Alimento();
            alimento.setIdAlimento("alim" + i);
            alimento.setNombre_alimento(faker.food().ingredient());
            alimento.setTipo_alimento(faker.food().measurement());
            alimento.setDosis_alimento(faker.number().digits(2) + " gramos");
            mySqlOperation.setSqlStatement("insert into alimento values('"
                    + alimento.getIdAlimento() + "','" + alimento.getNombre_alimento()
                    + "','" + alimento.getTipo_alimento() + "','" + alimento.getDosis_alimento()
                    + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarDieta() {
        for (int i = 1; i <= 50; i++) {
            Dieta dieta = new Dieta();
            dieta.setIdDieta("d" + i);
            dieta.setNombre_dieta(faker.food().ingredient());
            dieta.setDosis_dieta(faker.number().digits(2));
            dieta.setTipo_dieta(faker.food().spice());
            mySqlOperation.setSqlStatement("insert into dieta values('" + dieta.getIdDieta()
                    + "', '" + dieta.getNombre_dieta() + "', '" + dieta.getDosis_dieta() + "', '"
                    + dieta.getTipo_dieta() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarEntrenador() {
        for (int i = 1; i <= 50; i++) {
            Entrenador entrenador = new Entrenador();
            entrenador.setIdEntrenador("ent" + i);
            entrenador.setNombre_eentrenador(faker.name().fullName());
            entrenador.setTelefono_entrenador(faker.phoneNumber().cellPhone());
            mySqlOperation.setSqlStatement("insert into entrenador values('" +
                    entrenador.getIdEntrenador() + "','" + entrenador.getNombre_eentrenador()
                    + "','" + entrenador.getTelefono_entrenador() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    private static void insertarProveedor() {
        for (int i = 1; i <= 50; i++) {
            Proveedores proveedor = new Proveedores();
            proveedor.setIdProveedores("prov" + i);
            proveedor.setNombre_proveedor(faker.company().name());
            proveedor.setTelefono_proveedor(faker.phoneNumber().phoneNumber());
            mySqlOperation.setSqlStatement("INSERT INTO proveedores VALUES('" +
                    proveedor.getIdProveedores() + "','" + proveedor.getNombre_proveedor()
                    + "','" + proveedor.getTelefono_proveedor() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarLogista() {
        for(int i = 1; i <= 50; i++) {
            Logista logista = new Logista();
            logista.setIdlogista("log" + i);
            logista.setNombre_logista(faker.name().fullName());
            logista.setTelefono_logista(faker.phoneNumber().cellPhone());
            mySqlOperation.setSqlStatement("insert into logista values('" +
                    logista.getIdlogista() + "','" + logista.getNombre_logista()
                    + "','" + logista.getTelefono_logista() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    private static void insertarAnimales() {
        for (int i = 1; i <= 50; i++) {
            Animal animal = new Animal();
            animal.setIdAnimal("anim" + i);
            animal.setNombre_animal(faker.animal().name());
            animal.setEspecie(faker.animal().name());
            animal.setIdDieta("d" + i);
            mySqlOperation.setSqlStatement("insert into animal values('" + animal.getIdAnimal()
                    + "','" + animal.getNombre_animal()
                    + "','" + animal.getEspecie() + "','" + animal.getIdDieta() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }



    private static void insertarAnimalEntrenador() {
        for (int i = 1; i <= 50; i++) {
            Animal_entrenador animal_entrenador = new Animal_entrenador();
            animal_entrenador.setIdAnimal("anim" + i);
            animal_entrenador.setIdEntrenador("ent" + i);
            mySqlOperation.setSqlStatement("insert into animal_entrenador values('"
                    + animal_entrenador.getIdAnimal() + "','" + animal_entrenador.getIdEntrenador() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    private static void insertarDietaAlimento() {
        for (int i = 1; i <= 50; i++) {
            Dieta_alimento dieta_alimento = new Dieta_alimento();
            dieta_alimento.setIdDieta("d" + i);
            dieta_alimento.setIdAlimento("alim" + i);
            mySqlOperation.setSqlStatement("insert into dieta_alimento values('"
                    + dieta_alimento.getIdDieta() + "','" + dieta_alimento.getIdAlimento() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    private static void insertarInforme() {
        for (int i = 1; i <= 50; i++) {
            Informe informe = new Informe();
            informe.setIdInforme("inf" + i);
            informe.setPeso_animal(String.valueOf(faker.number().randomDouble(1, 1, 500)));
            informe.setEdad_animal(String.valueOf(faker.number().numberBetween(1, 20)));
            informe.setIdAnimal("anim" + i);
            informe.setIdEntrenador("ent" + i);
            mySqlOperation.setSqlStatement("insert into informe values('" +
                    informe.getIdInforme() + "','" + informe.getPeso_animal()
                    + "','" + informe.getEdad_animal() + "','" + informe.getIdAnimal() + "','"
                    + informe.getIdEntrenador() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    private static void insertarEntrenadorVeterinario() {
        for (int i = 1; i <= 50; i++) {
            Entrenador_veterinario entrenador_veterinario = new Entrenador_veterinario();
            entrenador_veterinario.setIdEntrenador("ent" + i);
            entrenador_veterinario.setIdVeterinario("vet" + i);
            mySqlOperation.setSqlStatement("insert into entrenador_veterinario values('"
                    + entrenador_veterinario.getIdEntrenador() + "','" +
                    entrenador_veterinario.getIdVeterinario() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarProveedoresAlimento() {
        for (int i = 1; i <= 50; i++) {
            Proveedores_alimento proveedoresAlimento = new Proveedores_alimento();
            proveedoresAlimento.setIdProveedores("prov" + i);
            proveedoresAlimento.setIdAlimento("alim" + i);
            mySqlOperation.setSqlStatement("insert into proveedores_alimento values('"
                    + proveedoresAlimento.getIdProveedores() + "','" +
                    proveedoresAlimento.getIdAlimento() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    private static void insertarVeterinarioDieta() {
        for(int i = 1; i <= 50; i++) {
            Veterinario_dieta veterinarioDieta = new Veterinario_dieta();
            veterinarioDieta.setIdVeterinario("vet" + i);
            veterinarioDieta.setIdDieta("d" + i);
            mySqlOperation.setSqlStatement("insert into veterinario_dieta values('"
                    + veterinarioDieta.getIdVeterinario()
                    + "','" + veterinarioDieta.getIdDieta() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarFactura() {
        for (int i = 1; i <= 50; i++) {
            Factura factura = new Factura();
            factura.setIdFactura("fact" + i);
            factura.setPrecio_factura(faker.number().digits(4));
            factura.setCantidad_factura(faker.number().digits(2));
            factura.setIdProveedores("prov" + i);
            mySqlOperation.setSqlStatement("insert into factura values('" + factura.getIdFactura()
                    + "','" + factura.getPrecio_factura() + "','" + factura.getCantidad_factura()
                    + "','" + factura.getIdProveedores() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarOrdenCompra() {
        for (int i = 1; i <= 50; i++) {
            Orden_compra orden_compra = new Orden_compra();
            orden_compra.setIdOrden_compra("oc" + i);
            orden_compra.setFecha_compra(String.valueOf(faker.date().birthday()));
            orden_compra.setIdlogista("log" + i);
            orden_compra.setIdProveedores("prov" + i);
            mySqlOperation.setSqlStatement("insert into orden_compra values('"
                    + orden_compra.getIdOrden_compra()
                    + "','" + orden_compra.getFecha_compra() + "','" +
                    orden_compra.getIdlogista() + "','"
                    + orden_compra.getIdProveedores() + "');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }



}






