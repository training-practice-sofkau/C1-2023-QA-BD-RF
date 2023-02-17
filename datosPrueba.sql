# Datos de tabla procedimiento.
INSERT INTO  proveedor (NIT, nombre, direccion)
VALUES ( 111, "Productos SA", "CRA 2B -78"), 
	(112,"Cosmeticos SA", "cra 3b-78");

INSERT INTO   producto (REF, nombre, cantidad,precioCompra, precioVenta, NITProveedor)
VALUES ( 111, "Producto1", 5,30000, 350000, 111), 
	(112,"Cosmetico2", 5,40000, 450000, 112);

INSERT INTO   insumo (REF, nombre, cantidad,precioCompra, NITProveedor)
VALUES ( 111, "Producto3", 5,30000, 111), 
	(112,"Cosmetico4", 5,40000, 112);

INSERT INTO   cliente(id, nombre, cedula,correo, edad, direccion)
VALUES ( 1, "Rosa", 1234, "r@gmail.com", "22", "direccion1"), 
	( 2, "Ana", 1234, "p@gmail.com", "23", "direccion2");

INSERT INTO   empleado(id, cedula, nombre)
VALUES ( 11, 1244, "Diana"), 
	( 12, 12445, "July");

INSERT INTO cotizacion(id,descripcion, idCliente,idEmpleado)
VALUES (10, "descripcion1", 1, 11), 
(11, "descripcion2", 2, 12);

INSERT INTO venta (id, valorTotal, liga, fecha, idProducto, idCotizacion, cantidad)
VALUES(1, 350000, 1000, "2023-02-02", 111, 10, 1);

INSERT INTO telefonoCliente(idCliente,telefono)
VALUES(1,"3700000"),
(2,"2340000");

INSERT INTO profesioncliente(idCliente,profesion)
VALUES(1,"Medico"),
	(2,"Artista");

INSERT INTO especialidadEmpleado(idEmpleado,especialidad)
VALUES(11,"Manicure"),
	(12,"Masajista");

INSERT INTO cita(id, idCliente, fechaSolicitda, horaSolicitada)
VALUES(1,1,"2022-02-02","16:00"),
(2,2,"2022-02-02","14:00");


INSERT INTO servicio (id, idCita, descripción, fecha, duracion, precio) 
VALUES (2, 2, "descripcion2", "2022-02-02", 80, 64000);


INSERT INTO servicioEmpleado(idServicio, idEmpleado)
VALUES(1,11),
    (2,12);

INSERT INTO servicioInsumo (idServicio, REFinsumo)
VALUES (1,111), (2,112);

