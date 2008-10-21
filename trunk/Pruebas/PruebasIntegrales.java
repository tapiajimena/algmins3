import java.io.IOException;

import pooglin.Pooglin;
import juego.*;
import punto.*;

import junit.framework.TestCase;


public class PruebasIntegrales extends TestCase {
	
	public void testNivelPooglin() throws IOException{	
		
		Nivel nivel=new Nivel();
		Punto punto=new Punto(0,0);
		Punto punto2=new Punto(1,2);
		
		/*Abajo cargamos un planeta desde un archivo.
		*Este seria el planeta a cargar..
		*AAAAA
		*TAAAA
		*AAAAA
		*TTTTT
		*Como vemos es de 5 x 5
		*
		*Fijarse para probar poner un archivo en un directorio por ejemplo c: y un archivo
		*.dat o .txt
		*
		*/
		Planeta unPlaneta=new Planeta("C:\\Documents and Settings\\Usuario\\Mis documentos\\workspace_java\\TPooglinsLunes\\archivo.dat",5,5);
		//Seteo el planeta cargado al nivel
		nivel.setPlaneta(unPlaneta);
		
		//queEs devuelve que clase de bloque es.
		nivel.getPlaneta().getBloque(punto2).queEs();
		
		
		Pooglin unPooglin=new Pooglin(punto,nivel);
		
		//quePuntoEs devuelve el punto
		unPooglin.getPosicion().quePuntoEs();
		
		//*Sacar los quePuntoEs no hace falta si hacemos los assert
		
		unPooglin.caminar();
		unPooglin.getPosicion().quePuntoEs();
		
		unPooglin.caminar();
		unPooglin.getPosicion().quePuntoEs();
		
		unPooglin.caminar();
		unPooglin.getPosicion().quePuntoEs();
		
		unPooglin.caminar();
		unPooglin.getPosicion().quePuntoEs();
		
		unPooglin.caminar();
		unPooglin.getPosicion().quePuntoEs();
		
		
		System.out.println(unPooglin.estaMuerto());
		
		//Como vemos en el terreno el pooglin debe avanzar hasta la posicion 2,4 de la matriz
		Punto nuevoPunto=new Punto(2,4);
		
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
