package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Particular")
public class Particular extends Cliente {

	@Column
	private int dni;

	// METODOS CONSTRUCTORES

	public Particular() {
	}

	public Particular(String nombre, String email, int telefono, int dni) {
		super(nombre, email, telefono);
		this.dni = dni;
	}

	// METODOS GETTERES Y SETTERS

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Particular [dni=" + dni + super.toString() + "]";
	}

}
