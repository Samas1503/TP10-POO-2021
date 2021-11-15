package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.conf.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IReservaDao;
import ar.edu.unju.escmi.poo.dominio.Reserva;

public class ReservaDaoImp implements IReservaDao {

    private static EntityManager manager = EmfSingleton.getInstace().getEmf().createEntityManager();

    @Override
    public void guardarReserva(Reserva nueva) {
        try {
            manager.getTransaction().begin();
            manager.persist(nueva);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Reserva> obtenerReservas() {
        try {
            Query query = manager.createQuery("Select r from Reserva r");
            return (List<Reserva>) query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Reserva obtenerReserva(int id) {
        try {
            Query query = manager.createQuery("Select r from Reserva where id = :id");
            query.setParameter("id", id);
            return (Reserva) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void eliminarReserva(Reserva eliminada) {
        try {
            manager.getTransaction().begin();
            manager.remove(eliminada);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }        
    }
    
}
