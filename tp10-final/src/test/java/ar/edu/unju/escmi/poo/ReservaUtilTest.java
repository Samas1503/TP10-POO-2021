package ar.edu.unju.escmi.poo;

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

	@Test
	public void testObtenerReservas() {
		assertNotNull(ReservaUtil.obtenerReservas());
	}

	@Test
	public void testObtenerUnaReserva() {
		Cliente cliente = ClienteUtil.obtenerParticular(44706400);
		Salon salon = SalonUtil.obtenerSalon("Salon de Mayko"); // SalonUtil.obtenerSalon("Salon de Mayko");
		Mozo mozo = MozoUtil.obtenerMozo(15684892);
		Reserva reserva2 = ReservaUtil.obtenerReserva(1);
		reserva2.setFecha(null);
		reserva2.setHora(null);
		reserva2.setCliente(null);
		reserva2.setSalon(null);
		reserva2.setMozo(null);
		Reserva reserva = new Reserva(6, 2, (float) 100, false, null, null, null, null, null);
		reserva.setIdreserva(1);

		assertEquals(reserva, reserva2);
	}

}