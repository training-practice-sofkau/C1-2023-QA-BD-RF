package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.mysql.MySqlOperation;
import com.sofkau.models.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.valueOf;

public class Main {
    private static final String SERVER = "localhost";
    private static final String DATA_BASE_NAME = "zoologico";
    private static final String USER = "root";
    private static final String PASSWORD = "Tech2022camp";
    private static final String SELECT_ALL_FROM_ANIMAL = String.format("select * from %s.animal", DATA_BASE_NAME);
    private static final MySqlOperation mySqlOperation = new MySqlOperation();
    public static int registros = 50;
    public static List<String> idVeterinario = new ArrayList<>();
    public static List<String> idDieta = new ArrayList<>();
    public static  List<String> idProveedor = new ArrayList<>();
    public static List<String> idEmpleadoLogistico = new ArrayList<>();
    public static List<String> idAlimento = new ArrayList<>();
    public static List<String> idAnimal = new ArrayList<>();
    public static List<String> idReporte = new ArrayList<>();
    public static List<String> idEntrenador = new ArrayList<>();
    public static List<String> idOrdenCompra = new ArrayList<>();
    public static List<String> idFactura = new ArrayList<>();
    public static void main(String[] args) throws SQLException {
        openConnection();
        List<String> idVeterinarios = insertVeterinario();
        List<String> idEntrenadores = insertEntrenador();
        List<String> idProveedores = insertProveedor();
        List<String> idEmpleadosLogisticos = insertEmpleadoLogistico();
        List<String> idAlimentos =  insertAlimento();
        insertFactura(idProveedores, idEmpleadosLogisticos);
        List<String> idOrdenesCompras =  insertOrdenCompra(idProveedores, idEmpleadosLogisticos);
        insertOrdenAlimento(idOrdenesCompras, idAlimentos);
        List<String>  idDietas = insertDieta(idVeterinarios);
        insertAlimentoDieta(idAlimentos, idDietas);
        List<String> idAnimales =  insertAnimal(idDietas);
        List<String> idReportes = insertReporte(idAnimales, idEntrenadores);
        insertVeterinarioReporte(idVeterinarios, idReportes);

    }
    public static void openConnection() {
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }

    public static void selectAllFromAnimal() throws SQLException {
        mySqlOperation.setSqlStatement(SELECT_ALL_FROM_ANIMAL);

        mySqlOperation.executeSqlStatement();
        mySqlOperation.printResultset();
    }



    public static void closeConnection() {
        mySqlOperation.close();
    }

    public static List<String> insertVeterinario(){
        String statementInsertVeterinario = "";

        for (int i = 0; i < registros; i++) {
            Veterinario veterinario = new Veterinario();

            Faker faker = new Faker();

            veterinario.setId("VET" + i);
            veterinario.setNombre(faker.name().firstName() + faker.name().lastName());
            veterinario.setCorreo(faker.name().firstName() + "@mail.com");
            veterinario.setTelefono("604" + faker.numerify("#####"));

            statementInsertVeterinario = String.format("insert into  veterinario (id, nombre, correo, telefono) " +
                            "values('%s', '%s', '%s', '%s');",
                    veterinario.getId(),
                    veterinario.getNombre(),
                    veterinario.getCorreo(),
                    veterinario.getTelefono());

            mySqlOperation.setSqlStatement(statementInsertVeterinario);
            mySqlOperation.executeInsertStatement();
            idVeterinario.add(veterinario.getId());


        }
        return idVeterinario;
    }

    public static List<String> insertDieta (List<String> idVeterinarios) {
        String statementInsertDieta = "";

        for (int i = 0; i < registros; i++) {
            Dieta dieta = new Dieta();
            Faker faker = new Faker();

            dieta.setId("Dieta-" + i);
            dieta.setNombre("Dieta " + dieta.getId());
            dieta.setDosis(faker.numerify("###"));
            dieta.setVeterinarioId(idVeterinarios.get(i));

            statementInsertDieta = String.format("insert into dieta(id, nombre, dosis, veterinario_id) " +
                    "values('%s', '%s', '%s', '%s');",
                    dieta.getId(),
                    dieta.getNombre(),
                    dieta.getDosis(),
                    dieta.getVeterinarioId());

            mySqlOperation.setSqlStatement(statementInsertDieta);
            mySqlOperation.executeInsertStatement();
            idDieta.add(dieta.getId());
        }
        return idDieta;
    }

    public static List<String> insertEntrenador() {
        String statementInsertEntrenador = "";

        for (int i = 0; i < registros; i++) {
            Entrenador entrenador = new Entrenador();
            Faker faker = new Faker();

            entrenador.setId("Ent" + i);
            entrenador.setNombre(faker.name().firstName() + faker.name().lastName());
            entrenador.setCorreo((faker.name().firstName() + ".") + faker.name().lastName() + "@mail.com");
            entrenador.setTelefono("604" + faker.numerify("######"));

            statementInsertEntrenador = String.format("insert into entrenador(id, nombre, correo, telefono)" +
                    "values('%s', '%s', '%s', '%s');",
                    entrenador.getId(),
                    entrenador.getNombre(),
                    entrenador.getCorreo(),
                    entrenador.getTelefono());

                mySqlOperation.setSqlStatement(statementInsertEntrenador);
                mySqlOperation.executeInsertStatement();
                idEntrenador.add(entrenador.getId());


        }
        return idEntrenador;
    }

    public static List<String> insertAnimal(List<String> idDietas) {
        String statementInsertAnimal = "";

        for (int i = 0; i < registros; i++ ) {
            Animal animal = new Animal();
            Faker faker = new Faker();

            animal.setId("Animal" + i);
            animal.setEspecie(faker.animal().name());
            animal.setDietaId(idDietas.get(i));

            statementInsertAnimal = String.format("insert into animal(id, especie, dieta_id)" +
                    "values ('%s', '%s', '%s');",
                    animal.getId(),
                    animal.getEspecie(),
                    animal.getDietaId());

            mySqlOperation.setSqlStatement(statementInsertAnimal);
            mySqlOperation.executeInsertStatement();
            idAnimal.add(animal.getId());

        }
        return idAnimal;
    }

    public static List<String> insertAlimento () {
        String statementInsertAlimento = "";

        for (int i = 0; i < registros; i++) {
            Alimento alimento = new Alimento();
            Faker faker = new Faker();

            alimento.setId("Ali " + i);
            alimento.setNombre(faker.food().ingredient());
            alimento.setTipo(faker.lorem().word());
            alimento.setCantidad(faker.numerify("###"));

            statementInsertAlimento = String.format("insert into alimento(id, nombre, tipo, cantidad)" +
                    "values ('%s', '%s', '%s', '%s');",
                    alimento.getId(),
                    alimento.getNombre(),
                    alimento.getTipo(),
                    alimento.getCantidad());

            mySqlOperation.setSqlStatement(statementInsertAlimento);
            mySqlOperation.executeInsertStatement();
            idAlimento.add(alimento.getId());

        }
        return idAlimento;
    }

    public static List<String> insertReporte(List<String> idAnimales, List<String> idEntrenadores){
        String statementInsertReporte = "";

        for (int i = 0; i < registros; i++){
            Reporte reporte = new Reporte();
            Faker faker = new Faker();

            reporte.setId("Report" + i);
            reporte.setPesoAnimal(faker.numerify("####"));
            reporte.setFecha (valueOf(faker.date().between(Date.from(LocalDate.of(2022, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            reporte.setAnimalId(idAnimales.get(i));
            reporte.setEntrenadorId(idEntrenadores.get(i));

            statementInsertReporte = String.format("insert into reporte(id, peso_animal, fecha, animal_id, entrenador_id)" +
                    "values ('%s', '%s', '%s', '%s', '%s');",
                    reporte.getId(),
                    reporte.getPesoAnimal(),
                    reporte.getFecha(),
                    reporte.getAnimalId(),
                    reporte.getEntrenadorId());

            mySqlOperation.setSqlStatement(statementInsertReporte);
            mySqlOperation.executeInsertStatement();
            idReporte.add(reporte.getId());
        }
        return idReporte;
    }

    public static void insertVeterinarioReporte(List<String> idVeterinarios, List<String> idReportes){
        String statementInsertVeterinarioReporte = "";

        for (int i = 0; i < registros; i++){
            VeterinarioReporte veterinarioReporte = new VeterinarioReporte();

            veterinarioReporte.setVeterinarioId(idVeterinarios.get(i));
            veterinarioReporte.setReporteId(idReportes.get(i));

            statementInsertVeterinarioReporte = String.format("insert into veterinario_reporte(veterinario_id, reporte_id)" +
                    "values('%s', '%s');",
                    veterinarioReporte.getVeterinarioId(),
                    veterinarioReporte.getReporteId());

            mySqlOperation.setSqlStatement(statementInsertVeterinarioReporte);
            mySqlOperation.executeInsertStatement();

        }
    }

    public static void insertAlimentoDieta(List<String> idAlimentos, List<String> idDietas){
        String statementInsertDietaAlimento = "";

        for (int i = 0; i < registros; i++){
            AlimentoDieta alimentoDieta = new AlimentoDieta();

            alimentoDieta.setAlimentoId(idAlimentos.get(i));
            alimentoDieta.setDietaId(idDietas.get(i));

            statementInsertDietaAlimento = String.format("insert into alimento_dieta(alimento_id, dieta_id)" +
                    "values('%s', '%s');",
                    alimentoDieta.getAlimentoId(),
                    alimentoDieta.getDietaId());

            mySqlOperation.setSqlStatement(statementInsertDietaAlimento);
            mySqlOperation.executeInsertStatement();
        }
    }

    public static List<String> insertProveedor(){
        String statementInsertProveedor = "";

        for (int i = 0; i < registros; i++){
            Proveedor proveedor = new Proveedor();
            Faker faker = new Faker();

            proveedor.setId("Prov" + i);
            proveedor.setNombre(faker.name().firstName() + faker.name().lastName());
            proveedor.setDireccion(faker.address().streetName());
            proveedor.setCorreo(faker.name().firstName() + "." + faker.name().lastName() + "@mail.com");
            proveedor.setTelefono("604" + faker.numerify("#####"));

            statementInsertProveedor = String.format("insert into proveedor(id, nombre, direccion, correo, telefono)" +
                    "values('%s', '%s', '%s', '%s', '%s');",
                    proveedor.getId(),
                    proveedor.getNombre(),
                    proveedor.getDireccion(),
                    proveedor.getCorreo(),
                    proveedor.getTelefono());

            mySqlOperation.setSqlStatement(statementInsertProveedor);
            mySqlOperation.executeInsertStatement();
            idProveedor.add(proveedor.getId());

        }
        return idProveedor;
    }

    public static List<String> insertEmpleadoLogistico(){
        String statementInsertEmpleadoLogistico = "";

        for (int i = 0; i < registros; i++){
            EmpleadoLogistico empleadoLogistico = new EmpleadoLogistico();
            Faker faker = new Faker();

            empleadoLogistico.setId("Logi" + i);
            empleadoLogistico.setNombre(faker.name().firstName() + faker.name().lastName());
            empleadoLogistico.setCorreo(faker.name().firstName() + "." + faker.name().lastName() + "@mail.com");
            empleadoLogistico.setTelefono(faker.numerify("604" + "#####"));

            statementInsertEmpleadoLogistico = String.format("insert into empleado_logistico(id, nombre, correo, telefono)" +
                    "values('%s', '%s', '%s', '%s');",
                    empleadoLogistico.getId(),
                    empleadoLogistico.getNombre(),
                    empleadoLogistico.getCorreo(),
                    empleadoLogistico.getTelefono());

            mySqlOperation.setSqlStatement(statementInsertEmpleadoLogistico);
            mySqlOperation.executeInsertStatement();
            idEmpleadoLogistico.add(empleadoLogistico.getId());


        }
        return idEmpleadoLogistico;
    }

    public static List<String> insertOrdenCompra(List<String> idProveedores, List<String> idEmpleadosLogisticos){
        String statementInsertOrdenCompra = "";

        for (int i = 0; i < registros; i++){
            OrdenCompra ordenCompra = new OrdenCompra();
            Faker faker = new Faker();

            ordenCompra.setId("Orden" + i);
            ordenCompra.setFecha(String.valueOf(faker.date().between(Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            ordenCompra.setProveedorId(idProveedores.get(i));
            ordenCompra.setEmpleadoLogisticoId(idEmpleadosLogisticos.get(i));
            ordenCompra.setUnidades(faker.numerify("###"));

            statementInsertOrdenCompra = String.format("insert into orden_compra(id, fecha, proveedor_id, empleado_logistico_id, unidades)" +
                    "values('%s', '%s', '%s', '%s', '%s');",
                    ordenCompra.getId(),
                    ordenCompra.getFecha(),
                    ordenCompra.getProveedorId(),
                    ordenCompra.getEmpleadoLogisticoId(),
                    ordenCompra.getUnidades());

            mySqlOperation.setSqlStatement(statementInsertOrdenCompra);
            mySqlOperation.executeInsertStatement();
            idOrdenCompra.add(ordenCompra.getId());
        }
        return idOrdenCompra;
    }

    public static void insertOrdenAlimento(List<String> idOrdenesCompras, List<String> idAlimentos){
        String statementInsertOrdenAlimento = "";

        for (int i = 0; i < registros; i++){
            OrdenAlimento ordenAlimento = new OrdenAlimento();

            ordenAlimento.setOrdenCompraId(idOrdenesCompras.get(i));
            ordenAlimento.setAlimentoId(idAlimentos.get(i));

            statementInsertOrdenAlimento = String.format("insert into orden_alimento(orden_compra_id, id_alimento)" +
                    "values('%s', '%s');",
                    ordenAlimento.getOrdenCompraId(),
                    ordenAlimento.getAlimentoId());

            mySqlOperation.setSqlStatement(statementInsertOrdenAlimento);
            mySqlOperation.executeInsertStatement();
        }
    }

    public static void insertFactura(List<String> idProveedores, List<String> idEmpleadosLogisticos){
        String statementInsertFactura = "";

        for (int i = 0; i < registros; i++){
            Factura factura = new Factura();
            Faker faker = new Faker();

            factura.setId("Factura" + i);
            factura.setFecha(String.valueOf(faker.date().between(Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            factura.setTotal("$" + faker.random().nextInt(100, 10000));
            factura.setIdProveedor(idProveedores.get(i));
            factura.setEmpleadoLogisticoId(idEmpleadosLogisticos.get(i));
            factura.setUnidades(faker.numerify("####"));

            statementInsertFactura = String.format("insert into factura(id, fecha, total, id_proveedor, id_empleado_logistico, unidades)" +
                    "values('%s', '%s', '%s', '%s', '%s', '%s');",
                    factura.getId(),
                    factura.getFecha(),
                    factura.getTotal(),
                    factura.getIdProveedor(),
                    factura.getEmpleadoLogisticoId(),
                    factura.getUnidades());

            mySqlOperation.setSqlStatement(statementInsertFactura);
            mySqlOperation.executeInsertStatement();
        }
    }

}