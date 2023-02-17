package com.sofkau;

import com.github.javafaker.Animal;
import com.github.javafaker.Faker;
import com.sofkau.integration.database.mysql.MySqlOperation;
import com.sofkau.integration.models.Veterinario;

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
        insertarVeterinario();
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

//    private static void insertarAnimal(){
//        for (int 1 = 0; i < 3; i++){
//            Animal animal = new Animal();
//            animal.setId_animal("Ani"+i+1);
//            animal.setNombre(faker.funnyName().name());
//
//        }
//    }

    private static void insertarVeterinario(){

        for (int i = 1; i < 4; i++) {
            Veterinario veterinario = new Veterinario();
            veterinario.setIdVeterinario("Vet"+i);
            veterinario.setNombre_veterinario(faker.name().firstName());
            veterinario.setTelefono(faker.phoneNumber().cellPhone().toString());

            mySqlOperation.setSqlStatement("insert into veterinario values('"+veterinario.getIdVeterinario()+"','"+veterinario.getNombre_veterinario()
                    +"','"+veterinario.getTelefono()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

}






