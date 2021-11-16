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
    static ReservaDaoImp reservaDao = new ReservaDaoImp();
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
        cliente = ClienteUtil.obtenerParticular(44706400);
        salon = SalonUtil.obtenerSalon("Salon de Mayko");
        salon.setMesas(salon.getMesas() - mesas);
        mozo = MozoUtil.obtenerMozo(15684892);
        mozo.setEstado(false);
        SalonUtil.modificarSalon(salon);
        MozoUtil.modificarMozo(mozo);
        crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);

        comensales = 2;
        if (comensales % 4 == 0)
            mesas = comensales / 4;
        else
            mesas = (comensales / 4) + 1;
        total = mesas * 50;
        cliente = ClienteUtil.obtenerParticular(44700523);
        salon = SalonUtil.obtenerSalon("Salon de Samuel");
        salon.setMesas(salon.getMesas() - mesas);
        mozo = MozoUtil.obtenerMozo(35489120);
        mozo.setEstado(false);
        SalonUtil.modificarSalon(salon);
        MozoUtil.modificarMozo(mozo);
        crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);

        // *Precarga de Reservas de Empresas

        comensales = 20;
        if (comensales % 4 == 0)
            mesas = comensales / 4;
        else
            mesas = (comensales / 4) + 1;
        total = mesas * 50;
        cliente = ClienteUtil.obtenerEmpresa(123456789);
        salon = SalonUtil.obtenerSalon("Salon de Santy");
        salon.setMesas(salon.getMesas() - mesas);
        mozo = MozoUtil.obtenerMozo(32654781);
        mozo.setEstado(false);
        SalonUtil.modificarSalon(salon);
        MozoUtil.modificarMozo(mozo);
        crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);

        comensales = 30;
        if (comensales % 4 == 0)
            mesas = comensales / 4;
        else
            mesas = (comensales / 4) + 1;
        total = mesas * 50;
        cliente = ClienteUtil.obtenerEmpresa(789456132);
        salon = SalonUtil.obtenerSalon("Salon de Mayko");
        salon.setMesas(salon.getMesas() - mesas);
        mozo = MozoUtil.obtenerMozo(23549842);
        mozo.setEstado(false);
        SalonUtil.modificarSalon(salon);
        MozoUtil.modificarMozo(mozo);
        crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);
    }

    public void generarReserva(Cliente cliente) throws Exception {
        if (cliente == null)
            throw new NullPointerException();
        String nombre, horario;
        float total = 0;
        int comensales, mesas, horas = -1, minutos = -1, id;
        boolean valido = false;
        LocalDate fecha = LocalDate.now();
        Salon salon = null;
        Mozo mozo = null;

        System.out.println("Ingrese el numero de comensales:");
        comensales = sc.nextInt();
        sc.nextLine();

        if (comensales % 4 == 0)
            mesas = comensales / 4;
        else
            mesas = (comensales / 4) + 1;
        total = mesas * 50;
        try {
            SalonUtil.mostrarSalonesDisponibles(mesas);
            do {
                try {
                    System.out.println("Ingrese el nombre del salon del cual desea reservar.");
                    nombre = sc.nextLine();
                    salon = SalonUtil.obtenerSalon(nombre);
                    if (salon != null) {
                        valido = true;
                        salon.setMesas(salon.getMesas() - mesas);
                    }
                } catch (Exception e) {
                    System.out.println("Salon no encontrado. Intente nuevamente.");
                    valido = false;
                }
            } while (!valido);
            SalonUtil.modificarSalon(salon);
            do {
                System.out.println("Ingrese la hora y minutos de la resera (hh:mm)");
                horario = sc.next();
                String[] valoresH = horario.split(":");
                if (valoresH.length == 2) {
                    horas = Integer.parseInt(valoresH[0]);
                    if (horas < 0 || horas > 23) {
                        horas = -1;
                        System.out.println("Ingreso incorrecto. Intente nuevamente.");
                    }
                    minutos = Integer.parseInt(valoresH[1]);
                    if (minutos < 0 || minutos > 59) {
                        minutos = -1;
                        System.out.println("Ingreso incorrecto. Intente nuevamente.");
                    }
                } else {
                    System.out.println("Ingreso incorrecto. Intente nuevamente.");
                }
            } while (horas == -1 || minutos == -1);
            LocalTime hora = LocalTime.of(horas, minutos);

            mozoUtil.mostrarMozos();
            do {
                try {
                    System.out.println("Ingrese el id del mozo que atendera la reserva:");
                    id = sc.nextInt();
                    mozo = MozoUtil.obtenerMozo(id);
                    if (mozo != null) {
                        valido = true;
                        mozo.setEstado(false);
                    }
                } catch (Exception e) {
                    System.out.println("Mozo no encontrado. Intente nuevamente.");
                    valido = false;
                }
            } while (!valido);
            MozoUtil.modificarMozo(mozo);
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

    public void mostrarReservas() throws Exception {
        List<Reserva> lista = new ArrayList<Reserva>();
        lista = reservaDao.obtenerReservas();
        if (lista.isEmpty())
            throw new NullPointerException();
        for (Reserva r : lista) {
            System.out.println(r.toString());
        }
    }

    public void mostrarReservasPendientes() throws Exception {
        List<Reserva> lista = new ArrayList<Reserva>();
        lista = reservaDao.obtenerReservas();
        if (lista.isEmpty())
            throw new NullPointerException();
        for (Reserva r : lista) {
            if (!r.getEstado())
                System.out.println(r.toString());
        }
    }

    public static List<Reserva> obtenerReservas() {
        return reservaDao.obtenerReservas();
    }

    public static Reserva obtenerReserva(int id) {
        return reservaDao.obtenerReserva(id);
    }

    public void modificarReserva(Reserva aModificar) {
        aModificar.setEstado(true);
        aModificar.getSalon().setMesas(aModificar.getSalon().getMesas() + aModificar.getMesas());
        aModificar.setMesas(0);
        aModificar.getMozo().setEstado(true);
        String res;
        int consumido = 0;
        do {
            System.out.println("Ingrese el monto de lo consumido en la reserva:");
            res = sc.next();
            try {
                consumido = Integer.parseInt(res);
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero");
            }
        } while (consumido == 0);
        aModificar.setTotal(aModificar.getTotal() + consumido);

        reservaDao.modificarReserva(aModificar);
    }

    public void eliminarReserva(Reserva aEliminar) {
        aEliminar.getSalon().setMesas(aEliminar.getSalon().getMesas() + aEliminar.getMesas());
        aEliminar.getMozo().setEstado(true);
        SalonUtil.modificarSalon(aEliminar.getSalon());
        MozoUtil.modificarMozo(aEliminar.getMozo());

        reservaDao.eliminarReserva(aEliminar);
    }
}
