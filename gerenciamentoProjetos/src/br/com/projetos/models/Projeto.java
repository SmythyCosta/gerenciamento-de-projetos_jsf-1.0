package br.com.projetos.models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "projeto")
public class Projeto implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@NotEmpty(message="Peencha o campo nome")
	@Length(max=50, message="O nome n�o pode ultrapassar {max} caracteres")
	@Column(name="nome", length=50, nullable=false)
	private String nome;
	
	@Type(type="org.hibernate.type.StringClobType")//para arm e exb caracters especiais
	@NotEmpty(message="A descri��o deve ser informada")
	@Column(name="descricao", nullable=false)
	@Lob
	private String descricao;
	
	@javax.validation.constraints.NotNull(message="Data de inicio deve ser informada")
	@Column(name="inicio", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar inicio;
	
	@javax.validation.constraints.NotNull(message="Data de fim deve ser informada")
	@Column(name="fim", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar fim;
	
	@javax.validation.constraints.NotNull(message="Status do projeto deve ser informado")
	@Column(name="ativo", nullable=false)
	private Boolean ativo;
	
	@javax.validation.constraints.NotNull(message="O setor deve ser informado")
	@ManyToOne
	@JoinColumn(name="setor", referencedColumnName="id", nullable=false)
	private Setor setor;
	
	public Projeto() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getInicio() {
		return inicio;
	}

	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}

	public Calendar getFim() {
		return fim;
	}

	public void setFim(Calendar fim) {
		this.fim = fim;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
	
	
}
