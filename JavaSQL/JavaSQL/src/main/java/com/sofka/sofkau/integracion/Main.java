package com.sofka.sofkau.integracion;
import com.github.javafaker.Faker;
import com.sofka.sofkau.integracion.database.mysql.MySqlOperacion;
import com.sofka.sofkau.integracion.modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Main {
    private static final String SERVIDOR="localhost";
    private static final String NOMBRE_BASE_DATOS="alimentos_parque_santafe";
    private static final String USUARIO="root";
    private static final String CONTRASENA="IVAN.dario00";
    private static final String INSERTAR_ANIMAL=("insert into %s.%s(%s) values (%s);");
    private static final String SELECT_ALL_FROM_ANIMALES=String.format("select * from %s.animal",NOMBRE_BASE_DATOS);
    private static final MySqlOperacion mySqlOperacion= new MySqlOperacion();
    public static void main(String[] args){
        ITabla tabla=new Veterinario();
        int contador=0;
        String valor;
        for(int i=0;i<51;i++){
            valor=tabla.getValores();
            abrirConexion();
            insertIntoAnimal(tabla.getTabla(),tabla.getAtributos(),valor);
            closeConexion();
            if(tabla instanceof AlimentoDieta&&i==49){
                break;
            }
            if(i==50){
                i=0;
                contador++;
                switch (contador){
                    case 1: tabla=new VeterinarioTelefono();
                            break;
                    case 2: tabla=new Dieta();
                            break;
                    case 3: tabla=new Animal();
                            break;
                    case 4: tabla=new AnimalDieta();
                            break;
                    case 5: tabla=new Proveedor();
                            break;
                    case 6: tabla=new ProveedorTelefono();
                            break;
                    case 7: tabla=new Alimento();
                            break;
                    case 8: tabla=new AlimentoDieta();
                            break;
                    default: break;
                }
            }
        }
    }
    private static void insertIntoAnimal(String tabla,String atributos,String valores) {
        mySqlOperacion.setInstruccionSql(String.format(INSERTAR_ANIMAL,NOMBRE_BASE_DATOS,
                tabla,
                atributos,
                valores));
        mySqlOperacion.ejecutarInstruccionSqlVoid();
    }
    public static void abrirConexion() {
        mySqlOperacion.setServidor(SERVIDOR);
        mySqlOperacion.setNombreBaseDatos(NOMBRE_BASE_DATOS);
        mySqlOperacion.setUsuario(USUARIO);
        mySqlOperacion.setContrasena(CONTRASENA);
    }
    public static void closeConexion(){
        mySqlOperacion.cerrar();
    }
}