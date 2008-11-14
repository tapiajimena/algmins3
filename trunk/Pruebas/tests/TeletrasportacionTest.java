package tests;
import habilidad.Habilidad;
import habilidad.Teletransportacion;
import juego.Nivel;
import juego.Planeta;
import junit.framework.TestCase;
import pooglin.Pooglin;
import punto.Punto;


public class TeletrasportacionTest extends TestCase {
	public void testInteractuar() {
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
	    		{	'A','A','A','A','A'
	    			,'A','A','A','A','A'
	    			,'A','A','A','A','A'
	    			,'A','A','A','A','A'
	    			,'A','A','A','A','A'
	    			,'A','A','A','A','A'
	    			,'A','A','A','A','A'
	    		},
	    		{	'T','T','T','T','T',
	    			'T','T','T','T','T',
	    			'T','T','T','T','T',
	    			'T','T','T','T','T',
	    			'T','T','T','T','T',
	    			'T','T','T','T','T',
	    			'T','T','T','T','T',
	    		}
	    	};
	    	
	    	Nivel nivel = new Nivel();
	    	Punto punto = new Punto(0,0);
	    	Planeta unPlaneta=new Planeta(2,35,matriz);
	    	nivel.setPlaneta(unPlaneta);
	    	Pooglin pooglin = new Pooglin(punto ,nivel);
	    	Habilidad teletransportacion=new Teletransportacion(pooglin);
	    	Punto siguientePosicion=pooglin.getPosicion();
	    	/*Verifico que camina 5 pasos antes de teletransportarce*/
	    	for(int i=0;i<5;i++){
	    		siguientePosicion=siguientePosicion.puntoRelativo(0,pooglin.getVectorDireccion());
	    		teletransportacion.interactuar(unPlaneta);
	    		assertTrue( pooglin.getPosicion().equals(siguientePosicion));    
	    	}
	    	siguientePosicion=siguientePosicion.puntoRelativo(0,20);
	    	/*Corroboro que se ha adelantado 20 posiciones despues de la interaccion*/
	    	teletransportacion.interactuar(unPlaneta);
    		assertTrue(pooglin.getPosicion().equals(siguientePosicion));
	}
}