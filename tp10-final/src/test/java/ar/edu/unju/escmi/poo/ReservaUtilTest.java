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
	
	@Test
    public void testObtenerReservasTest() {
        assertNotNull(ReservaUtil.obtenerReservas());
    }
	
	@Test
    public void testObtenerUnaReservaTest() {
		Cliente cliente = ClienteUtil.obtenerParticular(2);
		Salon salon = null ; //SalonUtil.obtenerSalon("Salon de Mayko");
		Mozo mozo = MozoUtil.obtenerMozo(15684892);
		Reserva reserva = new Reserva(6,2,(float)100,false,LocalDate.now(),LocalTime.of(15, 8, 0),cliente,salon,mozo);
		
        assertEquals(reserva,ReservaUtil.obtenerReserva(1));
    }
	
}