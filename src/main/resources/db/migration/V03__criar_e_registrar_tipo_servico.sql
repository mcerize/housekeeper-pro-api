CREATE TABLE tipo_servico (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipo_servico (nome) values ('Faxina Geral');
INSERT INTO tipo_servico (nome) values ('Passar Roupa');
INSERT INTO tipo_servico (nome) values ('Cozinhar');
INSERT INTO tipo_servico (nome) values ('Lavar Roupa');
