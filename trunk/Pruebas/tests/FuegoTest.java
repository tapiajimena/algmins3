package tests;
import pooglin.Pooglin;
import punto.Punto;
import bloque.Fuego;
import junit.framework.*;

public class FuegoTest extends TestCase {

	Punto punto =new Punto (2,2);
	Pooglin unPooglin = new Pooglin(punto);
	Fuego fuego = new Fuego(punto);
	
	public void testPosiciones(){	
		//Corroboro que las posiciones del pooglin
		//y del fuego sean las mismas
		boolean x = this.unPooglin.getPosicion().equals(fuego.getPosicion());
		assertTrue(x);
	}
	
	public void testInteraccionPooglinFuego(){
		//hago interactuar al pooglin y al fuego
		fuego.interactuar(unPooglin);
		assertEquals(true, unPooglin.estaMuerto());
		
	}
}
