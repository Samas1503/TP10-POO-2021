package ar.edu.unju.escmi.poo.dominio;

import java.time.LocalDate;

public class Reserva {
	private int idreserva,comensales,mesas;
	private Float total ;
	private boolean estado;
	private LocalDate fecha,hora;
	private Cliente cliente;
	private Salon salon;
	private Mozo mozo;
	
	//METODOS CONSTRUCTORES	
	
	public Reserva() {
	}

	public Reserva(int idreserva, int comensales, int mesas, Float total, boolean estado, LocalDate fecha,
			LocalDate hora, Cliente cliente, Salon salon, Mozo mozo) {
		super();
		this.idreserva = idreserva;
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
	
	//GETTERS Y SETTERS
	public int getIdreserva() {
		return idreserva;
	}
	
	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
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
		return "Reserva [idreserva=" + idreserva + ", comensales=" + comensales + ", mesas=" + mesas + ", total="
				+ total + ", estado=" + estado + ", fecha=" + fecha + ", hora=" + hora + ", cliente=" + cliente + "]";
	}

}
