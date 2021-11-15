package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Empresa;
import ar.edu.unju.escmi.poo.dominio.Particular;

public interface IClienteDao {

    public void guardarCliente(Cliente nuevo);
    public List<Cliente> obtenerClientes();
    public Particular obtenerClienteParticular(int dni);
    public Empresa obtenerClienteEmpresa(int cuit);
    
}
