package ar.edu.unju.escmi.poo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.dao.imp.ClienteDaoImp;
import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Empresa;
import ar.edu.unju.escmi.poo.dominio.Particular;


public class ClienteUtil {
    static ClienteDaoImp clienteDao = new ClienteDaoImp();

    public static void precargarClientes() {
        crearClienteParticular(1, "Mayko Hernandez", "hola@pvto.com", 123);
        crearClienteParticular(2, "Samoel Panfila", "hola2@pvto.com", 432);
        crearClienteParticular(3, "Churro Chorolque", "hola3@pvto.com", 623);
        crearClienteParticular(4, "Santula Ancalay", "hola4@pvto.com", 765);
        crearClienteEmpresa(5, "La Nortenia", "lanortenia@ea.com", 963);
        crearClienteEmpresa(6, "La Surenia", "lasurenia@ea.com", 741);
        crearClienteEmpresa(7, "The Wester", "thewester@ea.com", 852);
    }

    public static void crearClienteParticular(int dni, String nombre, String email, int telefono) {
        Cliente nuevo = new Particular(nombre, email, telefono, dni);
        clienteDao.guardarCliente(nuevo);
    }

    public static void crearClienteEmpresa(int cuit, String nombre, String email, int telefono) {
        Cliente nuevo = new Empresa(nombre, email, telefono, cuit);
        clienteDao.guardarCliente(nuevo);
    }

    public static void mostrarCliente(int id) {
        Cliente cliente = null;
        //controlamos que el cliente sea un particular o una empresa
        try {
            cliente = obtenerParticular(id);
            System.out.println(cliente.toString());
        } catch (Exception e) {
            try {
                cliente = obtenerEmpresa(id);
                System.out.println(cliente.toString());
            } catch (Exception f) // si no es ninguno, no existe el cliente  
            {
                System.out.println("No se encontro el cliente ingresado.");
            }
        }
    }

    public void mostrarClientes() {
        List<Cliente> lista = new ArrayList<Cliente>();
        lista = clienteDao.obtenerClientes();
        for (Cliente c : lista) {
            System.out.println(c.toString());
        }
    }
    
    public static Cliente generarNuevoCliente() {
    	Cliente cliente = null;
    	Scanner sc = new Scanner(System.in);
    	int telefono = 0, id = 0;
        String nombre, email, r = "";
    	
        // se elije entre un cliente particular o empresa
    	do {
            System.out.println("El cliente es particular o empresa?");
            r = sc.nextLine();
        } while (!r.equals("particular") && !r.equals("empresa"));
    	
    	//se cargan los datos del cliente
    	if(r.equals("particular")) {
    		System.out.println("ingrese el dni del cliente");
    		id = sc.nextInt();
    	}
    	else {
    		System.out.println("ingrese el cuit del cliente");
    		id = sc.nextInt();
    	}
        System.out.println("Ingrese el Nombre del cliente:");
        nombre = sc.nextLine();
        sc.next();
        System.out.println("Ingrese el Email del cliente:");
        email = sc.nextLine();
        sc.next();
      
        System.out.println("Ingrese el Telefono del cliente:"); 
            	telefono = sc.nextInt();
       
         
            	 
   
       
       //se crea, guarda y retorna el cliente 
        
        if (r.equals("particular")) {
           ClienteUtil.crearClienteParticular(id, nombre, email, telefono);
            cliente = ClienteUtil.obtenerParticular(id);
        } else {
            ClienteUtil.crearClienteEmpresa(id, nombre, email, telefono);
            cliente = ClienteUtil.obtenerEmpresa(id);
        }
        
        return cliente;
    }

    public List<Cliente> obtenerClientes() {
        return clienteDao.obtenerClientes();
    }

    public static Particular obtenerParticular(int dni) {
        return clienteDao.obtenerClienteParticular(dni);
    }

    public static Empresa obtenerEmpresa(int cuit) {
        return clienteDao.obtenerClienteEmpresa(cuit);
    }
}
