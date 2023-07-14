package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Prestito;

public class PrestitoDAO {
	private final EntityManager em;

	public PrestitoDAO(EntityManager em) {
		this.em = em;
	}

	public void savePrestito(Prestito p) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(p);
		t.commit();
		System.out.println(p.getElementoPrestato() + " prestato a " + p.getUtente().getNome() + " "
				+ p.getUtente().getCognome() + "\nPrestito con codice: " + p.getId() + " \nData inizio prestito: "
				+ p.getInizioPrestito() + "\nData programmata per la restituzione: " + p.getRestituzionePrevista()
				+ "\n------------------------------------------------------------\n");
	}

	public List<Prestito> findElementiInPrestitoPerUtenteQuery(long tessera) {
		TypedQuery<Prestito> findElementiInPrestitoPerUtenteQuery = em.createQuery(
				"SELECT p FROM Prestito p WHERE numero_tessera = :tessera AND restituzioneeffettiva = null",
				Prestito.class);
		findElementiInPrestitoPerUtenteQuery.setParameter("tessera", tessera);
		return findElementiInPrestitoPerUtenteQuery.getResultList();
	}

	public List<Prestito> findElementiInPrestitoScaduti(Prestito p) {
		boolean scaduto;
		if (LocalDate.now().isAfter(p.getRestituzionePrevista()))
			scaduto = true;
		else
			scaduto = false;
		TypedQuery<Prestito> findElementiInPrestitoPerUtenteQuery = em.createQuery(
				// Non ho fatto in tempo a completare la Query
				"SELECT p FROM Prestito p WHERE  restituzioneeffettiva = null", Prestito.class);
		return findElementiInPrestitoPerUtenteQuery.getResultList();
	}
}
