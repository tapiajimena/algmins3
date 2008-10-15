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
		assertEquals(1,unPooglin.getPosicionX());
		assertEquals(2,unPooglin.getPosicionY());
		assertEquals(2,unaTierra.getPosicionY());
		assertEquals(2,unaTierra.getPosicionX());
		
		/*
		 * Agrego el objeto al planeta y verifico las posiciones.
		 */
		unPlaneta.agregarObstaculo(unaTierra,2,2);
		assertEquals(2,unPlaneta.getBloque(2,2).getPosicionX());
		
		assertEquals(unPooglin.getPosicionX()+1,unaTierra.getPosicionX());
		assertEquals(unPooglin.getPosicionY(),unaTierra.getPosicionY());
	}
	
	public void testInteraccionPooglin(){
		unPlaneta.agregarObstaculo(unaTierra,2,2);
		unRayoLaser.interactuar(unPooglin,unPlaneta);
		/*
		 * El Pooglin tiene que aumentar una unidad su posicion en X porque
		 * ha caminado despues de crear aire delante suyo.
		 */
	    assertEquals(1,unPooglin.getPosicionX());
		assertEquals(2,unPooglin.getPosicionY());
	}

}
