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
	private UfficioDAO ufficioDAO;

	@Transactional(readOnly = true)
	public List<Ufficio> listAllUffici() {
		return ufficioDAO.list();
	}

	@Transactional(readOnly = true)
	public Ufficio caricaSingoloUfficio(Long id) {
		return ufficioDAO.get(id);
	}

	@Transactional(readOnly = true)
	public Ufficio caricaSingoloUfficioEagerWorkers(Long idUfficio) {
		return ufficioDAO.findEagerFetch(idUfficio);
	}

	@Transactional
	public void aggiorna(Ufficio ufficioInstance) {
		ufficioDAO.update(ufficioInstance);
	}

	@Transactional
	public void inserisciNuovo(Ufficio ufficioInstance) {
		ufficioDAO.insert(ufficioInstance);
	}

	@Transactional
	public void rimuovi(Ufficio ufficioInstance) {
		ufficioDAO.delete(ufficioInstance);
	}

	@Transactional(readOnly = true)
	public List<Ufficio> findByExample(Ufficio example) {
		return ufficioDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public void refresh(Ufficio ufficioInstance) {
		ufficioDAO.refresh(ufficioInstance);
	}

	@Transactional
	public void removeConEccezione(Ufficio ufficioInstance) {
		ufficioDAO.delete(ufficioInstance);
		throw new RuntimeException("Eccezione di prova transazione");
	}

	@Override
	public Long countByWorkersJunior() {
		return ufficioDAO.countByWorkersJunior();
	}

}
