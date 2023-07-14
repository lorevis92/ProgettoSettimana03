package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
}
