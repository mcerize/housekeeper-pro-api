package com.housekeeper.api.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import com.housekeeper.api.model.TipoServico;
import com.housekeeper.api.repository.TipoServicoRepository;
import com.housekeeper.api.service.TipoServicoService;

@RestController
@RequestMapping("/servicos")
public class TipoServicoResource {

	@Autowired
	private TipoServicoRepository tipoServicoRepository;
	
	@Autowired
	private TipoServicoService tipoServicoService;

	@PostMapping
	public ResponseEntity<TipoServico> criar(@Valid @RequestBody TipoServico tipoServico,
			HttpServletResponse response) {
		TipoServico tipoServicoSalvo = tipoServicoRepository.save(tipoServico);
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoServicoSalvo);
	}

	@GetMapping
	public ResponseEntity<List<TipoServicoDto>> buscarTodos() {
		List<TipoServico> tiposServicos = tipoServicoRepository.findAll();
		return !tiposServicos.isEmpty() ? ResponseEntity.ok(preencherTipoServicosDto(tiposServicos))
				: ResponseEntity.notFound().build();
	}

	private List<TipoServicoDto> preencherTipoServicosDto(List<TipoServico> tipoServicos) {
		List<TipoServicoDto> tipoServicosDto = new ArrayList<>();
		tipoServicos.forEach(tipoServico -> {
			TipoServicoDto tipoServicoDto = toTipoServicoDto(tipoServico);
			tipoServicosDto.add(tipoServicoDto);
		});
		return tipoServicosDto;
	}

	private TipoServicoDto toTipoServicoDto(TipoServico tipoServico) {
		TipoServicoDto tipoServicoDto = new TipoServicoDto();
		BeanUtils.copyProperties(tipoServico, tipoServicoDto);
		return tipoServicoDto;
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoServico> atualizar(@PathVariable Long id, @Valid @RequestBody TipoServico tipoServico) {
		TipoServico tipoServicoSalvo = tipoServicoService.atualizar(id, tipoServico);
		return ResponseEntity.ok(tipoServicoSalvo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.tipoServicoRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoServicoDto> buscarPeloId(@PathVariable Long id) {
		Optional<TipoServico> tipoServico = tipoServicoRepository.findById(id);
		TipoServicoDto tipoServicoDto = toTipoServicoDto(tipoServico.get());
		return tipoServico.isPresent() ? ResponseEntity.ok(tipoServicoDto) : ResponseEntity.notFound().build();
	}
	
}
