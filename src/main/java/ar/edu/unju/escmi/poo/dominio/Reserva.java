package ar.edu.unju.escmi.poo.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
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
	private LocalDate fecha;
	private LocalTime hora;

	// relationships
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "nombre_salon")
	private Salon salon;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "dni_mozo")
	private Mozo mozo;

	// METODOS CONSTRUCTORES

	public Reserva() {
	}

	public Reserva(int comensales, int mesas, Float total, boolean estado, LocalDate fecha, LocalTime hora,
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

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
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
				+ total + ", estado=" + (estado == true ? "Pagado" : "Sin Pagar") + ", fecha=" + fecha + ", hora="
				+ hora + ", cliente= " + cliente.getNombre() + ", salon= " + salon.getNombre() + ", mozo= "
				+ mozo.getNombre() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + comensales;
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + idReserva;
		result = prime * result + mesas;
		result = prime * result + ((mozo == null) ? 0 : mozo.hashCode());
		result = prime * result + ((salon == null) ? 0 : salon.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Reserva)) {
			return false;
		}
		Reserva other = (Reserva) obj;
		if (cliente == null) {
			if (other.cliente != null) {
				return false;
			}
		} else if (!cliente.equals(other.cliente)) {
			return false;
		}
		if (comensales != other.comensales) {
			return false;
		}
		if (estado != other.estado) {
			return false;
		}
		if (fecha == null) {
			if (other.fecha != null) {
				return false;
			}
		} else if (!fecha.equals(other.fecha)) {
			return false;
		}
		if (hora == null) {
			if (other.hora != null) {
				return false;
			}
		} else if (!hora.equals(other.hora)) {
			return false;
		}
		if (idReserva != other.idReserva) {
			return false;
		}
		if (mesas != other.mesas) {
			return false;
		}
		if (mozo == null) {
			if (other.mozo != null) {
				return false;
			}
		} else if (!mozo.equals(other.mozo)) {
			return false;
		}
		if (salon == null) {
			if (other.salon != null) {
				return false;
			}
		} else if (!salon.equals(other.salon)) {
			return false;
		}
		if (total == null) {
			if (other.total != null) {
				return false;
			}
		} else if (!total.equals(other.total)) {
			return false;
		}
		return true;
	}

}