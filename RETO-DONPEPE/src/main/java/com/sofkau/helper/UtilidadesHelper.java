package com.sofkau.helper;

public class UtilidadesHelper {

    public static String guardarProducto() {
        return "INSERT INTO `producto`( `NOMBRE`, `MARCA`, `ORIGEN`, `VOLUMEN`,`PRECIO`, `PESO`,`FOTO`,`ID_PROVEEDOR`,`ID_CATEGORIA`) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        public static String guardarCliente(){
            return "INSERT INTO `CLIENTE`(`CEDULA`,`NOMBRE`,`DIRECCION`,`TELEFONO`,`CORREO`,`CONTRASENA`,`CODIGO_POSTAL`)VALUES(?,?,?,?,?,?,?)";
        }
        public static String guardarZona(){
            return "INSERT INTO `ZONA`( `NOMBRE`, `barrio`) VALUES (?,?)";
        }
        public static String guardarDomiciliario(){
            return "INSERT INTO `DOMICILIARIO`( `NOMBRE`, `MATRICULA_FURGONETA`, `CODIGO_POSTAL`) VALUES (?,?,?)";
        }
        public static String guardarCategoria(){
            return "INSERT INTO `CATEGORIA`( `NOMBRE`, `OBSERVACIONES`, `CONDICIONES_ALMACENAMIENTO`) VALUES (?,?,?)";
        }
        public static String guardarPedido(){
            return "INSERT INTO `PEDIDO`( `FECHA_CADUCIDAD`, `NUMERO_TARJETA`, `FECHA_PEDIDO`, `DIRECCION_ENTREGA`,`IMPORTE_TOTAL_PEDIDO`, `ID_CLIENTE`,`ID_DOMICILIARIO`) VALUES (?,?,?,?,?,?,?)";
        }
        public static String guardarDetalle(){
            return "INSERT INTO `DETALLE_PEDIDO`(`ID_PRODUCTO`,`ID_PEDIDO`) VALUES(?,?)";
        }
    public static String guardarProveedor(){
        return "INSERT INTO `PROVEEDOR`(`NIT`,`NOMBRE`,`TELEFONO`) VALUES(?,?,?)";
    }
}
