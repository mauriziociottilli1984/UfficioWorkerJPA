package it.uwjpa.dao.abitante;

import it.uwjpa.dao.IBaseDAO;
import it.uwjpa.model.Worker;
import it.uwjpa.model.Ufficio;

import java.util.List;

public interface WorkerDAO extends IBaseDAO<Worker> {

	public List<Worker> findAllByUfficio(Ufficio input);
	public List<Worker> findAllByUbicazioneUfficioContiene(String ubicazioneToken);
	
}
