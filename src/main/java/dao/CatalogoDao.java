package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Catalogo;

public class CatalogoDao {
	private final EntityManager em;

	public CatalogoDao(EntityManager em) {
		this.em = em;
	}

	public void saveCatalogo(Catalogo c) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(c);
		t.commit();
		System.out.println(c.getTitolo() + " salvato!\n------------------------------------------\n");
	}
}
