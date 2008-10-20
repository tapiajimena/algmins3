
import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class testHielo extends TestCase {

	Punto punto = new Punto(2,3);
	Hielo hielo = new Hielo(punto);
	Pooglin pooglin= new Pooglin(punto);

	public void testGolpear(){
		//El constructor de hielo inicializa un atributo
		//llamado dureza, que corresponde a la cantidad de vida
		//del hielo y que tiene un valor inicial de 6.
		System.out.println("La dureza en este momento esta en 6");
		int decremento = 0;
		while(decremento<4){
			//El método golpear disminuye en 1 la dureza.
			hielo.golpear();
			decremento++;
			assertEquals(6-decremento,hielo.getDureza());
			System.out.println(hielo.getDureza());
		}
		//Probemos que pasa si sigo decrementando una vez
		//que ya llegue a 0 en la dureza del hielo.
		int nuevoDecremento = 0;
		System.out.println("La dureza en este momento quedo en 2");
		while (nuevoDecremento < 3){
			hielo.golpear();
			nuevoDecremento++;
			System.out.println(hielo.getDureza());
			if (hielo.getDureza()>0){
				assertEquals(2-nuevoDecremento,hielo.getDureza());
			}else{
					assertEquals(0,hielo.getDureza());
				}	
				
			}
		System.out.println("Como se ve nunca pasa del valor 0");
	}
	
	public void testDecrementarDureza(){
	//Este metodo a diferencia del golpear, 
	//permite decrementar la dureza en un valor determinado elegido
	// y no en solo 1 como lo realizaba el golpear.
		hielo.decrementarDureza(5);
		assertEquals(1,hielo.getDureza());
	//Veamos si le damos un valor de decremento mayor que 6 si 
	//como sucedia antes deja la dureza en 0.
		hielo.decrementarDureza(20);
		assertEquals(0,hielo.getDureza());
	}
		
	public void testInteraccionPooglinHielo(){
	//Corroboro que esten en la misma posicion.
		assertEquals(pooglin.getPosicionX(),hielo.getPosicionX());
		assertEquals(pooglin.getPosicionY(),hielo.getPosicionY());
		System.out.println("La posicion del pooglin es(2,3)");
	//Los hago interactuar
		//hielo.interactuar(pooglin);
		//assertEquals(3,pooglin.getPosicionX());
		//assertEquals(3,pooglin.getPosicionY());
	}
}


