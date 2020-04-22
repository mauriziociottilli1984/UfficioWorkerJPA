package it.uwjpa.service.municipio;

import it.uwjpa.dao.municipio.UfficioDAO;
import it.uwjpa.model.Ufficio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UfficioServiceImpl implements UfficioService {

	@Autowired
	private UfficioDAO municipioDAO;

	@Transactional(readOnly = true)
	public List<Ufficio> listAllMunicipi() {
		return municipioDAO.list();
	}

	@Transactional(readOnly = true)
	public Ufficio caricaSingoloMunicipio(Long id) {
		return municipioDAO.get(id);
	}

	@Transactional(readOnly = true)
	public Ufficio caricaSingoloMunicipioEagerAbitanti(Long idMunicipio) {
		return municipioDAO.findEagerFetch(idMunicipio);
	}

	@Transactional
	public void aggiorna(Ufficio municipioInstance) {
		municipioDAO.update(municipioInstance);
	}

	@Transactional
	public void inserisciNuovo(Ufficio municipioInstance) {
		municipioDAO.insert(municipioInstance);
	}

	@Transactional
	public void rimuovi(Ufficio municipioInstance) {
		municipioDAO.delete(municipioInstance);
	}

	@Transactional(readOnly = true)
	public List<Ufficio> findByExample(Ufficio example) {
		return municipioDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public void refresh(Ufficio municipioInstance) {
		municipioDAO.refresh(municipioInstance);
	}

	@Transactional
	public void removeConEccezione(Ufficio municipioInstance) {
		municipioDAO.delete(municipioInstance);
		throw new RuntimeException("Eccezione di prova transazione");
	}

	@Override
	public Long countByAbitantiMinorenni() {
		return municipioDAO.countByAbitantiMinorenni();
	}
}
