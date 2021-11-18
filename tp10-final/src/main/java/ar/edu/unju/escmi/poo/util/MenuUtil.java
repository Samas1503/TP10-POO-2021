package ar.edu.unju.escmi.poo.util;

import java.util.Scanner;

import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;


public class MenuUtil {
	public static void menu() {
        Scanner sc = new Scanner(System.in);
        int comensales, mesas, op = -1, id = 0;
        String nombre, domicilio, r = "";
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
                System.out.println("*    9- Cancelar Reserva.                                             *");
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
                    if (MozoUtil.obtenerMozos().size() < 6) {
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
                        MozoUtil.crearMozo(id, nombre, domicilio);
                    } else
                        System.out.println("Ya no se pueden cargar mas Mozos");
                    break;
                case 2:
                    MozoUtil.mostrarMozos();
                    break;
                case 3:
                	//verificamos que haya datos cargados
                    try {
                    	//se muestra el nombre de los salones 
                        SalonUtil.obtenerSalones().stream().forEach(n -> System.out.println(n.getNombre()));
                        
                        //se ingresa el nombre del salon a consultar
                        System.out.println("Ingrese el nombre del salon al que desea consultar.");
                        nombre = sc.nextLine();
                        Salon buscado = SalonUtil.obtenerSalon(nombre);
                        if (buscado != null) // se muestra la cantidad de mesas libres 
                            System.out
                                    .println("El salon dispone de " + SalonUtil.obtenerMesasLibres(buscado) + " mesas");
                        else
                            System.out.println("No hay ningun salon con ese nombre.");
                    } catch (Exception e) {
                        System.out.println("No hay Salones Registrados");
                    }
                    break;
                case 4:
                	// verificamos que hayan datos cargados
                    try {
                        do {
                        	//mostramos los nombres de los salones 
                        	SalonUtil.obtenerSalones().stream().forEach(n -> System.out.println(n.getNombre()));
                        	
                        	//solicitamos el ingreso de un salon 
                            System.out.println("Ingrese el nombre del salon al que desea consultar.");
                            nombre = sc.nextLine();
                            if (SalonUtil.verificarSalon(nombre)) // mostramos las mesas ocupadas y la cantidad de comensales
                            {
                                mesas = SalonUtil.obtenerMesasOcupadas(nombre);
                                comensales = SalonUtil.obtenerComensales(nombre);
                                System.out.println("El salon " + nombre + " tiene " + mesas + " mesas ocupadas con "
                                        + comensales + " comensales.");
                            } 
                            else // controlamos si desea volver a intentar
                            {
                                System.out.println("El salon ingresado no existe. Desea intentar nuevamente? [si/no]");
                                r = sc.nextLine();
               
                            }
                        } while (r.equals("si"));
                    } catch (Exception e) {
                        System.out.println("No hay Salones Registrados");
                    }
                    break;
                case 5:
                	//verificamos las existencias de salones y mozos
                	if (SalonUtil.obtenerSalones().isEmpty()) {
                        System.out.println("No hay salones cargados");
                        break;
                    } else {
                        if (MozoUtil.obtenerMozos().isEmpty()) {
                            System.out.println("No hay mozos cargados");
                            break;
                        }else
                        {
                        	if(MozoUtil.obtenerUnLibre() == null)
                        	{
                        		System.out.println("no hay mozos disponibles");
                        		break;
                        	}
                        		
                        	
                        }
                    }
                    
                    //se busca un cliente
                    System.out.println("Ingrese el DNI o CUIT del Cliente:");
                    id = sc.nextInt();
                    sc.nextLine();
                    try {
                        Cliente particular = ClienteUtil.obtenerParticular(id);
                        ReservaUtil.generarReserva(particular);
                    } catch (Exception e) {
                        try {
                            Cliente empresa = ClienteUtil.obtenerEmpresa(id);
                            ReservaUtil.generarReserva(empresa);
                        } catch (Exception f) 
                        // en caso de no tener registrado al cliente se registra al momento
                        {
                            System.out.println("Cliente no encontrado. Se registrara un cliente nuevo.");
                            Cliente cliente = ClienteUtil.generarNuevoCliente();
                            ReservaUtil.generarReserva(cliente);
                        }
                    }
                    break;
                case 6:
                	//verificamos que haya datos cargados
                    if (ReservaUtil.obtenerReservas().isEmpty()) {
                        System.out.println("No hay reservas registradas");
                        break;
                    }
                    
                    //controlamos que hayan reservas no pagadas 
                    try {
                    	ReservaUtil.mostrarReservasPendientes();
                        Reserva reserva = null;
                        do {
                            System.out.println("Ingrese el id de la reserva a modificar.");
                            id = sc.nextInt();
                            sc.nextLine();
                            reserva = ReservaUtil.obtenerReserva(id);
                            if (reserva != null)
                                valido = false;
                            else {
                                System.out.println("id no encontrado, intente nuevamente.");
                                valido = true;
                            }
                        } while (valido); 
                        
                        //cambiamos el estado de la reserva a "pagado"
                        ReservaUtil.finalizarReserva(reserva);
         
                    } catch (Exception e) {
                        System.out.println("No hay reservas no pagadas registradas.");
                    }
                    break;
                case 7:
                	//controlamos el casteo de los datos
                    try {
                        System.out.println("Ingrese el id del Cliente a consultar.");
                        id = sc.nextInt();
                        sc.nextLine();
                        ClienteUtil.mostrarCliente(id);
                    } catch (Exception e) {
                        System.out.println("No hay Clientes registrados.");
                    }
                    break;
                case 8:
                	//controlamos que hayan reservas registradas
                    try {
                        ReservaUtil.mostrarReservas();
                    } catch (Exception e) {
                        System.out.println("No hay reservas registrados.");
                    }
                    break;
                case 9:
                	//controlamos que hayan datos cargados 
                    try {
                    	//mostramos las reservas pendientes 
                        ReservaUtil.mostrarReservasPendientes();
                        Reserva reserva = null;
                       // se solicita la seleccion de una reserva 
                        do {
                            System.out.println("Ingrese el id de la reserva a eliminar.");
                            id = sc.nextInt();
                            sc.nextLine();
                            reserva = ReservaUtil.obtenerReserva(id);
                            if (reserva != null) {
                                valido = false;
                                ReservaUtil.eliminarReserva(reserva);
                                System.out.println("Se elimino la reserva");
                            } else {
                                System.out.println("reserva no encontrada");
                                valido = true;
                            }
                        } while (valido);
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
