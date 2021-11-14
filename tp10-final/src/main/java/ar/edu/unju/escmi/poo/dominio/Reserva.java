package ar.edu.unju.escmi.poo.dominio;

import java.time.LocalDate;

public class Reserva {
    private int idReserva = 0;
    private Cliente cliente;
    private int comensales;
    private LocalDate fecha;
    private int mesas;
    private float total;
    private boolean estado;

    public Reserva() {
    }

    public Reserva(int idReserva, Cliente cliente, int comensales, LocalDate fecha, int mesas, float total,
            boolean estado) {
        this.idReserva = idReserva++;
        this.cliente = cliente;
        this.comensales = comensales;
        this.fecha = fecha;
        this.mesas = mesas;
        this.total = total;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getComensales() {
        return comensales;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getMesas() {
        return mesas;
    }

    public void setMesas(int mesas) {
        this.mesas = mesas;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva [" + "idReserva=" + idReserva + (cliente != null ? "cliente=" + cliente + ", " : "")
                + "comensales=" + comensales + ", estado=" + estado + ", "
                + (fecha != null ? "fecha=" + fecha + ", " : "") + ", mesas=" + mesas + ", total=" + total + "]";
    }

}
