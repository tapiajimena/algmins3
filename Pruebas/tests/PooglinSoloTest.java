package tests;
import modelo.Pooglin;
import modelo.Punto;
import junit.framework.TestCase;


public class PooglinSoloTest extends TestCase {
	Pooglin pooglin = new Pooglin();
	public void testPooglin() {
		Punto punto=new Punto(1,3);
		Pooglin otroPooglin=new Pooglin(punto);
		/*compruebo que la posicion del Pooglin es la posicion de inicializacion*/
		assertTrue(otroPooglin.getPosicion().equals(punto));
		assertFalse(otroPooglin.estaMuerto());
	}

	public void testPooglinPunto() {
		Punto pto=new Punto(2,2);
		pooglin.setPosicion(pto);
		assertTrue(pto.equals(pooglin.getPosicion()));
	}

	public void testMorir() {
		assertFalse(pooglin.estaMuerto());
		pooglin.morir();
		assertTrue(pooglin.estaMuerto());
	}

}
