package tests;
//import bloque.PuertaDeEscape;
import pooglin.Pooglin;
import punto.Punto;
import junit.framework.TestCase;


public class PuertaDeEscapeTest extends TestCase {
	Punto punto = new Punto (1,1); 
	Pooglin pooglin= new Pooglin(punto);
	//PuertaDeEscape  puerta = new PuertaDeEscape(punto); 
	
	
	public void testInteraccionPuertaDeEscapePooglin (){
			// verifico que esten en la misma posicion
	//	boolean posiciones = this.pooglin.getPosicion().equals(this.puerta.getPosicion());
	//	assertTrue(posiciones);	
		// los hago interactuar
	//	this.puerta.interactuar(pooglin);
		assertTrue(this.pooglin.EstaSalvado());
	}
}
