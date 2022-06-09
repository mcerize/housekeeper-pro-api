package com.housekeeper.api.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.housekeeper.api.dto.AgendaDto;
import com.housekeeper.api.dto.TipoServicoDto;
import com.housekeeper.api.dto.UsuarioDto;
import com.housekeeper.api.model.Agenda;
import com.housekeeper.api.model.TipoServico;
import com.housekeeper.api.model.Usuario;
import com.housekeeper.api.repository.AgendaRepository;
import com.housekeeper.api.repository.TipoServicoRepository;
import com.housekeeper.api.repository.UsuarioRepository;
import com.housekeeper.api.service.AgendaService;

@RestController
@RequestMapping("/agendas")
public class AgendaResource {

	@Autowired
	private AgendaRepository agendaRepository;

	@Autowired
	private TipoServicoRepository tipoServicoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AgendaService agendaService;

	@PostMapping
	public ResponseEntity<AgendaDto> criar(@Valid @RequestBody AgendaDto agendaDto, HttpServletResponse response) {
		Agenda agenda = new Agenda(agendaDto);
		Agenda agendaSalva = agendaRepository.save(agenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(toAgendaDto(agendaSalva));
	}

	@GetMapping
	public ResponseEntity<List<AgendaDto>> buscarTodos() {
		List<Agenda> agendas = agendaRepository.findAll();
		return !agendas.isEmpty() ? ResponseEntity.ok(preencherAgendasDto(agendas)) : ResponseEntity.notFound().build();
	}

	private List<AgendaDto> preencherAgendasDto(List<Agenda> agendas) {
		List<AgendaDto> agendasDto = new ArrayList<>();
		agendas.forEach(agenda -> {
			AgendaDto agendaDto = toAgendaDto(agenda);
			agendasDto.add(agendaDto);
		});
		return agendasDto;
	}

	private AgendaDto toAgendaDto(Agenda agenda) {
		AgendaDto agendaDto = new AgendaDto();
		BeanUtils.copyProperties(agenda, agendaDto);
		preencherTipoServico(agenda, agendaDto);
		agendaDto.setPrestadorServico(preencherUsuario(agenda.getIdPrestadorServico()));
		agendaDto.setCliente(agenda.getIdCliente() != null ? preencherUsuario(agenda.getIdCliente()) : null);
		agendaDto.setValorServicoFormatado(
				agendaDto.getValorServico() != null ? agendaDto.getValorServico().toString().replace(".", ",") : "");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		agendaDto.setDataServicoFormatada(dateFormat.format(agenda.getDataServico()));
		agendaDto.setDataInicioServicoFormatada(formatarDatasInicioFimExibicao(agenda.getDataServico()));
		agendaDto.setDataFimServicoFormatada(formatarDatasInicioFimExibicao(agenda.getDataServicoFim()));
		return agendaDto;
	}
	
	private String formatarDatasInicioFimExibicao(Date data) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		return dateFormat.format(data);		
	}

	private void preencherTipoServico(Agenda agenda, AgendaDto agendaDto) {
		Optional<TipoServico> tipoServico = tipoServicoRepository.findById(agenda.getIdTipoServico());
		TipoServicoDto tipoServicoDto = toTipoServicoDto(tipoServico.get());
		agendaDto.setTipoServico(tipoServicoDto);
	}

	private TipoServicoDto toTipoServicoDto(TipoServico tipoServico) {
		TipoServicoDto tipoServicoDto = new TipoServicoDto();
		BeanUtils.copyProperties(tipoServico, tipoServicoDto);
		return tipoServicoDto;
	}

	private UsuarioDto preencherUsuario(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return toUsuarioDto(usuario.get());
	}

	private UsuarioDto toUsuarioDto(Usuario usuario) {
		UsuarioDto usuarioDto = new UsuarioDto();
		List<TipoServico> tipoServicos = usuario.getTipoServicos();
		List<TipoServicoDto> tipoServicosDto = new ArrayList<>();
		tipoServicos.forEach(tipoServico -> {
			TipoServicoDto tipoServicoDto = new TipoServicoDto();
			BeanUtils.copyProperties(tipoServico, tipoServicoDto);
			tipoServicosDto.add(tipoServicoDto);
		});
		BeanUtils.copyProperties(usuario, usuarioDto);
		usuarioDto.setTipoServicos(tipoServicosDto);
		return usuarioDto;
	}

	@GetMapping("/agenda-por-usuario/{id}")
	public ResponseEntity<List<AgendaDto>> buscarPorPrestadorServico(@PathVariable Long id) {
		List<Agenda> agendas = agendaRepository.findAllByIdPrestadorServico(id);
		return !agendas.isEmpty() ? ResponseEntity.ok(preencherAgendasDto(agendas)) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/agenda-por-cliente/{id}")
	public ResponseEntity<List<AgendaDto>> buscarPorCliente(@PathVariable Long id) {
		List<Agenda> agendas = agendaRepository.findAllByIdCliente(id);
		return !agendas.isEmpty() ? ResponseEntity.ok(preencherAgendasDto(agendas)) : ResponseEntity.notFound().build();
	}


	@GetMapping("/agenda-por-usuario-servico/{idUsuario}/{idTipoServico}")
	public ResponseEntity<List<AgendaDto>> buscarPorUsuarioServicoNaoAgendado(@PathVariable Long idUsuario,
			@PathVariable Long idTipoServico) {
		List<Agenda> agendas = agendaRepository.findAllByIdUsuarioIdPrestadorServico(idUsuario, idTipoServico);
		return !agendas.isEmpty() ? ResponseEntity.ok(preencherAgendasDto(agendas)) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<AgendaDto> atualizar(@PathVariable Long id, @Valid @RequestBody AgendaDto agendaDto) {
		Agenda agenda = new Agenda(agendaDto);
		Agenda agendaSalva = agendaService.atualizar(id, agenda);
		return ResponseEntity.ok(toAgendaDto(agendaSalva));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.agendaRepository.deleteById(id);
	}
}
