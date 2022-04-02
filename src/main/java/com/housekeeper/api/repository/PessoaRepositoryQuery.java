package com.housekeeper.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.housekeeper.api.model.Pessoa;

public interface PessoaRepositoryQuery {

	public Page<Pessoa> filtrar(Pageable pageable);

}
