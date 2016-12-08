package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="paciente", catalog="dbagenda")
@NamedQuery(name="Paciente.findAll", query="select p from Paciente p")
public class Paciente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CPF", unique=true, nullable=false)
	private String cpf;
	
	@Column(name="DESCRICAO")
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATANASC")
	private Date dataNascimento;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pacientes")
	private Set<Agenda> agendas = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private Set<MaterialMedico> materiaisMedicos = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private Set<Procedimento> procedimentos = new HashSet<>();
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Set<Agenda> getAgendas() {
		return agendas;
	}
	public void setAgendas(Set<Agenda> agenda) {
		this.agendas = agenda;
	}
	public Set<MaterialMedico> getMateriaisMedicos() {
		return materiaisMedicos;
	}
	public void setMateriaisMedicos(Set<MaterialMedico> materiaisMedicos) {
		this.materiaisMedicos = materiaisMedicos;
	}
	public Set<Procedimento> getProcedimentos() {
		return procedimentos;
	}
	public void setProcedimentos(Set<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

}

