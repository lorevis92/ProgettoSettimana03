package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Prestito {
	// definizione attibuti
	@Id
	@GeneratedValue
	long id;

	@ManyToOne
	@JoinColumn(name = "numero_tessera", referencedColumnName = "numerotessera", nullable = false)
	Persona utente;

	@ManyToOne
	@JoinColumn(name = "codice_ISBN", referencedColumnName = "codiceisbn", nullable = false)
	Catalogo elementoPrestato;

	LocalDate inizioPrestito;
	LocalDate restituzionePrevista;
	LocalDate restituzioneEffettiva;

	// definizione constructor
	public Prestito(Catalogo elementoPrestato, LocalDate inizioPrestito) {
		this.elementoPrestato = elementoPrestato;
		this.inizioPrestito = inizioPrestito;
		this.restituzionePrevista = inizioPrestito.plusDays(30);
	}

}
