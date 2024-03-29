package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Empresa")
public class Empresa extends Cliente {

	@Column
	private int cuit;

	// METODOS CONSTRUCTORES

	public Empresa() {
	}

	public Empresa(String nombre, String email, int telefono, int cuit) {
		super(nombre, email, telefono);
		this.cuit = cuit;
	}

	// METODOS ACCESORES
	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cuit;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Empresa)) {
			return false;
		}
		Empresa other = (Empresa) obj;
		if (cuit != other.cuit) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Empresa [cuit=" + cuit + super.toString() + "]";
	}

	public String toString2() {
		return "Particular [dni=" + cuit + "]";
	}

}
