package it.uwjpa.service.municipio;

import java.util.List;

import it.uwjpa.model.Ufficio;

public interface UfficioService {

	public List<Ufficio> listAllUffici();

	public Ufficio caricaSingoloUfficio(Long id);

	public Ufficio caricaSingoloUfficioEagerWorkers(Long idUfficio);

	public void aggiorna(Ufficio ufficioInstance);

	public void inserisciNuovo(Ufficio ufficioInstance);

	public void rimuovi(Ufficio ufficioInstance);

	public List<Ufficio> findByExample(Ufficio example);

	public void refresh(Ufficio ufficioInstance);

	public void removeConEccezione(Ufficio ufficioInstance);
	
	public Long countByWorkersJunior();
}
