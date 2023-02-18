use tiendadonpepe;
-- -----------------------------------------------------
-- Procedimiento actualizar la tabla inventario cada vez que se agregue un producto 
-- en el carrito de compra 

DELIMITER //
create procedure actualizar_inventario(in Nom_producto varchar(60), Cantidad int )
begin
	update inventario 
    set cant_disponible = cant_disponible -  Cantidad
    where nombre_producto = Nom_producto;
end; 

call actualizar_inventario('jamon',3);

-- -----------------------------------------------------
-- Procedimiento para agregar un nuevo producto a la tienda
DELIMITER //
create procedure agregar_producto_tienda(in Nom_producto varchar(60), Marca_prod varchar(50),
Dimen_prod varchar(15), foto_prod varchar(20), precio_prod varchar(10), Id_categoria varchar(15))
begin
	insert into producto (nom_producto,marca,dimension,foto,precio,id_categorias)
    values (Nom_producto, Marca_prod,Dimen_prod,foto_prod,precio_prod,Id_categoria);
end;
call agregar_producto_tienda('Lenteja','diana','500 gr','letej.png','3200','104')

 -- -----------------------------------------------------
-- Procedimiento para modificar el precio del producto 

DELIMITER //
create procedure modificar_precio(in Nom_producto varchar(60), Precio_prod varchar(10))
begin 
	update producto set precio=Precio_prod where nom_producto= Nom_producto; 
end;

call modificar_precio('jamon','4800')

 -- -----------------------------------------------------
-- Procedimiento para agregar una nueva zona

DELIMITER // 
create procedure crear_zona(in Codigo_postal varchar(15), Nombre_postal varchar(60))
begin 
	insert into zona (cod_postal,nombre) 
    values (Codigo_postal,Nombre_postal);
end;

call crear_zona('B-06','Fusacatan')



