package controledecusto.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import controledecusto.modelo.dominio.Fixo;

public class FixoDAO extends GenericDao<Fixo> {

			EntityManager em = super.getEntityManager();
			

	public List<Fixo> buscarFixosUsuario(Integer idUsuario) {
		Query query = em.createQuery("select f from Fixo f where f.usuario.id = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		List<Fixo> fixoList = query.getResultList();
		
		return fixoList;
	}
}
