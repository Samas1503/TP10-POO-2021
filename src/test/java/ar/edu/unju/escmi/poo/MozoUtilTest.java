package ar.edu.unju.escmi.poo;

import org.junit.Test;

import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.util.MozoUtil;
import junit.framework.TestCase;

public class MozoUtilTest extends TestCase {

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

	@Test // testeara que la funcion de obtenerMozos devuelva una lista
	public void testObtenerMozosTest() {

		assertNotNull(MozoUtil.obtenerMozos());
	}

	@Test // testeara que la carga y el retorno de un mozo funcionan correctamente
	public void testObtenerUnMozoTest() {
		Mozo mozo = new Mozo(-1, "ejemploTest", "ejemploTest", true);
		if (MozoUtil.obtenerMozo(-1) == null)
			MozoUtil.crearMozo(-1, "ejemploTest", "ejemploTest");

		assertEquals(mozo, MozoUtil.obtenerMozo(-1));
	}

}
