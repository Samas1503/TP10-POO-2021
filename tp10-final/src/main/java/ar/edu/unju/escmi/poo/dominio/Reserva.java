package ar.edu.unju.escmi.poo.dominio;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReserva;

	@Column
	private int comensales, mesas;

	@Column
	private Float total;
	@Column
	private boolean estado;
	@Column
	private LocalDate fecha, hora;

	// relationships
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nombre_salon")
	private Salon salon;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dni_mozo")
	private Mozo mozo;

	// METODOS CONSTRUCTORES

	public Reserva() {
	}

	public Reserva(int comensales, int mesas, Float total, boolean estado, LocalDate fecha, LocalDate hora,
			Cliente cliente, Salon salon, Mozo mozo) {
		this.comensales = comensales;
		this.mesas = mesas;
		this.total = total;
		this.estado = estado;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
		this.salon = salon;
		this.mozo = mozo;
	}

	// GETTERS Y SETTERS
	public int getIdreserva() {
		return idReserva;
	}

	public void setIdreserva(int idreserva) {
		this.idReserva = idreserva;
	}

	public int getComensales() {
		return comensales;
	}

	public void setComensales(int comensales) {
		this.comensales = comensales;
	}

	public int getMesas() {
		return mesas;
	}

	public void setMesas(int mesas) {
		this.mesas = mesas;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalDate getHora() {
		return hora;
	}

	public void setHora(LocalDate hora) {
		this.hora = hora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	@Override
	public String toString() {
		return "Reserva [idreserva=" + idReserva + ", comensales=" + comensales + ", mesas=" + mesas + ", total="
				+ total + ", estado=" + estado + ", fecha=" + fecha + ", hora=" + hora + ", cliente=" + cliente + "]";
	}

}