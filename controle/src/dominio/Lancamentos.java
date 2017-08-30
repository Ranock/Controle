package dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lancamentos {
	@Id
	private Integer idLacamento; 
	private String dataLancamento;
	private String nomeLancamento;
	private float valorLancamento;

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
		Lancamentos other = (Lancamentos) obj;
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
		return "Lancamentos [idLacamento=" + idLacamento + ", dataLancamento=" + dataLancamento + ", nomeLancamento="
				+ nomeLancamento + ", valorLancamento=" + valorLancamento + "]";
	}

}
