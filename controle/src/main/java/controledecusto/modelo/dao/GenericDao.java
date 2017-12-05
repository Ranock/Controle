package controledecusto.modelo.dao;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;

import util.JpaUtil;

public class GenericDao<E> {

	protected Class<E> persistentClass;
	private EntityManager manager;

	
	public GenericDao() {
		super();
		Type tipo = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.persistentClass = (Class<E>) tipo;
		manager = JpaUtil.getEntityManager();
	}

	public GenericDao(EntityManager manager) {
		super();
		this.manager = manager;
	}

	public EntityManager getEntityManager() {
		if ((this.manager != null) && (!this.manager.isOpen()))
			this.manager = JpaUtil.getEntityManager();

		return this.manager;
	}

	public void abrirTransacao() {
		this.getEntityManager().getTransaction().begin();
	}

	public void gravarTransacao() {
		this.getEntityManager().flush();
		this.getEntityManager().getTransaction().commit();
	}

	public void desfazerTransacao() {
		this.getEntityManager().getTransaction().rollback();
	}

	public E inserir(E obj) {
		boolean transacao = this.getEntityManager().getTransaction().isActive();

		if (!transacao)
			this.abrirTransacao();

		obj = this.getEntityManager().merge(obj);

		if (!transacao)
			this.gravarTransacao();
		return obj;
	}
	
	public E lerPorId(Object id){
		return (E) this.getEntityManager().find(this.persistentClass,id);
	}
	
	public void Excluir(E obj){
		
		boolean transacao = this.getEntityManager().getTransaction().isActive();
		if(!transacao)
			this.abrirTransacao();
			
		this.getEntityManager().remove(obj);
		
		if(!transacao)
			this.gravarTransacao();
				
	}

}
