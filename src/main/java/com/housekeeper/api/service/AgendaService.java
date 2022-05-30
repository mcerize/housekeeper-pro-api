package com.housekeeper.api.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.housekeeper.api.model.Agenda;
import com.housekeeper.api.repository.AgendaRepository;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepository agendaRepository;

	public Agenda atualizar(Long id, @Valid Agenda agenda) {
		Agenda agendaSalva = buscarAgendaPeloId(id);
		BeanUtils.copyProperties(agenda, agendaSalva, "id");
		return agendaRepository.save(agendaSalva);
	}

	private Agenda buscarAgendaPeloId(Long id) {
		return agendaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

}
