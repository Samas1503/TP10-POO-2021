package ar.edu.unju.escmi.poo.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.poo.dao.imp.SalonDaoImp;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class SalonUtil {
    SalonDaoImp salonDao = new SalonDaoImp();

    public void crearSalon(String nombre, int mesas) {
        Salon nuevo = new Salon(nombre, mesas);
        salonDao.guardarSalon(nuevo);
    }

    public Salon buscarSalon(String nombre) {
        return salonDao.obtenerSalon(nombre);
    }

    public void mostrarSalones() {
        List<Salon> lista = new ArrayList<Salon>();
        lista = salonDao.obtenerSalones();
        for (Salon s : lista) {
            System.out.println(s.toString());
        }
    }

    public List<Salon> obtenerSalones() {
        return salonDao.obtenerSalones();
    }

    public int mesasLibres(Salon salon) {
        return salon.getMesas();
    }
}
