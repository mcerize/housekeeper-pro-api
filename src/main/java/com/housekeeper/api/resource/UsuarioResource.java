package com.housekeeper.api.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.housekeeper.api.dto.TipoServicoDto;
import com.housekeeper.api.dto.UsuarioDto;
import com.housekeeper.api.model.Usuario;
import com.housekeeper.api.repository.UsuarioRepository;
import com.housekeeper.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;


	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

	@GetMapping
	public ResponseEntity<List<UsuarioDto>> buscarTodos() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return !usuarios.isEmpty() ? ResponseEntity.ok(preencherUsuariosDto(usuarios))
				: ResponseEntity.notFound().build();
	}

	private List<UsuarioDto> preencherUsuariosDto(List<Usuario> usuarios) {
		List<UsuarioDto> usuariosDto = new ArrayList<>();
		usuarios.forEach(usuario -> {
			UsuarioDto usuarioDto = toUsuarioDto(usuario);
			usuariosDto.add(usuarioDto);
		});
		return usuariosDto;
	}

	@GetMapping("/{nome}/{cpf}")
	public ResponseEntity<List<UsuarioDto>> buscarPorCamposPreenchidos(@PathVariable String nome,
			@PathVariable String cpf) {
		List<Usuario> usuarios = new ArrayList<>();
		if (nome.equals("undefined")) {
			nome = null;
		}
		if (cpf.equals("undefined")) {
			cpf = null;
		} else if(StringUtils.isNotBlank(cpf)) {
			cpf = cpf.replace(".", "");
			cpf = cpf.replace("-", "");
			
		}
		if ((!StringUtils.isNotBlank(nome) && !StringUtils.isNotBlank(cpf))) {
			usuarios = usuarioRepository.findAll();
		} else {
			usuarios = usuarioRepository.findByExample(nome, cpf);
		}
		return !usuarios.isEmpty() ? ResponseEntity.ok(preencherUsuariosDto(usuarios))
				: ResponseEntity.notFound().build();
	}

	@PostMapping("/usuario-logado")
	public ResponseEntity<UsuarioDto> buscarPorEmailSenha(@RequestBody UsuarioDto usuarioDto) {
		Optional<Usuario> usuario = usuarioRepository.findByEmailSenha(usuarioDto.getEmail(), usuarioDto.getSenha());
		return usuario.isPresent() ? ResponseEntity.ok(toUsuarioDto(usuario.get())) : ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> buscarPeloId(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		UsuarioDto usuarioDto = toUsuarioDto(usuario.get());
		return usuario.isPresent() ? ResponseEntity.ok(usuarioDto) : ResponseEntity.notFound().build();
	}

	private UsuarioDto toUsuarioDto(Usuario usuario) {
		UsuarioDto usuarioDto = new UsuarioDto();
		BeanUtils.copyProperties(usuario, usuarioDto);
		List<TipoServicoDto> tipoServicosDto = new ArrayList<>();
		usuario.getTipoServicos().forEach(tipoServico -> {
			TipoServicoDto tipoServicoDto = new TipoServicoDto();
			BeanUtils.copyProperties(tipoServico, tipoServicoDto);
			tipoServicosDto.add(tipoServicoDto);

		});
		usuarioDto.setTipoServicos(tipoServicosDto);
		return usuarioDto;
	}

	@GetMapping("/tiposServicos/{id}")
	public ResponseEntity<List<UsuarioDto>> findAllByTipoServicos(@PathVariable Long id) {
		List<Usuario> usuarios = usuarioRepository.findAllByTipoServicos(id);
		return !usuarios.isEmpty() ? ResponseEntity.ok(preencherUsuariosDto(usuarios))
				: ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
		Usuario usuarioSalva = usuarioService.atualizar(id, usuario);
		return ResponseEntity.ok(usuarioSalva);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.usuarioRepository.deleteById(id);
	}

}
