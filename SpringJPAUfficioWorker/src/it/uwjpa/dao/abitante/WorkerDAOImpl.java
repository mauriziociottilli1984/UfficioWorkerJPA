package it.uwjpa.dao.abitante;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import it.uwjpa.model.Worker;
import it.uwjpa.model.Ufficio;

@Component
public class WorkerDAOImpl implements WorkerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Worker> list() {
		return entityManager.createQuery("from Abitante").getResultList();
	}

	@Override
	public Worker get(Long id) {
		return entityManager.find(Worker.class, id);
	}

	@Override
	public void update(Worker abitanteInstance) {
		abitanteInstance = entityManager.merge(abitanteInstance);
	}

	@Override
	public void insert(Worker abitanteInstance) {
		entityManager.persist(abitanteInstance);
	}

	@Override
	public void delete(Worker abitanteInstance) {
		entityManager.remove(entityManager.merge(abitanteInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Worker> findByExample(Worker abitanteInstance) {
		Session session = (Session) entityManager.getDelegate();
		Example abitanteExample = Example.create(abitanteInstance)
				.excludeZeroes();
		Criteria criteria = session.createCriteria(Worker.class).add(
				abitanteExample);
		return criteria.list();
	}

	@Override
	public void refresh(Worker abitanteInstance) {
		entityManager.refresh(entityManager.merge(abitanteInstance));
	}

	@Override
	public List<Worker> findAllByMunicipio(Ufficio input) {
		TypedQuery<Worker> query = entityManager
				.createQuery(
						"select u FROM Abitante u JOIN FETCH u.municipio where u.municipio =:municipioInput",
						Worker.class);
		return query.setParameter("municipioInput", input).getResultList();
	}

	@Override
	public List<Worker> findAllByUbicazioneMunicipioContiene(
			String ubicazioneToken) {
		TypedQuery<Worker> query = entityManager
				.createQuery(
						"select u FROM Abitante u JOIN FETCH u.municipio m where m.ubicazione like :ubicazioneInput",
						Worker.class);
		return (List<Worker>) query.setParameter("ubicazioneInput",
				'%' + ubicazioneToken + '%').getResultList();
	}

}
