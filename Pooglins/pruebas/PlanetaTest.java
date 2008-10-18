import bloque.Aire;
import bloque.Bloque;
import bloque.Tierra;
import junit.framework.TestCase;


public class PlanetaTest extends TestCase {
	
	Punto posTierra = new Punto (2,2);
	Bloque[][] unTerreno = new Bloque[3][3];
	Planeta unPlaneta = new Planeta(4,4, unTerreno);
	Tierra unaTierra = new Tierra(posTierra);
	Aire unAire = new Aire(posTierra);
	
	
	public void testDimensiones(){
		/*
		 * Corroboro las dimensiones del Planeta creado.
		 */
		assertEquals(4,unPlaneta.getAlto());
		assertEquals(4,unPlaneta.getAncho());
	}
	
	
	public void testAgregarObstaculo(){	
		/*
		 * Agrego un bloque Tierra al Planeta y verifico las posiciones.
		 */
		unPlaneta.agregarObstaculo(unaTierra,2,2);
		assertEquals(2,unPlaneta.getBloque(2,2).getPosicionX());
		assertEquals(2,unPlaneta.getBloque(2,2).getPosicionY());
		System.out.println("Se agregó un bloque Tierra");
	}
	
	
	public void testQuitarObstaculo(){	
		/*
		 * Elimino un bloque Tierra al Planeta y verifico que en la posicion
		 * donde estaba el bloque Tierra ahora hay Aire.
		 * Para esto compruebo que ese bloque sea traspasable.
		 */
		unPlaneta.quitarObstaculo(2,2);
		assertTrue(unPlaneta.getBloque(2,2).esTraspasable());
		System.out.println("Se eliminó un bloque Tierra");
	}
	
}
