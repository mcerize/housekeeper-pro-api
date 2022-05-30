package com.housekeeper.api.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historico_agenda")
public class HistoricoAgenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="data_servico")
	private Date dataServico;
	
	@Column(name="data_atualizacao")
	private Date dataAtualizacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipo_servico")
	private TipoServico tipoServico;
	
	@Column(name="valor_servico")
	private BigDecimal valorServico;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente")
	private Usuario cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_prestador_servico")
	private Usuario prestadorServico;

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

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public BigDecimal getValorServico() {
		return valorServico;
	}

	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Usuario getPrestadorServico() {
		return prestadorServico;
	}

	public void setPrestadorServico(Usuario prestadorServico) {
		this.prestadorServico = prestadorServico;
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
		HistoricoAgenda other = (HistoricoAgenda) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
