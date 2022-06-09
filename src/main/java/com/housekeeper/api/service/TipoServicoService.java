package com.housekeeper.api.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.housekeeper.api.model.TipoServico;
import com.housekeeper.api.repository.TipoServicoRepository;

@Service
public class TipoServicoService {
	
	@Autowired
	private TipoServicoRepository tipoServicoRepository;

	public TipoServico atualizar(Long id, @Valid TipoServico tipoServico) {
		TipoServico tipoServicoSalvo = buscarTipoServicoPeloId(id);
		BeanUtils.copyProperties(tipoServico, tipoServicoSalvo, "id");
		return tipoServicoRepository.save(tipoServicoSalvo);
	}

	private TipoServico buscarTipoServicoPeloId(Long id) {
		return tipoServicoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

}
