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
	private WorkerDAO workerDAO;

	@Transactional(readOnly = true)
	public List<Worker> listAllWorkers() {
		return workerDAO.list();
	}

	@Transactional(readOnly = true)
	public Worker caricaSingoloWorker(Long id) {
		return workerDAO.get(id);
	}

	@Transactional
	public void aggiorna(Worker workerInstance) {
		workerDAO.update(workerInstance);
	}

	@Transactional
	public void inserisciNuovo(Worker workerInstance) {
		workerDAO.insert(workerInstance);
	}

	@Transactional
	public void rimuovi(Worker abitanteInstance) {
		workerDAO.delete(abitanteInstance);
	}

	@Transactional(readOnly = true)
	public List<Worker> findByExample(Worker example) {
		return workerDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public void refresh(Worker workerInstance) {
		workerDAO.refresh(workerInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Worker> cercaWorkersInUfficio(Ufficio input) {
		return workerDAO.findAllByUfficio(input);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Worker> cercaWorkersInUfficioConUbicazioneContiene(
			String ubicazioneToken) {
		return workerDAO.findAllByUbicazioneUfficioContiene(ubicazioneToken);
	}

}
