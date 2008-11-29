package tests;
import Modelo.Pooglin;
import Modelo.Punto;
import bloque.Aire;
import juego.Nivel;
import juego.Planeta;
import junit.framework.TestCase;
import habilidad.PlatilloVolador;
import habilidad.Habilidad;

public class TestPlatilloVolador extends TestCase {
	
	public void testInteractuar(){
		
	/* Creo una matriz con el terreno a utilizar.
	 * "Geografia" de este terreno:
	 *   	  AAAAA
	 *     P->AAAAA
	 *     	  AAAAA
	 *     	  AAAAA
	 *     	  AAAAA
	 *     	  AAAAA
	 *     	  AAAAA
	 *     	  TTTTT
	 *     P:Lugar de partida.(1,0)
	 *     Lugar donde deberia llegar.(6,1)
	 */     
		
		char[][] matriz={
				{'A','A','A','A','A'},
				{'A','A','A','A','A'},
				{'A','A','A','A','A'},
				{'A','A','A','A','A'},
				{'A','A','A','A','A'},
				{'A','A','A','A','A'},
				{'A','A','A','A','A'},
				{'T','T','T','T','T'}
		};
		
		Nivel nivel = new Nivel();
		Punto punto = new Punto(1,0);
		Planeta unPlaneta = new Planeta(8,5,matriz);
		nivel.setPlaneta(unPlaneta);
		Pooglin unPooglin = new Pooglin();
		Habilidad miPlatillo = new PlatilloVolador(unPooglin);
		
		/*
		 * Inicialmente el pooglin está en la posición de un Bloque del 
		 * tipo aire.
		 */
		assertTrue(unPlaneta.getBloque(punto) instanceof Aire );
		
		/*
		 * Interactuo y observo que la posicion del Pooglin aumento una 
		 * unidad, es decir que descendio una posicion en el sentido de las
		 * x, cayo una distancia equivalente a un bloque.
		 */
		miPlatillo.interactuar(unPlaneta);
		assertEquals(1,unPooglin.getPosicion().getX());
		
		/*
		 * El platillo volador debe ayudar al Pooglin a que caiga más de
		 * cinco bloques y no muera.
		 * Se ejecuta interactuar seis veces mas.
		 */
		miPlatillo.interactuar(unPlaneta);
		miPlatillo.interactuar(unPlaneta);
		miPlatillo.interactuar(unPlaneta);
		miPlatillo.interactuar(unPlaneta);
		miPlatillo.interactuar(unPlaneta);
		/*
		 * Se debe comprobar la posicion de llegada y que el Pooglin esté
		 * vivo.
		 */
		assertEquals(6,unPooglin.getPosicion().getX());
		assertFalse(unPooglin.estaMuerto());
 

	}
	
}
