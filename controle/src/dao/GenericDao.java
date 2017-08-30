package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class GenericDao<E> {

	protected Class<E> persistentClass;
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public GenericDao() {
		super();
		Type tipo = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.persistentClass = (Class<E>) tipo;
		manager = JpaUtil.getEntityManager();
	}
	public GenericDao(EntityManager manager){
		super();
		this.manager = manager;
	}
	
	@Override
	public EntityManager getEntityManager(){
		if((this.manager != null) && (!this.manager.isOpen()))
		this.manager = JpaUtil.getEntityManager();
		
		return this.manager;
		
		
	}
	
	CriteriaBuilder cd = this.manager.getCriteriaBuilder();
}
