package com.housekeeper.api.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housekeeper.api.model.Endereco;
import com.housekeeper.api.model.Perfil;
import com.housekeeper.api.model.Permissao;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String nome;

	private LocalDate dataNascimento;

	private String cpf;

	private String telefone;

	private Endereco endereco;

	private Perfil perfil;

	private String email;

	private List<Permissao> permissoes;
	
	private String senha;

	public String getTipoServicosConcatenados() {
		String tipoServicosConcatenados = "";
		if (this.getTipoServicos() != null || !this.getTipoServicos().isEmpty()) {
			for (TipoServicoDto t : this.getTipoServicos()) {
				tipoServicosConcatenados += t.getNome() + "; ";
			}
		}
		return tipoServicosConcatenados;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	private List<TipoServicoDto> tipoServicos;

	public List<TipoServicoDto> getTipoServicos() {
		return tipoServicos;
	}

	public void setTipoServicos(List<TipoServicoDto> tipoServicos) {
		this.tipoServicos = tipoServicos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
