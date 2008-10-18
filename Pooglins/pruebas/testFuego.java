import pooglin.Pooglin;
import punto.Punto;
import bloque.Fuego;
import junit.framework.*;

public class testFuego extends TestCase {

	Punto punto =new Punto (2,2);
	Pooglin unPooglin = new Pooglin(punto);
	Fuego fuego = new Fuego(punto);
	
	public void testPosiciones(){	
		//Corroboro que las posiciones del pooglin
		//y del fuego sean las mismas
		assertEquals(2,unPooglin.getPosicionY());
		assertEquals(2, unPooglin.getPosicionX());
		assertEquals(2,fuego.getPosicionY());
		assertEquals(2,fuego.getPosicionX());
	}
	
	public void testInteraccionPooglinFuego(){
		//hago interactuar al pooglin y al fuego
		fuego.interactuar(unPooglin);
		assertEquals(true, unPooglin.estaMuerto());
		assertEquals(true, unPooglin.estaMuerto());
	}
}
