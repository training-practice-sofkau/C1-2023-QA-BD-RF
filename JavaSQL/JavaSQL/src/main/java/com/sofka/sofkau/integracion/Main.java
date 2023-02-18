package com.sofka.sofkau.integracion;
import com.github.javafaker.Faker;
import com.sofka.sofkau.integracion.database.mysql.MySqlOperacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Main {
    private static final String SERVIDOR="localhost";
    private static final String NOMBRE_BASE_DATOS="alimentos_parque_santafe";
    private static final String USUARIO="root";
    private static final String CONTRASENA="IVAN.dario00";
    private static final String INSERTAR_ANIMAL=("insert into %s.%s(%s) values ('%s');");
    private static final String SELECT_ALL_FROM_ANIMALES=String.format("select * from %s.animal",NOMBRE_BASE_DATOS);
    private static final MySqlOperacion mySqlOperacion= new MySqlOperacion();
    public static Random random=new Random();
    public static Faker faker=new Faker();
    public static void main(String[] args){
        int tablas=0,posicionReal=0,bandera;
        String tabla,atributos,valores;
        for(int i=0;i<50;i++){
            tabla=nombreTabla(tablas);
            System.out.println(tabla+" "+i);
            if (){
                bandera=1;
                posicionReal=i+1;
                i=random.nextInt(posicionReal+1);
            }else{
                bandera=0;
            }
            atributos=stringAtributos(tabla);
            valores=stringValores(tabla,i);
            abrirConexion();
            /*insertIntoAnimal(
                    tabla,
                    atributos,
                    valores);
             */
            closeConexion();
            if (bandera==1)
                i=posicionReal-1;
            if(i==49){
                tablas++;
                i=0;
            }if(tablas==9){
                break;
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
    public static String nombreTabla(int valor){
        switch (valor){
            default:
                return null;
        }
    }
    public static String stringAtributos(String valor){
        switch (valor){
            default: return null;
        }
    }
    public static String stringValores(String valor,int i){
        switch (valor){
            case :
            default: return null;
        }
    }
}