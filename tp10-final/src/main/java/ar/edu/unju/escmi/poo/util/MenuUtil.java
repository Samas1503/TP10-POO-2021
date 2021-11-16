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
            try {
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
                System.out.println("*    9- Eliminar Reserva.                                             *");
                System.out.println("***********************************************************************");
                System.out.println("*                              0- Salir.                              *");
                System.out.println("***********************************************************************");
                String opcion = sc.nextLine();
                op = Integer.parseInt(opcion);
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
                    sc.nextLine();
                    System.out.println("Ingrse el Nombre completo del mozo:");
                    nombre = sc.nextLine();
                    System.out.println("Ingrse el Domicilio del mozo:");
                    domicilio = sc.nextLine();
                    System.out.println(domicilio);
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
                        Salon buscado = SalonUtil.obtenerSalon(nombre);
                        if (buscado != null)
                            System.out
                                    .println("El salon dispone de " + salonUtil.obtenerMesasLibres(buscado) + " mesas");
                        else
                            System.out.println("No hay ningun salon con ese nombre.");
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
                            if (salonUtil.verificarSalon(nombre)) {
                                mesas = salonUtil.obtenerMesasOcupadas(nombre);
                                comensales = salonUtil.obtenerComensales(nombre);
                                System.out.println("El salon " + nombre + " tiene " + mesas + " mesas ocupadas con "
                                        + comensales + " comensales.");
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
                    if (salonUtil.obtenerSalones().isEmpty()) {
                        System.out.println("No hay salones cargados");
                        break;
                    } else {
                        if (mozoUtil.obtenerMozos().isEmpty()) {
                            System.out.println("No hay mozos cargados");
                            break;
                        }
                    }
                    System.out.println("Ingrese el DNI o CUIT del Cliente:");
                    id = sc.nextInt();
                    sc.nextLine();
                    try {
                        Cliente particular = ClienteUtil.obtenerParticular(id);
                        System.out.println("Cliente encontrado. Ingrese los datos de la reserva.");
                        reservaUtil.generarReserva(particular);
                    } catch (Exception e) {
                        try {
                            Cliente empresa = ClienteUtil.obtenerEmpresa(id);
                            System.out.println("Cliente encontrado. Ingrese los datos de la reserva.");
                            reservaUtil.generarReserva(empresa);
                        } catch (Exception f) {
                            System.out.println("Cliente no encontrado. Se registrara un cliente nuevo.");
                            do {
                                System.out.println("El cliente es particular o empresa?");
                                r = sc.nextLine();
                            } while (!r.equals("particular") || !r.equals("empresa"));
                            System.out.println("Ingrese el Nombre del cliente:");
                            nombre = sc.nextLine();
                            sc.next();
                            System.out.println("Ingrese el Email del cliente:");
                            email = sc.next();
                            System.out.println("Ingrse el Telefono del cliente:");
                            telefono = sc.nextInt();
                            sc.nextLine();
                            Cliente cliente;
                            if (r.equals("particular")) {
                                clienteUtil.crearClienteParticular(id, nombre, email, telefono);
                                cliente = ClienteUtil.obtenerParticular(id);
                            } else {
                                clienteUtil.crearClienteEmpresa(id, nombre, email, telefono);
                                cliente = ClienteUtil.obtenerEmpresa(id);
                            }
                            reservaUtil.generarReserva(cliente);
                        }
                    }
                    break;
                case 6:
                    if (ReservaUtil.obtenerReservas().isEmpty()) {
                        System.out.println("No hay reservas registradas");
                        break;
                    }
                    try {
                        reservaUtil.mostrarReservas();
                        Reserva reserva = null;
                        do {
                            System.out.println("Ingrese el id de la reserva a modificar.");
                            id = sc.nextInt();
                            sc.nextLine();
                            reserva = ReservaUtil.obtenerReserva(id);
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
                    try {
                        System.out.println("Ingrese el id del Cliente a consultar.");
                        id = sc.nextInt();
                        sc.nextLine();
                        clienteUtil.mostrarCliente(id);
                    } catch (Exception e) {
                        System.out.println("No hay Clientes registrados.");
                    }
                    break;
                case 8:
                    try {
                        reservaUtil.mostrarReservas();
                    } catch (Exception e) {
                        System.out.println("No hay reservas registrados.");
                    }
                    break;
                case 9:
                    try {
                        reservaUtil.mostrarReservas();
                        Reserva reserva = null;
                        do {
                            System.out.println("Ingrese el id de la reserva a eliminar.");
                            id = sc.nextInt();
                            sc.nextLine();
                            reserva = ReservaUtil.obtenerReserva(id);
                            if (reserva != null) {
                                valido = true;
                                reservaUtil.eliminarReserva(reserva);
                                System.out.println("Se elimino la reserva");
                            } else {
                                System.out.println("reserva no encontrada");
                                valido = false;
                            }
                        } while (!valido);
                    } catch (Exception e) {
                        System.out.println("No hay Reservas registradas");
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                }
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero");
            }
        } while (op != 0);
        sc.close();
    }
}
