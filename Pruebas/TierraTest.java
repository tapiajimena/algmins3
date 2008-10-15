import junit.framework.TestCase;

public class TierraTest extends TestCase {
	
	Punto posTierra = new Punto(1,1);
	Punto posPooglin = new Punto(1,2);
	Tierra unaTierra = new Tierra(posTierra);
	Pooglin unPooglin= new Pooglin(posPooglin);

	
	public void testGolpear(){
		/*
		 * El constructor de Tierra inicializa la dureza, es decir, la
		 * cantidad de vida del obstáculo, en 4.
		 */
		System.out.println("La dureza en este momento esta en " + unaTierra.getDureza());
		int decremento = 0;
		while(unaTierra.getDureza()<=4 && unaTierra.getDureza()>0 && decremento<4){
			//El método golpear disminuye en 1 la dureza.
			unaTierra.golpear();
			decremento++;
			assertEquals(4-decremento,unaTierra.getDureza());
			System.out.println(unaTierra.getDureza());
		}
		/*
		 * Si continúo decrementando, una vez que llegué a cero, el proceso se 
		 * interrumpe y se  
		 */
		int nuevoDecremento = 0;
		System.out.println("La dureza en este momento quedo en 2");
		while (unaTierra.getDureza()<=4 && unaTierra.getDureza()>0 && nuevoDecremento < 3){
			unaTierra.golpear();
			nuevoDecremento++;
			System.out.println(unaTierra.getDureza());
			if (unaTierra.getDureza()>0){
				assertEquals(2-nuevoDecremento,unaTierra.getDureza());
			}else{
					assertEquals(0,unaTierra.getDureza());
				}	
				
			}
		System.out.println("Como se ve nunca pasa del valor 0");
	}
	
	
	public void testDecrementarDureza(){
	/*
	 * Este método, a diferencia del golpear, permite decrementar la dureza
	 * en un valor determinado. 
	 */
		unaTierra.decrementarDureza(3);
		assertEquals(1,unaTierra.getDureza());
	/*
	 * Veamos si le damos un valor de decremento mayor que 4, deja la
	 * dureza en 0. 
	 */
		unaTierra.decrementarDureza(20);
		assertEquals(0,unaTierra.getDureza());		
	}
		
	
	public void testInteraccionPooglinHielo(){
	/*
	 * Corroboro que el Pooglin esté parado sobre la un bloque Tierra.
	 */
		assertEquals(unPooglin.getPosicionX(),unaTierra.getPosicionX());
		assertEquals(unPooglin.getPosicionY()-1,unaTierra.getPosicionY());
		System.out.println("La posicion del Pooglin es " + unPooglin.getPosicionX()+"," + unPooglin.getPosicionY());
	/*
	 * Los hago interactuar, es decir, el bloque Tierra le dice al Pooglin que
	 * camine si éste se encuentra sobre ella.
	 */
		unaTierra.interactuar(unPooglin);
		assertEquals(2,unPooglin.getPosicionX());
		assertEquals(2,unPooglin.getPosicionY());
	}
	
	
	public void testEsTraspasable(){
		assertFalse(unaTierra.esTraspasable());
	}
	
	public void testRompible(){
		assertTrue(unaTierra.esRomplible());
	}
}


