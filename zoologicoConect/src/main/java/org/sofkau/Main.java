package org.sofkau;

import com.github.javafaker.Faker;
import org.sofkau.dbZoo.clases.*;
import org.sofkau.dbZoo.mysql.MySqlOperation;
import org.sofkau.dbZoo.zoologico.*;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static final String SERVER = "localhost";
    private static final String DATA_BASE_NAME = "zoologico";
    private static final String USER = "root";
    private static final String PASSWORD = "fjrr950535";
    private static final MySqlOperation mysqlOperation = new MySqlOperation();

    public static void main(String[] args) throws SQLException {
        openConnection();
        agregarveter();
        listarVeter();
        agregarprovee();
        listarprovee();
        agregarAlimento();
        listaralimento();
        agregarAnimal();
        listaranimal();
        agregarEntrenador();
        listarentre();
        agregarEmplogistico();
        listaremplog();
        agregarDieta();
        listarDieta();
        agregarFactura();
        listarFactura();
        agregarorden();
        listarorden();
        agregarAliLog();
        agregarClasificacion();
        agregarDietaAli();
        agregarDietaVeter();
        agregarEntreAminal();
        agregarPeso();
        agregarProvFac();
        closeConnection();
    }

    public static void openConnection() {
        mysqlOperation.setServer(SERVER);
        mysqlOperation.setDataBaseName(DATA_BASE_NAME);
        mysqlOperation.setUser(USER);
        mysqlOperation.setPassword(PASSWORD);
    }


    public static void closeConnection() {
        mysqlOperation.close();
    }


    public static void agregarveter() {
        Veterinario_zoo veterinarioZoo = new Veterinario_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_veter = ("PR-"+i);
            String nombre = faker.name().firstName();
            String telefono = faker.phoneNumber().cellPhone();

            veterinarioZoo.insertVeterinario(new Veterinario(id_veter, nombre,telefono));
        }
    }
    public static void listarVeter(){
        Veterinario_zoo veterinarioZoo = new Veterinario_zoo(mysqlOperation);
        List<Veterinario> veterinarioList = veterinarioZoo.mostrarVeterinario();
        for (Veterinario datos: veterinarioList){
            System.out.println("ID: "+datos.getId_veterinario()+ " "+" NOMBRE: "+ datos.getNombre()+ " "+
                    " TELEFONO: "+datos.getTelefono()+" ");
        }
    }

    public static void agregarprovee() {
        Proveedor_zoo proveedor_zoo = new Proveedor_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_provee = ("PRO-"+i);
            String nombre = faker.name().firstName();
            String direccion = faker.address().cityName();
            String correo = faker.internet().emailAddress();

            proveedor_zoo.insertProveedor(new Proveedor(id_provee, nombre,direccion,correo));
        }
    }

    public static void listarprovee(){
        Proveedor_zoo proveedor_zoo = new Proveedor_zoo(mysqlOperation);
        List<Proveedor> proveedorList = proveedor_zoo.mostrarProveedor();
        for (Proveedor datos: proveedorList){
            System.out.println("ID: "+datos.getId_proveedor()+ " "+" NOMBRE: "+ datos.getNombre()+ " "+
                    " DIRECCION: "+datos.getDireccion()+" "+ " CORREO: "+datos.getCorreo()+" ");
        }
    }

    public static void agregarAlimento() {
        Alimento_zoo alimentoZoo = new Alimento_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_alimento = ("ASR-"+i);
            String nombre = faker.food().ingredient();
            String dosis = faker.number().digit();

            alimentoZoo.insertAlimento(new Alimento(id_alimento, nombre,dosis));
        }
    }

    public static void listaralimento(){
        Alimento_zoo alimentoZoo = new Alimento_zoo(mysqlOperation);
        List<Alimento> alimentoList= alimentoZoo.mostrarAlimento();
        for (Alimento datos: alimentoList){
            System.out.println("ID: "+datos.getId_alimento()+ " "+" NOMBRE: "+ datos.getNombre()+ " "+
                    " DOSIS: "+datos.getDosis()+" ");
        }
    }


    public static void agregarAnimal() {
        Animal_zoo animalZoo = new Animal_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_animal = ("ANIM-"+i);
            String nombre = faker.animal().name();
            String sexo = faker.dog().gender();
            String fecha = faker.dog().age();
            String edad = faker.dog().age();

            animalZoo.insertAnimal(new Animal(id_animal, nombre,sexo,fecha,edad));
        }
    }

    public static void listaranimal(){
        Animal_zoo animalZoo= new Animal_zoo(mysqlOperation);
        List<Animal> animals= animalZoo.mostrarAnimal();
        for (Animal datos: animals){
            System.out.println("ID: "+datos.getId_animal()+ " "+" NOMBRE: "+ datos.getNombre()+ " "+
                    " SEXO: "+datos.getSexo()+" "+" FECHA NACIMIENTO: "+ datos.getFecha_nacimiento()+ " "+
                    " EDAD: "+ datos.getEdad()+ " ");
        }
    }

    public static void agregarEntrenador() {
        Entrenador_zoo entrenadorZoo = new Entrenador_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_entre = ("ENTREN-"+i);
            String nombre = faker.name().firstName();
            String telefono = faker.phoneNumber().cellPhone();
            String id_veterinarios = ("PR-"+i);


            entrenadorZoo.insertEntrenador(new Entrenador(id_entre, nombre,telefono,id_veterinarios));
        }
    }

    public static void listarentre(){
        Entrenador_zoo entrenadorZoo = new Entrenador_zoo(mysqlOperation);
        List<Entrenador> entrenadors = entrenadorZoo.mostrarEntrenador();
        for (Entrenador datos: entrenadors){
            System.out.println("ID: "+datos.getId_entrenador()+ " "+" NOMBRE: "+ datos.getNombre()+ " "+
                    " TELEFONO: "+datos.getTelefono()+" "+" VETERINARIO A REPORTAR PESO: "+ datos.getId_veterinarios());
        }
    }

    public static void agregarEmplogistico() {
        Emp_logistico_zoo empLogisticoZoo = new Emp_logistico_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_emp = ("ELOG-"+i);
            String nombre = faker.name().firstName();
            String correo = faker.internet().emailAddress();

            empLogisticoZoo.insertEmp_logistico(new Emp_logistico(id_emp, nombre,correo));
        }
    }

    public static void listaremplog(){
        Emp_logistico_zoo empLogisticoZoo = new Emp_logistico_zoo(mysqlOperation);
        List<Emp_logistico> empLogisticos = empLogisticoZoo.mostrarEmp_logistico();
        for (Emp_logistico datos: empLogisticos){
            System.out.println("ID: "+datos.getId_logistico()+ " "+" NOMBRE: "+ datos.getNombre()+ " "+
                    " CORREO: "+datos.getCorreo());
        }
    }

    public static void agregarDieta() {
        Dieta_zoo dietaZoo = new Dieta_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_dieta = ("DIE-"+i);
            String recomendaciones = faker.lorem().characters();
            String id_animals = ("ANIM-"+i);

            dietaZoo.insertDieta(new Dieta(id_dieta, recomendaciones, id_animals));
        }
    }

    public static void listarDieta(){
        Dieta_zoo dietaZoo = new Dieta_zoo(mysqlOperation);
        List<Dieta> dietas = dietaZoo.mostrarDieta();
        for (Dieta datos: dietas){
            System.out.println("ID: "+datos.getId_dieta()+ " "+" RECOMENDACIONES: "+ datos.getRecomendaciones()+ " "+
                    " ANIMAL A ASIGNAR DIETA: "+datos.getId_animales());
        }
    }

    public static void agregarFactura() {
        Factura_zoo facturaZoo = new Factura_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_factura = ("FAC-"+i);
            String fecha = faker.idNumber().valid();
            String total = faker.idNumber().valid();

            facturaZoo.insertFactura(new Factura(id_factura, fecha, total));
        }
    }

    public static void listarFactura(){
        Factura_zoo facturaZoo = new Factura_zoo(mysqlOperation);
        List<Factura> facturas = facturaZoo.mostrarFactura();
        for (Factura datos: facturas){
            System.out.println("ID: "+datos.getId_factura()+ " "+" FECHA: "+ datos.getFecha()+ " "+
                    " TOTAL "+datos.getTotal());
        }
    }

    public static void agregarorden() {
        Orden_compra_zoo ordenCompraZoo = new Orden_compra_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_orden = ("OR-"+i);
            String fecha = faker.idNumber().valid();
            String nombre = faker.food().ingredient();
            String cantidad = faker.number().digit();
            String id_log = ("ELOG-"+i);
            String id_provee = ("PRO-"+i);
            String obser = faker.lorem().sentence();

            ordenCompraZoo.insertOrden_compra(new Orden_compra(id_orden, fecha, nombre,cantidad,id_log,id_provee,obser));
        }
    }
    public static void listarorden(){
        Orden_compra_zoo ordenCompraZoo = new Orden_compra_zoo(mysqlOperation);
        List<Orden_compra> ordenCompras = ordenCompraZoo.mostrarOrden_compra();
        for (Orden_compra datos: ordenCompras){
            System.out.println("ID: "+datos.getId_orden()+ " "+" FECHA: "+ datos.getFecha()+ " "+
                    " ALIMENTO "+datos.getNombre_alimento()+" "+"CANTIDAD:"+ datos.getCantidad()+" "+
                    "EMPLEADO QUE HIZO LA ORDEN: "+datos.getId_logisticos()+" "+"PROVEEDOR: "+datos.getId_proveedors()+
                    " "+"OBSERVACIONES: "+datos.getOnservaciones());
        }
    }

    public static void agregarAliLog() {
        Alimento_logistico_zoo alimentoLogisticoZoo = new Alimento_logistico_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_ali = ("ALI-"+i);
            String id_elog = ("ELOG-"+i);
            alimentoLogisticoZoo.insertAlimento_logistico(new Alimento_logistico(id_ali,id_elog));
        }
    }
    public static void agregarClasificacion() {
        Clasificacion_animal_zoo clasificacionAnimalZoo = new Clasificacion_animal_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_ani = ("ASR-"+i);
            String peso = faker.number().digit();
            clasificacionAnimalZoo.insertClasificacion_animal(new Clasificacion_animal(id_ani,peso));
        }
    }

    public static void agregarDietaAli() {
        Dieta_alimento_zoo dietaAlimentoZoo = new Dieta_alimento_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_dieta = ("DIE-"+i);
            String id_aliment = ("ASR-"+i);
            dietaAlimentoZoo.insertDieta_Alimento(new Dieta_alimento(id_dieta,id_aliment));
        }
    }

    public static void agregarDietaVeter() {
        Dieta_veterinario_zoo dietaVeterinarioZoo = new Dieta_veterinario_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_dieta = ("DIE"+i);
            String id_veter = ("VET-"+i);
            dietaVeterinarioZoo.insertDietaVeterinario(new Dieta_veterinario(id_dieta,id_veter));;
        }
    }

    public static void agregarEntreAminal() {
        Entrenador_animal_zoo entrenadorAnimalZoo = new Entrenador_animal_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_anim = ("ANIM-"+i);
            String id_entre = ("ENTREN-"+i);
            entrenadorAnimalZoo.inserEntrenador_animal(new Entrenador_animal(id_anim,id_entre));
        }
    }

    public static void agregarPeso() {
        Peso_animal_zoo pesoAnimalZoo = new Peso_animal_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_ani = ("ANIM-"+i);
            String peso = faker.number().digit();
            pesoAnimalZoo.insertPeso(new Peso_historial(id_ani,peso));
        }
    }

    public static void agregarProvFac() {
        Proveedor_factura_zoo proveedorFacturaZoo= new Proveedor_factura_zoo(mysqlOperation);
        Faker faker = new Faker();
        for (int i = 0; i <= 50; i++) {
            String id_prov = ("PRO-"+i);
            String id_fac = ("FAC-"+i);
            proveedorFacturaZoo.insertProveedorFactura(new Proveedor_factura(id_prov,id_fac));
        }
    }
}