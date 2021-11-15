package ar.edu.unju.escmi.poo.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.poo.dao.imp.ClienteDaoImp;
import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Empresa;
import ar.edu.unju.escmi.poo.dominio.Particular;

public class ClienteUtil {
    static ClienteDaoImp clienteDao = new ClienteDaoImp();

    public void precargarClientes() {
        crearClienteParticular(44706681, "Mayko Hernandez", "hola@pvto.com", 123);
        crearClienteParticular(44706400, "Samoel Panfila", "hola2@pvto.com", 432);
        crearClienteParticular(44700523, "Churro Chorolque", "hola3@pvto.com", 623);
        crearClienteParticular(44500463, "Santula Ancalay", "hola4@pvto.com", 765);
        crearClienteEmpresa(123456789, "La Nortenia", "lanortenia@ea.com", 963);
        crearClienteEmpresa(456123789, "La Surenia", "lasurenia@ea.com", 741);
        crearClienteEmpresa(789456123, "The Wester", "thewester@ea.com", 852);
    }

    public void crearClienteParticular(int dni, String nombre, String email, int telefono) {
        Cliente nuevo = new Particular(nombre, email, telefono, dni);
        clienteDao.guardarCliente(nuevo);
    }

    public void crearClienteEmpresa(int cuit, String nombre, String email, int telefono) {
        Cliente nuevo = new Empresa(nombre, email, telefono, cuit);
        clienteDao.guardarCliente(nuevo);
    }

    public void mostrarCliente(int id) {
        Cliente cliente = null;
        try {
            cliente = obtenerParticular(id);
            System.out.println(cliente.toString());
        } catch (Exception e) {
            try {
                cliente = obtenerEmpresa(id);
                System.out.println(cliente.toString());
            } catch (Exception f) {
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
