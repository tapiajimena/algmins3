import pooglin.Pooglin;
import punto.Punto;
import bloque.AgujeroNegro;
import bloque.Bloque;
import junit.framework.TestCase;


public class AgujeroNegroTest extends TestCase {
	
	public void testVacio(){
		Bloque agujero=new AgujeroNegro(new Punto(1,1));
		assertFalse(agujero.vacio());
	}
	public void testDestruir(){
		
	}
	public void testSetGetPosicionX(){
		AgujeroNegro agujero=new AgujeroNegro(new Punto(1,1));
		agujero.setPosicionX(3);
		assertEquals(3,agujero.getPosicionX());
	}
	public void testSetGetPosicionY(){
		AgujeroNegro agujero=new AgujeroNegro(new Punto(1,1));
		agujero.setPosicionY(3);
		assertEquals(3,agujero.getPosicionY());
	}
	
	public void testInteractuar() {
		AgujeroNegro agujero=new AgujeroNegro(new Punto(0,0));
		for(int i=0;i<25;i++){
			Pooglin unPooglin=new Pooglin(new Punto(2,2));
			agujero.setPosicionX(i/3);
			agujero.setPosicionY(i%3);
			agujero.interactuar(unPooglin);
			boolean muerto=(agujero.getPosicion().distancia(unPooglin.getPosicion())<=1);
			assertEquals(muerto,unPooglin.estaMuerto());
		}
	}
	public void testEsTraspasable() {	
		AgujeroNegro agujero=new AgujeroNegro(new Punto(1,1));
		assertEquals(true,agujero.esTraspasable());
	}

}
