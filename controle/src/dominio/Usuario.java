package dominio;

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

}
