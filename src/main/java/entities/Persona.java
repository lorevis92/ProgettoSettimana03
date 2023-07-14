package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Persona {
	// definizione attributi
	@Id
	@GeneratedValue
	long numeroTessera;
	String nome;
	String cognome;
	LocalDate dataDiNascita;

	@OneToMany(mappedBy = "utente")
	Set<Prestito> elencoPrestitiUtente = new HashSet<>();

	// definizione costruttore
	public Persona(long numeroTessera, String nome, String cognome, LocalDate nascita) {
		this.numeroTessera = numeroTessera;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = nascita;
	}

	@Override
	public String toString() {
		return "Persona [numeroTessera=" + numeroTessera + ", nome=" + nome + ", cognome=" + cognome
				+ ", dataDiNascita=" + dataDiNascita + "]";
	}
}
