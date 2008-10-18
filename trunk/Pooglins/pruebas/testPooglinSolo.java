import pooglin.Pooglin;
import punto.Punto;
import junit.framework.TestCase;


public class testPooglinSolo extends TestCase {
	Pooglin p = new Pooglin();
	
	public void testPooglin() {
		fail("Not yet implemented");
	}

	public void testPooglinPunto() {
		Punto pto=new Punto(2,2);
		p.setPosicion(pto);
		assertTrue(pto.equals(p.getPosicion()));
	}

	public void testInteractuar() {
		fail("Not yet implemented");
	}

	public void testMorir() {
		assertFalse(p.estaMuerto());
		p.morir();
		assertTrue(p.estaMuerto());
	}

	public void testCaminar() {
		fail("Not yet implemented");
	}

	public void testDarVuelta() {
		fail("Not yet implemented");
	}

	public void testCaer() {
		fail("Not yet implemented");
	}

	public void testDefinirHabilidad() {
		fail("Not yet implemented");
	}

	public void testSalvar() {
		fail("Not yet implemented");
	}
}
