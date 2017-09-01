package modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lancamento {
	@Id
	private Integer idLacamento; 
	private String dataLancamento;
	private String nomeLancamento;
	private float valorLancamento;

	@ManyToOne
	private Usuario usuario;
	
	public Integer getIdLacamento() {
		return idLacamento;
	}

	public void setIdLacamento(Integer idLacamento) {
		this.idLacamento = idLacamento;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getNomeLancamento() {
		return nomeLancamento;
	}

	public void setNomeLancamento(String nomeLancamento) {
		this.nomeLancamento = nomeLancamento;
	}

	public float getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(float valorLancamento) {
		this.valorLancamento = valorLancamento;
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
		result = prime * result + ((dataLancamento == null) ? 0 : dataLancamento.hashCode());
		result = prime * result + ((idLacamento == null) ? 0 : idLacamento.hashCode());
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
		Lancamento other = (Lancamento) obj;
		if (dataLancamento == null) {
			if (other.dataLancamento != null)
				return false;
		} else if (!dataLancamento.equals(other.dataLancamento))
			return false;
		if (idLacamento == null) {
			if (other.idLacamento != null)
				return false;
		} else if (!idLacamento.equals(other.idLacamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lancamento [idLacamento=" + idLacamento + ", dataLancamento=" + dataLancamento + ", nomeLancamento="
				+ nomeLancamento + ", valorLancamento=" + valorLancamento + "]";
	}

}
