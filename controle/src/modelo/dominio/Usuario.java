package modelo.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	@Id
	private Integer idUsuario;
	private String nome;
	private float saldo;
	
	@OneToMany(mappedBy ="usuario")
	private List<Divida> divida;
	
	@OneToMany(mappedBy = "usuario")
	private List<Lancamento> lancamento;
	
	@OneToMany(mappedBy = "usuario")
	private List<Fixos> fixos;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<Divida> getDivida() {
		return divida;
	}

	public void setDivida(List<Divida> divida) {
		this.divida = divida;
	}

	public List<Lancamento> getLancamento() {
		return lancamento;
	}

	public void setLancamento(List<Lancamento> lancamento) {
		this.lancamento = lancamento;
	}

	public List<Fixos> getFixos() {
		return fixos;
	}

	public void setFixos(List<Fixos> fixos) {
		this.fixos = fixos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", saldo=" + saldo + ", divida=" + divida
				+ ", lancamento=" + lancamento + ", fixos=" + fixos + "]";
	}

	
}
