package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
	@Enumerated(EnumType.STRING)
	Periodicità periodicità;

	// definizione costruttore
	public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.periodicità = periodicità;
	}

}
