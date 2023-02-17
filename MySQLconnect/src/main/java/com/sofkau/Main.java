package com.sofkau;

import com.sofkau.integration.mysql.MySqlOperation;

import java.sql.SQLException;

public class Main {

    private static final String SERVER="localhost";
    private static final String DATA_BASE_NAME="barberia";
    private static final String USER="root";
    private static final String PASSWORD="123456";
    private static final String SELECT_ALL_FROM_EMPLEADOS="select * from empleado; ";
    private static final MySqlOperation mySqlOperation=new MySqlOperation();
    public static void main(String[] args) throws SQLException{
        openConnection();
        closeConnection();
        insertRegistro();
        setSelectAllFromEmpleados();

    }

    public static void openConnection(){
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);

    }

    public static void setSelectAllFromEmpleados()throws SQLException{
        mySqlOperation.setSqlStatement(SELECT_ALL_FROM_EMPLEADOS);
        mySqlOperation.executeSqlStatement();
        mySqlOperation.printResultSet();
    }

    public static void insertRegistro(){
        //DATOS CLIENTE
        int id_cliente=005;
        String cc_cliente="1115789456";
        String nombre_cliente="Pablo Emilio";
        String profesion="Jugador";
        String correo="@.com";
        String edad="37";
        String direccion="calle falsa 123";

        //DATOS CONTACTO_CLIENTE
        String telefono_cliente="315687954";

        //DATOS PROVEEDOR
        int id_proveedor=104;
        String nombre_proveedor="Proveedor";
        String proveedor_direccion="Calle falsa 123456";

        //DATOS CONTACTO_PROVEEDOR
        String telefono_proveedor="315645987";

        //DATOS EMPLEADO
        int id_empleado=1005;
        String cc_empleado="1116987132";
        String nombre_empleado="Nombre";
        double liga=2000;

        //DATOS ESPECIALIDAD
        String especialidad="cabello";

        //DATOS PRODUCTO
        int id_producto = 2006;
        String nombre_producto="Gel ego";
        String descripcion="descripcion";
        String cantidad="100";
        String precio="2000";

        //DATOS CITA
        int id_cita=3007;
        String hora_cita="10:00";
        String fecha_cita="10:00";

        //DATOS SERVICIO
        int id_servicio = 4004;
        String fecha_servicio = "01/01/95";
        String servicio_descripcion = "descripcion";
        String servicio_precio = "20000";
        String servicio_duracion = "60";

        //DATOS PRODUCTO_SERVICIO


        //DATOS EMPLEADO_VENDE


        //DATOS COMPRA
        String cantidad_producto="5";
        String total="10000";
        String compra_fecha="01/01/21";

        //DATOS PRODUCTO_PROVEEDOR


        for(int i=0;i<50;i++){
            //Tabla cliente
            mySqlOperation.setSqlStatement("insert into cliente values('"+String.valueOf(id_cliente)+"','"+cc_cliente+"','"+nombre_cliente+"','"+profesion+"','"
                    +correo+"','"+edad+"','"+direccion+"')");
            mySqlOperation.executeSqlStatementVoid();
            //Tabla contacto_cliente
            mySqlOperation.setSqlStatement("insert into contacto_cliente values('"+String.valueOf(id_cliente)+"','"+telefono_cliente+"')");
            mySqlOperation.executeSqlStatementVoid();
            //Tabla proveedor
            mySqlOperation.setSqlStatement("insert into proveedor values('"+String.valueOf(id_proveedor)+"','"+nombre_proveedor+"','"+proveedor_direccion+"')");
            mySqlOperation.executeSqlStatementVoid();
            //Tabla contacto_proveedor
            mySqlOperation.setSqlStatement("insert into contacto_proveedor values('"+String.valueOf(id_proveedor)+"','"+telefono_proveedor+"')");
            mySqlOperation.executeSqlStatementVoid();
            //TABLA EMPLEADO
            mySqlOperation.setSqlStatement("insert into empleado values('"+String.valueOf(id_empleado)+"','"+cc_empleado+"','"+nombre_empleado+"','"+liga+"')");
            mySqlOperation.executeSqlStatementVoid();
            //TABLA ESPECIALIDAD
            mySqlOperation.setSqlStatement("insert into especialidad values('"+String.valueOf(id_empleado)+"','"+especialidad+"')");
            mySqlOperation.executeSqlStatementVoid();
            //TABLA PRODUCTO
            mySqlOperation.setSqlStatement("insert into producto values('"+String.valueOf(id_producto)+"','"+nombre_producto+"','"+descripcion+"','"+cantidad+"','"
                    +precio+"')");
            mySqlOperation.executeSqlStatementVoid();
            //TABLA CITA
            mySqlOperation.setSqlStatement("insert into cita values('"+String.valueOf(id_cita)+"','"+hora_cita+"','"+fecha_cita+"','"+String.valueOf(id_cliente)+"','"
                    +String.valueOf(id_proveedor)+"')");
            mySqlOperation.executeSqlStatementVoid();
            //TABLA SERVICIO
            mySqlOperation.setSqlStatement("insert into servicio values('"+String.valueOf(id_servicio)+"','"+fecha_servicio+"','"+servicio_descripcion+"','"+servicio_precio+"','"
                    +String.valueOf(id_cita)+"','"+servicio_duracion+"')");
            mySqlOperation.executeSqlStatementVoid();
            //TABLA PRODUCTO_SERVICIO
            mySqlOperation.setSqlStatement("insert into producto_servicio values('"+String.valueOf(id_producto)+"','"+String.valueOf(id_servicio)+"')");
            mySqlOperation.executeSqlStatementVoid();
            //TABLA EMPLEADO_VENDE
            mySqlOperation.setSqlStatement("insert into empleado_vende values('"+String.valueOf(id_empleado)+"','"+String.valueOf(id_producto)+"')");
            mySqlOperation.executeSqlStatementVoid();
            //TABLA COMPRA
            mySqlOperation.setSqlStatement("insert into compra values('"+String.valueOf(id_producto)+"','"+String.valueOf(id_cliente)+"','"+cantidad_producto+"','"+total+"','"
                    +compra_fecha+"')");
            mySqlOperation.executeSqlStatementVoid();
            //TABLA PRODUCTO_PROVEEDOR
            mySqlOperation.setSqlStatement("insert into producto_proveedor values('"+String.valueOf(id_proveedor)+"','"+String.valueOf(id_producto)+"')");
            mySqlOperation.executeSqlStatementVoid();
            id_cliente=id_cliente+1;
            id_proveedor=id_proveedor+1;
            id_empleado=id_empleado+1;
            id_producto=id_producto+1;
            id_cita=id_cita+1;
            id_servicio=id_servicio+1;
        }
    }

    public static void closeConnection(){
        mySqlOperation.close();
    }
}