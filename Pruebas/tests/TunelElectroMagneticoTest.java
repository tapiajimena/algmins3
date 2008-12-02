package tests;
import modelo.Nivel;
import modelo.Planeta;
import modelo.Pooglin;
import modelo.Punto;
import modelo.bloque.Bloque;
import modelo.habilidad.TunelElectroMagnetico;
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
		    {'A','A','A','A','A','A'},
		    {'A','A','A','A','A','A'},
		    {'T','T','T','T','T','T'}
	    };
	    
	    unPlaneta=new Planeta(6,6,matriz);
	    nivel.setPlaneta(unPlaneta);
	    unPooglin=new Pooglin(new Punto(4,0),nivel);
	    /*
	     * Corroboro que un bloque traspasable se
	     * encuentra delante del Pooglin
	     */
	    Bloque bloqueFrontal=unPlaneta.getBloque( unPooglin.getPosicion().puntoRelativo(0,1));
	    assertTrue(bloqueFrontal.esTraspasable());
	    constructorDeTunel =new TunelElectroMagnetico(unPooglin);
	    unPooglin.definirHabilidad(constructorDeTunel);
	    int longitudInicial=constructorDeTunel.getLongitudFaltante();
	    Punto posicionAnteriorPooglin;
	    /*Empiezo la interaccion*/
	    for(int i=1;longitudInicial>=i;i++){
	    	posicionAnteriorPooglin=unPooglin.getPosicion();
	    	constructorDeTunel.interactuar(unPlaneta);
	    	assertEquals(longitudInicial-i,constructorDeTunel.getLongitudFaltante());
	    	/*a medida que construye el tunel va subiendo por el tunel*/
	    	assertTrue(unPooglin.getPosicion().equals(posicionAnteriorPooglin.puntoRelativo(-1,unPooglin.getVectorDireccion())));
	    }
	    /*una vez que puso la ultima piesa del tunel cae en diagonal*/
	    posicionAnteriorPooglin=unPooglin.getPosicion();
	    unPooglin.interactuar();
	    /*controlo que la nueva posicion uno en la direccion de que se mueve y uno hacia abajo por la caida*/
	    assertTrue(unPooglin.getPosicion().equals(posicionAnteriorPooglin));	    
	}
}
