package ar.edu.unju.escmi.poo.util;

import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class MenuUtil {
    public void menu() {
        Scanner sc = new Scanner(System.in);
        MozoUtil mozoUtil = new MozoUtil();
        SalonUtil salonUtil = new SalonUtil();
        ReservaUtil reservaUtil = new ReservaUtil();
        int op = -1, dni = 0;
        String nombre, domicilio;
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
            System.out.println("*    9- Eliminar Reserva. Eliminar Reserva.                           *");
            System.out.println("***********************************************************************");
            System.out.println("*                              0- Salir.                              *");
            System.out.println("***********************************************************************");
            switch (op) {
            case 0:
                System.out.println("Saliendo del programa");
                break;
            case 1:
                do {
                    System.out.println("Ingrese el DNI del mozo:");
                    try {
                        dni = sc.nextInt();
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
                mozoUtil.crearMozo(dni, nombre, domicilio);
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
                    Salon buscado = salonUtil.buscarSalon(nombre);
                    salonUtil.mesasLibres(buscado);
                } catch (Exception e) {
                    System.out.println("No hay Salones Registrados");
                }
                break;
            case 4:

                break;
            case 5:
                try {
                    List<Reserva> reservas = reservaUtil.obtenerReservas();
                    int mesas = 0;
                    int comensales = 0;
                    for (Reserva r : reservas) {
                        mesas += r.getMesas();
                        comensales += r.getComensales();
                    }
                    System.out.println("Hay " + mesas + " mesas ocupadas por " + comensales + " comensales.");
                } catch (Exception e) {
                    System.out.println("No hay nunguna mesa ocupada");
                }
                break;
            case 6:

                break;
            case 7:

                break;
            case 8:
                reservaUtil.mostrarReservas();
                break;
            case 9:

                break;
            default:
                System.out.println("Opcion incorrecta");
            }
        } while (op != 0);
        sc.close();
    }
}
