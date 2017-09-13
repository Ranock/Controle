package controledecusto.modelo.dominio;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fixos {
	
	@Id
	private Integer idFixo;
	private String nomeFixo;
	private float valorFixo;
	private Integer tipoFixo;
	private boolean precoVaria;
	
	@ManyToOne
	private Usuario usuario;
	
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFixo == null) ? 0 : idFixo.hashCode());
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
		Fixos other = (Fixos) obj;
		if (idFixo == null) {
			if (other.idFixo != null)
				return false;
		} else if (!idFixo.equals(other.idFixo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fixos [idFixo=" + idFixo + ", nomeFixo=" + nomeFixo + ", valorFixo=" + valorFixo + ", tipoFixo="
				+ tipoFixo + ", precoVaria=" + precoVaria + ", usuario=" + usuario + "]";
	}
	
	

}