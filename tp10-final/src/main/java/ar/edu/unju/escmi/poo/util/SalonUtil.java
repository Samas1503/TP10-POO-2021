package ar.edu.unju.escmi.poo.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.poo.dao.imp.SalonDaoImp;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class SalonUtil {
    SalonDaoImp salonDao = new SalonDaoImp();
    ReservaUtil reservaUtil;

    public void pregargarSalones() {
        crearSalon("Salon de Mayko", 20);
        crearSalon("Salon de Santy", 10);
        crearSalon("Salon de Samuel", 15);
    }

    public void crearSalon(String nombre, int mesas) {
        Salon nuevo = new Salon(nombre, mesas);
        salonDao.guardarSalon(nuevo);
    }

    public Salon obtenerSalon(String nombre) {
        return salonDao.obtenerSalon(nombre);
    }

    public boolean verificarSalon(String nombre) {
        try {
            Salon buscado = salonDao.obtenerSalon(nombre);
            if (buscado.getNombre().equals(nombre))
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void mostrarSalones() {
        List<Salon> lista = new ArrayList<Salon>();
        lista = salonDao.obtenerSalones();
        for (Salon s : lista)
            System.out.println(s.toString());
    }

    public void mostrarSalonesDisponibles(int m) {
        List<Salon> lista = new ArrayList<Salon>();
        lista = salonDao.obtenerSalones();
        for (Salon s : lista) {
            if (s.getMesas() < m)
                lista.remove(s);
        }
    }

    public List<Salon> obtenerSalones() {
        return salonDao.obtenerSalones();
    }

    public int obtenerMesasLibres(Salon salon) {
        return salon.getMesas();
    }

    public int obtenerMesasOcupadas(String n) {
        int m = 0;
        List<Reserva> reservas = reservaUtil.obtenerReservas();
        for (Reserva r : reservas)
            if (r.getSalon().getNombre().equals(n))
                m += r.getMesas();
        return m;
    }

    public int obtenerComensales(String n) {
        int c = 0;
        List<Reserva> reservas = reservaUtil.obtenerReservas();
        for (Reserva r : reservas)
            if (r.getSalon().getNombre().equals(n))
                c += r.getComensales();
        return c;
    }
}
