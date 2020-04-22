package it.uwjpa.dao.municipio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import it.uwjpa.model.Ufficio;

@Component
public class UfficioDAOImpl implements UfficioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Ufficio> list() {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera
		// maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Municipio").getResultList();
	}

	@Override
	public Ufficio get(Long id) {
		return entityManager.find(Ufficio.class, id);
	}

	@Override
	public Ufficio findEagerFetch(long idMunicipio) {
		Query q = entityManager.createQuery("SELECT m FROM Municipio m JOIN FETCH m.abitanti a WHERE m.id = :id");
		q.setParameter("id", idMunicipio);
		return (Ufficio) q.getSingleResult();
	}

	@Override
	public void update(Ufficio municipioInstance) {
		municipioInstance = entityManager.merge(municipioInstance);
	}

	@Override
	public void insert(Ufficio municipioInstance) {
		entityManager.persist(municipioInstance);
	}

	@Override
	public void delete(Ufficio municipioInstance) {
		entityManager.remove(entityManager.merge(municipioInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ufficio> findByExample(Ufficio municipioInstance) {
		Session session = (Session) entityManager.getDelegate();
		Example municipioExample = Example.create(municipioInstance)
				.excludeZeroes();
		Criteria criteria = session.createCriteria(Ufficio.class).add(
				municipioExample);
		return criteria.list();
	}

	@Override
	public void refresh(Ufficio municipioInstance) {
		entityManager.refresh(entityManager.merge(municipioInstance));
	}

	@Override
	public Long countByAbitantiMinorenni() {
		Query q = entityManager.createQuery("SELECT count(m) from Municipio m where m in ( select distinct m from Municipio m join m.abitanti a where a.eta < 18 ) ");
		Object result =  q.getSingleResult();
		return (Long)result;
	}
	
}
