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
		 * Corroboro que la posici�n del objeto a eliminar sea la que se
		 * encuentra delante del Pooglin
		 */
		
		assertEquals(unPooglin.getPosicionX()+1,unaTierra.getPosicionX());
		assertEquals(unPooglin.getPosicionY(),unaTierra.getPosicionY());
	}
	
	
	public void testInteraccionPooglin(){

		unPlaneta.agregarObstaculo(unaTierra,2,2);
		unRayoLaser.interactuar(unPooglin,unPlaneta);
		/*
		 * El Pooglin tiene que mantener su posicion en X porque su
		 * dureza aun es 0 entonces no cre� aire delante suyo.
		 */
	    assertEquals(1,unPooglin.getPosicionX());
		assertEquals(2,unPooglin.getPosicionY());
		
		/*
		 * Ahora decremento la dureza de Tierra (dej�ndola en cero) para que
		 * entre al ciclo. Asi se elimina la Tierra delante del Pooglin,
		 * colocando un bloque de Aire.
		 */
		unaTierra.decrementarDureza(3);
		System.out.println("La dureza ahora es " + unaTierra.getDureza());
		unRayoLaser.interactuar(unPooglin,unPlaneta);
		System.out.println("Sssssssssss.");
		/*
		 * Para probar que hay un bloque Aire, compruebo si es o no traspasable
		 * ya que la Tierra no lo era y el Aire si.
		 */
		assertTrue(unPlaneta.getBloque(2,2).esTraspasable());
		System.out.println("Se elimin� la Tierra delante del Pooglin.");
		assertEquals(1,unPooglin.getPosicionX());
		assertEquals(2,unPooglin.getPosicionY());
		System.out.println("La posici�n del Pooglin a�n no cambia.");
		
		
		/*
		 * Ahora 
		 */
	}

}