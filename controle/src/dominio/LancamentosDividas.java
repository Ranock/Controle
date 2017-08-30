package dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LancamentosDividas {
	
	@Id
	private Integer idLancamentoDivida;
	private String data;
	private float valor;
	private String tipo;
	
	
	public Integer getIdLancamentoDivida() {
		return idLancamentoDivida;
	}
	public void setIdLancamentoDivida(Integer idLancamentoDivida) {
		this.idLancamentoDivida = idLancamentoDivida;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((idLancamentoDivida == null) ? 0 : idLancamentoDivida.hashCode());
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
		LancamentosDividas other = (LancamentosDividas) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (idLancamentoDivida == null) {
			if (other.idLancamentoDivida != null)
				return false;
		} else if (!idLancamentoDivida.equals(other.idLancamentoDivida))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LancamentosDividas [idLancamentoDivida=" + idLancamentoDivida + ", data=" + data + ", valor=" + valor
				+ ", tipo=" + tipo + "]";
	}
	
	
}
