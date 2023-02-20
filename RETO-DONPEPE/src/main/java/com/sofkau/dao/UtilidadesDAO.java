package com.sofkau.dao;

import com.sofkau.models.*;
import com.sofkau.helper.UtilidadesHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UtilidadesDAO {
    public boolean guardarClientesDAO(Connection con, List<Cliente> listClientes) {

        boolean resultado = true;

        Cliente objCliente;

        try {
            PreparedStatement p = con.prepareStatement(UtilidadesHelper.guardarCliente());



            for (Cliente cliente : listClientes) {
                objCliente = cliente;
                p.setString(1,objCliente.getCedula());
                p.setString(2,objCliente.getNombre());
                p.setString(3,objCliente.getDireccion());
                p.setString(4,objCliente.getTelefono() );
                p.setString(5, objCliente.getCorreo());
                p.setString(6,objCliente.getContrasena());
                p.setInt(7,objCliente.getCodigo_postal());
                p.execute();
                objCliente = null;
            }

            System.out.println("se guardaron los datos");

        } catch (Exception ex) {
            ex.printStackTrace();
            resultado = false;
        } finally {
            try {
                con.close();
            } catch (Exception clo) {
                clo.printStackTrace();
            }
        }
        return resultado;

   }
    public boolean guardarZonaDAO(Connection con, List<Zona> listZonas) {

        boolean resultado = true;

        Zona objZona;

        try {
            PreparedStatement p = con.prepareStatement(UtilidadesHelper.guardarZona());



            for (Zona zona : listZonas) {
                objZona = zona;

                p.setString(1,objZona.getNombre());
                p.setString(2,objZona.getBarrio());

                p.execute();
                objZona = null;
            }

            System.out.println("se guardaron los datos");

        } catch (Exception ex) {
            ex.printStackTrace();
            resultado = false;
        } finally {
            try {
                con.close();
            } catch (Exception clo) {
                clo.printStackTrace();
            }
        }
        return resultado;

    }
    public boolean guardarProductosDAO(Connection con, List<Producto> listProductos) {

        boolean resultado = true;

        Producto objProducto;

        try {
            PreparedStatement p = con.prepareStatement(UtilidadesHelper.guardarProducto());



            for (Producto producto : listProductos) {
                objProducto = producto;
                p.setString(1, objProducto.getNombre());
                p.setString(2, objProducto.getMarca());
                p.setString(3, objProducto.getOrigen());
                p.setString(4, objProducto.getVolumen());
                p.setDouble(5, objProducto.getPrecio());
                p.setString(6, objProducto.getPeso());
                p.setString(7, objProducto.getFoto());
                p.setString(8, objProducto.getIdProvedor());
                p.setInt(9, objProducto.getIdCategoria());
                p.execute();
                objProducto = null;
            }

            System.out.println("se guardaron los datos");

        } catch (Exception ex) {
            ex.printStackTrace();
            resultado = false;
        } finally {
            try {
                con.close();
            } catch (Exception clo) {
                clo.printStackTrace();
            }
        }
        return resultado;

    }

    public boolean guardarPedidosDAO(Connection con, List<Pedido> listPedidos) {

        boolean resultado = true;

        Pedido objPedido;

        try {
            PreparedStatement p = con.prepareStatement(UtilidadesHelper.guardarPedido());



            for (Pedido pedidos : listPedidos) {
                objPedido = pedidos;
                p.setString(1, objPedido.getFecha_caducidad());
                p.setString(2, objPedido.getNumero_tarjeta());
                p.setString(3, objPedido.getFecha_pedido());
                p.setString(4, objPedido.getDireccion_entrega());
                p.setString(5, objPedido.getImporte_total_pedido());
                p.setInt(6, objPedido.getId_cliente());
                p.setInt(7, objPedido.getId_domiciliario());

                p.execute();
                objPedido = null;
            }

            System.out.println("se guardaron los datos");

        } catch (Exception ex) {
            ex.printStackTrace();
            resultado = false;
        } finally {
            try {
                con.close();
            } catch (Exception clo) {
                clo.printStackTrace();
            }
        }
        return resultado;

   }

    public boolean guardarDomiciliarioDAO(Connection con, List<Domiciliario> listDomiciliarios) {

        boolean resultado = true;

        Domiciliario objDomiciliario;

        try {
            PreparedStatement p = con.prepareStatement(UtilidadesHelper.guardarDomiciliario());



            for (Domiciliario domiciliario : listDomiciliarios) {
                objDomiciliario = domiciliario;
                p.setString(1, objDomiciliario.getNombre());
                p.setString(2, objDomiciliario.getMatricula_furgoneta());
                p.setInt(3, objDomiciliario.getCodigo_postal());


                p.execute();
                objDomiciliario = null;
            }

            System.out.println("se guardaron los datos");

        } catch (Exception ex) {
            ex.printStackTrace();
            resultado = false;
        } finally {
            try {
                con.close();
            } catch (Exception clo) {
                clo.printStackTrace();
            }
        }
        return resultado;

   }

    public boolean guardarProveedorDAO(Connection con, List<Proveedor> listProveedores) {

        boolean resultado = true;

        Proveedor objProveedor;

        try {
            PreparedStatement p = con.prepareStatement(UtilidadesHelper.guardarProveedor());



            for (Proveedor proveedor : listProveedores) {
                objProveedor = proveedor;
                p.setString(1, objProveedor.getNIT());
                p.setString(2, objProveedor.getNombre());
                p.setString(3, objProveedor.getTelefono());


                p.execute();
                objProveedor = null;
            }

            System.out.println("se guardaron los datos");

        } catch (Exception ex) {
            ex.printStackTrace();
            resultado = false;
        } finally {
            try {
                con.close();
            } catch (Exception clo) {
                clo.printStackTrace();
            }
        }
        return resultado;

   }

    public boolean guardarCategoriaDAO(Connection con, List<Categoria> listCategorias) {

        boolean resultado = true;

        Categoria objCategoria;

        try {
            PreparedStatement p = con.prepareStatement(UtilidadesHelper.guardarCategoria());



            for (Categoria categoria : listCategorias) {
                objCategoria = categoria;
                p.setString(1, objCategoria.getNombre());
                p.setString(2, objCategoria.getObservaciones());
                p.setString(3, objCategoria.getCondiciones_almacenamiento());


                p.execute();
                objCategoria = null;
            }

            System.out.println("se guardaron los datos");

        } catch (Exception ex) {
            ex.printStackTrace();
            resultado = false;
        } finally {
            try {
                con.close();
            } catch (Exception clo) {
                clo.printStackTrace();
            }
        }
        return resultado;

    }

    public boolean guardarDetalleDAO(Connection con, List<Datalle_Pedido> listDetalle) {

        boolean resultado = true;

        Datalle_Pedido objDetalle;

        try {
            PreparedStatement p = con.prepareStatement(UtilidadesHelper.guardarDetalle());



            for (Datalle_Pedido detalle : listDetalle) {
                objDetalle = detalle;
                p.setInt(1, objDetalle.getIdProducto());
                p.setInt(2, objDetalle.getIdPedido());


                p.execute();
                objDetalle = null;
            }

            System.out.println("se guardaron los datos");

        } catch (Exception ex) {
            ex.printStackTrace();
            resultado = false;
        } finally {
            try {
                con.close();
            } catch (Exception clo) {
                clo.printStackTrace();
            }
        }
        return resultado;

    }
}
