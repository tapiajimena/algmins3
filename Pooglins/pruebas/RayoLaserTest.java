import pooglin.Pooglin;
import punto.Punto;
import habilidad.RayoLaser;
import bloque.Aire;
import bloque.Bloque;
import bloque.Tierra;
import juego.Planeta;
import junit.framework.TestCase;

public class RayoLaserTest extends TestCase {
	
	Punto posPooglin = new Punto(1,2);
	Punto posTierra = new Punto (2,2);
	Pooglin unPooglin = new Pooglin(posPooglin);
	Bloque[][] unTerreno = new Bloque[4][4];
	Planeta unPlaneta = new Planeta(4,4,unTerreno);
	Tierra unaTierra = new Tierra(posTierra);
	RayoLaser unRayoLaser = new RayoLaser(unPooglin,1);
	
	
	public void testPosiciones(){	
		/*
		 * Corroboro que la posición del objeto a eliminar sea la que se
		 * encuentra delante del Pooglin
		 */
		
		assertEquals(unPooglin.getPosicion().getX()+1,unaTierra.getPosicion().getX());
		assertEquals(unPooglin.getPosicion().getY(),unaTierra.getPosicion().getY());
	}
	
	
	public void testInteraccionPooglin(){

		/*
		 * Armo un Terreno para poder realizar las interacciones.
		 */
		for(int i=0;i<=4;i++){
			for(int j=0; j<=4; j++){
				Punto punto = new Punto(i,j);
				Aire unAire = new Aire(punto);
				unPlaneta.agregarObstaculo(unAire);
			}
		}
		unPlaneta.agregarObstaculo(unaTierra);
		
		unRayoLaser.interactuar(unPlaneta);
		/*
		 * El Pooglin tiene que mantener su posicion en X porque su
		 * dureza aun es 0 entonces no creó aire delante suyo.
		 */
	    assertEquals(1,unPooglin.getPosicion().getX());
		assertEquals(2,unPooglin.getPosicion().getY());
		
		/*
		 * Ahora decremento la dureza de Tierra (dejándola en cero) para que
		 * entre al ciclo. Asi se elimina la Tierra delante del Pooglin,
		 * colocando un bloque de Aire.
		 */
		unaTierra.decrementarDureza(3);
		System.out.println("La dureza ahora es " + unaTierra.getDureza());
		unRayoLaser.interactuar(unPlaneta);
		/*
		 * Para probar que hay un bloque Aire, compruebo si es o no traspasable
		 * ya que la Tierra no lo era y el Aire si.
		 */
		assertTrue(unPlaneta.getBloque(new Punto(2,2)).esTraspasable());
		System.out.println("Se eliminó la Tierra delante del Pooglin.");
		assertEquals(1,unPooglin.getPosicion().getX());
		assertEquals(2,unPooglin.getPosicion().getY());
		System.out.println("La posición del Pooglin aún no cambia.");
		
		
		/*
		 * Ahora 
		 */
	}

}
