package ar.edu.unju.escmi.poo.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.dao.imp.ReservaDaoImp;
import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class ReservaUtil {
    ReservaDaoImp reservaDao = new ReservaDaoImp();
    SalonUtil salonUtil = new SalonUtil();
    MozoUtil mozoUtil = new MozoUtil();
    ClienteUtil clienteUtil = new ClienteUtil();
    Scanner sc = new Scanner(System.in);

    public void precargarReservas() {
        Cliente cliente;
        Salon salon;
        Mozo mozo;
        LocalDate fecha = LocalDate.now();
        LocalTime hota = LocalTime.now();
        int comensales;
        int mesas;
        float total;

        // *Precarga de Reservas Particulares

        comensales = 6;
        if (comensales % 4 == 0)
            mesas = comensales / 4;
        else
            mesas = (comensales / 4) + 1;
        total = mesas * 50;
        cliente = clienteUtil.obtenerParticular(44706400);
        salon = salonUtil.obtenerSalon("Salon de Mayko");
        mozo = mozoUtil.obtenerMozo(15684892);
        mozo.setEstado(false);
        crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);

        comensales = 2;
        if (comensales % 4 == 0)
            mesas = comensales / 4;
        else
            mesas = (comensales / 4) + 1;
        total = mesas * 50;
        cliente = clienteUtil.obtenerParticular(44700523);
        salon = salonUtil.obtenerSalon("Salon de Samuel");
        mozo = mozoUtil.obtenerMozo(35489120);
        mozo.setEstado(false);
        crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);

        // *Precarga de Reservas de Empresas

        comensales = 20;
        if (comensales % 4 == 0)
            mesas = comensales / 4;
        else
            mesas = (comensales / 4) + 1;
        total = mesas * 50;
        cliente = clienteUtil.obtenerEmpresa(123456789);
        salon = salonUtil.obtenerSalon("Salon de Santy");
        mozo = mozoUtil.obtenerMozo(32654781);
        mozo.setEstado(false);
        crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);

        comensales = 30;
        if (comensales % 4 == 0)
            mesas = comensales / 4;
        else
            mesas = (comensales / 4) + 1;
        total = mesas * 50;
        cliente = clienteUtil.obtenerEmpresa(789456132);
        salon = salonUtil.obtenerSalon("Salon de Mayko");
        mozo = mozoUtil.obtenerMozo(23549842);
        mozo.setEstado(false);
        crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);
    }

    public void generarReserva(Cliente cliente) {
        String nombre;
        float total = 0;
        int comensales, mesas, horas, minutos, id;
        boolean valido = false;
        LocalDate fecha = LocalDate.now();
        Salon salon = null;
        Mozo mozo = null;

        System.out.println("Ingrese el numero de comensales:");
        comensales = sc.nextInt();

        if (comensales % 4 == 0)
            mesas = comensales / 4;
        else
            mesas = (comensales / 4) + 1;
        total = mesas * 50;
        try {
            salonUtil.mostrarSalonesDisponibles(mesas);
            do {
                try {
                    System.out.println("Ingrese el nombre del salon del cual desea reservar.");
                    nombre = sc.nextLine();
                    sc.next();
                    salon = salonUtil.obtenerSalon(nombre);
                    if (salon != null)
                        valido = true;
                } catch (Exception e) {
                    System.out.println("Salon no encontrado. Intente nuevamente.");
                    valido = false;
                }
            } while (salon == null);

            System.out.println("Ingrese la hora y minutos de la resera:");
            System.out.println("Hora:");
            horas = sc.nextInt();
            System.out.println("Minutos:");
            minutos = sc.nextInt();
            LocalTime hora = LocalTime.of(horas, minutos);

            mozoUtil.mostrarMozos();
            do {
                try {
                    System.out.println("Ingrese el id del mozo que atendera la reserva:");
                    id = sc.nextInt();
                    mozo = mozoUtil.obtenerMozo(id);
                    if (mozo != null) {
                        valido = true;
                        mozo.setEstado(false);
                    }
                } catch (Exception e) {
                    System.out.println("Mozo no encontrado. Intente nuevamente.");
                    valido = false;
                }
            } while (!valido);

            crearReserva(comensales, mesas, total, false, fecha, hora, cliente, salon, mozo);

        } catch (Exception e) {
            System.out.println("No es posible registrar la reserva");
        }
    }

    public void crearReserva(int comensales, int mesas, Float total, boolean estado, LocalDate fecha, LocalTime hora,
            Cliente cliente, Salon salon, Mozo mozo) {
        Reserva nueva = new Reserva(comensales, mesas, total, false, fecha, hora, cliente, salon, mozo);
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

    public Reserva obtenerReserva(int id) {
        return reservaDao.obtenerReserva(id);
    }

    public void modificarReserva(Reserva aModificar) {
        aModificar.setEstado(true);
        aModificar.getSalon().setMesas(aModificar.getSalon().getMesas() + aModificar.getMesas());
        aModificar.setMesas(0);
        aModificar.getMozo().setEstado(true);
        aModificar.setTotal((float) 0);
    }

    public void eliminarReserva(Reserva aEliminar) {
        reservaDao.eliminarReserva(aEliminar);
    }
}
