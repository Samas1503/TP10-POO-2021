package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.conf.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.ISalonDao;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class SalonDaoImp implements ISalonDao{

    private static EntityManager manager = EmfSingleton.getInstace().getEmf().createEntityManager();
    
    @Override
    public void guardarSalon(Salon nuevo) {
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
    public List<Salon> obtenerSalones() {
        try {
            Query query = manager.createQuery("Select s from Salon s");
            return (List<Salon>) query.getResultList();
        } catch (Exception e) {
           System.out.println(e);
        }
        return null;
    }

    @Override
    public Salon obtenerSalon(String nombre) {
        try {
            Query query = manager.createQuery("Select s from Salon where nombre like :nombre");
            query.setParameter("nombre", nombre);
            return (Salon) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    

}
