package controledecusto.modelo.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder.In;

import controledecusto.modelo.dominio.Lancamento;

public class LancamentoDAO extends GenericDao<Lancamento>{

	EntityManager em = super.getEntityManager();
	
	public List<Lancamento> buscarLancamentosUsuario(Integer idUsuario) {
		Query query = em.createQuery("select l from Lancamento l where l.usuario.id = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		List<Lancamento> lancamentoList = query.getResultList();
		
		return lancamentoList;
	}
	
	public List<Lancamento> buscarLancamentosPorData(Integer idUsuario, Date dataInicio, Date dataFim) {

		
		Query query = em.createQuery("select l from Lancamento l where l.usuario.id = :idUsuario and l.dataLancamento BETWEEN :dataInicio and :dataFim" );
		query.setParameter("idUsuario", idUsuario);
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);
		
		List<Lancamento> lancamentoList = query.getResultList();
		
		return lancamentoList;
		
	}
	public List<Lancamento> buscarLancamentoPorDivida(Integer idDivida){
		
		Query query = em.createQuery("select l from Lancamento where l.divida.id = :idDivida");
		query.setParameter("idDivida", idDivida);
		List<Lancamento> lancL = query.getResultList();
		
		return lancL;
	}
}
