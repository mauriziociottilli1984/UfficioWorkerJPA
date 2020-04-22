package it.uwjpa.test;

import org.springframework.stereotype.Component;

import it.uwjpa.service.BatteriaDiTestService;
import it.uwjpa.service.MyServiceFactory;

@Component
public class MyTest {

	public static void main(String[] args) {

		// DA VALORIZZARE SECONDO I CASI ESPOSTI NELLE COSTANTI SOPRA
		// ##########################################################
		String casoDaTestare = BatteriaDiTestService.ELENCA_TUTTI_I_MUNICIPI;
		// ##########################################################

		System.out.println("################ START   #################");
		System.out.println("################ eseguo il test " + casoDaTestare
				+ "  #################");

		MyServiceFactory.getBatteriaDiTestServiceInstance()
				.eseguiBatteriaDiTest(casoDaTestare);

		System.out.println("################ FINE   #################");

	}
}
