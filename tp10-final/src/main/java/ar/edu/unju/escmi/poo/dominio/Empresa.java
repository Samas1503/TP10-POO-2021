package ar.edu.unju.escmi.poo.dominio;

public class Empresa extends Cliente {
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
	public String toString() {
		return "Empresa [cuit=" + cuit + super.toString() + "]";
	}

}
