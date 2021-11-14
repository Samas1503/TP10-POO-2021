package ar.edu.unju.escmi.poo.dominio;

public class Particular extends Cliente {
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
