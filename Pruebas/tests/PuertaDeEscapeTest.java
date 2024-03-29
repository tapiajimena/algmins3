package tests;
import modelo.Pooglin;
import modelo.Punto;
import modelo.bloque.Salida;
import junit.framework.TestCase;

public class PuertaDeEscapeTest extends TestCase {
	
	public void testInteraccionPuertaDeEscapePooglin (){
		Punto punto = new Punto (1,1); 
		Pooglin pooglin= new Pooglin(punto);
		Salida  puerta = new Salida(punto); 
		// verifico que esten en la misma posicion
		assertTrue(pooglin.getPosicion().equals(puerta.getPosicion()));	
		// los hago interactuar
		puerta.interactuar(pooglin);
		assertTrue(pooglin.EstaSalvado());
	}
}
