package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salones")
public class Salon {

	@Id
	@Column
	private String nombre;
	@Column
	private int mesas;

	// METODOS CONSTRUCTORES

	public Salon() {
	}

	public Salon(String nombre, int mesas) {
		this.nombre = nombre;
		this.mesas = mesas;
	}

	// GETTERS Y SETTERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMesas() {
		return mesas;
	}

	public void setMesas(int mesas) {
		this.mesas = mesas;
	}

	@Override
	public String toString() {
		return "Salon [nombre=" + nombre + ", mesas=" + mesas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mesas;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Salon)) {
			return false;
		}
		Salon other = (Salon) obj;
		if (mesas != other.mesas) {
			return false;
		}
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}

}