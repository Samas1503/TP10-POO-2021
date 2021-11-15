package ar.edu.unju.escmi.poo.principal;

import java.time.LocalDate;

import ar.edu.unju.escmi.poo.dao.IClienteDao;
import ar.edu.unju.escmi.poo.dao.IMozoDao;
import ar.edu.unju.escmi.poo.dao.IReservaDao;
import ar.edu.unju.escmi.poo.dao.ISalonDao;
import ar.edu.unju.escmi.poo.dao.imp.ClienteDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.MozoDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.ReservaDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.SalonDaoImp;
import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Particular;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class Principal {
    public static void main(String[] args) {

        // DAOS
        IClienteDao clienteDao = new ClienteDaoImp();
        IMozoDao mozoDao = new MozoDaoImp();
        IReservaDao reservaDao = new ReservaDaoImp();
        ISalonDao salonDao = new SalonDaoImp();

        // test
        // cliente
        Cliente nuevo = new Particular("mayko", "hola", 123, 44706681);

        clienteDao.guardarCliente(nuevo);

        // mozo

        Mozo nuevoMozo = new Mozo(123, "juan", "asd", true);
        mozoDao.guardarMozo(nuevoMozo);

        // salon
        Salon nuevoSalon = new Salon("juan ramirez", 20);
        salonDao.guardarSalon(nuevoSalon);

        // reserva
        Reserva nueva = new Reserva(10, 20, (float) 123.3, false, LocalDate.now(), LocalDate.now(), nuevo, nuevoSalon,
                nuevoMozo);
        reservaDao.guardarReserva(nueva);

    }
}
