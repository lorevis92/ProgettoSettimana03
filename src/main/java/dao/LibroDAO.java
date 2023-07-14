package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Libro;

public class LibroDAO {
	private final EntityManager em;

	public LibroDAO(EntityManager em) {
		this.em = em;
	}

	public List<Libro> findLibroByAutoreQuery(String name) {
		TypedQuery<Libro> getLibroByAutoreQuery = em.createQuery("SELECT l FROM Libro l WHERE autore = :autore",
				Libro.class);
		getLibroByAutoreQuery.setParameter("autore", name);
		return getLibroByAutoreQuery.getResultList();
	}
}
