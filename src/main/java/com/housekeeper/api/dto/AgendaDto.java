package com.housekeeper.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgendaDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private TipoServicoDto tipoServico;
	
	private Date dataServico;
	
	private Date dataServicoFim;
	
	private BigDecimal valorServico;
	
	private String valorServicoFormatado;
	
	private UsuarioDto cliente;
	
	private UsuarioDto prestadorServico;
	
	private String dataServicoFormatada;
	
	private String dataInicioServicoFormatada;
	
	private String dataFimServicoFormatada;

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

	public String getDataServicoFormatada() {
		return dataServicoFormatada;
	}

	public void setDataServicoFormatada(String dataServicoFormatada) {
		this.dataServicoFormatada = dataServicoFormatada;
	}

	public String getDataInicioServicoFormatada() {
		return dataInicioServicoFormatada;
	}

	public void setDataInicioServicoFormatada(String dataInicioServicoFormatada) {
		this.dataInicioServicoFormatada = dataInicioServicoFormatada;
	}

	public String getDataFimServicoFormatada() {
		return dataFimServicoFormatada;
	}

	public void setDataFimServicoFormatada(String dataFimServicoFormatada) {
		this.dataFimServicoFormatada = dataFimServicoFormatada;
	}
	
	
	
}
