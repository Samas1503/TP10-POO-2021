package ar.edu.unju.escmi.poo.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.poo.dao.imp.ClienteDaoImp;
import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Empresa;
import ar.edu.unju.escmi.poo.dominio.Particular;

public class ClienteUtil {
    ClienteDaoImp clienteDao = new ClienteDaoImp();

    public void crearClienteParticular(int dni, String nombre, String email, int telefono) {
        Cliente nuevo = new Particular(nombre, email, telefono, dni);
        clienteDao.guardarCliente(nuevo);
    }

    public void crearClienteEmpresa(int cuit, String nombre, String email, int telefono) {
        Cliente nuevo = new Empresa(nombre, email, telefono, cuit);
        clienteDao.guardarCliente(nuevo);
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

    public Particular obtenerParticular(int dni) {
        return clienteDao.obtenerClienteParticular(dni);
    }

    public Empresa obtenerEmpresa(int cuit) {
        return clienteDao.obtenerClienteEmpresa(cuit);
    }
}
