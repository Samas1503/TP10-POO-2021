package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.conf.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IMozoDao;
import ar.edu.unju.escmi.poo.dominio.Mozo;

public class MozoDaoImp implements IMozoDao {

    private static EntityManager manager = EmfSingleton.getInstace().getEmf().createEntityManager();

    @Override
    public void guardarMozo(Mozo nuevo) {
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
    public List<Mozo> obtenerMozos() {
        try {
            Query query = manager.createQuery("Select m from Mozo m");
            return (List<Mozo>) query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Mozo obtenerMozo(int dni) {
        try {
            Query query = manager.createQuery("SELECT m FROM Mozo m " + " WHERE m.dni = :dni");
            query.setParameter("dni", dni);
            return (Mozo) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
