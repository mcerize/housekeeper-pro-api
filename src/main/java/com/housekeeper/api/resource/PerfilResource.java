package com.housekeeper.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.housekeeper.api.model.Perfil;
import com.housekeeper.api.repository.PerfilRepository;

@RestController
@RequestMapping("/perfis")
public class PerfilResource {

	@Autowired
	private PerfilRepository perfilRepository;

	@GetMapping
	public ResponseEntity<List<Perfil>> findAllPerfis() {
		List<Perfil> perfis = perfilRepository.findAll();
		return !perfis.isEmpty() ? ResponseEntity.ok(perfis) : ResponseEntity.notFound().build();
	}

}
