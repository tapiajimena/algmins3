import junit.framework.TestCase;

public class RayoLaserTest extends TestCase {
	
	Punto posPooglin = new Punto(1,2);
	Punto posTierra = new Punto (2,2);
	Pooglin unPooglin = new Pooglin(posPooglin);
	Bloque[][] unTerreno = new Bloque[3][3];
	Planeta unPlaneta = new Planeta(4,4, unTerreno);
	Tierra unaTierra = new Tierra(posTierra);
	RayoLaser unRayoLaser = new RayoLaser(1);
	
	
	public void testPosiciones(){	
		/*
		 * Corroboro que la posicion del objeto a eliminar sea la que se
		 * encuentra delante del Pooglin
		 */
		
		assertEquals(unPooglin.getPosicionX()+1,unaTierra.getPosicionX());
		assertEquals(unPooglin.getPosicionY(),unaTierra.getPosicionY());
	}
	
	
	public void testInteraccionPooglin(){

		unPlaneta.agregarObstaculo(unaTierra,2,2);
		unRayoLaser.interactuar(unPooglin,unPlaneta);
		/*
		 * El Pooglin tiene que mantener su posicion en X porque
		 * no ha caminado todavia, solo creó aire delante suyo.
		 */
	    assertEquals(1,unPooglin.getPosicionX());
		assertEquals(2,unPooglin.getPosicionY());
		
		
	}

}
