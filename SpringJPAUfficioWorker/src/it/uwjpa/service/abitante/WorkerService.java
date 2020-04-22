package it.uwjpa.service.abitante;

import java.util.List;

import it.uwjpa.model.Worker;
import it.uwjpa.model.Ufficio;

public interface WorkerService {

	public List<Worker> listAllAbitanti();

	public Worker caricaSingoloAbitante(Long id);

	public void aggiorna(Worker abitanteInstance);

	public void inserisciNuovo(Worker abitanteInstance);

	public void rimuovi(Worker abitanteInstance);

	public List<Worker> findByExample(Worker example);
	
	public void refresh(Worker abitanteInstance);
	
	public List<Worker> cercaAbitantiInMunicipio(Ufficio input);
	
	public List<Worker> cercaAbitantiInMunicipioConUbicazioneContiene(String ubicazioneToken);

}
