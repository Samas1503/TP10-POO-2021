package ar.edu.unju.escmi.poo.dominio;

public abstract class Cliente {
	private String nombre,email;
	private int telefono;
		
	//METODOS CONSTRUCTORES
	
	public Cliente() {
	}
	
	public Cliente(String nombre, String email, int telefono) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}
	
	//METODO GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	//METODO ToString
	
	@Override
	public String toString() {
		return "Clientes [nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + "]";
	}	
	
	public Reserva hacerReserva() {
		return null;
	}
	
	public void pagarReserva() {
		
	}
	
}
