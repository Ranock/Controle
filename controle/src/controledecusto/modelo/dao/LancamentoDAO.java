package controledecusto.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import controledecusto.modelo.dominio.Lancamento;

public class LancamentoDAO extends GenericDao<Lancamento>{

	EntityManager em = super.getEntityManager();
	
	public List<Lancamento> buscarLancamentosUsuario(Integer idUsuario) {
		Query query = em.createQuery("select l from Lancamento l where l.usuario.id = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		List<Lancamento> lancamentoList = query.getResultList();
		
		return lancamentoList;
	}
}
