package controledecusto.modelo.dominio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Divida  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIVIDA_SEQUENCE")
	@SequenceGenerator(name="DIVIDA_SEQUENCE", allocationSize=1, sequenceName="public.divida_sequence")
	private Integer idDivida;
	private String data;
	private BigDecimal valorDivida;
	private String nomeDivida;
	private boolean quitacao;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;


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


	public BigDecimal getValorDivida() {
		return valorDivida;
	}


	public void setValorDivida(BigDecimal valorDivida) {
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

	@JsonIgnore
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
		result = prime * result + ((idDivida == null) ? 0 : idDivida.hashCode());
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
		Divida other = (Divida) obj;
		if (idDivida == null) {
			if (other.idDivida != null)
				return false;
		} else if (!idDivida.equals(other.idDivida))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Divida [idDivida=" + idDivida + ", data=" + data + ", valorDivida=" + valorDivida + ", nomeDivida="
				+ nomeDivida + ", quitacao=" + quitacao + "]";
	}

}
	