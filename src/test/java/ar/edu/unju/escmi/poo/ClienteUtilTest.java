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

	@Test // probara que la funcion obtener clientes devuelva una lista
	public void testObtenerClientesTest() {
		assertNotNull(ClienteUtil.obtenerClientes());
	}

	@Test // probara que la creacion de un Particular y la recuperacion de esté funcionan
	public void testObtenerParticularTest() {
		Particular particular = new Particular("ejemploTest", "ejemploTest", -1, -1);

		// para la primera vez que se ejecute la prueba
		if (ClienteUtil.obtenerParticular(-1) == null)
			ClienteUtil.crearClienteParticular(-1, "ejemploTest", "ejemploTest", -1);

		particular.setId(ClienteUtil.obtenerParticular(-1).getId());

		assertEquals(particular, ClienteUtil.obtenerParticular(-1));
	}

	@Test // probara que la creacion de un Empresa y la recuperacion de esté funcionan
	public void testObtenerEmpresaTest() {
		Empresa empresa = new Empresa("ejemploTest", "ejemploTest", -2, -2);

		// para la primera vez que se ejecuta el test
		if (ClienteUtil.obtenerEmpresa(-2) == null)
			ClienteUtil.crearClienteEmpresa(-2, "ejemploTest", "ejemploTest", -2);

		empresa.setId(ClienteUtil.obtenerEmpresa(-2).getId());

		assertEquals(empresa, ClienteUtil.obtenerEmpresa(-2));
	}
}
