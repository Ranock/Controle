package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dividas {
	@Id
	private Integer idDivida;
	private String data;
	private float valorDivida;
	private String nomeDivida;
	private boolean quitacao;

	public Integer getIdDivida() {
		return idDivida;
	}

	public void setIdDivida(Integer idDivida) {
		this.idDivida = idDivida;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getValorDivida() {
		return valorDivida;
	}

	public void setValorDivida(float valorDivida) {
		this.valorDivida = valorDivida;
	}

	public String getNomeDivida() {
		return nomeDivida;
	}

	public void setNomeDivida(String nomeDivida) {
		this.nomeDivida = nomeDivida;
	}

	public boolean isQuitacao() {
		return quitacao;
	}

	public void setQuitacao(boolean quitacao) {
		this.quitacao = quitacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDivida == null) ? 0 : idDivida.hashCode());
		result = prime * result + ((nomeDivida == null) ? 0 : nomeDivida.hashCode());
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
		Dividas other = (Dividas) obj;
		if (idDivida == null) {
			if (other.idDivida != null)
				return false;
		} else if (!idDivida.equals(other.idDivida))
			return false;
		if (nomeDivida == null) {
			if (other.nomeDivida != null)
				return false;
		} else if (!nomeDivida.equals(other.nomeDivida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dividas [idDivida=" + idDivida + ", data=" + data + ", valorDivida=" + valorDivida + ", nomeDivida="
				+ nomeDivida + ", quitacao=" + quitacao + "]";
	}
	

}
