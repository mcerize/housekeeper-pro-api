package com.housekeeper.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.housekeeper.api.model.Pessoa;
import com.housekeeper.api.repository.PessoaRepository;

@Service
public class PessoaService {
 	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPeloId(id);
		
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return pessoaRepository.save(pessoaSalva);
	}   

	
	public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloId(id);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}

	public Pessoa buscarPessoaPeloId(Long id) {
		Pessoa pessoaSalva =  pessoaRepository.findById(id)
								.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return pessoaSalva;
	}
}
