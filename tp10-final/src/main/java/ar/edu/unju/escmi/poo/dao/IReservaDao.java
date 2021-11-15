package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Reserva;

public interface IReservaDao {
    
    public void guardarReserva(Reserva nueva);
    public List<Reserva> obtenerReservas();
    public Reserva obtenerReserva(int id);
}
