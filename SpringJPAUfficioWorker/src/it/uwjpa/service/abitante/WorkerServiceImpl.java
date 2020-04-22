package it.uwjpa.service.abitante;

import it.uwjpa.dao.abitante.WorkerDAO;
import it.uwjpa.model.Worker;
import it.uwjpa.model.Ufficio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerDAO abitanteDAO;

	@Transactional(readOnly = true)
	public List<Worker> listAllAbitanti() {
		return abitanteDAO.list();
	}

	@Transactional(readOnly = true)
	public Worker caricaSingoloAbitante(Long id) {
		return abitanteDAO.get(id);
	}

	@Transactional
	public void aggiorna(Worker abitanteInstance) {
		abitanteDAO.update(abitanteInstance);
	}

	@Transactional
	public void inserisciNuovo(Worker abitanteInstance) {
		abitanteDAO.insert(abitanteInstance);
	}

	@Transactional
	public void rimuovi(Worker abitanteInstance) {
		abitanteDAO.delete(abitanteInstance);
	}

	@Transactional(readOnly = true)
	public List<Worker> findByExample(Worker example) {
		return abitanteDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public void refresh(Worker abitanteInstance) {
		abitanteDAO.refresh(abitanteInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Worker> cercaAbitantiInMunicipio(Ufficio input) {
		return abitanteDAO.findAllByMunicipio(input);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Worker> cercaAbitantiInMunicipioConUbicazioneContiene(
			String ubicazioneToken) {
		return abitanteDAO.findAllByUbicazioneMunicipioContiene(ubicazioneToken);
	}

}
