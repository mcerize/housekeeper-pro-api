CREATE TABLE perfil (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO perfil (nome) values ('Administrador');
INSERT INTO perfil (nome) values ('Cliente');
INSERT INTO perfil (nome) values ('Prestador de Serviços');