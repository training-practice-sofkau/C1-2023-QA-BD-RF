package com.sofka.sofkau.integracion;

import com.github.javafaker.Faker;
import com.sofka.sofkau.integracion.database.mysql.MySqlOperation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final String SERVER="localhost:3306";
    private static final String DATA_BASE_NAME="alimentos_parque_santafe";
    private static final String USER="root";
    private static final String PASSWORD="IVAN.dario00";
    private static final String INSERT_ANIMAL=("insert into %s.%s(%s) values (%s)");
    private static final String SELECT_ALL_FROM_ANIMALES=String.format("select * from %s.animal",DATA_BASE_NAME);
    private static final MySqlOperation mySqlOperation= new MySqlOperation();
    static Random random=new Random();
    public static void main(String[] args) throws SQLException{
        int tablas=0,posicionReal=0,bandera=0;
        String tabla,atributos,valores;
        for(int i=0;i<1;i++){
            if(i==49){
                tablas++;
            }if(tablas==9){
                break;
            }
            tabla=nombreTabla(tablas);
            if (tabla.equalsIgnoreCase("telefono_veterinario")||
            tabla.equalsIgnoreCase("animal_dieta")||
            tabla.equalsIgnoreCase("telefono_proveedor")||
            tabla.equalsIgnoreCase("alimento_dieta")||
            tabla.equalsIgnoreCase("Dieta")||
            tabla.equalsIgnoreCase("alimento")){
                bandera=1;
                posicionReal=i+1;
                i=random.nextInt(posicionReal+1);
            }else{
                bandera=0;
            }
            atributos=stringAtributos(tabla);
            valores=stringValores(tabla,i);
            openConnection();
            /*insertIntoAnimal(String.format(INSERT_ANIMAL,DATA_BASE_NAME,
                    tabla,
                    atributos,
                    valores));
             */
            insertIntoAnimal("insert into alimentos_parque_santafe.veterinario(nombre) values (Juan)");
            closeConnection();
            if (bandera==1)
                i=posicionReal-1;
        }

    }
    private static void insertIntoAnimal(String valor) {
        mySqlOperation.setSqlStatement(valor);
        mySqlOperation.executeSqlStatementVoid();
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
    public static String nombreTabla(int valor){
        switch (valor){
            case 0: return "veterinario";
            case 1: return "telefono_veterinario";
            case 2: return "dieta";
            case 3: return "animal";
            case 4: return "animal_dieta";
            case 5: return "proveedor";
            case 6: return "telefono_proveedor";
            case 7: return "alimento";
            case 8: return "alimento_dieta";
            default:
                return null;
        }
    }
    public static String stringAtributos(String valor){
        switch (valor){
            case "veterinario": return "nombre";
            case "telefono_veterinario": return "idEmpleado_telefono,telefono_veterinario";
            case "dieta": return "idEmpleado_veterinario";
            case "animal": return "nombre,peso,clasificacion";
            case "animal_dieta": return "idAlimento_dieta,idDieta_alimento";
            case "proveedor": return "nombre";
            case "telefono_proveedor": return "idProceedor_telefono,telefono_proveedor";
            case "alimento": return "dosis,tipo,nombre,idProveedor";
            case "alimento_dieta": return "idAnimal_dieta,idDieta_animal";
            default: return null;
        }
    }
    public static String stringValores(String valor,int i){
        ArrayList<String> clasificacion= (ArrayList<String>)List.of("mamiferos","aves","anfibios","peces","reptíles");
        ArrayList<String> tipo= (ArrayList<String>)List.of("humeda","seca","mixta");
        Faker faker=new Faker();
        switch (valor){
            case "veterinario": return faker.name().fullName();
            case "telefono_veterinario": return i+","+faker.phoneNumber().phoneNumber();
            case "dieta": return ""+i;
            case "animal": return faker.animal().name()+","+random.nextInt(1000-50)+50+","+clasificacion.get(random.nextInt(5)+1);
            case "animal_dieta": return i+","+ random.nextInt(i)+1;
            case "proveedor": return faker.name().fullName();
            case "telefono_proveedor": return i+","+random.nextInt(i)+1;
            case "alimento": return random.nextInt(500)+1+"gr"+","+tipo.get(random.nextInt(5)+1)+","+"comida"+","+random.nextInt(i)+1;
            case "alimento_dieta": return i+","+random.nextInt(i)+1;
            default: return null;
        }
    }
}