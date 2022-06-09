CREATE TABLE endereco (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	logradouro VARCHAR(50) NOT NULL,
	numero VARCHAR(50) NOT NULL,
	complemento VARCHAR(50),
	bairro VARCHAR(50),
	cep VARCHAR(50),
	cidade VARCHAR(50),
	estado VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO endereco (logradouro, numero, complemento, bairro, cep, cidade, estado) values ('rua Curió', '252', 'casa', 'Vila Celeste', '35162498', 'Ipatinga', 'MG');
INSERT INTO endereco (logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG');
INSERT INTO endereco (logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP');
INSERT INTO endereco (logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO');
INSERT INTO endereco (logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA');
