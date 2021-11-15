package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.conf.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IClienteDao;
import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Empresa;
import ar.edu.unju.escmi.poo.dominio.Particular;

public class ClienteDaoImp implements IClienteDao{

    private static EntityManager manager = EmfSingleton.getInstace().getEmf().createEntityManager();

    @Override
    public void guardarCliente(Cliente nuevo) {
        try {
            manager.getTransaction().begin();
            manager.persist(nuevo);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Cliente> obtenerClientes() {
        try {
            Query query = manager.createQuery("Select e from Cliente e");
            return (List<Cliente>)query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Particular obtenerClienteParticular(int dni) {
        try {
            Query query = manager.createQuery("Select c from Cliente where dni = :dni");
            query.setParameter("dni", dni);
            return (Particular) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Empresa obtenerClienteEmpresa(int cuit) {
        try {
            Query query = manager.createQuery("Select c from Cliente where cuit = :cuit");
            query.setParameter("cuit", cuit);
            return (Empresa) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
