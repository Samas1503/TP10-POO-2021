package ar.edu.unju.escmi.poo.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.poo.dao.imp.ReservaDaoImp;
import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class ReservaUtil {
    ReservaDaoImp reservaDao = new ReservaDaoImp();

    public void crearReserva(int comensales, int mesas, float total, boolean estado, LocalDate fecha, LocalDate hora,
            Cliente cliente, Salon salon, Mozo mozo) {
        Reserva nueva = new Reserva(comensales, mesas, total, estado, fecha, hora, cliente, salon, mozo);
        reservaDao.guardarReserva(nueva);
    }

    public void mostrarReservas() {
        List<Reserva> lista = new ArrayList<Reserva>();
        lista = reservaDao.obtenerReservas();
        for (Reserva r : lista) {
            System.out.println(r.toString());
        }
    }

    public List<Reserva> obtenerReservas() {
        return reservaDao.obtenerReservas();
    }

    public Reserva buscarReserva(int id) {
        return reservaDao.obtenerReserva(id);
    }

    public void modificarReserva(Reserva aModificar) {
        aModificar.setEstado(true);
        aModificar.getSalon().setMesas(aModificar.getSalon().getMesas() + aModificar.getMesas());
        aModificar.setMesas(0);
        aModificar.getMozo().setEstado(true);
        aModificar.setTotal((float) 0);
    }
}
