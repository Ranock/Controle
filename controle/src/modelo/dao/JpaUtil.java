package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory fabrica;
	
	static{
		JpaUtil.fabrica = Persistence.createEntityManagerFactory("hugo");
	}
	public static EntityManagerFactory getFactory(){
		return JpaUtil.fabrica;		
	}
	
	
	//criar um por thread e limpar a atual
	
	private static ThreadLocal<EntityManager> CACHE = new ThreadLocal<EntityManager>();
	
	public static void limparThreadLocal(){
		EntityManager em = CACHE.get();
		
		if(em != null)
			em.close();
		
		CACHE.remove();
	}
	
	public static EntityManager getEntityManager(){
		
		EntityManager retorno = CACHE.get();
				
		if((retorno != null) && (!retorno.isOpen()))
			retorno = null;
		
			
		if(retorno == null){
			retorno = JpaUtil.fabrica.createEntityManager();
			CACHE.set(retorno);
		}
	return retorno;
	}
}
