package controledecusto.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import controledecusto.modelo.dominio.Divida;
import controledecusto.modelo.dominio.Usuario;

public class DividaDAO extends GenericDao<Divida> {

	EntityManager em = super.getEntityManager();
	
	public List<Divida> buscarDividasUsuario(Integer idUsuario) {
		Query query = em.createQuery("select d from Divida d where d.usuario.id = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		List<Divida> dividaList = query.getResultList();
		
		return dividaList;
		
	}
}
