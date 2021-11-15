package ar.edu.unju.escmi.poo;

import org.junit.Test;

import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.util.ClienteUtil;
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
		
		@Test
	    public void testObtenerMozosTest() {
			MozoUtil mozoUtil = new MozoUtil();
	        
	        assertNotNull(mozoUtil.obtenerMozos());
	    }
		
		@Test
	    public void testObtenerUnMozoTest() {
	        Mozo mozo = new Mozo(23549842, "Jarvis", "mi casa 18",true);
	        Mozo mozo2 = MozoUtil.obtenerMozo(23549842);
	        assertEquals(mozo, mozo2);
	    }
		
}
