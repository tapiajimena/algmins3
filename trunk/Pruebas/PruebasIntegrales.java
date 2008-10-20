import java.io.IOException;

import pooglin.Pooglin;
import juego.*;
import punto.*;

import junit.framework.TestCase;


public class PruebasIntegrales extends TestCase {
	
	
	public void testNivelPooglin() throws IOException{	
		
		Nivel nivel=new Nivel();
		Punto punto=new Punto(1,1);
		
		//Abajo cargamos un planeta desde un archivo.
		Planeta unPlaneta=new Planeta("C:\\Documents and Settings\\Usuario\\Mis documentos\\workspace_java\\Pooglins3\\src\\archivo.dat",4,4);
		//Seteo el planeta cargado al nivel
		nivel.setPlaneta(unPlaneta);
		
		
		Pooglin unPooglin=new Pooglin(punto,nivel);
	
		unPooglin.getPosicion().quePuntoEs();
		
		unPooglin.caminar();
		
		unPooglin.getPosicion().quePuntoEs();
		
		//Como vemos en el terreno el pooglin debe avanzar en Y
		Punto nuevoPunto=new Punto(1,2);
		
		assertEquals(nuevoPunto,unPooglin.getPosicion());
		
		
	}
	
	public void testPooglingSoloPelado(){
		//Pooglin unPoogling = new Pooglin();
		/*
		 * creo un terreno
		 * agrego el poogling
		 * agrego las otras yerbas
		 * "muevo el poogling"
		 * y verifico que todo haya ocurrido como se esperaba
		 */
	}
	

}
