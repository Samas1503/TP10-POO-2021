package ar.edu.unju.escmi.poo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.dao.imp.MozoDaoImp;
import ar.edu.unju.escmi.poo.dominio.Mozo;

public class MozoUtil {
    Scanner sc = new Scanner(System.in);
    MozoDaoImp mozoDao = new MozoDaoImp();

    public void crearMozo(int dni, String nombre, String domicilio) {
        Mozo nuevo = new Mozo(dni, nombre, domicilio, true);
        mozoDao.guardarMozo(nuevo);
    }

    public void mostrarMozos() {
        List<Mozo> lista = new ArrayList<Mozo>();
        lista = mozoDao.obtenerMozos();
        for (Mozo m : lista) {
            System.out.println(m.toString());
        }
    }

    public List<Mozo> obtenerMozos() {
        return mozoDao.obtenerMozos();
    }

    public void buscarMozo() {
        int dni = 0;
        boolean valido = true;
        do {
            System.out.println("Ingrese el DNI del mozo que desea buscar:");
            try {
                dni = sc.nextInt();
                valido = false;
            } catch (Exception e) {
                System.out.println("Ingreso incorrecto, intente nuevamente.");
                valido = true;
            }
        } while (valido);
        Mozo buscado = mozoDao.obtenerMozo(dni);
        if (buscado != null)
            System.out.println(buscado.toString());
        else
            System.out.println("Mozo no encontrado.");
    }
}
