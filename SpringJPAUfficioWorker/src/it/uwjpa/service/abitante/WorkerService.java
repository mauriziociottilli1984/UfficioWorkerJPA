package it.uwjpa.service.abitante;

import java.util.List;

import it.uwjpa.model.Worker;
import it.uwjpa.model.Ufficio;

public interface WorkerService {

	public List<Worker> listAllWorkers();

	public Worker caricaSingoloWorker(Long id);

	public void aggiorna(Worker workerInstance);

	public void inserisciNuovo(Worker workerInstance);

	public void rimuovi(Worker workerInstance);

	public List<Worker> findByExample(Worker example);
	
	public void refresh(Worker workerInstance);
	
	public List<Worker> cercaWorkersInUfficio(Ufficio input);
	
	public List<Worker> cercaWorkersInUfficioConUbicazioneContiene(String ubicazioneToken);

}
