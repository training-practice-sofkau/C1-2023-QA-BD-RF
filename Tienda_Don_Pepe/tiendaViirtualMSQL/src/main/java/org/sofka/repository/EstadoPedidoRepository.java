package org.sofka.repository;

import org.sofka.integration.database.mysql.MySqlOperation;
import org.sofka.model.EstadoPedido;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoPedidoRepository implements Table {

    private MySqlOperation mySqlOperation;

    public EstadoPedidoRepository() throws SQLException {
    }


    @Override
    public void generateData() throws SQLException {
        mySqlOperation = new MySqlOperation();
        mySqlOperation.configureDatabaseconetion();


        List<EstadoPedido> estadoPedidos = new ArrayList<EstadoPedido>();
        estadoPedidos.add(new EstadoPedido(800, "Estado 800", "verificando productos"));
        estadoPedidos.add(new EstadoPedido(801, "Estado 801", "pedido empacado"));
        estadoPedidos.add(new EstadoPedido(802, "Estado 802", "facturado"));
        estadoPedidos.add(new EstadoPedido(804, "Estado 804", "no facturo"));
        estadoPedidos.add(new EstadoPedido(805, "Estado 805", "modificar pedido"));
        String sql = "";

        for (EstadoPedido ep : estadoPedidos) {
            sql = String.format("INSERT INTO ESTADO_PEDIDO VALUES(%s,'%s','%s');",
                    ep.getId(),
                    ep.getEstado(),
                    ep.getDescripcion());


            this.mySqlOperation.myExecuteInsertUpdate(sql);

        }
    }
}