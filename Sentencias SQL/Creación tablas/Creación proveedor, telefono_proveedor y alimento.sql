create table proveedor(
	idProveedor int auto_increment primary key,
    nombre varchar(60)
);

create table telefono_proveedor(
	idProveedor_telefono int,
    telefono_proveedor varchar(15),
    primary key(idProveedor_telefono,telefono_proveedor),
    foreign key(idProveedor_telefono) references proveedor(idProveedor)
);

create table alimento(
	idAlimento int auto_increment primary key,
    dosis varchar(30),
    tipo varchar(30),
    nombre varchar(60),
    idProveedor_alimento int,
    foreign key(idProveedor_alimento) references proveedor(idProveedor)
);