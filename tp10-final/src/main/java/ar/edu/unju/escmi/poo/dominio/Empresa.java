package package ar.edu.unju.escmi.poo.dominio;

public class Empresa extends Cliente {
	private int cuit;

	//METODOS ACCESORES
	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	//METODOS CONSTRUCTORES
	
	public Empresa(String nombre, String email, int telefono, int cuit) {
		super(nombre, email, telefono);
		this.cuit = cuit;
	}

	public Empresa(String nombre, String email, int telefono) {
		super(nombre, email, telefono);
	}

	@Override
	public String toString() {
		return "Empresa [cuit=" + cuit + ", getNombre()=" + getNombre() + ", getEmail()=" + getEmail()
				+ ", getTelefono()=" + getTelefono() + "]";
	}

	
	
}
