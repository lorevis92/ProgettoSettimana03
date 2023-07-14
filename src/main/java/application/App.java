package application;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.CatalogoDao;
import dao.PersonaDAO;
import dao.PrestitoDAO;
import entities.Libro;
import entities.Persona;
import entities.Prestito;
import entities.Rivista;
import enu.Periodicità;
import util.JpaUtil;

public class App {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		PersonaDAO persDao = new PersonaDAO(em);
		CatalogoDao cDao = new CatalogoDao(em);
		PrestitoDAO prestDao = new PrestitoDAO(em);
		System.out.println("Ciao");

		// Creazione utenti
		Persona aldo = new Persona("Aldo", "Baglio", LocalDate.of(1962, 4, 17));
		Persona franco = new Persona("Franco", "Califano", LocalDate.of(1958, 5, 3));
		Persona mara = new Persona("Mara", "Maiocchi", LocalDate.of(1912, 6, 7));
		Persona silvio = new Persona("Silvio", "Berlusconi", LocalDate.of(2018, 2, 17));
		Persona andrea = new Persona("Andrea", "Pirlo", LocalDate.of(1962, 4, 17));

		// Creazione libri
		Libro doorsOfPerseption = new Libro("The doors of perseption", 1954, 208, "Aldous Huxley", "Saggio");
		Libro cheapWhiskey = new Libro("Cheap Whiskey", 2023, 174, "Lorenzo G. Visconti", "Fantascianza");
		Libro milleNovecentoOttantaQuattro = new Libro("1984", 1949, 159, "George Orwell", "Distopico");

		// Creazione riviste
		Rivista vanityFairAgosto = new Rivista("Vanity Fair Agosto", 2022, 34, Periodicità.MENSILE);
		Rivista vanityFairSettembre = new Rivista("Vanity Fair Settembre", 2022, 37, Periodicità.MENSILE);
		Rivista vanityFairOttobre = new Rivista("Vanity Fair Ottobre", 2022, 35, Periodicità.MENSILE);
		Rivista vanityFairNovembre = new Rivista("Vanity Fair Novembre", 2022, 35, Periodicità.MENSILE);
		Rivista vanityFairDicembre = new Rivista("Vanity Fair Dicembre", 2022, 34, Periodicità.MENSILE);

		// Creazione prestiti
		Prestito prestitoAldo1 = new Prestito(doorsOfPerseption, aldo);
		Prestito prestitoAldo2 = new Prestito(cheapWhiskey, aldo);
		Prestito prestitoAldo3 = new Prestito(milleNovecentoOttantaQuattro, aldo);
		Prestito prestitoAldo4 = new Prestito(vanityFairOttobre, aldo);
		Prestito prestitoMara1 = new Prestito(vanityFairAgosto, mara);
		Prestito prestitoMara2 = new Prestito(vanityFairSettembre, mara);
		Prestito prestitoMara3 = new Prestito(vanityFairOttobre, mara);
		Prestito prestitoMara4 = new Prestito(vanityFairNovembre, mara);
		Prestito prestitoMara5 = new Prestito(vanityFairDicembre, mara);

		// Salvataggio utenti sul Database
//		persDao.savePersona(aldo);
//		persDao.savePersona(franco);
//		persDao.savePersona(mara);
//		persDao.savePersona(silvio);
//		persDao.savePersona(andrea);

		// Salvataggio elementi Catalogo
//		cDao.saveCatalogo(doorsOfPerseption);
//		cDao.saveCatalogo(cheapWhiskey);
//		cDao.saveCatalogo(milleNovecentoOttantaQuattro);
//		cDao.saveCatalogo(vanityFairAgosto);
//		cDao.saveCatalogo(vanityFairSettembre);
//		cDao.saveCatalogo(vanityFairOttobre);
//		cDao.saveCatalogo(vanityFairNovembre);
//		cDao.saveCatalogo(vanityFairDicembre);

		// Salvataggio prestiti
//		prestDao.savePrestito(prestitoAldo1);
//		prestDao.savePrestito(prestitoAldo2);
//		prestDao.savePrestito(prestitoAldo3);
//		prestDao.savePrestito(prestitoAldo4);
//		prestDao.savePrestito(prestitoMara1);
//		prestDao.savePrestito(prestitoMara2);
//		prestDao.savePrestito(prestitoMara3);
//		prestDao.savePrestito(prestitoMara4);
//		prestDao.savePrestito(prestitoMara5);

	}

}
