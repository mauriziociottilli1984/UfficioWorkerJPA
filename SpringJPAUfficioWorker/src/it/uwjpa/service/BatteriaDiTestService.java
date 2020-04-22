package it.uwjpa.service;

import it.uwjpa.model.Worker;
import it.uwjpa.model.Ufficio;
import it.uwjpa.service.abitante.WorkerService;
import it.uwjpa.service.municipio.UfficioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BatteriaDiTestService {

	@Autowired
	private UfficioService ufficioService;

	@Autowired
	private WorkerService workerService;

	// casi di test (usare valorizzando la variabile casoDaTestare nel main)
	public static final String INSERISCI_NUOVO_UFFICIO = "INSERISCI_NUOVO_UFFICIO";
	public static final String INSERISCI_WORKERS_DATO_UN_UFFICIO = "INSERISCI_WORKERS_DATO_UN_UFFICIO";
	public static final String CERCA_WORKER_DATO_ID_UFFICIO = "CERCA_WORKER_DATO_ID_UFFICIO";
	public static final String RIMUOVI_UFFICIO_E_WORKERS = "RIMUOVI_UFFICIO_E_WORKERS";
	public static final String ELENCA_TUTTI_GLI_UFFICI = "ELENCA_TUTTI_GLI_UFFICI";
	public static final String FIND_BY_EXAMPLE_BY_PIANO = "FIND_BY_EXAMPLE_BY_PIANO";
	public static final String UPDATE_WORKER_SET_ISJUNIOR = "UPDATE_WORKER_SET_ISJUNIOR";
	public static final String CARICA_UFFICIO_EAGER = "CARICA_UFFICIO_EAGER";
	public static final String REMOVE_CON_ECCEZIONE_VA_IN_ROLLBACK = "REMOVE_CON_ECCEZIONE_VA_IN_ROLLBACK";
	public static final String FIND_ALL_WORKER_UBICAZIONE_CONTIENE = "FIND_ALL_WORKER_UBICAZIONE_CONTIENE";
	public static final String COUNT_UFFICI_BY_JUNIOR = "COUNT_UFFICI_BY_JUNIOR";

	public void eseguiBatteriaDiTest(String casoDaTestare) {
		try {
			switch (casoDaTestare) {
			case INSERISCI_NUOVO_UFFICIO:
				// creo nuovo ufficio
				Ufficio nuovoUfficio = new Ufficio("Ufficio sinistri",
						"Piano 3", "Sede ostia");
				// salvo
				ufficioService.inserisciNuovo(nuovoUfficio);
				System.out.println("Municipio appena inserito: "
						+ nuovoUfficio);
				break;

			case INSERISCI_WORKERS_DATO_UN_UFFICIO:
				// / creo nuovo worker
				Worker nuovoWorker = new Worker("Pluto", "Plutorum", 77);
				nuovoWorker.setUfficio(ufficioService.caricaSingoloUfficio(22L));
				// salvo
				workerService.inserisciNuovo(nuovoWorker);
				break;

			case CERCA_WORKER_DATO_ID_UFFICIO:
				// stampo i workers di un determinato ufficio
				System.out.println(workerService.
						cercaWorkersInUfficio(ufficioService.caricaSingoloUfficio(22L)));
				break;

			case RIMUOVI_UFFICIO_E_WORKERS:
				// per cancellare tutto l'ufficio
				ufficioService.rimuovi(ufficioService
						.caricaSingoloUfficio(24L));
				break;

			case ELENCA_TUTTI_GLI_UFFICI:
				// elencare gli uffici
				System.out.println("Elenco gli uffici:");
				for (Ufficio ufficioItem : ufficioService
						.listAllUffici()) {
					System.out.println(ufficioItem);
				}
				break;

			case FIND_BY_EXAMPLE_BY_PIANO:
				System.out
						.println("########### EXAMPLE ########################");
				// find by example: voglio ricercare i municipi con
				// ubicazione'Via dei Grandi'
				Ufficio ufficioExample = new Ufficio();
				ufficioExample.setUbicazione("Quarto piano");
				for (Ufficio ufficioItem : ufficioService
						.findByExample(ufficioExample)) {
					System.out.println(ufficioItem);
				}
				break;

			case UPDATE_WORKER_SET_ISJUNIOR:
				// carico un worker e cambio eta
				Worker workerEsistente = workerService
						.caricaSingoloWorker(14L);
				if (workerEsistente != null) {
					workerEsistente.setJunior(true);
					workerService.aggiorna(workerEsistente);
				}
				break;

			case CARICA_UFFICIO_EAGER:
				// quando carico un Municipio ho già i suoi abitanti
				Ufficio ufficioACaso = ufficioService
						.caricaSingoloUfficioEagerWorkers(23L);
				if (ufficioACaso != null) {
					for (Worker workerItem : ufficioACaso.getWorkers()) {
						System.out.println(workerItem);
					}
				}
				break;

			case REMOVE_CON_ECCEZIONE_VA_IN_ROLLBACK:
				// Test transaction rollback provando a cancellare l'ultimo
				// inserito
				List<Ufficio> allUffici = ufficioService
						.listAllUffici();
				System.out.println("...size before..." + allUffici.size());
				try {
					Ufficio ultimoInserito = allUffici.get(allUffici
							.size() - 1);

					ufficioService.removeConEccezione(ultimoInserito);
				} catch (Exception e) {
					e.printStackTrace();
				}

				allUffici = ufficioService.listAllUffici();
				System.out.println("...size after..." + allUffici.size());
				break;
				/*
			case FIND_ALL_WORKER_UBICAZIONE_CONTIENE:
				System.out
						.println("########### FIND_ALL_WORKER_UBICAZIONE_CONTIENE ########################");

				for (Worker workerItem : workerService
						.cercaWorkersInUfficioConUbicazioneContiene(ubicazioneToken)"cani")) {
					System.out.println(abitanteItem);
				}
				break;
			case COUNT_MUNICIPI_BY_MINORENNI:
				System.out
				.println("########### COUNT_MUNICIPI_BY_MINORENNI ########################");
				System.out.println("ci sono "+ municipioService.countByAbitantiMinorenni() + " municipi con minorenni");
				break;
				*/
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
