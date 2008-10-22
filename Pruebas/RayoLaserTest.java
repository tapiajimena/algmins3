
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
	    char[][] matriz={{'A','A','A','T','T'},
		    {'A','A','A','T','T'},
		    {'A','A','A','T','T'},
		    {'T','T','T','T','T'}};
	    unPlaneta=new Planeta(4,5,matriz);
	    nivel.setPlaneta(unPlaneta);
	    unPooglin=new Pooglin(new Punto(2,2),nivel);
	    /*
	     * Corroboro que un bloque del tipo tierra se
	     * encuentra delante del Pooglin
	     */
	    Bloque bloqueFrontal=unPlaneta.getBloque( unPooglin.getPosicion().puntoRelativo(0,1));
	    assertTrue(bloqueFrontal instanceof Tierra);
	    unRayoLaser=new RayoLaser(unPooglin);
	    /*Empiezo la interaccion*/
	    /* La idea es golpear la tierra hasta tenga dureza cero*/
	    int durezaInicial=((Tierra)bloqueFrontal).getDureza();
	    Punto posicionInicialPooglin=unPooglin.getPosicion();
	    Punto posicionInicialBloque=bloqueFrontal.getPosicion();
	    for(int i=1;durezaInicial>=i;i++){
		unRayoLaser.interactuar(unPlaneta);
		assertEquals(durezaInicial-i,((Tierra)bloqueFrontal).getDureza());
	    }
	    /*el bloque de tierra todabia no esta roto por lo que 
	     * el pooglin debe seguir en la posicionanterior
	     */
	    assertTrue(posicionInicialPooglin.equals(unPooglin.getPosicion()));
	    /*
	     * Con una interacccion mas el bloque se debe romper, el pooglin avanza un casillero simultaneamente
	     * Para probar que hay un bloque Aire delante, compruebo si es o no traspasable
	     * ya que la Tierra no lo era y el Aire si.
	     */
	    unRayoLaser.interactuar(unPlaneta);
	    bloqueFrontal=unPlaneta.getBloque(posicionInicialBloque);
	    assertTrue(bloqueFrontal.esTraspasable());
	    /*
	     * 
	    */

	}

}