package ar.edu.unju.escmi.poo.util;

import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.dao.imp.MozoDaoImp;
import ar.edu.unju.escmi.poo.dominio.Mozo;

public class MozoUtil {
    Scanner sc = new Scanner(System.in);
    static MozoDaoImp mozoDao = new MozoDaoImp();

    public void precargarMozos() {
        crearMozo(23549842, "Jarvis", "mi casa 18");
        crearMozo(15684892, "Ana", "mi casa 38");
        crearMozo(35489120, "Maria", "mi casa 58");
        crearMozo(40654873, "Eliot", "mi casa 78");
        crearMozo(20174689, "Juan", "mi casa 98");
        crearMozo(32654781, "Pedro", "mi casa 28");
        crearMozo(35548951, "Manuela", "mi casa 48");
    }

    public void crearMozo(int dni, String nombre, String domicilio) {
        Mozo nuevo = new Mozo(dni, nombre, domicilio, true);
        mozoDao.guardarMozo(nuevo);
    }

    public void mostrarMozos() {
        List<Mozo> lista = mozoDao.obtenerMozos();
        for (Mozo m : lista)
            System.out.println(m.toString());

    }

    public List<Mozo> obtenerMozos() {
        return mozoDao.obtenerMozos();
    }

    public static Mozo obtenerMozo(int dni) {
        return mozoDao.obtenerMozo(dni);
    }
}
