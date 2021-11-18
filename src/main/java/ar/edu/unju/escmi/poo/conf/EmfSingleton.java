package ar.edu.unju.escmi.poo.conf;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmfSingleton {

    private static EmfSingleton instancia = new EmfSingleton();

    static private final String PERSISTENCE_UNIT_NAME = "TPFinalPersistence";

    private EntityManagerFactory emf = null;

    public static EmfSingleton getInstace() {
        return instancia;
    }

    private EmfSingleton() {

    }

    public EntityManagerFactory getEmf() {
        if (emf == null)
            this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return this.emf;
    }
}
