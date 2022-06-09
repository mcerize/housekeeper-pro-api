CREATE TABLE pessoa (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	id_endereco BIGINT(20) NOT NULL,
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, id_endereco, ativo) values ('João Silva', 1, true);
INSERT INTO pessoa (nome, id_endereco, ativo) values ('Maria Rita', 2, true);
INSERT INTO pessoa (nome, id_endereco, ativo) values ('Pedro Santos', 3, true);
INSERT INTO pessoa (nome, id_endereco, ativo) values ('Ricardo Pereira', 4, true);
INSERT INTO pessoa (nome, id_endereco, ativo) values ('Josué Mariano', 5, true);
