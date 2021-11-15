package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Cliente {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String nombre, email;
	@Column
	private int telefono;

	// METODOS CONSTRUCTORES

	public Cliente() {
	}

	public Cliente(String nombre, String email, int telefono) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	// METODO GETTERS Y SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	// METODO ToString

	@Override
	public String toString() {
		return ", Nombre=" + nombre + ", Email=" + email + ", Telefono=" + telefono + "]";
	}

	public Reserva hacerReserva() {
		return null;
	}

	public void pagarReserva() {

	}

}
