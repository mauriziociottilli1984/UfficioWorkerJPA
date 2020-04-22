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
		return entityManager.createQuery("from Ufficio").getResultList();
	}

	@Override
	public Ufficio get(Long id) {
		return entityManager.find(Ufficio.class, id);
	}

	@Override
	public Ufficio findEagerFetch(long idUfficio) {
		Query q = entityManager.
				createQuery("SELECT m FROM Ufficio m JOIN FETCH m.workers a WHERE m.id = :id");
		q.setParameter("id", idUfficio);
		return (Ufficio) q.getSingleResult();
	}

	@Override
	public void update(Ufficio ufficioInstance) {
		ufficioInstance = entityManager.merge(ufficioInstance);
	}

	@Override
	public void insert(Ufficio ufficioInstance) {
		entityManager.persist(ufficioInstance);
	}

	@Override
	public void delete(Ufficio ufficioInstance) {
		entityManager.remove(entityManager.merge(ufficioInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ufficio> findByExample(Ufficio ufficioInstance) {
		Session session = (Session) entityManager.getDelegate();
		Example ufficioExample = Example.create(ufficioInstance)
				.excludeZeroes();
		Criteria criteria = session.createCriteria(Ufficio.class).add(
				ufficioExample);
		return criteria.list();
	}

	@Override
	public void refresh(Ufficio ufficioInstance) {
		entityManager.refresh(entityManager.merge(ufficioInstance));
	}

	@Override
	public Long countByWorkersJunior() {
		Query q = entityManager.createQuery("SELECT count(m) from Ufficio m where m in ( select distinct m from Ufficio m join m.workers a where a.isJunior = 1 ) ");
		Object result =  q.getSingleResult();
		return (Long)result;
	}
	
}
