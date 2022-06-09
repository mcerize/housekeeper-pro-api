CREATE TABLE usuario_tipo_servico (
	id_usuario BIGINT(20) NOT NULL,
	id_tipo_servico BIGINT(20) NOT NULL,
	PRIMARY KEY (id_usuario, id_tipo_servico),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id),
	FOREIGN KEY (id_tipo_servico) REFERENCES tipo_servico(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO usuario_tipo_servico (id_usuario, id_tipo_servico) values (2, 1);
INSERT INTO usuario_tipo_servico (id_usuario, id_tipo_servico) values (1, 3);