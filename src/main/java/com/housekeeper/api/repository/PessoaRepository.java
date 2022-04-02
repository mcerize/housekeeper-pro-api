package com.housekeeper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.housekeeper.api.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long>, PessoaRepositoryQuery {
	
    
}
