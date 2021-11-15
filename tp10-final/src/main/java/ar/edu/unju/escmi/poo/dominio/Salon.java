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

}