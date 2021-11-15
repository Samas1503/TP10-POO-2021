package ar.edu.unju.escmi.poo.util;

import java.util.Scanner;

import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class MenuUtil {
    public void menu() {
        Scanner sc = new Scanner(System.in);
        MozoUtil mozoUtil = new MozoUtil();
        SalonUtil salonUtil = new SalonUtil();
        ReservaUtil reservaUtil = new ReservaUtil();
        ClienteUtil clienteUtil = new ClienteUtil();
        int telefono, comensales, mesas, op = -1, id = 0;
        String nombre, domicilio, email, r = "";
        boolean valido = true;
        do {
            System.out.println("***********************************************************************");
            System.out.println("*                                MENU                                 *");
            System.out.println("***********************************************************************");
            System.out.println("*    1- Alta Mozo                                                     *");
            System.out.println("*    2- Listado Mozos                                                 *");
            System.out.println("*    3- Consultar Mesas Disponibles de un Salon.                      *");
            System.out.println("*    4- Consultar Mesas Ocupadas Mostrando la Cantidad de Comensales. *");
            System.out.println("*    5- Alta de una Reserva.                                          *");
            System.out.println("*    6- Finalizar Reserva.                                            *");
            System.out.println("*    7- Consultar Cliente.                                            *");
            System.out.println("*    8- Listar Reservas.                                              *");
            System.out.println("*    9- Eliminar Reserva.					                         *");
            System.out.println("***********************************************************************");
            System.out.println("*                              0- Salir.                              *");
            System.out.println("***********************************************************************");
            op = sc.nextInt(); 
            switch (op) {
            case 0:
                System.out.println("Saliendo del programa");
                break;
            case 1:
                do {
                    System.out.println("Ingrese el DNI del mozo:");
                    try {
                        id = sc.nextInt();
                        valido = false;
                    } catch (Exception e) {
                        System.out.println("Ingreso incorrecto, intente nuevamente.");
                        valido = true;
                    }
                } while (valido);
                System.out.println("Ingrse el Nombre del mozo:");
                nombre = sc.nextLine();
                sc.next();
                System.out.println("Ingrse el Domicilio del mozo:");
                domicilio = sc.nextLine();
                mozoUtil.crearMozo(id, nombre, domicilio);
                break;
            case 2:
                mozoUtil.mostrarMozos();
                break;
            case 3:
                try {
                    salonUtil.mostrarSalones();
                    System.out.println("Ingrese el nombre del salon al que desea consultar.");
                    nombre = sc.nextLine();
                    sc.next();
                    Salon buscado = SalonUtil.obtenerSalon(nombre);
                    salonUtil.obtenerMesasLibres(buscado);
                } catch (Exception e) {
                    System.out.println("No hay Salones Registrados");
                }
                break;
            case 4:
                try {
                    do {
                        salonUtil.mostrarSalones();
                        System.out.println("Ingrese el nombre del salon al que desea consultar.");
                        nombre = sc.nextLine();
                        sc.next();
                        if (salonUtil.verificarSalon(nombre)) {
                            mesas = salonUtil.obtenerMesasOcupadas(nombre);
                            comensales = salonUtil.obtenerComensales(nombre);
                            System.out.println("El salon " + nombre + " tiene " + mesas + " ocupadas con " + comensales
                                    + " comensales.");
                        } else {
                            System.out.println("El salon ingresado no existe. Desea intentar nuevamente? [si/no]");
                            r = sc.nextLine();
                            sc.next();
                        }
                    } while (r.equals("si"));
                } catch (Exception e) {
                    System.out.println("No hay Salones Registrados");
                }
                break;
            case 5:
                try {
                    System.out.println("Ingrese el DNI o CUIT del Cliente:");
                    id = sc.nextInt();
                    try {
                        Cliente particular = clienteUtil.obtenerParticular(id);
                        System.out.println("Cliente encontrado. Ingrese los datos de la reserva.");
                        reservaUtil.generarReserva(particular);
                    } catch (Exception e) {
                        try {
                            Cliente empresa = clienteUtil.obtenerEmpresa(id);
                            System.out.println("Cliente encontrado. Ingrese los datos de la reserva.");
                            reservaUtil.generarReserva(empresa);
                        } catch (Exception f) {
                            System.out.println("Cliente no encontrado. Se registrara un cliente nuevo.");
                            do {
                                System.out.println("El cliente es particular o empresa?");
                                r = sc.next();
                            } while (!r.equals("particular") || !r.equals("empresa"));
                            System.out.println("Ingrese el Nombre del cliente:");
                            nombre = sc.nextLine();
                            sc.next();
                            System.out.println("Ingrese el Email del cliente:");
                            email = sc.next();
                            System.out.println("Ingrse el Telefono del cliente:");
                            telefono = sc.nextInt();
                            Cliente cliente;
                            if (r.equals("particular")) {
                                clienteUtil.crearClienteParticular(id, nombre, email, telefono);
                                cliente = clienteUtil.obtenerParticular(id);
                            } else {
                                clienteUtil.crearClienteEmpresa(id, nombre, email, telefono);
                                cliente = clienteUtil.obtenerEmpresa(id);
                            }
                            reservaUtil.generarReserva(cliente);
                        }
                    }
                } catch (Exception e) {
                }
                break;
            case 6:
                try {
                    reservaUtil.mostrarReservas();
                    Reserva reserva = null;
                    do {
                        System.out.println("Ingrese el id de la reserva a modificar.");
                        id = sc.nextInt();
                        reserva = reservaUtil.obtenerReserva(id);
                        if (reserva != null)
                            valido = true;
                        else {
                            System.out.println("id no encontrado, intente nuevamente.");
                            valido = false;
                        }
                    } while (!valido);
                    reservaUtil.modificarReserva(reserva);
                } catch (Exception e) {
                    System.out.println("No hay reservas registradas.");
                }
                break;
            case 7:
                clienteUtil.mostrarClientes();
                System.out.println("Ingrese el id del Cliente a consultar.");
                id = sc.nextInt();
                clienteUtil.mostrarCliente(id);
                break;
            case 9:
                reservaUtil.mostrarReservas();
                Reserva reserva = null;
                do {
                    System.out.println("Ingrese el id de la reserva a eliminar.");
                    id = sc.nextInt();
                    reserva = reservaUtil.obtenerReserva(id);
                    if (reserva != null)
                        valido = false;
                    else {
                        reservaUtil.eliminarReserva(reserva);
                        valido = true;
                    }
                } while (!valido);
                break;
            case 8:
                try {
                    reservaUtil.mostrarReservas();
                } catch (Exception e) {
                    System.out.println("No hay reservas registrados.");
                }
                break;
            default:
                System.out.println("Opcion incorrecta");
            }
        } while (op != 0);
        sc.close();
    }
}
