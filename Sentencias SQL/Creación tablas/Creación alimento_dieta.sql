create table alimento_dieta(
	idAlimento_dieta int,
    idDieta_alimento int,
    primary key(idAlimento_dieta,idDieta_alimento),
    foreign key(idAlimento_dieta) references alimento(idAlimento),
    foreign key(idDieta_alimento) references dieta(idDieta)
);