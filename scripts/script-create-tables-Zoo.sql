-- ---------------------------------
-- Se crea la tabla Veterinario
-- ---------------------------------

create table zoologico.veterinario (
	id varchar(15) not null,
    nombre varchar(45) not null,
    correo varchar(45) not null,
    telefono varchar(15) not null,
    primary key (id));
    
-- -------------------------------------
-- Se crea la tabla Dieta
-- -------------------------------------

create table zoologico.dieta (
	id varchar(10) not null,
    nombre varchar(45) not null,
    dosis varchar(45) not null,
    veterinario_id varchar(15) not null,
    primary key (id),
    foreign key (veterinario_id) references zoologico.veterinario (id));
    
-- ---------------------------------------
-- Se crea la tabla Animal
-- ---------------------------------------

create table zoologico.animal (
	id varchar(10) not null,
    especie varchar(45) not null,
    dieta_id varchar(10) not null,
    primary key (id),
    foreign key (dieta_id) references zoologico.dieta (id));
    
-- -------------------------------------
-- Se crea la tabla Entrenador
-- ------------------------------------

create table zoologico.entrenador (
	id varchar(15) not null,
    nombre varchar(45) not null,
    correo varchar(45) not null,
    telefono varchar(15) not null,
    primary key (id));
    
-- --------------------------------------
-- Se crea la tabla Reporte
-- -------------------------------------

create table zoologico.reporte (
	id varchar(10) not null,
    peso_animal varchar(5) not null,
    fecha varchar(45) not null,
    animal_id varchar(10) not null,
    entrenador_id varchar(15) not null,
    primary key (id),
    foreign key (animal_id) references zoologico.animal (id),
    foreign key (entrenador_id) references zoologico.entrenador (id));
    
-- ---------------------------------------
-- Se crea la tabla Alimento
-- ---------------------------------------

create table zoologico.alimento (
	id varchar(10) not null,
    nombre varchar(45) not null,
    tipo varchar(45) not null,
    cantidad varchar(6) not null,
    primary key (id));
    
-- ---------------------------------------
-- Se crea la tabla Empleado_logistico
-- --------------------------------------

create table zoologico.empleado_logistico (
	id varchar(15) not null,
    nombre varchar(45) not null,
    correo varchar(45) not null,
    telefono varchar(15) not null,
    primary key (id));
    
-- ------------------------------------------
-- Se crea la tabla Proveedor
-- ------------------------------------------

create table zoologico.proveedor (
	id varchar(10) not null,
    nombre varchar(45) not null,
    direccion varchar(45) not null,
    telefono varchar(15) not null,
    correo varchar(45) not null,
    primary key (id));
    
-- ----------------------------------------
-- Se crea la tabla Orden_compra
-- ----------------------------------------

create table zoologico.orden_compra (
	id varchar(10) not null,
    fecha varchar(45) not null,
    unidades varchar(5) not null,
    proveedor_id varchar(10) not null,
    empleado_logistico_id varchar(15) not null,
    primary key (id),
    foreign key (proveedor_id) references zoologico.proveedor (id),
    foreign key (empleado_logistico_id)
    references zoologico.empleado_logistico (id));
    
-- ---------------------------------------
-- Se crea la tabla Factura
-- ----------------------------------------

create table zoologico.factura (
	id varchar(10) not null,
    fecha varchar(45) not null,
    unidades varchar(5) not null,
    total varchar(10) not null,
    id_proveedor varchar(10) not null,
    id_empleado_logistico varchar(15) not null,
    primary key (id),
    foreign key (id_proveedor) references zoologico.proveedor (id),
    foreign key (id_empleado_logistico)
    references zoologico.empleado_logistico (id));
    
-- -------------------------------------------------
-- Se crea la tabla Veterinario_reporte
-- --------------------------------------------------

create table zoologico.veterinario_reporte (
	veterinario_id varchar(15) not null,
    reporte_id varchar(10) not null,
    primary key (veterinario_id, reporte_id),
    foreign key (veterinario_id) references zoologico.veterinario (id),
    foreign key (reporte_id) references zoologico.reporte (id));
    
-- -------------------------------------
-- Se crea la tabla Alimento_dieta
-- -----------------------------------

create table zoologico.alimento_dieta (
	alimento_id varchar(10) not null,
    dieta_id varchar(10) not null,
    primary key (alimento_id, dieta_id),
    foreign key (dieta_id) references zoologico.dieta (id),
    foreign key (alimento_id) references zoologico.alimento (id));
-- ---------------------------------------------
-- Se crea la tabla Orden_alimento
-- ---------------------------------------------

create table zoologico.orden_alimento (
	orden_compra_id varchar(10) not null,
    alimento_id varchar(10) not null,
    primary key (orden_compra_id, alimento_id),
    foreign key (orden_compra_id)
    references zoologico.orden_compra (id),
    foreign key (alimento_id)
    references zoologico.alimento (id));
    
