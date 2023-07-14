package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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

	public Catalogo findById(long codiceISBN) {
		Catalogo found = em.find(Catalogo.class, codiceISBN);
		return found;
	}

	public void findByIdAndDelete(long codiceISBN) {
		Catalogo found = em.find(Catalogo.class, codiceISBN);
		if (found != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(found);
			t.commit();
			System.out.println("Elemento eliminato correttamente");
		} else {
			System.out.println("Elemento eliminato non trovato");
		}
	}

	public List<Catalogo> findByAnnoPubblicazione(int anno) {
		TypedQuery<Catalogo> getCataloghiQuery = em.createQuery(
				"SELECT c FROM Catalogo c WHERE annopubblicazione = :anno",
				Catalogo.class);
		getCataloghiQuery.setParameter("anno", anno);
		return getCataloghiQuery.getResultList();
	}

	public List<Catalogo> findByTitolo(String titolo) {
		TypedQuery<Catalogo> getCataloghiByTitoloQuery = em
				.createQuery("SELECT c FROM Catalogo c WHERE titolo LIKE :titolo", Catalogo.class);
		getCataloghiByTitoloQuery.setParameter("titolo", titolo + "%");
		return getCataloghiByTitoloQuery.getResultList();
	}

}
