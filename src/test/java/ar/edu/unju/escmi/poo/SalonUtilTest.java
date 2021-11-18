package ar.edu.unju.escmi.poo;

import org.junit.Test;

import ar.edu.unju.escmi.poo.dominio.Salon;
import ar.edu.unju.escmi.poo.util.SalonUtil;
import junit.framework.TestCase;

public class SalonUtilTest extends TestCase {

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
	public void testObtenerSalon() {
		if (SalonUtil.obtenerSalon("ejemploTest") == null)
			SalonUtil.crearSalon("ejemploTest", 0);

		Salon esperado = new Salon("ejemploTest", 0);

		assertEquals(esperado, SalonUtil.obtenerSalon("ejemploTest"));
	}
}