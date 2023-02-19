package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.models.*;
import com.sofkau.integration.database.mysql.MySqlOperation;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {


    private  static final String INSERT_ANIMAL = "INSERT INTO Animal VALUES('1005', 'gato', 'felino', '01A')";

    private static final String SERVER="localhost";
    private static final String DATA_BASE_NAME="zoo_santafe";
    private static final String USER="root";
    private static final String PASSWORD="1970";

    private static final String SELECT_ALL_FROM_ANIMALES=String.format("select * from %s.animal",DATA_BASE_NAME);
    private static final MySqlOperation mySqlOperation= new MySqlOperation();

    static Faker faker = new Faker();

    public static void main(String[] args) throws SQLException {

        openConnection();
        //inserIntoAnimal();
        //insertarVeterinario();
        //insertarEntrenador();
        //insertarAlimento();
        //insertarDieta();
        //insertar_dieta_alimento();
        //insertar_logistico();
        //insertarProveedor();
        //insertarFactura();
        //insertarOrdenCompra();
        //insertarProveedor_alimento();
        //insertarTelefono_proveedor();
        //insertarVeterinarioDieta();
        //insertarReporte();
        //insertarReporte_veterinario();
        //insertarAnimal();
        setSelectAllFromAnimales();
        closeConnection();

        Faker faker = new Faker();
        System.out.println(faker.animal().name());
    }

    private static void insertarVeterinario(){

        for (int i = 0; i < 50; i++) {
            Empleado_veterinario vet = new Empleado_veterinario();
            vet.setId_empleado_veterinario("V"+i);
            vet.setNombre_empleado_veterinario(faker.name().firstName());
            vet.setTelefono_empleado_veterinario(faker.phoneNumber().cellPhone().toString());

            mySqlOperation.setSqlStatement("insert into empleado_veterinario values('"+vet.getId_empleado_veterinario()+
                    "','"+vet.getNombre_empleado_veterinario()+"','"+vet.getTelefono_empleado_veterinario()+"');");
            mySqlOperation.executeSqlStatementVoid();

        }

    }
    private static void insertarEntrenador(){
        for (int i=0 ; i<=50 ; i++){
            Empleado_entrenador e= new Empleado_entrenador();
            e.setId_empleado_entrenador("E"+i);
            e.setNombre_empleado_entrenador(faker.name().firstName());
            e.setTelefono_empleado_entrnador(faker.phoneNumber().cellPhone().toString());

            mySqlOperation.setSqlStatement("insert into empleado_entrenador values ('"+e.getId_empleado_entrenador()+"','"+e.getNombre_empleado_entrenador()+"','"+e.getTelefono_empleado_entrnador()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarAlimento(){
        for (int i=0 ; i<=50; i++){
            Alimento a = new Alimento();
            a.setId_alimento("a"+i);
            a.setTipo_alimento(faker.food().vegetable());
            a.setCantidad(faker.number().digits(4) + " gramos");

            mySqlOperation.setSqlStatement("insert into alimento values ('"+a.getId_alimento()+"','"+a.getTipo_alimento()+"','"+a.getCantidad()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }

    }

    private static void insertarDieta(){
        for (int i=0; i<=50 ; i++){
            Dieta d= new Dieta();
            d.setId_dieta("D"+i);
            d.setTipo_dieta(faker.food().dish());
            d.setDosis(faker.number().digits(3) + " gramos");

            mySqlOperation.setSqlStatement("insert into dieta values ('"+d.getId_dieta()+"','"+d.getTipo_dieta()+"','"+d.getDosis()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertar_dieta_alimento() {


        for (int i=0; i<=50 ;i++) {
            String id_dieta_d_a= ("D"+i);
            String id_alimento_d_a= ("a"+i);
            mySqlOperation.setSqlStatement("insert into dieta_alimento values('"+id_dieta_d_a+"','"+id_alimento_d_a+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    private static void insertar_logistico(){

        for (int i=0; i<=50; i++){
            Empleado_logistico l= new Empleado_logistico();
            l.setId_empleado_logistico("L"+i);
            l.setNombre_empleado_logistico(faker.name().name());
            l.setTelefono(faker.phoneNumber().phoneNumber());
            mySqlOperation.setSqlStatement("insert into empleado_logistico values ('"+l.getId_empleado_logistico()+
                    "','"+l.getNombre_empleado_logistico()+"','"+l.getTelefono()+"');");
            mySqlOperation.executeSqlStatementVoid();


        }
    }
    private static void insertarProveedor(){

        for (int i=0; i<=50 ;i++){
            Proveedor p = new Proveedor();
            p.setId_proveedor("P"+i);
            p.setNombre_proveedor(faker.name().name());
            p.setDireccion(faker.address().firstName());
            mySqlOperation.setSqlStatement("insert into proveedor values ('"+p.getId_proveedor()+
                    "','"+p.getNombre_proveedor()+"','"+p.getDireccion()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarFactura(){

        for (int i=0; i<=50 ;i++){
            Factura f= new Factura();
            f.setId_factura("f"+i);
            f.setCantidad_productos(faker.number().digits(3));
            f.setCantidad_total(String.valueOf(faker.number().numberBetween(1000000, 25000000)));
            f.setId_proveedor_f("P"+i);
            mySqlOperation.setSqlStatement("insert into factura values ('"+f.getId_factura()+
                    "','"+f.getCantidad_productos()+"','"+f.getCantidad_total()+"','"+f.getId_proveedor_f()+"');");
            mySqlOperation.executeSqlStatementVoid();

        }
    }

    private static void insertarOrdenCompra(){

        for (int i=0; i<=50 ;i++){
            OrdenCompra o= new OrdenCompra();
            o.setId_orden("O-"+i);
            o.setDescripcion(faker.business().creditCardType());
            o.setFecha_de_elaboracion((String.valueOf(faker.date().between(Date.from(LocalDate.of(2022, 4, 11).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date()))));
            o.setFecha_de_entrega((String.valueOf(faker.date().between(Date.from(LocalDate.of(2023, 2, 5).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date()))));
            o.setId_empleado_logistico_o("L"+i);
            o.setId_proveedor_o("P"+i);
            mySqlOperation.setSqlStatement("insert into orden_compra values ('"+o.getId_orden()+
                    "','"+o.getFecha_de_elaboracion()+"','"+o.getFecha_de_entrega()+"','"+o.getDescripcion()+
                    "','"+o.getId_empleado_logistico_o()+"','"+o.getId_proveedor_o()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarProveedor_alimento(){

        for (int i=0; i<=50 ;i++){
            String id_alimento_p=("a"+i);
                    String id_proveedor_p=("P"+i);

            mySqlOperation.setSqlStatement("insert into proveedor_alimento values('"+id_alimento_p+"','"+id_proveedor_p+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    private static void insertarTelefono_proveedor(){
        for (int i=0; i<=50 ;i++){
            String id_proveedor_telefono=("P"+i);
            String numero=faker.phoneNumber().cellPhone().toString();
            mySqlOperation.setSqlStatement("insert into telefono_proveedor values('"+id_proveedor_telefono+"','"+numero+"');");
            mySqlOperation.executeSqlStatementVoid();

        }
    }
    private static void insertarVeterinarioDieta(){

        for (int i=0; i<=50 ;i++){
           String id_empleado_veterinario_d=("V"+i);
            String id_dieta_d=("D"+i);
            mySqlOperation.setSqlStatement("insert into veterinario_dieta values('"+id_empleado_veterinario_d+"','"+id_dieta_d+"');");
            mySqlOperation.executeSqlStatementVoid();

        }
    }

    private static void insertarReporte(){

        for (int i=0; i<=50 ;i++) {
            Reporte r = new Reporte();
            r.setId_reporte("R-" + i);
            r.setDetalles(faker.medical().symptoms());
            r.setFecha_ultimo_peso((String.valueOf(faker.date().between(Date.from(LocalDate.of(2023, 2, 2).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date()))));
            r.setId_animal_r("Animal-" + i);
            r.setId_empleado_entrenador_r("E" + i);
            r.setPeso_ultimo(String.valueOf(faker.number().randomDouble(1, 1, 650)));

            mySqlOperation.setSqlStatement("insert into reporte values('" + r.getId_reporte() + "', '"
                    + r.getPeso_ultimo() + "', '" + r.getFecha_ultimo_peso() + "', '"
                    + r.getDetalles() + "', '" + r.getId_empleado_entrenador_r() + "', '"
                    + r.getId_animal_r() + "')");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

    private static void insertarReporte_veterinario(){
        for (int i=0; i<=50 ;i++){
            String id_empleado_veterinario_r=("V"+i);
            String id_reporte_r=("R-" + i);
            mySqlOperation.setSqlStatement("insert into reporte_veterinario values('"+id_empleado_veterinario_r+"','"+id_reporte_r+"');");
            mySqlOperation.executeSqlStatementVoid();


        }
    }

    private static void insertarAnimal(){

        for (int i=0; i<=50 ;i++){
            Animal animal= new Animal();
            animal.setId_animal("Animal-"+i);
            animal.setEspecie(faker.animal().name());
            animal.setEdad(String.valueOf(faker.number().numberBetween(1, 28)));
            animal.setId_dieta_a("D"+i);
            mySqlOperation.setSqlStatement("insert into animal values('" + animal.getId_animal() + "', '"
                    + animal.getEspecie() + "', '" + animal.getEdad() + "', '"
                    + animal.getId_dieta_a() + "')");
            mySqlOperation.executeSqlStatementVoid();


        }
    }


    private static void inserIntoAnimal() {
        mySqlOperation.setSqlStatement(INSERT_ANIMAL);
        mySqlOperation.executeSqlStatementVoid();
    }
    public static void openConnection(){
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }

    public static void setSelectAllFromAnimales()throws SQLException{
        mySqlOperation.setSqlStatement(SELECT_ALL_FROM_ANIMALES);
        mySqlOperation.executeSqlStatement();
        mySqlOperation.printResulset();
    }

    public static void closeConnection(){
        mySqlOperation.close();

    }







}