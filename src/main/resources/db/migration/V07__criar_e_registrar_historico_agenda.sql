CREATE TABLE historico_agenda (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	data_servico DATETIME NOT NULL,
	data_atualizacao DATETIME NOT NULL,
	id_tipo_servico BIGINT(20) NOT NULL,
	valor_servico DECIMAL(4,2),
	id_cliente BIGINT(20),
	id_prestador_servico BIGINT(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO historico_agenda (data_servico, data_atualizacao, id_tipo_servico, valor_servico, id_cliente, id_prestador_servico) values ('2022/05/09 10:00:00', '2022/05/09 11:00:00', '1', '20.52', '2', '2');
