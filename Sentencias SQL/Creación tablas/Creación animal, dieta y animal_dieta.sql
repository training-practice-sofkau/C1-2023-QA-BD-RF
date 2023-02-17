create table dieta(
	idDieta int auto_increment primary key,
    idEmpleado_veterinario int,
    foreign key(idEmpleado_veterinario) references veterinario(idEmpleado)
);

create table animal(
	idAnimal int auto_increment primary key,
    nombre varchar(60),
    peso float,
    clasificacion varchar(50)
);

create table animal_dieta(
	idAnimal_dieta int,
    idDieta_animal int,
    primary key(idAnimal_dieta,idDieta_animal),
    foreign key(idAnimal_dieta) references animal(idAnimal),
    foreign key(idDieta_animal) references dieta(idDieta)
);