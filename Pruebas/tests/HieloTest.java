package tests;
import bloque.Hielo;
import juego.Nivel;
import juego.Planeta;
import juego.Pooglin;
import juego.Punto;
import junit.framework.TestCase;

public class HieloTest extends TestCase {

	Punto punto = new Punto(1,1);
	Hielo hielo = new Hielo(punto);
	Nivel nivel=new Nivel();
	
	
	/*Creo una matriz con el terreno a utilizar.
	*Tambien si se quiere se le puede pasar un archivo con la matriz al constructor 
	*de Planeta.
	*"Geografia" de este terreno:
	* 	  AAAAA
	*	  AHAAA
	*	  TTTTT
	*	  TTTTT
	*/
	char[][] matriz={{'A','A','A','A','A'},{'A','H','A','A','A'},{'T','T','T','T','T'},{'T','T','T','T','T'}};
	
	public void testGolpear(){
		//El constructor de hielo inicializa un atributo
		//llamado dureza, que corresponde a la cantidad de vida
		//del hielo y que tiene un valor inicial de 6.
		int decremento = 0;
		while(decremento<4){
			//El m�todo golpear disminuye en 1 la dureza.
			hielo.golpear();
			decremento++;
			assertEquals(6-decremento,hielo.getDureza());
			
		}
		//Probemos que pasa si sigo decrementando una vez
		//que ya llegue a 0 en la dureza del hielo.
		int nuevoDecremento = 0;
		
		while (nuevoDecremento < 3){
			hielo.golpear();
			nuevoDecremento++;
			
			if (hielo.getDureza()>0){
				assertEquals(2-nuevoDecremento,hielo.getDureza());
			}else{
					assertEquals(0,hielo.getDureza());
				}	
				
			}
		
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
		punto = new Punto(1,1);
		hielo = new Hielo(punto.puntoRelativo(-1, 0));
		Pooglin pooglin = new Pooglin(punto,nivel);
		Planeta unPlaneta=new Planeta(4,5,matriz);
		nivel.setPlaneta(unPlaneta);
			
	
		//Los hago interactuar
		hielo.interactuar(pooglin);
		/*
		 * su nueva posicion al hacer el hielo avanzarlo 
		 * mas rapido seria avanzar 
		 * dos lugares con lo cual pasaria a estar 
		 * en el punto (1,3).
		 */
		Punto nuevoPunto=new Punto(1,3);
		assertEquals(nuevoPunto,pooglin.getPosicion());
		
	}

	
}


