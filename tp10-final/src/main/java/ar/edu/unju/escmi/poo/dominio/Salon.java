package ar.edu.unju.escmi.poo.dominio;

public class Salon {
	private String nombre;
	private int mesas;
	
	//GETTERS Y SETTERS
	
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
	//METODOS CONSTRUCTORES
	
	public Salon(String nombre, int mesas) {
		super();
		this.nombre = nombre;
		this.mesas = mesas;
	}
	public Salon() {
		super();
	}
	
	@Override
	public String toString() {
		return "Salon [nombre=" + nombre + ", mesas=" + mesas + "]";
	}
	
	
}
