package controledecusto.modelo.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="USER_SEQUENCE", allocationSize=1, sequenceName="public.user_sequence")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USER_SEQUENCE")
	private Integer idUsuario;
	private String nome;
	private float saldo;

	@OneToMany
	@JoinColumn(name="usuario_id")
	private List<Divida> divida;

	@OneToMany
	@JoinColumn(name="usuario_id")
	private List<Lancamento> lancamento;

	@OneToMany
	@JoinColumn(name="usuario_id")
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

	public List<Divida> getDividas() {
		return divida;
	}

	public void setDividas(List<Divida> divida) {
		this.divida = divida;
	}
	
	public void setDivida(Divida divida)  {
		if(this.divida != null) {
			if(!this.divida.contains(divida)) {
				this.divida.add(divida);
			}
	}else;
}


	public List<Lancamento> getLancamentos() {
		return lancamento;
	}

	public void setLancamentos(List<Lancamento> lancamento) {
		this.lancamento = lancamento;
	}
	
	public void setLancamento(Lancamento lancamento) {
		if(this.lancamento != null) {
			if(!this.lancamento.contains(lancamento)) {
				this.lancamento.add(lancamento);
			}
	}else;
}



	public List<Fixos> getFixos() {
		return fixos;
	}

	public void setFixos(List<Fixos> fixos) {
		this.fixos = fixos;
	}
	
	public void setFixo(Fixos fixos)  {
		if(this.fixos != null) {
			if(!this.fixos.contains(fixos)) {
				this.fixos.add(fixos);
			}
	}else;
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
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", saldo=" + saldo + "]";
	}

}
