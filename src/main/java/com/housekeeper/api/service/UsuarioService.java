package com.housekeeper.api.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.housekeeper.api.model.Usuario;
import com.housekeeper.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario atualizar(Long id, @Valid Usuario usuario) {
		Usuario usuarioSalvo = buscarUsuarioPeloId(id);
		BeanUtils.copyProperties(usuario, usuarioSalvo, "id");
		return usuarioRepository.save(usuarioSalvo);
	}

	private Usuario buscarUsuarioPeloId(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

}
