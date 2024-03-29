package ar.edu.unju.escmi.poo.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.poo.dao.imp.SalonDaoImp;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class SalonUtil {
    static SalonDaoImp salonDao = new SalonDaoImp();

    public static void pregargarSalones() {
        crearSalon("Salon de Mayko", 20);
        crearSalon("Salon de Santy", 10);
        crearSalon("Salon de Samuel", 15);
    }

    public static void crearSalon(String nombre, int mesas) {
        Salon nuevo = new Salon(nombre, mesas);
        salonDao.guardarSalon(nuevo);
    }

    public static Salon obtenerSalon(String nombre) {
        return salonDao.obtenerSalon(nombre);
    }

    public static boolean verificarSalon(String nombre) {
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

    public void mostrarSalones() throws Exception {
        List<Salon> lista = new ArrayList<Salon>();
        lista = salonDao.obtenerSalones();
        if (lista.isEmpty())
            throw new NullPointerException();
        for (Salon s : lista)
            System.out.println(s.toString());
    }

    
    public static boolean mostrarSalonesDisponibles(int m) {
        List<Salon> lista = new ArrayList<Salon>();
        lista = salonDao.obtenerSalonesDisponibles(m);
        if(!lista.isEmpty()) {
        	lista.stream().forEach(n -> System.out.println(n.getNombre()));
        	return true;
        }	
        else
        	return false;
        
    }

    public static List<Salon> obtenerSalones() {
        return salonDao.obtenerSalones();
    }

    public static int obtenerMesasLibres(Salon salon) {
        return salon.getMesas();
    }

    public static int obtenerMesasOcupadas(String n) {
        int m = 0;
        List<Reserva> reservas = ReservaUtil.obtenerReservas();
        for (Reserva r : reservas)
            if (r.getSalon().getNombre().equals(n))
                m += r.getMesas();
        return m;
    }

    public static int obtenerComensales(String n) {
        int c = 0;
        List<Reserva> reservas = ReservaUtil.obtenerReservas();
        for (Reserva r : reservas)
            if (r.getSalon().getNombre().equals(n)) {
            	if(r.getEstado() == false)
            		c += r.getComensales();
            }
            	
        return c;
    }

    public static void modificarSalon(Salon salon) {
        salonDao.modificarSalon(salon);
    }

}
