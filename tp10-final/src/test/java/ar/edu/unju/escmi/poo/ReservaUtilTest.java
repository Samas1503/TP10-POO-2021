package ar.edu.unju.escmi.poo;

import java.time.LocalDate;
import java.time.LocalTime;

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

	@Test //testeara que la funcion devuelva una lista
	public void testObtenerReservas() {
		assertNotNull(ReservaUtil.obtenerReservas());
	}
	
	/*  test no funcional 
	@Test //probara que la carga y el retorno de una reserva funcionan
	public void testObtenerUnaReserva() {
		Cliente cliente = ClienteUtil.obtenerParticular(-1);
		Salon salon = SalonUtil.obtenerSalon("Salon de Mayko");
		Mozo mozo = MozoUtil.obtenerMozo(-1);
		
		Reserva reserva = new Reserva(0, 0, (float)100, false, LocalDate.of(2222, 2, 2), LocalTime.of(23, 00), cliente, salon, mozo);
		
		if(ReservaUtil.obtenerReserva(52) == null)
				ReservaUtil.crearReserva(0, 0, (float)100, false, LocalDate.of(2222, 2, 2), LocalTime.of(23, 00), cliente, salon, mozo);
		
		reserva.setIdreserva(ReservaUtil.obtenerReserva(52).getIdreserva());

		assertEquals(reserva, ReservaUtil.obtenerReserva(52));
	}
	*/
}