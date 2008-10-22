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


@SuppressWarnings("unused")
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
	     * Corroboro que un bloque traspasable se
	     * encuentra delante del Pooglin
	     */
	    Bloque bloqueFrontal=unPlaneta.getBloque( unPooglin.getPosicion().puntoRelativo(0,1));
	    
	    assertTrue(bloqueFrontal.esTraspasable());
	    
	    constructorDeTunel =new TunelElectroMagnetico(unPooglin);
	    int longitudInicial=constructorDeTunel.getLongitudFaltante();
	    Punto posicionInicialPooglin;
	    /*Empiezo la interaccion*/
	    for(int i=1;i<constructorDeTunel.getLongitudFaltante();i++){
		posicionInicialPooglin=unPooglin.getPosicion();
		constructorDeTunel.interactuar(unPlaneta);
		assertEquals(longitudInicial-i,constructorDeTunel.getLongitudFaltante());
		assertTrue(unPooglin.getPosicion().equals(posicionInicialPooglin.puntoRelativo(-1,unPooglin.getVectorDireccion())));		
	    }
	    posicionInicialPooglin=unPooglin.getPosicion();
	    constructorDeTunel.interactuar(unPlaneta);
	    System.out.println(unPooglin.getPosicion());
	    //assertTrue(unPooglin.getPosicion().equals(new Punto(1,3)));
	    constructorDeTunel.interactuar(unPlaneta);
	    //unPooglin.caminar();
	    System.out.println(unPooglin.getPosicion());
	    constructorDeTunel.interactuar(unPlaneta);
	    System.out.println(unPooglin.getPosicion());
	    
	}
}
