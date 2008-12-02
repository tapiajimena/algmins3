package tests;

import modelo.Nivel;
import modelo.Planeta;
import modelo.Pooglin;
import modelo.Punto;
import modelo.bloque.Bloque;
import modelo.bloque.Tunel;
import junit.framework.TestCase;


public class TunelTest extends TestCase {
	
	Nivel nivel = new Nivel();
	Punto punto = new Punto(2,0);
	Bloque unTunel;
	
	/*Creo una matriz con el terreno a utilizar.
	*Tambien si se quiere se le puede pasar un archivo con la matriz al constructor 
	*de Planeta.
	*"Geografia" de este terreno:
	*  	  AAAAA
	*	  AAAAA
	*  P->AAAAA
	*	  BBBBB
	*P:Lugar de partida.(2,0)
	*Lugar donde deberia llegar.(2,1)
	*/
	char[][] matriz={
			{'A','A','A','A','A'},
			{'A','A','A','A','A'},
			{'A','A','A','A','A'},
			{'B','B','B','B','B'}
	};

	
	public void testInteraccionPooglinTunel(){
		
		Planeta unPlaneta=new Planeta(4,5,matriz);
		nivel.setPlaneta(unPlaneta);
		Pooglin pooglin = new Pooglin(punto ,nivel);
		/*Referencio el bloque de debajo, para comprobar */
		unTunel=unPlaneta.getBloque(punto.puntoRelativo(1, 0));
		assertTrue(unTunel instanceof Tunel);
		//Los hago interactuar
		unTunel.interactuar(pooglin);
		/*
		 * su nueva posicion al hacer la Tunel que 
		 * solamente camine 
		 * pasará a estar 
		 * en el punto (2,1).
		 */
		assertTrue(pooglin.getPosicion().equals(new Punto(2,1)));
	}
	
	public void testEsTraspasable(){
	    unTunel=new Tunel(new Punto(0,0));
	    assertFalse(unTunel.esTraspasable());
	}
}
