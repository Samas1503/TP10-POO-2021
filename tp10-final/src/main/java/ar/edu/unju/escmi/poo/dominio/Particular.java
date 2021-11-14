package ar.edu.unju.escmi.poo.dominio;

public class Particular extends Cliente {
	private int dni;

	//METODOS GETTERES Y SETTERS
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	//METODOS CONSTRUCTORES

	public Particular(String nombre, String email, int telefono) {
		super(nombre, email, telefono);
	}

	public Particular(String nombre, String email, int telefono, int dni) {
		super(nombre, email, telefono);
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Particular [dni=" + dni + ", Nombre=" + super.getNombre() + ", Email=" + super.getEmail()
				+ ", Telefono=" + super.getTelefono() + "]";
	}

	
	
}
