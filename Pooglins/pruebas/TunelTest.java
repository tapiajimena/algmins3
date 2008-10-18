import pooglin.Pooglin;
import punto.Punto;
import bloque.Tunel;
import junit.framework.TestCase;


public class TunelTest extends TestCase {
	
	Punto posPooglin = new Punto(1,2);
	Punto posTunel = new Punto (2,2);
	Pooglin unPooglin = new Pooglin(posPooglin);
	Tunel unTunel = new Tunel(posTunel);

	
	public void testPosiciones(){	
		/*
		 * Corroboro que la posicion del Tunel sea la que se
		 * encuentra delante del Pooglin
		 */
		assertEquals(unPooglin.getPosicionX()+1,unTunel.getPosicionX());
		assertEquals(unPooglin.getPosicionY(),unTunel.getPosicionY());
	}
	
	
	public void testInteraccionPooglin(){
		
		/*
		 * El Pooglin tiene que aumentar su posición en X cuando atravieza
		 * un bloque Tunel
		 */
	    assertEquals(2,unPooglin.getPosicionX());
		assertEquals(2,unPooglin.getPosicionY());
		
		
	}


}
