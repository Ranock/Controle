package controledecusto.modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity

public class Usuario {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USER_SEQUENCE")
	@SequenceGenerator(name="USER_SEQUENCE", allocationSize=1, sequenceName="public.user_sequence")
	private Integer idUsuario;
	
	@Column(length=100)
	private String nome;
	@Column(columnDefinition="numeric", precision=2)
	private float saldo;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
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
