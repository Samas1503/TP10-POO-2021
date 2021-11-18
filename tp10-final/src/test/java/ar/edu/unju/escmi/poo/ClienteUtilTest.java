package ar.edu.unju.escmi.poo;

import org.junit.Test;

import ar.edu.unju.escmi.poo.dominio.Empresa;
import ar.edu.unju.escmi.poo.dominio.Particular;
import ar.edu.unju.escmi.poo.util.ClienteUtil;
import junit.framework.TestCase;

public class ClienteUtilTest extends TestCase {

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
	public void testObtenerClientesTest() {
		ClienteUtil clienteUtil = new ClienteUtil();

		assertNotNull(clienteUtil.obtenerClientes());
	}

	@Test
	public void testObtenerParticularTest() {
		Particular particular = new Particular("Mayko Hernandez", "hola@pvto.com", 123, 1);
		particular.setId(1);
		assertEquals(particular, ClienteUtil.obtenerParticular(1));
	}

	@Test
	public void testObtenerEmpresaTest() {
		Empresa empresa = new Empresa("The Wester", "thewester@ea.com", 852, 7);
		empresa.setId(7);
		Empresa empresa2 = ClienteUtil.obtenerEmpresa(7);
		assertEquals(empresa, empresa2);
	}
}
