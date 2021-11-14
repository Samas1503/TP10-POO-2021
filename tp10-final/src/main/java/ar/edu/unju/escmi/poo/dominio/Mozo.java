package ar.edu.unju.escmi.poo.dominio;

public class Mozo {
	private int dni;
	private String nombre, domicilio, jornada; // no se si jornada sigue valido
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

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	// METODO DE MUESTREO

	@Override
	public String toString() {
		return "Mozo [dni=" + dni + ", nombre=" + nombre + ", domicilio=" + domicilio + ", estado=" + estado + "]";
	}

}
