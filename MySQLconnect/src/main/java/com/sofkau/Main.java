package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.mysql.MySqlOperation;
import com.sofkau.integration.models.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    private static final String SERVER = "localhost";
    private static final String DATA_BASE_NAME = "zoodb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String SELECT_ALL_FROM_ANIMALES = String.format("select * from %s.animal", DATA_BASE_NAME);
    //private static final String INSERT_ANIMAL = "INSERT INTO animal VALUES ('ANI-005', 'Animal 5', 'Clase 3', 'Especie 3', '2021-02-01', 'DIE-002')";
    private static final MySqlOperation mySqlOperation = new MySqlOperation();

    public static int n = 50;
    public static List<String> id_entrenadores = new ArrayList<>();
    public static List<String> nit_proveedores = new ArrayList<>();
    public static List<String> id_logisticos = new ArrayList<>();
    public static List<String> id_alimentos = new ArrayList<>();
    public static List<String> id_dietas = new ArrayList<>();
    public static List<String> id_animales = new ArrayList<>();
    public static List<String> id_veterinarios = new ArrayList<>();
    public static List<String> id_informes = new ArrayList<>();

    public static void main(String[] args) throws SQLException {


        openConnection();

        List<String> ids_entrenadores = generarEntrenadores();

        List<String> nits_proveedores =  generarProveedores();
        List<String> ids_logisticos =  generarLogisticos();

        generarFacturas(nits_proveedores);
        generarOrdenCompra(nits_proveedores, ids_logisticos);

        List<String> ids_alimentos = generarAlimentos();

        generarProveedorAlimento(nits_proveedores,ids_alimentos);

        List<String> ids_dietas = generarDieta();
        List<String> ids_animales = generarAnimal(ids_dietas);

        generarAlimentoAnimal(ids_alimentos,ids_animales);
        List<String> ids_informes = generarInformeAnimal(ids_animales, ids_entrenadores);

        List<String> ids_veterinarios = generarVeterinarios();

        generarVeterinarioInforme(ids_veterinarios, ids_informes);
        generarVeterinarioDieta(ids_veterinarios,ids_dietas);

        closeConnection();
    }

    private static List<String> generarEntrenadores() {

        String insertEntrenador = "";

        for (int i = 0; i < n ; i++) {

            Entrenador entrenador = new Entrenador();

            Faker faker = new Faker();

            entrenador.setId_entrenador("ENT-" + i);
            entrenador.setNombre_entrenador(faker.name().firstName());
            entrenador.setApellido_entrenador(faker.name().lastName());
            entrenador.setTelefono("555" + faker.numerify("##"));

            insertEntrenador = "INSERT INTO entrenador (id_entrenador, nombre, apellido, telefono) VALUES('%s', '%s', '%s', '%s' );";
            insertEntrenador = String.format(insertEntrenador,
                    entrenador.getId_entrenador(),
                    entrenador.getNombre_entrenador(),
                    entrenador.getApellido_entrenador(),
                    entrenador.getTelefono());

            mySqlOperation.setSqlStatement(insertEntrenador);
            mySqlOperation.executeSqlStatementVoid();

            id_entrenadores.add(entrenador.getId_entrenador());
        }
       return id_entrenadores;
    }

    /**
     * Para insertar registro de Proveedores
     */
    private static List<String> generarProveedores() {

        String insertProveedor = "";
        for (int i = 0; i < n ; i++) {
            Proveedor proveedor = new Proveedor();
            Faker faker = new Faker();

            proveedor.setNit("NIT-" + i);
            proveedor.setNombre(faker.name().name());
            proveedor.setTelefono("555" + faker.numerify("##"));
            proveedor.setCorreo(faker.internet().emailAddress());
            proveedor.setDireccion(faker.address().streetName());

            insertProveedor = "INSERT INTO proveedor (nit, nombre, telefono, correo, direccion) VALUES('%s', '%s', '%s', '%s', '%s' );";
            insertProveedor = String.format(insertProveedor,
                    proveedor.getNit(),
                    proveedor.getNombre(),
                    proveedor.getTelefono(),
                    proveedor.getCorreo(),
                    proveedor.getDireccion());

            mySqlOperation.setSqlStatement(insertProveedor);
            mySqlOperation.executeSqlStatementVoid();

            nit_proveedores.add(proveedor.getNit());
        }
        return nit_proveedores;
    }

    /**
     * Para insertar registro de Facturas
     */
    private static void generarFacturas(List<String> nits_proveedores) {

        String insertFactura = "";

        for (int i = 0; i < n ; i++) {
            Factura factura= new Factura();
            Faker faker = new Faker();

            factura.setId_factura("FAC" + i+1);
            factura.setTotal("$" + faker.random().nextInt(100, 10000));
            factura.setNit_proveedor_factura(nits_proveedores.get(i));

            insertFactura = "INSERT INTO factura (id_factura, total, nit_proveedor_factura) VALUES('%s', '%s', '%s');";
            insertFactura = String.format(insertFactura,
                    factura.getId_factura(),
                    factura.getTotal(),
                    factura.getNit_proveedor_factura());

            mySqlOperation.setSqlStatement(insertFactura);
            mySqlOperation.executeSqlStatementVoid();

        }
    }

    /**
     * Para insertar registro de Logisticos
     */
    private static List<String> generarLogisticos() {

        String insertLogistico = "";

        for (int i = 0; i < n ; i++) {
            Logistico logistico = new Logistico();
            Faker faker = new Faker();

            logistico.setId_logistico("LOG-" + i);
            logistico.setNombre(faker.name().firstName());
            logistico.setApellido(faker.name().lastName());
            logistico.setTelefono("111" + faker.numerify("##"));

            insertLogistico = "INSERT INTO logistico (id_logistico, nombre, apellido, telefono)  VALUES('%s', '%s', '%s', '%s' );";
            insertLogistico = String.format(insertLogistico,
                    logistico.getId_logistico(),
                    logistico.getNombre(),
                    logistico.getApellido(),
                    logistico.getTelefono());

            mySqlOperation.setSqlStatement(insertLogistico);
            mySqlOperation.executeSqlStatementVoid();

            id_logisticos.add(logistico.getId_logistico());
        }
        return id_logisticos;
    }

    /**
     * Para insertar registro de Ordenes
     */
    private static void generarOrdenCompra(List<String> nits_proveedores, List<String> ids_logisticos ) {

        String insertOrdenCompra = "";

        for (int i = 0; i < n ; i++) {
            OrdenCompra ordenCompra = new OrdenCompra();
            Faker faker = new Faker();

            ordenCompra.setId_orden("ORD-" + i);
            ordenCompra.setFecha_emision(String.valueOf(faker.date().between(Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            ordenCompra.setFecha_entrega(String.valueOf(faker.date().between(Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            ordenCompra.setDescripcion(faker.lorem().characters(45));
            ordenCompra.setNit_proveedor_orden(nits_proveedores.get(i));
            ordenCompra.setId_logistico_orden(ids_logisticos.get(i));

            insertOrdenCompra = "INSERT INTO orden_compra (id_orden, fecha_emision, fecha_entrega, descripcion, nit_proveedor_orden, id_logistico_orden)  VALUES('%s', '%s', '%s', '%s', '%s', '%s');";
            insertOrdenCompra = String.format(insertOrdenCompra,
                    ordenCompra.getId_orden(),
                    ordenCompra.getFecha_emision(),
                    ordenCompra.getFecha_entrega(),
                    ordenCompra.getDescripcion(),
                    ordenCompra.getNit_proveedor_orden(),
                    ordenCompra.getId_logistico_orden());

            mySqlOperation.setSqlStatement(insertOrdenCompra);
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    /**
     * Para insertar registro de Alimentos
     */
    private static List<String> generarAlimentos() {

        String insertAlimento = "";

        for (int i = 0; i < n ; i++) {
            Alimento alimento = new Alimento();
            Faker faker = new Faker();

            alimento.setId_alimento("ALI-" + i);
            alimento.setNombre_alimento(faker.food().ingredient());
            alimento.setTipo_alimento(faker.lorem().word());
            alimento.setCantidad(String.valueOf(faker.number().numberBetween(10, 5000)+ " kg"));

            insertAlimento = "INSERT INTO alimento (id_alimento, nombre_alimento, tipo_alimento, cantidad)  VALUES('%s', '%s', '%s', '%s' );";
            insertAlimento = String.format(insertAlimento,
                    alimento.getId_alimento(),
                    alimento.getNombre_alimento(),
                    alimento.getTipo_alimento(),
                    alimento.getCantidad());

            mySqlOperation.setSqlStatement(insertAlimento);
            mySqlOperation.executeSqlStatementVoid();

            id_alimentos.add(alimento.getId_alimento());
        }
        return id_alimentos;
    }

    /**
     * Para insertar registro de proveedor_alimento
     */
    private static void generarProveedorAlimento(List<String> nit_proveedores, List<String> id_alimentos) {

        String insertProveedorAlimento = "";

        for (int i = 0; i < n ; i++) {

            ProveedorAlimento proveedorAlimento = new ProveedorAlimento();

            proveedorAlimento.setId_proveedor_alimento(nit_proveedores.get(i));
            proveedorAlimento.setId_alimento_proveedor(id_alimentos.get(i));

            insertProveedorAlimento = "INSERT INTO proveedor_alimento (id_proveedor_alimento, id_alimento_proveedor)  VALUES('%s', '%s');";
            insertProveedorAlimento = String.format(insertProveedorAlimento,
                    proveedorAlimento.getId_proveedor_alimento(),
                    proveedorAlimento.getId_alimento_proveedor());

            mySqlOperation.setSqlStatement(insertProveedorAlimento);
            mySqlOperation.executeSqlStatementVoid();

        }

    }

    private static List<String> generarDieta() {

        String insertDieta = "";

        for (int i =0; i < n; i++) {
            Dieta dieta = new Dieta();
            Faker faker = new Faker();

            dieta.setId_dieta("DIE-" + i);
            dieta.setTipo_alimento(faker.lorem().word());
            dieta.setDosis(faker.number().numberBetween(1000, 10000)+ " gr");

            insertDieta = "INSERT INTO dieta (id_dieta, tipo_alimento, dosis) VALUES ('%s', '%s', '%s');";
            insertDieta = String.format(insertDieta,
                    dieta.getId_dieta(),
                    dieta.getTipo_alimento(),
                    dieta.getDosis());

            mySqlOperation.setSqlStatement(insertDieta);
            mySqlOperation.executeSqlStatementVoid();

            id_dietas.add(dieta.getId_dieta());
        }
        return id_dietas;
    }

    private static List<String> generarAnimal(List<String> id_dietas) {

        String insertAnimal = "";
        for (int i = 0; i < n; i++) {
            Animal animal = new Animal();
            Faker faker = new Faker();

            animal.setId_animal("ANI-" + i);
            animal.setNombre(faker.animal().name());
            animal.setClase(faker.animal().name());
            animal.setEspecie(faker.animal().name());
            animal.setFecha_nacimiento(String.valueOf(faker.date().between(Date.from(LocalDate.of(1990, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            animal.setId_dieta_animal(id_dietas.get(i));

            insertAnimal = "INSERT INTO animal (id_animal, nombre, clase, especie, fecha_nacimiento, id_dieta_animal) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');";
            insertAnimal = String.format(insertAnimal,
                    animal.getId_animal(),
                    animal.getNombre(),
                    animal.getClase(),
                    animal.getEspecie(),
                    animal.getFecha_nacimiento(),
                    animal.getId_dieta_animal());

            mySqlOperation.setSqlStatement(insertAnimal);
            mySqlOperation.executeSqlStatementVoid();
            id_animales.add(animal.getId_animal());
        }
        return id_animales;
    }

    /**
     * Para insertar registro de alimento_animal
     */
    private static void generarAlimentoAnimal(List<String> id_alimentos, List<String> id_animales) {

        String insertAlimentoAnimal = "";

        for (int i = 0; i < n ; i++) {

            AlimentoAnimal alimentoAnimal = new AlimentoAnimal();

            alimentoAnimal.setId_alimento_animal(id_alimentos.get(i));
            alimentoAnimal.setId_animal_alimento(id_animales.get(i));

            insertAlimentoAnimal = "INSERT INTO alimento_animal (id_alimento_animal, id_animal_alimento) VALUES('%s', '%s');";
            insertAlimentoAnimal = String.format(insertAlimentoAnimal,
                    alimentoAnimal.getId_alimento_animal(),
                    alimentoAnimal.getId_animal_alimento());

            mySqlOperation.setSqlStatement(insertAlimentoAnimal);
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    /**
     * Para insertar registro de informe_animal
     */
    private static List<String> generarInformeAnimal(List<String> id_animales, List<String> id_entrenadores) {

        String insertInformeAnimal = "";
        for (int i = 0; i < n ; i++) {
            InformeAnimal informeAnimal = new InformeAnimal();
            Faker faker = new Faker();

            informeAnimal.setId_informe("INF-" + i);
            informeAnimal.setFecha_peso(String.valueOf(faker.date().between(Date.from(LocalDate.of(2022, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            informeAnimal.setPeso_registrado(faker.number().numberBetween(1000, 10000)+ " kg");
            informeAnimal.setDetalles(faker.lorem().characters(45));
            informeAnimal.setId_animal_informe(id_animales.get(i));
            informeAnimal.setId_entrenador_informe(id_entrenadores.get(i));

            insertInformeAnimal = "INSERT INTO informe_animal (id_informe, fecha_peso, peso_registrado, detalles, id_animal_informe, id_entrenador_informe) VALUES('%s', '%s', '%s', '%s', '%s', '%s');";
            insertInformeAnimal = String.format(insertInformeAnimal,
                    informeAnimal.getId_informe(),
                    informeAnimal.getFecha_peso(),
                    informeAnimal.getPeso_registrado(),
                    informeAnimal.getDetalles(),
                    informeAnimal.getId_animal_informe(),
                    informeAnimal.getId_entrenador_informe());

            mySqlOperation.setSqlStatement(insertInformeAnimal);
            mySqlOperation.executeSqlStatementVoid();
            id_informes.add(informeAnimal.getId_informe());
        }
        return id_informes;
    }

    private static List<String> generarVeterinarios() {

        String insertVeterinario = "";

        for (int i = 0; i < n ; i++) {

            Veterinario veterinario = new Veterinario();
            Faker faker = new Faker();

            veterinario.setId_veterinario("VET-" + i);
            veterinario.setNombre(faker.name().firstName());
            veterinario.setApellido(faker.name().lastName());
            veterinario.setTelefono("555" + faker.numerify("##"));

            insertVeterinario = "INSERT INTO veterinario (id_veterinario, nombre, apellido, telefono) VALUES('%s', '%s', '%s', '%s' );";
            insertVeterinario = String.format(insertVeterinario,
                    veterinario.getId_veterinario(),
                    veterinario.getNombre(),
                    veterinario.getApellido(),
                    veterinario.getTelefono());

            mySqlOperation.setSqlStatement(insertVeterinario);
            mySqlOperation.executeSqlStatementVoid();

            id_veterinarios.add(veterinario.getId_veterinario());
        }
        return id_veterinarios;
    }

    /**
     * Para insertar registro de veterinario_informe
     */
    private static void generarVeterinarioInforme(List<String> id_veterinarios, List<String> id_informes) {

        String insertVeterinarioInforme = "";

        for (int i = 0; i < n ; i++) {

            VeterinarioInforme veterinarioInforme = new VeterinarioInforme();

            veterinarioInforme.setId_veterinario_informe(id_veterinarios.get(i));
            veterinarioInforme.setId_informe_veterinario(id_informes.get(i));

            insertVeterinarioInforme = "INSERT INTO veterinario_informe (id_veterinario_informe, id_informe_veterinario) VALUES('%s', '%s');";
            insertVeterinarioInforme = String.format(insertVeterinarioInforme,
                    veterinarioInforme.getId_veterinario_informe(),
                    veterinarioInforme.getId_informe_veterinario());

            mySqlOperation.setSqlStatement(insertVeterinarioInforme);
            mySqlOperation.executeSqlStatementVoid();

        }

    }

    /**
     * Para insertar registro de veterinario_dieta
     */
    private static void generarVeterinarioDieta(List<String> id_veterinarios, List<String> id_dietas) {

        String insertVeterinarioDieta = "";

        for (int i = 0; i < n ; i++) {

            VeterinarioDieta veterinarioDieta = new VeterinarioDieta();

            veterinarioDieta.setId_veterinario_dieta(id_veterinarios.get(i));
            veterinarioDieta.setId_dieta_veterinario(id_dietas.get(i));

            insertVeterinarioDieta = "INSERT INTO veterinario_dieta (id_veterinario_dieta, id_dieta_veterinario) VALUES('%s', '%s');";
            insertVeterinarioDieta = String.format(insertVeterinarioDieta,
                    veterinarioDieta.getId_veterinario_dieta(),
                    veterinarioDieta.getId_dieta_veterinario());

            mySqlOperation.setSqlStatement(insertVeterinarioDieta);
            mySqlOperation.executeSqlStatementVoid();

        }

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

}