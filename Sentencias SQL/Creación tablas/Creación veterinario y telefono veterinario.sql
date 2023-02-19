create table veterinario(
	idEmpleado int auto_increment primary key,
    nombre varchar(60)
);

create table telefono_veterinario(
	idEmpleado_telefono int,
    telefono_veterinario varchar(15),
    primary key (idEmpleado_telefono,telefono_veterinario),
    foreign key(idEmpleado_telefono) references veterinario(idEmpleado)
);
