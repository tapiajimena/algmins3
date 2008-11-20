package tests;
import punto.Punto;
import bloque.Aire;
import bloque.Bloque;
import bloque.Tierra;
import juego.Planeta;
import junit.framework.TestCase;


public class PlanetaTest extends TestCase {
	
	Punto posTierra;
	Bloque[][] unTerreno;
	Planeta unPlaneta;
	Tierra unaTierra ;
	Aire unAire ;
	
	public void setUp(){
		posTierra = new Punto (2,2);
		this.unTerreno = new Bloque[4][4];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
				Tierra tierra=new Tierra(new Punto(i,j));
				this.unTerreno[i][j]=tierra;
			}
		}
		unPlaneta = new Planeta(4,4, unTerreno);
		unaTierra = new Tierra(posTierra);
		unAire = new Aire(posTierra);
		
	}
	
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
		unPlaneta.agregarObstaculo(unaTierra);
		assertEquals(2,unPlaneta.getBloque(new Punto(2,2)).getPosicion().getX());
		assertEquals(2,unPlaneta.getBloque(new Punto(2,2)).getPosicion().getY());
	}
	
	
	public void testQuitarObstaculo(){	
		/*
		 * Elimino un bloque Tierra al Planeta y verifico que en la posicion
		 * donde estaba el bloque Tierra ahora hay Aire.
		 * Para esto compruebo que ese bloque sea traspasable.
		 */
		unPlaneta.quitarObstaculo(new Punto(2,2));
		assertTrue(unPlaneta.getBloque(new Punto(2,2)).esTraspasable());
	}
	
}
