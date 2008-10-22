import pooglin.Pooglin;
import punto.Punto;
import bloque.Roca;
import juego.Nivel;
import juego.Planeta;
import junit.framework.TestCase;
public class RocaTest extends TestCase {
	
	Punto punto = new Punto(1,2);
	Roca roca = new Roca(punto);
	Nivel nivel = new Nivel();
	
	/*Creo una matriz con el terreno a utilizar.
	*Tambien si se quiere se le puede pasar un archivo con la matriz al constructor 
	*de Planeta.
	*"Geografia" de este terreno:
	* 	  AARAA
	*	  AARAA
	*	  TTTTT
	*	  TTTTT
	*/
	char[][] matriz={{'A','A','R','A','A'},{'A','A','R','A','A'},{'T','T','T','T','T'},{'T','T','T','T','T'}};
	
	public void testTraspasable(){
		assertEquals(false,roca.esTraspasable());
	}

	public void testInteraccion(){
		
		Planeta unPlaneta=new Planeta(4,5,matriz);
		nivel.setPlaneta(unPlaneta);
		Pooglin pooglin= new Pooglin(punto);
		
		boolean posiciones = pooglin.getPosicion().equals(roca.getPosicion());
		assertEquals(true, posiciones);
		
	}



	
}
