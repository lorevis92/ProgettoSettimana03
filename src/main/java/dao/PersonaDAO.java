package dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Persona;

public class PersonaDAO {
	private final EntityManager em;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	public void savePersona(Persona p) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(p);
		t.commit();
		p.getDataDiNascita();
		System.out.println("Utente " + p.getNome() + " " + p.getCognome() + " registrato correttamente in data "
				+ LocalDate.now() + "\n------------------------------------------------------------\n");
	}
}
