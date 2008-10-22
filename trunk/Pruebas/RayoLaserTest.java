
import habilidad.RayoLaser;
import juego.Nivel;
import juego.Planeta;
import junit.framework.TestCase;
import pooglin.Pooglin;
import punto.Punto;
import bloque.Bloque;
import bloque.Tierra;

public class RayoLaserTest extends TestCase {
	
	
	
    	Pooglin unPooglin ;
	Nivel nivel;
    	Planeta unPlaneta ;
	RayoLaser unRayoLaser;
    	
	
	public void testInteraccionPooglin(){
	    /*Creo el nivel del pooglin y cargo el planeta*/
	    nivel=new Nivel();
	    nivel.setPlaneta(unPlaneta);
	    char[][] matriz={{'A','A','A','T','T'},
		    {'A','A','A','T','T'},
		    {'A','A','A','T','T'},
		    {'T','T','T','T','T'}};
	    unPlaneta=new Planeta(4,5,matriz);
	    unPooglin=new Pooglin(new Punto(2,2),nivel);
	    /*
	     * Corroboro que un bloque del tipo tierra se
	     * encuentra delante del Pooglin
	     */
	    Bloque tierra=unPlaneta.getBloque(unPooglin.getPosicion().puntoRelativo(1,0));
	    assertTrue(tierra instanceof Tierra);
	    unRayoLaser=new RayoLaser(unPooglin);
	    /*Empiezo la interaccion*/
	    /* La idea es golpear la tierra hasta tenga dureza cero*/
	    int durezaInicial=((Tierra)tierra).getDureza();
	    for(int i=1;durezaInicial>=i;i++){
		unRayoLaser.interactuar(unPlaneta);
		assertEquals(durezaInicial-i,((Tierra)tierra).getDureza());
	    }
	    /*falta ver q se elimina el bloque tierra estoy en eso*/

	}

}