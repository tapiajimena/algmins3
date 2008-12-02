package tests;
import modelo.Nivel;
import modelo.Planeta;
import modelo.Pooglin;
import modelo.Punto;
import modelo.bloque.Tierra;
import junit.framework.TestCase;

public class TierraTest extends TestCase {
	
	Nivel nivel = new Nivel();
	Punto punto = new Punto(2,0);
	Tierra unaTierra = new Tierra(punto);
	
	/*Creo una matriz con el terreno a utilizar.
	*Tambien si se quiere se le puede pasar un archivo con la matriz al constructor 
	*de Planeta.
	*"Geografia" de este terreno:
	*  	  AAAAA
	*	  AAAAA
	*  P->AAAAA
	*	  TTTTT
	*P:Lugar de partida.(2,0)
	*Lugar donde deberia llegar.(2,1)
	*/
	char[][] matriz={
			{'A','A','A','A','A'},
			{'A','A','A','A','A'},
			{'A','A','A','A','A'},
			{'T','T','T','T','T'}};

	
	public void testGolpear(){
		/*
		 * El constructor de Tierra inicializa la dureza, es decir, la
		 * cantidad de vida del obst�culo, en 4.
		 */
		
		int decremento = 0;
		int durezaInicial=unaTierra.getDureza();
		while(unaTierra.getDureza()<=durezaInicial && unaTierra.getDureza()>0 && decremento<durezaInicial){
			//El m�todo golpear disminuye en 1 la dureza.
			unaTierra.golpear();
			decremento++;
			assertEquals(durezaInicial-decremento,unaTierra.getDureza());
		}
		/*
		 * Si contin�o decrementando, una vez que llegu� a cero, el proceso se 
		 * interrumpe y se  
		 */
		int nuevoDecremento = 0;
		
		while (unaTierra.getDureza()<=4 && unaTierra.getDureza()>0 && nuevoDecremento < 3){
			unaTierra.golpear();
			nuevoDecremento++;
			if (unaTierra.getDureza()>0){
				assertEquals(2-nuevoDecremento,unaTierra.getDureza());
			}else{
					assertEquals(0,unaTierra.getDureza());
				}	
			}
	}
	
	public void testDecrementarDureza(){
		/*
		 * Este m�todo, a diferencia del golpear, permite decrementar la dureza
		 * en un valor determinado. 
		 */
			int durezaInicial=unaTierra.getDureza();
			unaTierra.decrementarDureza(3);
			assertEquals(durezaInicial-3,unaTierra.getDureza());
			/*
			 * Veamos si le damos un valor de decremento mayor que 4, deja la
			 * dureza en 0. 
			 */
			unaTierra.decrementarDureza(20);
			assertEquals(0,unaTierra.getDureza());		
	}
		
	
	public void testInteraccionPooglinTierra(){
		punto = new Punto(2,0);
		unaTierra = new Tierra(punto.puntoRelativo(-1, 0));
		Planeta unPlaneta=new Planeta(4,5,matriz);
		nivel.setPlaneta(unPlaneta);
		Pooglin pooglin = new Pooglin(punto ,nivel);
	//Los hago interactuar
		unaTierra.interactuar(pooglin);
		/*
		 * su nueva posicion al hacer la tierra que 
		 * solamente camine 
		 * pasar� a estar 
		 * en el punto (2,1).
		 */
		Punto nuevoPunto=new Punto(2,1);
		assertEquals(nuevoPunto,pooglin.getPosicion());
		
	}
		
	public void testEsTraspasable(){
		assertFalse(unaTierra.esTraspasable());
	}
	
	public void testRompible(){
		assertTrue(unaTierra.esRomplible());
	}
}


