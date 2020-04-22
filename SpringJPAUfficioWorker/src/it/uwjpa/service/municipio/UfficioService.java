package it.uwjpa.service.municipio;

import java.util.List;

import it.uwjpa.model.Ufficio;

public interface UfficioService {

	public List<Ufficio> listAllMunicipi();

	public Ufficio caricaSingoloMunicipio(Long id);

	public Ufficio caricaSingoloMunicipioEagerAbitanti(Long idMunicipio);

	public void aggiorna(Ufficio municipioInstance);

	public void inserisciNuovo(Ufficio municipioInstance);

	public void rimuovi(Ufficio municipioInstance);

	public List<Ufficio> findByExample(Ufficio example);

	public void refresh(Ufficio municipioInstance);

	public void removeConEccezione(Ufficio municipioInstance);
	
	public Long countByAbitantiMinorenni();
}
