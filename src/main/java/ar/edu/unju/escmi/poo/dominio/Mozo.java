package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mozos")
public class Mozo {

	@Id
	private int dni;

	@Column
	private String nombre, domicilio;

	@Column
	private boolean estado;

	// METODOS CONSTRUCTORES

	public Mozo() {
	}

	public Mozo(int dni, String nombre, String domicilio, boolean estado) {
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.estado = estado;
	}

	// GETTERS Y SETTERS

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	// HASHCODE AND EQUALS

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Mozo)) {
			return false;
		}
		Mozo other = (Mozo) obj;
		if (dni != other.dni) {
			return false;
		}
		if (domicilio == null) {
			if (other.domicilio != null) {
				return false;
			}
		} else if (!domicilio.equals(other.domicilio)) {
			return false;
		}
		if (estado != other.estado) {
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

	// METODO DE MUESTREO

	@Override
	public String toString() {
		return "Mozo [dni=" + dni + ", nombre=" + nombre + ", domicilio=" + domicilio + ", estado="
				+ (estado == true ? "Libre" : "Ocupado") + "]";
	}

}