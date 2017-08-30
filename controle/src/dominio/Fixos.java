package dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fixos {
	
	@Id
	private Integer idFixo;
	private String nomeFixo;
	private float valorFixo;
	private Integer tipoFixo;
	private boolean precoVaria;
	
	public Integer getIdFixo() {
		return idFixo;
	}

	public void setIdFixo(Integer idFixo) {
		this.idFixo = idFixo;
	}

	public String getNomeFixo() {
		return nomeFixo;
	}

	public void setNomeFixo(String nomeFixo) {
		this.nomeFixo = nomeFixo;
	}

	public float getValorFixo() {
		return valorFixo;
	}

	public void setValorFixo(float valorFixo) {
		this.valorFixo = valorFixo;
	}

	public Integer getTipoFixo() {
		return tipoFixo;
	}

	public void setTipoFixo(Integer tipoFixo) {
		this.tipoFixo = tipoFixo;
	}

	public boolean isPrecoVaria() {
		return precoVaria;
	}

	public void setPrecoVaria(boolean precoVaria) {
		this.precoVaria = precoVaria;
	}

}
