package ar.edu.unju.escmi.poo;

import java.time.LocalDate;

import org.hibernate.Hibernate;
import org.junit.Test;

import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;
import ar.edu.unju.escmi.poo.util.ClienteUtil;
import ar.edu.unju.escmi.poo.util.MozoUtil;
import ar.edu.unju.escmi.poo.util.ReservaUtil;
import ar.edu.unju.escmi.poo.util.SalonUtil;
import junit.framework.TestCase;

public class ReservaUtilTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		System.out.println("inicia test");
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		System.out.println("finaliza el test");
		super.tearDown();
	}

	@Test // testeara que la funcion devuelva una lista
	public void testObtenerReservas() {
		assertNotNull(ReservaUtil.obtenerReservas());
	}

	@Test // probara que la carga y el retorno de una reserva funcionan
	public void testObtenerUnaReserva() {
		Cliente cliente = ClienteUtil.obtenerParticular(2);
		Salon salon = SalonUtil.obtenerSalon("Salon de Samuel");
		Mozo mozo = MozoUtil.obtenerMozo(2);

		Reserva reserva = new Reserva(2, 1, (float) 50.0, false, LocalDate.now(), null, cliente, salon, mozo);
		reserva.setIdreserva(2);
		Reserva reserva2 = ReservaUtil.obtenerReserva(2);
		reserva2.setHora(null);
		reserva2.setCliente((Cliente) Hibernate.unproxy(reserva2.getCliente()));
		reserva2.setMozo((Mozo) Hibernate.unproxy(reserva2.getMozo()));
		reserva2.setSalon((Salon) Hibernate.unproxy(reserva2.getSalon()));

		assertEquals(reserva, reserva2);
	}

}