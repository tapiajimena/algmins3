import pooglin.Pooglin;
import punto.Punto;
import bloque.Aire;
import juego.Nivel;
import juego.Planeta;
import junit.framework.TestCase;


public class AireTest extends TestCase {
	
	Punto punto = new Punto(1,1);
	Aire  aire = new Aire(punto);
	Nivel nivel=new Nivel();
	
	
	/*Creo una matriz con el terreno a utilizar.
	*Tambien si se quiere se le puede pasar un archivo con la matriz al constructor 
	*de Planeta.
	*"Geografia" de este terreno:
	* 	  AAAAA
	*	  AAAAA
	*	  TTTTT
	*	  TTTTT
	*/
	char[][] matriz={{'A','A','A','A','A'},{'A','A','A','A','A'},{'T','T','T','T','T'},{'T','T','T','T','T'}};
	
	public void testInteraccionAirePooglin(){
		Pooglin pooglin = new Pooglin(punto,nivel);
		Planeta unPlaneta=new Planeta(4,5,matriz);
		nivel.setPlaneta(unPlaneta);
		//verifico que esten en las mismas posiciones
		 boolean posiciones = (pooglin.getPosicion().equals(this.aire.getPosicion()));
		 assertTrue(posiciones);
		 
		/*Produzco la interaccion 
		 * y solo debe pasar que el pooglin
		 * camine, ahora esta en la posicion
		 * (1,1) debe pasar a la (1,2)
		 */
		 this.aire.interactuar(pooglin);
		 Punto nuevoPunto = new Punto(1,2);
		 assertEquals(nuevoPunto,pooglin.getPosicion());
		
	}
}
