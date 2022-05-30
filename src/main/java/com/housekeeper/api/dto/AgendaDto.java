package com.housekeeper.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AgendaDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private TipoServicoDto tipoServico;
	
	private LocalDate dataServico;
	
	private LocalDate dataServicoFim;
	
	private BigDecimal valorServico;
	
	private String valorServicoFormatado;
	
	private UsuarioDto cliente;
	
	private UsuarioDto prestadorServico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoServicoDto getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServicoDto tipoServico) {
		this.tipoServico = tipoServico;
	}
	
	public LocalDate getDataServico() {
		return dataServico;
	}

	public void setDataServico(LocalDate dataServico) {
		this.dataServico = dataServico;
	}

	public LocalDate getDataServicoFim() {
		return dataServicoFim;
	}

	public void setDataServicoFim(LocalDate dataServicoFim) {
		this.dataServicoFim = dataServicoFim;
	}

	public BigDecimal getValorServico() {
		return valorServico;
	}

	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
	}
	
	public String getValorServicoFormatado() {
		return valorServicoFormatado;
	}

	public void setValorServicoFormatado(String valorServicoFormatado) {
		this.valorServicoFormatado = valorServicoFormatado;
	}

	public UsuarioDto getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioDto cliente) {
		this.cliente = cliente;
	}

	public UsuarioDto getPrestadorServico() {
		return prestadorServico;
	}

	public void setPrestadorServico(UsuarioDto prestadorServico) {
		this.prestadorServico = prestadorServico;
	}

}
