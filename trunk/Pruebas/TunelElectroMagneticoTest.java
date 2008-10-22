import bloque.Bloque;
import bloque.Tierra;
import pooglin.Pooglin;
import punto.Punto;
import habilidad.RayoLaser;
import habilidad.TaladroUltrasonico;
import habilidad.TunelElectroMagnetico;
import juego.Nivel;
import juego.Planeta;
import junit.framework.TestCase;


public class TunelElectroMagneticoTest extends TestCase {
    Pooglin unPooglin ;
	Nivel nivel;
	Planeta unPlaneta ;
	TunelElectroMagnetico constructorDeTunel;
	
	
	public void testInteraccionPooglin(){
	    /*Creo el nivel del pooglin y cargo el planeta*/
	    nivel=new Nivel();
	    char[][] matriz={
		    {'A','A','A','A','A','A'},
		    {'A','A','A','A','A','A'},
		    {'A','A','A','A','A','A'},
		    {'T','T','T','T','T','T'}
	    };
	    
	    unPlaneta=new Planeta(4,6,matriz);
	    
	    nivel.setPlaneta(unPlaneta);
	    
	    unPooglin=new Pooglin(new Punto(2,0),nivel);
	    /*
	     * Corroboro que un bloque del tipo tierra se
	     * encuentra delante del Pooglin
	     */
	    Bloque bloqueFrontal=unPlaneta.getBloque( unPooglin.getPosicion().puntoRelativo(0,1));
	    
	    assertTrue(bloqueFrontal instanceof Tierra);
	    
	    constructorDeTunel =new TunelElectroMagnetico(unPooglin);
	    
	    /*guardo informacion inicial*/
	    
	    int durezaInicial=((Tierra)bloqueFrontal).getDureza();
	    
	    Punto posicionInicialPooglin=unPooglin.getPosicion();
	    
	    Punto posicionInicialBloque=bloqueFrontal.getPosicion();
	    
	    int disparosInicial=constructorDeTunel.getLongitudFaltante();
	    
	    /*Empiezo la interaccion*/
	    /* La idea es golpear la tierra hasta tenga dureza cero*/
	    for(int i=1;durezaInicial>=i;i++){
		constructorDeTunel.interactuar(unPlaneta);
		
		assertEquals(durezaInicial-i,((Tierra)bloqueFrontal).getDureza());
		assertEquals(disparosInicial-i,constructorDeTunel.getLongitudFaltante());
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
	    constructorDeTunel.interactuar(unPlaneta);
	    
	    bloqueFrontal=unPlaneta.getBloque(posicionInicialBloque);
	    
	    assertTrue(bloqueFrontal.esTraspasable());
	    
	    assertTrue( unPooglin.getPosicion().equals(posicionInicialPooglin.puntoRelativo(0, 1)));
	    /*Ahora de manera similar compruebo que rompa el bloque siguiente
	    *empiezo por guardar el estado inicial
	    */
	    bloqueFrontal =unPlaneta.getBloque( unPooglin.getPosicion().puntoRelativo(0,1));
	   
	    durezaInicial=((Tierra)bloqueFrontal).getDureza();
	    
	    posicionInicialPooglin=unPooglin.getPosicion();
	    
	    posicionInicialBloque=bloqueFrontal.getPosicion();
	    /*Opero*/
	    assertTrue(bloqueFrontal instanceof Tierra);
	    
	    for(int i=1;durezaInicial>=i;i++){
		constructorDeTunel.interactuar(unPlaneta);
		
		assertEquals(durezaInicial-i,((Tierra)bloqueFrontal).getDureza());
	    }
	    /*aun no avanzo un bloque*/
	    assertTrue(posicionInicialPooglin.equals(unPooglin.getPosicion()));
	    /*rompe el bloque y avanza*/
	    constructorDeTunel.interactuar(unPlaneta);
	    
	    bloqueFrontal=unPlaneta.getBloque(posicionInicialBloque);
	    /*Corroboro que ahora hay una bloque traspasable en lugar del 
	     * bloque anterior y que el pooglin avanzo una posicion
	     */
	    assertTrue(bloqueFrontal.esTraspasable());
	    assertTrue( unPooglin.getPosicion().equals(posicionInicialPooglin.puntoRelativo(0, 1)));
	}
}
