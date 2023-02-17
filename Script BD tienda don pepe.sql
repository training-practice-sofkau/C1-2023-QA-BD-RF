create database tiendaDonPepe;
use tiendaDonPepe;

create table domiciliario (
  cedula_domiciliario VARCHAR(15) primary key,
  nombre VARCHAR(100),
  num_matricula VARCHAR(10)
);

create table zona (
   cod_postal VARCHAR(15) primary key,
   nombre VARCHAR(60)
);

create table cliente(
ced_cliente VARCHAR(15) primary key,
nombre VARCHAR(100),
direccion VARCHAR(25),
correo VARCHAR(60),
contraseña VARCHAR(20),
codigo_postal VARCHAR(15),
foreign key (codigo_postal) references zona(cod_postal)
);

create table categoria(
id_categoria VARCHAR(15) primary key,
nombre VARCHAR(60),
almacenamiento VARCHAR(30),
observaciones VARCHAR(100)
);

create table producto(
nom_producto VARCHAR(60) primary key,
marca VARCHAR(50),
dimension VARCHAR(15),
foto VARCHAR(20),
precio VARCHAR(10),
id_categorias VARCHAR(15),
foreign key (id_categorias) references categoria(id_categoria)
);

create table carrito_de_compra(
id_carrito VARCHAR(15) primary key,
cantidad INT 
);

create table carrito_compra_producto(
id_carrito_compra VARCHAR(15),
nombre_producto VARCHAR(60),
primary key(id_carrito_compra,nombre_producto),
foreign key(id_carrito_compra) references carrito_de_compra(id_carrito),
foreign key(nombre_producto) references producto(nom_producto)
);
create table pedido(
codigo_pedido VARCHAR(20) primary key,
fecha DATE,
num_tarjeta VARCHAR(20),
fecha_caducidad DATE,
id_carrito_compra VARCHAR(15),
foreign key(id_carrito_compra) references carrito_de_compra(id_carrito)
);

create table proveedor(
razon_social VARCHAR(50) primary key,
telefono VARCHAR(15),
correo VARCHAR(50)
);

create table producto_proveedor(
razon_social VARCHAR(50),
nombre_prod VARCHAR(60),
primary key(razon_social,nombre_prod),
foreign key(razon_social) references proveedor(razon_social),
foreign key(nombre_prod) references producto(nom_producto)
);

create table factura(
codigo_factura VARCHAR(20) primary key,
total VARCHAR(20),
ced_domiciliario VARCHAR(20),
cedula_cliente VARCHAR(15),
cod_pedido VARCHAR(20),
foreign key(ced_domiciliario) references domiciliario(cedula_domiciliario),
foreign key(cedula_cliente) references cliente(ced_cliente),
foreign key(cod_pedido) references pedido(codigo_pedido)
);

create table inventario(
id_inventario VARCHAR(10) primary key,
cant_disponible INT,
nombre_producto VARCHAR(60),
foreign key(nombre_producto) references producto(nom_producto)
);

