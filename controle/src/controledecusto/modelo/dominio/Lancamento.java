package controledecusto.modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Lancamento{
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "LANCAMENTO_SEQUENCE")
	@SequenceGenerator(name="LANCAMENTO_SEQUENCE", allocationSize=1, sequenceName="public.lancamento_sequence")
	private Integer idLancamento; 
	private String dataLancamento;
	private String nomeLancamento;
	private float valorLancamento;
	
	@ManyToOne
	@JoinTable(
			name="lancamento_divida",
			joinColumns= @JoinColumn(name="id_lancamento", referencedColumnName="idLancamento"),
			inverseJoinColumns = @JoinColumn(name="id_divida", referencedColumnName="idDivida")			
			)
	private Divida divida;
	
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Integer getIdLancamento() {
		return idLancamento;
	}

	public void setIdLancamento(Integer idLancamento) {
		this.idLancamento = idLancamento;
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

	public Divida getDivida() {
		return divida;
	}

	public void setDivida(Divida divida) {
		this.divida = divida;
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
		result = prime * result + ((idLancamento == null) ? 0 : idLancamento.hashCode());
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
		if (idLancamento == null) {
			if (other.idLancamento != null)
				return false;
		} else if (!idLancamento.equals(other.idLancamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lancamento [idLancamento=" + idLancamento + ", dataLancamento=" + dataLancamento + ", nomeLancamento="
				+ nomeLancamento + ", valorLancamento=" + valorLancamento + "]";
	}
	
}
