

-- Creación de base de datos Tienda Don Pepe, se crean tablas con llave primaria y foranea 

CREATE DATABASE tienda_don_pepe;

USE tienda_don_pepe;


  -- Creación tabla proveedor
  CREATE TABLE Proveedor(
  id_proveedor INT NOT NULL,
  nombre_proveedor VARCHAR(45) NULL,
  direccion VARCHAR(45) NULL,
  telefono VARCHAR(45) NULL,
  PRIMARY KEY (id_proveedor)

  );
  
   -- Creación tabla Categoria
   
   CREATE TABLE Categoria (
  id_categoria VARCHAR(15) NOT NULL,
  nombre_categoria VARCHAR(45) NULL,
  almacenamiento VARCHAR(15) NULL,
  observaciones VARCHAR(60) NULL,
  PRIMARY KEY (id_categoria)
  );
  

-- Creación tabla producto
CREATE TABLE Producto (
  id_producto VARCHAR(15) NOT NULL,
  nombre_producto VARCHAR(45) NULL,
  origen VARCHAR(45) NULL,
  marca VARCHAR(45) NULL,
  peso  DOUBLE NULL,
  stock INT NULL,
  precio DOUBLE NULL,
  id_proveedor INT NOT NULL,
  id_categoria VARCHAR(15) NOT NULL,
  PRIMARY KEY (id_producto, id_proveedor, id_categoria),
  FOREIGN KEY (id_proveedor)  REFERENCES Proveedor (id_proveedor),
  FOREIGN KEY (id_categoria)  REFERENCES Categoria (id_categoria)
  );

 
    -- Creación tabla zona postal
  
  CREATE TABLE Zona_postal (
  id_zona_postal VARCHAR(15) NOT NULL,
  zona VARCHAR(45) NULL,
  codigo_postal VARCHAR(45) NULL,
  PRIMARY KEY (id_zona_postal)

  );
  
   
   -- Creación tabla tipo de pago
   CREATE TABLE Tipo_de_pago (
	id_tipo_de_pago VARCHAR(15) NOT NULL,
	numero_tarjeta VARCHAR(45) NULL,
	fecha_caducidad VARCHAR(45) NULL,
     PRIMARY KEY (id_tipo_de_pago)

   
   );
   
-- Creación tabla estado de pedido
  
  CREATE TABLE Estado_pedido (
  
    id_estado_pedido INT NOT NULL,
    estado VARCHAR(45) NULL,
    dscripcion VARCHAR(60) NULL,
    PRIMARY KEY (id_estado_pedido)

  );
     -- Creación tabla Pedido
  
  CREATE TABLE Pedido(
   id_pedido VARCHAR(15) NOT NULL,
   codigo_pedido VARCHAR(30) NULL,
   fecha_pedido DATE NULL,
   total_compra VARCHAR(45) NULL,
   id_cliente VARCHAR(15) NOT NULL,
   id_estado_pedido INT NOT NULL,
   id_tipo_de_pago VARCHAR(15) NOT NULL,
  PRIMARY KEY (id_pedido),
  FOREIGN KEY (id_cliente) REFERENCES Cliente (id_cliente),
  FOREIGN KEY(id_estado_pedido) REFERENCES Estado_pedido (id_estado_pedido),
  FOREIGN KEY(id_tipo_de_pago) REFERENCES Tipo_de_pago (id_tipo_de_pago)
  );


      -- Creación tabla orden entrega
    CREATE TABLE Orden_entrega (
	id_orden_entrega VARCHAR(15) NOT NULL,
	numero VARCHAR(45) NULL,
	fecha_entrega VARCHAR(45) NULL,
	direccion_entrega VARCHAR(45) NULL,
	id_domiciliario VARCHAR(15) NOT NULL,
	id_pedido VARCHAR(15) NOT NULL,
	PRIMARY KEY (id_orden_entrega, id_domiciliario),
    FOREIGN KEY (id_domiciliario) REFERENCES Domiciliario (id_domiciliario),
    FOREIGN KEY (id_pedido) REFERENCES Pedido (id_pedido)

    );
    

  -- Creación tabla cliente
  
  CREATE TABLE Cliente (
   id_cliente VARCHAR(15) NOT NULL,
   nombre_cliente VARCHAR(45) NULL,
   cedula VARCHAR(20) NULL,
   email VARCHAR(20) NULL,
   password VARCHAR(45) NULL,
   telefono VARCHAR(45) NULL,
   id_zona_postal VARCHAR(15) NOT NULL,
   PRIMARY KEY (id_cliente),
   FOREIGN KEY (id_zona_postal) REFERENCES Zona_postal (id_zona_postal)
  
);
 -- Creación tabla direccion cliente
    
    CREATE TABLE direccion_cliente (
	id_direccion_cliente INT NOT NULL,
	calle VARCHAR(45) NULL,
	numero VARCHAR(45) NULL,
	barrio VARCHAR(45) NULL,
	id_cliente VARCHAR(15) NOT NULL,
	PRIMARY KEY (id_direccion_cliente, id_cliente),
    FOREIGN KEY (id_cliente) REFERENCES Cliente (id_cliente)
    
    );
-- Creación tabla domiciliario

CREATE TABLE Domiciliario (
   id_domiciliario VARCHAR(15) NOT NULL,
   nombre_domiciliario VARCHAR(45) NULL,
   matricula_vehiculo VARCHAR(45) NULL,
   zona_reparto VARCHAR(45) NULL,
   id_zona_postal VARCHAR(15) NOT NULL,
   PRIMARY KEY (id_domiciliario, id_zona_postal),
   FOREIGN KEY (id_zona_postal) REFERENCES Zona_postal (id_zona_postal)

);

-- Creación tabla telefono proveedor

CREATE TABLE telefono_proveeedor (
   id_proveedor INT NOT NULL,
   telefono VARCHAR(20) NOT NULL,
   PRIMARY KEY (id_proveedor),
   FOREIGN KEY(id_proveedor) REFERENCES Proveedor (id_proveedor)


);


-- Creación tabla direccion cliente
CREATE TABLE telefono_cliente ( 
   id_cliente VARCHAR(15) NOT NULL,
   telefono VARCHAR(20) NOT NULL,
   PRIMARY KEY (id_cliente),
   FOREIGN KEY (id_cliente) REFERENCES Cliente (id_cliente)
   

);

-- Creación tabla detalles de pedido

CREATE TABLE Detalles_pedido (
   id_detalles_pedido INT NOT NULL,
   cantidad INT NULL,
   precio DOUBLE NULL,
   id_producto VARCHAR(15) NOT NULL,
   id_pedido VARCHAR(15) NOT NULL,
   PRIMARY KEY (id_detalles_pedido),
   FOREIGN KEY (id_producto) REFERENCES Producto (id_producto),
   FOREIGN KEY (id_pedido) REFERENCES Producto (id_producto),
   FOREIGN KEY (id_categoria) REFERENCES Producto (id_categoria)
   
);



-- Creación tabla direccion cliente

CREATE TABLE direccion_cliente (
  id_direccion_cliente INT NOT NULL,
  calle VARCHAR(45) NULL,
  numero VARCHAR(45) NULL,
  barrio VARCHAR(45) NULL,
  id_cliente VARCHAR(15) NOT NULL,
  PRIMARY KEY (id_direccion_cliente),
  FOREIGN KEY (id_direccion_cliente) REFERENCES Cliente (id_cliente)

);


-- Creación tabla fotos producto
 
CREATE TABLE  fotos_producto (
  id_fotos_producto INT NOT NULL,
  imagen VARCHAR(100) NULL,
   id_producto VARCHAR(15) NOT NULL,
  id_proveedor INT NOT NULL,
  id_categoria VARCHAR(15) NOT NULL,
  PRIMARY KEY (id_fotos_producto),
  FOREIGN KEY (id_producto , id_proveedor , id_categoria)
    REFERENCES Producto (id_producto , id_proveedor , id_categoria)
  );
 





