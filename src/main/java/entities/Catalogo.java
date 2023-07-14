package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_catalogo")
public abstract class Catalogo {
	// definizione attributi
	@Id
	@GeneratedValue
	long codiceISBN;
	String titolo;
	int annoPubblicazione;
	int numeroPagine;
	@OneToMany(mappedBy = "elementoPrestato")
	Set<Prestito> setPrestiti = new HashSet<>();

	// definizione costruttore
	public Catalogo(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

}
