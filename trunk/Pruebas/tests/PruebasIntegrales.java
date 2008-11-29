package tests;
import java.io.IOException;

import Modelo.Pooglin;
import Modelo.Punto;

import juego.*;
import punto.*;

import junit.framework.TestCase;


public class PruebasIntegrales extends TestCase {
	
	/*
	 * Las siguientes prubas van a mostras que es lo que sucede con las interaccion de los bloques
	 * sin habilidades. O sea se crea un terreno y se pone a un pooglin a desarrollar su actividad
	 * por defecto.
	 * Se van a realizar 6 pruebas similares para ver la interaccion con distintos bloque y con distintos
	 * terrenos.
	 * 
	 */
	public void testNivelPooglinInteraccionBloquesUno() throws IOException{	
		
		Nivel nivel=new Nivel();
		
		Punto punto=new Punto(0,0);
		
		
		/*Creo una matriz con el terreno a utilizar.
		*Tambien si se quiere se le puede pasar un archivo con la matriz al constructor 
		*de Planeta.
		*"Geografia" de este terreno:
		*  P->AAAAA
		*	  AAAAA
		*	  AAAAA<-L
		*	  TTTTT
		*P:Lugar de partida.(0,0)
		*L:Lugar donde deberia llegar.(2,4)
		*/
		char[][] matriz={{'A','A','A','A','A'},{'A','A','A','A','A'},{'A','A','A','A','A'},{'T','T','T','T','T'}};
		
		//USO INTERNOR: Borrar al finalizar.
		//Cantidad filas de la matriz
		//Cantidad columnas de la matriz
		
		Planeta unPlaneta=new Planeta(4,5,matriz);
		
		//Seteo el Planeta creado al nivel
		nivel.setPlaneta(unPlaneta);
		
		//Le paso el Punto de inicio y el Nivel al Pooglin
		Pooglin unPooglin=new Pooglin(punto,nivel);
		
		/*Comenzamos a interactuar.
		 * Conociendo la "geografia" del terreno que estamos probando
		 * vemos que el pooglin debe "caer" y luego "caminar" hasta la posicion
		 * (2,4) de la matriz
		 * Debe interactuar 6 veces para llegar a esa posicion en teoria
		 */
		for(int i=1; i<=6;i++){
			unPooglin.interactuar();
		}
		
		//Como vemos en el terreno el pooglin debe avanzar hasta la posicion 2,4 de la matriz
		Punto nuevoPunto=new Punto(2,4);
		assertEquals(nuevoPunto,unPooglin.getPosicion());
	
		/*
		 * Ademas como el Pooglin cae menos de 5 bloques (posiciones en la matriz)
		 * El mismo no debe estar muerto, sino algo esta mal
		 *  
		 */
		assertEquals(false,unPooglin.estaMuerto());	
	}
	
public void testNivelPooglinInteraccionBloquesDos() throws IOException{	
		
		Nivel nivel=new Nivel();
		
		Punto punto=new Punto(0,0);
		
		
		/*Creo una matriz con el terreno a utilizar.
		*Tambien si se quiere se le puede pasar un archivo con la matriz al constructor 
		*de Planeta.
		*"Geografia" de este terreno:
		*  P->AAAAA
		*	  AAAAA
		*	  AAAAA
		*	  AAAAA
		*	  AAAAA
		*  L->AAAAA
		*     TTTTT
		*P:Lugar de partida.(0,0)
		*L:Lugar donde deberia llegar.Pero debe estar muerto para este entonces.
		*/
		char[][] matriz={{'A','A','A','A','A'},{'A','A','A','A','A'},{'A','A','A','A','A'},{'A','A','A','A','A'},{'A','A','A','A','A'},{'A','A','A','A','A'},{'T','T','T','T','T'}};
		
		//USO INTERNOR: Borrar al finalizar.
		//Cantidad filas de la matriz
		
		//Cantidad columnas de la matriz
				
		Planeta unPlaneta=new Planeta(7,5,matriz);
		
		//Seteo el Planeta creado al nivel
		nivel.setPlaneta(unPlaneta);
		
		//Le paso el Punto de inicio y el Nivel al Pooglin
		Pooglin unPooglin=new Pooglin(punto,nivel);
		
		/*Comenzamos a interactuar.
		 * Conociendo la "geografia" del terreno que estamos probando
		 * vemos que el pooglin debe "caer" 5 bloque y "morir"
		 * Debe interactuar 5 veces para llegar a esa posicion en teoria
		 */
		for(int i=1; i<=5;i++){
			unPooglin.interactuar();
		}
		/*
		 * Como el Pooglin cae 5 bloques
		 * El mismo debe estar muerto, sino algo esta mal
		 *  
		 */
		assertEquals(true,unPooglin.estaMuerto());	
	}


public void testNivelPooglinInteraccionBloqueTres() throws IOException{	
	
	Nivel nivel=new Nivel();
	
	Punto punto=new Punto(0,0);
	
	
	/*Creo una matriz con el terreno a utilizar.
	*Tambien si se quiere se le puede pasar un archivo con la matriz al constructor 
	*de Planeta.
	*"Geografia" de este terreno:
	*  P->AAAAA
	*	  TAAAA
	*	  AAAAA
	*	  TTTTT<-
	*P:Lugar de partida.(0,0)
	*L:Lugar donde deberia llegar.(2,4)
	*/
	char[][] matriz={{'A','A','A','A','A'},{'T','A','A','A','A'},{'A','A','A','A','A'},{'T','T','T','T','T'}};
		
	Planeta unPlaneta=new Planeta(4,5,matriz);
	
	//Seteo el Planeta creado al nivel
	nivel.setPlaneta(unPlaneta);
	
	//Le paso el Punto de inicio y el Nivel al Pooglin
	Pooglin unPooglin=new Pooglin(punto,nivel);
	
	/*Comenzamos a interactuar.
	 * Conociendo la "geografia" del terreno que estamos probando
	 * vemos que el pooglin debe caminar hacia la derecha un bloque y
	 * luego "caer" y luego "caminar" hasta la posicion final.
	 * (2,4) de la matriz
	 * Veremos que salta el obstaculo de la posicion (1,0) y que luego cae
	 * hasta toparse con la tierra y sigue hasta la posicion final
	 * Debe interactuar 2 veces para llegar a la tierra en teoria posicion (2,2)
	 */
	for(int i=1; i<=2;i++){
		unPooglin.interactuar();
	}
	Punto nuevoPunto=new Punto(2,1);
	assertEquals(nuevoPunto,unPooglin.getPosicion());
	/*
	 * Luego deberia interactuar 2 veces mas para llegar a la posicion final
	 */
	for(int i=1; i<=3;i++){
		unPooglin.interactuar();
	}
	//Como vemos en el terreno el pooglin debe avanzar hasta la posicion 2,4 de la matriz
	Punto nuevoPunto2=new Punto(2,4);
	assertEquals(nuevoPunto2,unPooglin.getPosicion());

	
}

public void testNivelPooglinInteraccionBloquesCuatro() throws IOException{	
	
	Nivel nivel=new Nivel();
	
	Punto punto=new Punto(0,0);
	
	
	/*Creo una matriz con el terreno a utilizar.
	*Tambien si se quiere se le puede pasar un archivo con la matriz al constructor 
	*de Planeta.
	*"Geografia" de este terreno:
	*  P->AAAAA
	*	  TTTTA
	*	  AAAAA<-L
	*	  TTTTT
	*P:Lugar de partida.(0,0)
	*L:Lugar donde deberia llegar. Pero por otro camino (2,4)
	*/
	char[][] matriz={{'A','A','A','A','A'},{'T','T','T','T','A'},{'A','A','A','A','A'},{'T','T','T','T','T'}};
	
	//USO INTERNOR: Borrar al finalizar.
	
	Planeta unPlaneta=new Planeta(4,5,matriz);
	
	//Seteo el Planeta creado al nivel
	nivel.setPlaneta(unPlaneta);
	
	//Le paso el Punto de inicio y el Nivel al Pooglin
	Pooglin unPooglin=new Pooglin(punto,nivel);
	
	/*Comenzamos a interactuar.
	 * Conociendo la "geografia" del terreno que estamos probando
	 * vemos que el pooglin debe "caminar" por la fila 0 hasta la posicion
	 * (0,3) y luego caer hasta la posicion (2,4) de la matriz
	 * Debe interactuar 3 veces para llegar a la posicion (0,3)
	 */
	for(int i=1; i<=3;i++){
		unPooglin.interactuar();
	}
	
	//Como vemos en el terreno el pooglin debe avanzar hasta la posicion (0,3) de la matriz
	Punto nuevoPunto=new Punto(0,3);
	assertEquals(nuevoPunto,unPooglin.getPosicion());

	/*
	 * Y ahora "caer" dos veces
	 */
	for(int i=1; i<=2;i++){
		unPooglin.interactuar();
	}
	
	//Ahora como vemos en el terreno el pooglin debe "caer" hasta la posicion (2,3) de la matriz
	Punto nuevoPunto2=new Punto(2,4);
	assertEquals(nuevoPunto2,unPooglin.getPosicion());
}

public void testNivelPooglinInteraccionBloquesCinco() throws IOException{	
	
	Nivel nivel=new Nivel();
	
	Punto punto=new Punto(0,0);
	
	
	/*Creo una matriz con el terreno a utilizar.
	*Tambien si se quiere se le puede pasar un archivo con la matriz al constructor 
	*de Planeta.
	*"Geografia" de este terreno:
	*  P->AAAAA
	*	  AAAAT
	*	  AAAAT
	*	  TTTTT
	*P:Lugar de partida.(0,0)
	*Deberia caer por la columna 0, luego caminar hasta la posicion (2,3) y
	*al haber un bloque tierra en la pos (2,4) dar vuelta y caminar en la otra
	*direccion
	*/
	char[][] matriz={{'A','A','A','A','A'},{'A','A','A','A','T'},{'A','A','A','A','T'},{'T','T','T','T','T'}};
	
	
	Planeta unPlaneta=new Planeta(4,5,matriz);
	
	//Seteo el Planeta creado al nivel
	nivel.setPlaneta(unPlaneta);
	
	//Le paso el Punto de inicio y el Nivel al Pooglin
	Pooglin unPooglin=new Pooglin(punto,nivel);
	
	/*Comenzamos a interactuar.
	 * Conociendo la "geografia" del terreno que estamos probando
	 * vemos que el pooglin debe caer por la columna 0 hasta la posicion
	 * (2,0) y luego caminar hasta la posicion (2,4) de la matriz
	 * Debe interactuar 2 veces para llegar a la posicion (2,0)
	 */
	for(int i=1; i<=2;i++){
		unPooglin.interactuar();
	}
	
	Punto nuevoPunto=new Punto(2,0);
	assertEquals(nuevoPunto,unPooglin.getPosicion());

	/*
	 * Y ahora caminar 3 veces hasta la posicion (2,3) donde "rebota"
	 */
	for(int i=1; i<=3;i++){
		unPooglin.interactuar();
	}
	
	Punto nuevoPunto2=new Punto(2,3);
	assertEquals(nuevoPunto2,unPooglin.getPosicion());
	
	/*
	 * Al intentar caminar hacia adelante, como el bloque que sigue no es
	 * transpasable, el pooglin debera rebotar.
	 * Si interactuo nuevamente 4 veces(1 rebote + 3 para volver), el pooglin 
	 * deberia volver a la posicion (2,0) nuevamente.
	 */
	for(int i=1; i<=4;i++){
		unPooglin.interactuar();
	}
	
	Punto nuevoPunto3=new Punto(2,0);
	assertEquals(nuevoPunto3,unPooglin.getPosicion());
}

public void testNivelPooglinInteraccionBloquesSeis() throws IOException{	
	
	Nivel nivel=new Nivel();
	
	Punto punto=new Punto(0,0);
	
	
	/*Creo una matriz con el terreno a utilizar.
	*Tambien si se quiere se le puede pasar un archivo con la matriz al constructor 
	*de Planeta.
	*"Geografia" de este terreno:
	*  P->AAAAA
	*	  AAAAA
	*	  AAFFF
	*	  TTTTT
	*P:Lugar de partida.(0,0)
	*El pooglin deberia morir en la posicion (2,2).
	*/
	char[][] matriz={{'A','A','A','A','A'},{'A','A','A','A','A'},{'A','A','F','F','F'},{'T','T','T','T','T'}};
	
	Planeta unPlaneta=new Planeta(4,5,matriz);
	
	//Seteo el Planeta creado al nivel
	nivel.setPlaneta(unPlaneta);
	
	//Le paso el Punto de inicio y el Nivel al Pooglin
	Pooglin unPooglin=new Pooglin(punto,nivel);
	
	
	/*Comenzamos a interactuar.
	 * Conociendo la "geografia" del terreno que estamos probando
	 * vemos que el pooglin debe "caer" y luego "caminar" hasta la posicion
	 * (2,1) y en la proxima interaccion se topara con fuego por lo que 
	 * en la posicion (2,2) el pooglin ya deberia estar muerto
	 * Debe interactuar 5 veces para llegar a esa posicion en teoria
	 */
	for(int i=1; i<=5;i++){
		unPooglin.interactuar();
	}
	
	//Como vemos en el terreno el pooglin debe avanzar hasta la posicion 2,2 de la matriz
	
	Punto nuevoPunto=new Punto(2,2);
	assertEquals(nuevoPunto,unPooglin.getPosicion());

	/*
	 * El pooglin deberia estar muerto porque se poso 
	 * sobre fuego.
	 */
	assertEquals(true,unPooglin.estaMuerto());	
}


}



