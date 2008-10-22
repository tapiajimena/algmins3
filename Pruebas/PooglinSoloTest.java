import pooglin.Pooglin;
import punto.Punto;
import junit.framework.TestCase;


public class PooglinSoloTest extends TestCase {
	Pooglin p = new Pooglin();
	public void testPooglin() {
		Punto punto=new Punto(1,3);
		Pooglin op=new Pooglin(punto);
		/*compruebo que la posicion del Pooglin es la posicion de inicializacion*/
		assertTrue(op.getPosicion().equals(punto));
		assertFalse(op.estaMuerto());
	}

	public void testPooglinPunto() {
		Punto pto=new Punto(2,2);
		p.setPosicion(pto);
		assertTrue(pto.equals(p.getPosicion()));
	}

	public void testMorir() {
		assertFalse(p.estaMuerto());
		p.morir();
		assertTrue(p.estaMuerto());
	}

}
