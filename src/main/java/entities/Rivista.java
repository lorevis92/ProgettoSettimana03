package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import enu.Periodicità;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@DiscriminatorValue("Rivista")
public class Rivista extends Catalogo {
	// definizione attributi
	Periodicità periodicità;

	// definizione costruttore
	public Rivista(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.periodicità = periodicità;
	}

}
