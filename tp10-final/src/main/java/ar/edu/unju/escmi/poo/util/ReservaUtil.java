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
	static Scanner sc = new Scanner(System.in);

	public static void precargarReservas() {
		// variables
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
		mesas = 2;
		total = mesas * 50;
		cliente = ClienteUtil.obtenerParticular(1);
		salon = SalonUtil.obtenerSalon("Salon de Mayko");
		salon.setMesas(salon.getMesas() - mesas);
		mozo = MozoUtil.obtenerMozo(1);
		mozo.setEstado(false);
		SalonUtil.modificarSalon(salon);
		MozoUtil.modificarMozo(mozo);
		crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);

		comensales = 2;
		mesas = 1;
		total = mesas * 50;
		cliente = ClienteUtil.obtenerParticular(2);
		salon = SalonUtil.obtenerSalon("Salon de Samuel");
		salon.setMesas(salon.getMesas() - mesas);
		mozo = MozoUtil.obtenerMozo(2);
		mozo.setEstado(false);
		SalonUtil.modificarSalon(salon);
		MozoUtil.modificarMozo(mozo);
		crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);

		// *Precarga de Reservas de Empresas

		comensales = 20;
		mesas = 5;
		total = mesas * 50;
		cliente = ClienteUtil.obtenerEmpresa(7);
		salon = SalonUtil.obtenerSalon("Salon de Santy");
		salon.setMesas(salon.getMesas() - mesas);
		mozo = MozoUtil.obtenerMozo(3);
		mozo.setEstado(false);
		SalonUtil.modificarSalon(salon);
		MozoUtil.modificarMozo(mozo);
		crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);

		comensales = 30;
		mesas = 8;
		total = mesas * 50;
		cliente = ClienteUtil.obtenerEmpresa(6);
		salon = SalonUtil.obtenerSalon("Salon de Mayko");
		salon.setMesas(salon.getMesas() - mesas);
		mozo = MozoUtil.obtenerMozo(4);
		mozo.setEstado(false);
		SalonUtil.modificarSalon(salon);
		MozoUtil.modificarMozo(mozo);
		crearReserva(comensales, mesas, total, false, fecha, hota, cliente, salon, mozo);
	}

	public static void generarReserva(Cliente cliente) throws Exception {
		if (cliente == null)
			throw new NullPointerException();
		String nombre;
		float total = 0;
		int comensales = 0, mesas;
		boolean valido = false;
		LocalDate fecha = LocalDate.now();
		Salon salon = null;
		Mozo mozo = MozoUtil.obtenerUnLibre();

		// ingreso de comensales y asignacion de mesas
		do {
			try {
				System.out.println("Ingrese el numero de comensales:");
				comensales = Integer.parseInt(sc.nextLine());
				valido = false;
			} catch (Exception e) {
				System.out.println("Debe ingresar un numero");
				valido = true;
			}
		} while (valido);

		if (comensales % 4 == 0)
			mesas = comensales / 4;
		else
			mesas = (comensales / 4) + 1;
		total = mesas * 50;

		// se muestran los salones disponibles, en caso de que no se termina el metodo

		if (!SalonUtil.mostrarSalonesDisponibles(mesas)) {
			System.out.println("no hay salones con suficientes mesas");
			return;
		}

		// se ingresa el salon para la reserva
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
		// se guardan los cambios del salon seleccionado en la base de datos
		SalonUtil.modificarSalon(salon);

		// se ingresa el horario
		LocalTime hora = null;
		do {
			try {
				String input;
				System.out.print("Ingrese la hora y los minutos(hh:mm): ");
				input = sc.nextLine();
				hora = LocalTime.parse(input);

			} catch (Exception e) {
				System.out.println("Ingreso incorrecto. Ingrese de nuevo");
			}
		} while (hora == null);

		// actualizamos el estado del mozo en la base de datos
		mozo.setEstado(false);
		MozoUtil.modificarMozo(mozo);

		// creamos la reserva
		crearReserva(comensales, mesas, total, false, fecha, hora, cliente, salon, mozo);

	}

	public static void crearReserva(int comensales, int mesas, Float total, boolean estado, LocalDate fecha,
			LocalTime hora, Cliente cliente, Salon salon, Mozo mozo) {
		Reserva nueva = new Reserva(comensales, mesas, total, false, fecha, hora, cliente, salon, mozo);
		reservaDao.guardarReserva(nueva);
	}

	public static void mostrarReservas() throws Exception {
		List<Reserva> lista = new ArrayList<Reserva>();
		lista = reservaDao.obtenerReservas();
		if (lista.isEmpty() || lista == null)
			throw new NullPointerException();

		lista.stream().forEach(System.out::println);
	}

	public static void mostrarReservasPendientes() throws Exception {
		List<Reserva> lista = new ArrayList<Reserva>();
		lista = reservaDao.obtenerReservas();
		if (lista.isEmpty())
			throw new NullPointerException();
		lista.stream().filter(n -> n.getEstado() == false).forEach(System.out::println);
	}

	public static List<Reserva> obtenerReservas() {
		return reservaDao.obtenerReservas();
	}

	public static Reserva obtenerReserva(int id) {
		return reservaDao.obtenerReserva(id);
	}

	public static void finalizarReserva(Reserva aModificar) {
		// se modifica el estado de la reserva
		aModificar.setEstado(true);
		// se actualiza la cantidad de mesas disponibles del salon
		aModificar.getSalon().setMesas(aModificar.getSalon().getMesas() + aModificar.getMesas());
		// se cambia el valor de las mesas a 0
		aModificar.setMesas(0);
		// se actualiza el estado del mozo
		aModificar.getMozo().setEstado(true);

		String res;
		int consumido = 0;

		// solicitamos el ingreso del monto a pagar por la comida
		do {
			System.out.println("Ingrese el monto de lo consumido en la reserva:");
			res = sc.nextLine();
			try {
				consumido = Integer.parseInt(res);
			} catch (Exception e) {
				System.out.println("Debe ingresar un numero");
			}
		} while (consumido == 0);

		// se modifica y guarda el valor del monto a pagar en la base de datos
		aModificar.setTotal(aModificar.getTotal() + consumido);
		reservaDao.modificarReserva(aModificar);
	}

	public static void eliminarReserva(Reserva aEliminar) {
		// actualizamos las mesas del salon
		aEliminar.getSalon().setMesas(aEliminar.getSalon().getMesas() + aEliminar.getMesas());
		// actualizamos el estado del mozo
		aEliminar.getMozo().setEstado(true);
		// se actualiza el salon y el mozo en la base de datos
		SalonUtil.modificarSalon(aEliminar.getSalon());
		MozoUtil.modificarMozo(aEliminar.getMozo());

		// se elimina la reserva de la base de datos
		reservaDao.eliminarReserva(aEliminar);
	}
}
