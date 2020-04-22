package it.uwjpa.dao.municipio;

import it.uwjpa.dao.IBaseDAO;
import it.uwjpa.model.Ufficio;

public interface UfficioDAO extends IBaseDAO<Ufficio> {
	public Ufficio findEagerFetch(long idMunicipio);
	public Long countByAbitantiMinorenni();
}
