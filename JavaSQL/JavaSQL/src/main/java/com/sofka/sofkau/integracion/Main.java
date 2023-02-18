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
            if (tabla.equals("telefono_veterinario")||
                    tabla.equals("animal_dieta")||
                    tabla.equals("telefono_proveedor")||
                    tabla.equals("alimento_dieta")||
                    tabla.equals("Dieta")||
                    tabla.equals("alimento")){
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
            case 0: return "veterinario";
            case 1: return "telefono_veterinario";
            case 2: return "dieta";
            case 3: return "proveedor";
            case 4: return "telefono_proveedor";
            case 5: return "animal";
            case 6: return "animal_dieta";
            case 7: return "alimento";
            case 8: return "alimento_dieta";
            default:
                return null;
        }
    }
    public static String stringAtributos(String valor){
        switch (valor){
            case "veterinario":
            case "proveedor":
                return "nombre";
            case "telefono_veterinario": return "idEmpleado_telefono,telefono_veterinario";
            case "dieta": return "idEmpleado_veterinario";
            case "animal": return "nombre,peso,clasificacion";
            case "animal_dieta": return "idAlimento_dieta,idDieta_alimento";
            case "telefono_proveedor": return "idProceedor_telefono,telefono_proveedor";
            case "alimento": return "dosis,tipo,nombre,idProveedor";
            case "alimento_dieta": return "idAnimal_dieta,idDieta_animal";
            default: return null;
        }
    }
    public static String stringValores(String valor,int i){
        List<String> clasificacion= List.of("mamiferos","aves","anfibios","peces","reptíles");
        List<String> tipo= List.of("humeda","seca","mixta");
        switch (valor){
            case "veterinario":
            case "proveedor":
                return faker.name().firstName()+faker.name().lastName()+" ";
            case "telefono_veterinario":
            case "telefono_proveedor":
                return i+","+faker.phoneNumber().phoneNumber();
            case "dieta": return ""+i;
            case "animal": return faker.animal().name()+","+random.nextInt(1000-50)+50+","+clasificacion.get(random.nextInt(4)+1);
            case "animal_dieta":
            case "alimento_dieta":
                return i+","+random.nextInt(49)+1;
            case "alimento": return random.nextInt(500)+1+" gr"+","+tipo.get(random.nextInt(2)+1)+","+"comida"+","+random.nextInt(49)+1;
            default: return null;
        }
    }
}