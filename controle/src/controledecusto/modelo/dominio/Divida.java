package controledecusto.modelo.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="DIVIDA_SEQUENCE", allocationSize=1, sequenceName="public.divida_sequence")

public class Divida implements Serializable	 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIVIDA_SEQUENCE")
	private Integer idDivida;
	private String data;
	private Float valorDivida;
	private String nomeDivida;
	private boolean quitacao;

	
	@OneToMany
	@JoinTable(
			name="lancamento_divida",
			joinColumns= @JoinColumn(name="id_divida"),
			inverseJoinColumns = @JoinColumn(name="id_lancamento")			
			)
	private List<Lancamento> lancamento;
	
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

	public Float getValorDivida() {
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
	
	
	public List<Lancamento> getLancamentos() {
		return lancamento;
	}

	public void setLancamentos(List<Lancamento> lancamento) {
		this.lancamento= lancamento;
	}
	
	public void setLancamento(Lancamento lancamento) {
		
		if(this.lancamento != null) {
				if(!this.lancamento.contains(lancamento)) {
					this.lancamento.add(lancamento);
				}
		}else;
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
		Divida other = (Divida) obj;
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
		return "Divida [idDivida=" + idDivida + ", data=" + data + ", valorDivida=" + valorDivida + ", nomeDivida="
				+ nomeDivida + ", quitacao=" + quitacao + "]";
	}
	

}
