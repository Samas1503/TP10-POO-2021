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

	// HASHCODE AND EQUALS

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + dni;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Particular)) {
			return false;
		}
		Particular other = (Particular) obj;
		if (dni != other.dni) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Particular [dni=" + dni + super.toString() + "]";
	}

	public String toString2() {
		return "Particular [dni=" + dni + "]";
	}

}
