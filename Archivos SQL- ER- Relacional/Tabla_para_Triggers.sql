CREATE TABLE zoologico.auditoria(
	usuario VARCHAR (10),
    accion VARCHAR (20),
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP); 