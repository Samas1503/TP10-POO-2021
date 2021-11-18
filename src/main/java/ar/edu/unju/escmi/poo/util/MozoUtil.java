package ar.edu.unju.escmi.poo.util;

import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.dao.imp.MozoDaoImp;
import ar.edu.unju.escmi.poo.dominio.Mozo;

public class MozoUtil {
    Scanner sc = new Scanner(System.in);
    static MozoDaoImp mozoDao = new MozoDaoImp();

    public static void precargarMozos() {
        crearMozo(1, "Jarvis", "mi casa 18");
        crearMozo(2, "Ana", "mi casa 38");
        crearMozo(3, "Maria", "mi casa 58");
        crearMozo(4, "Eliot", "mi casa 78");
        crearMozo(5, "Juan", "mi casa 98");
    }

    public static void crearMozo(int dni, String nombre, String domicilio) {
        Mozo nuevo = new Mozo(dni, nombre, domicilio, true);
        mozoDao.guardarMozo(nuevo);
    }

    public static void mostrarMozos() {
        List<Mozo> lista = mozoDao.obtenerMozos();
        if (!lista.isEmpty())
            for (Mozo m : lista)
                System.out.println(m.toString());
        else
            System.out.println("No hay Mozos Registrados.");
    }

    public static List<Mozo> obtenerMozos() {
        return mozoDao.obtenerMozos();
    }

    public static Mozo obtenerMozo(int dni) {
        return mozoDao.obtenerMozo(dni);
    }

    public static void modificarMozo(Mozo mozo) {
        mozoDao.modificarMozo(mozo);
    }

    public static Mozo obtenerUnLibre() {
        return mozoDao.obtenerDisponible();
    }
}
