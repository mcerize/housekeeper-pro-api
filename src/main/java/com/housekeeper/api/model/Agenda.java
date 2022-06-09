package com.housekeeper.api.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housekeeper.api.dto.AgendaDto;

@Entity
@Table(name = "agenda")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "data_servico")
	private Date dataServico;

	@Column(name = "data_servico_fim")
	private Date dataServicoFim;

	@Column(name = "id_tipo_servico")
	private Long idTipoServico;

	@Column(name = "valor_servico")
	private BigDecimal valorServico;

	@Column(name = "id_cliente")
	private Long idCliente;

	@Column(name = "id_prestador_servico")
	private Long idPrestadorServico;
	
	public Agenda() {
		super();
	}

	public Agenda(AgendaDto agendaDto) {
		this.setId(agendaDto.getId());
		this.setDataServico(agendaDto.getDataServico());
		this.setDataServicoFim(agendaDto.getDataServicoFim());
		this.setIdTipoServico(agendaDto.getTipoServico() != null ? agendaDto.getTipoServico().getId() : null);
		this.setValorServico(agendaDto.getValorServico());
		this.setIdCliente(agendaDto.getCliente() != null ? agendaDto.getCliente().getId() : null);
		this.setIdPrestadorServico(
				agendaDto.getPrestadorServico() != null ? agendaDto.getPrestadorServico().getId() : null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataServico() {
		return dataServico;
	}

	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}

	public Date getDataServicoFim() {
		return dataServicoFim;
	}

	public void setDataServicoFim(Date dataServicoFim) {
		this.dataServicoFim = dataServicoFim;
	}

	public Long getIdTipoServico() {
		return idTipoServico;
	}

	public void setIdTipoServico(Long idTipoServico) {
		this.idTipoServico = idTipoServico;
	}

	public BigDecimal getValorServico() {
		return valorServico;
	}

	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdPrestadorServico() {
		return idPrestadorServico;
	}

	public void setIdPrestadorServico(Long idPrestadorServico) {
		this.idPrestadorServico = idPrestadorServico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(id, other.id);
	}

}
