package tests;
import habilidad.TaladroUltrasonico;
import juego.Nivel;
import juego.Planeta;
import junit.framework.TestCase;
import pooglin.Pooglin;
import punto.Punto;
import bloque.Bloque;
import bloque.Tierra;


public class TestTaladroUltraSonico extends TestCase {
    	Pooglin unPooglin ;
	Nivel nivel;
	Planeta unPlaneta ;
	TaladroUltrasonico unTaladro;
	
	public void setUp(){
		 /*Creo el nivel del pooglin y cargo el planeta*/
	    nivel=new Nivel();
	    char[][] matriz={
		    {'A','A','A','A','A','A'},
		    {'T','T','T','T','T','T'},
		    {'T','T','T','T','T','T'},
		    {'T','T','T','T','T','T'}
	    };
	    
	    unPlaneta=new Planeta(4,6,matriz);
	    
	    nivel.setPlaneta(unPlaneta);
	    
	    unPooglin=new Pooglin(new Punto(0,2),nivel);
	}
	public void testElTaladroSeGasta(){
		unTaladro=new TaladroUltrasonico(unPooglin);
		int vueltasIniciales=unTaladro.getVueltasDeTorpedo();
	    /*Empiezo la interaccion*/
	    /* La idea es golpear la tierra hasta tenga dureza cero*/
	    for(int i=1;vueltasIniciales>i;i++){
	    	unPlaneta.agregarObstaculo(new Tierra(unPooglin.getPosicion().puntoRelativo(1, 0)));
	    	unTaladro.interactuar(unPlaneta);
	    	assertEquals(vueltasIniciales-i,unTaladro.getVueltasDeTorpedo());
	    }
	}
	public void testInteraccionPooglin(){
	   
	    /*
	     * Corroboro que un bloque del tipo tierra se
	     * encuentra delante del Pooglin
	     */
	    Bloque bloqueInferior=unPlaneta.getBloque( unPooglin.getPosicion().puntoRelativo(1,0));
	    
	    assertTrue(bloqueInferior instanceof Tierra);
	    
	    unTaladro=new TaladroUltrasonico(unPooglin);
	    
	    /*guardo informacion inicial*/
	    
	    int durezaInicial=((Tierra)bloqueInferior).getDureza();
	    
	    Punto posicionInicialPooglin=unPooglin.getPosicion();
	    
	    Punto posicionInicialBloque=bloqueInferior.getPosicion();
	    
	    int disparosInicial=unTaladro.getVueltasDeTorpedo();
	    
	    /*Empiezo la interaccion*/
	    /* La idea es golpear la tierra hasta tenga dureza cero*/
	    for(int i=1;durezaInicial>i;i++){
	    	unTaladro.interactuar(unPlaneta);
			assertEquals(durezaInicial-i,((Tierra)bloqueInferior).getDureza());
			assertEquals(disparosInicial-i,unTaladro.getVueltasDeTorpedo());
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
	    unTaladro.interactuar(unPlaneta);
	    
	    bloqueInferior=unPlaneta.getBloque(posicionInicialBloque);
	    
	    assertTrue(bloqueInferior.esTraspasable());
	    
	    assertTrue( unPooglin.getPosicion().equals(posicionInicialPooglin.puntoRelativo(1,0)));
	    /*Ahora de manera similar compruebo que rompa el bloque siguiente
	    *empiezo por guardar el estado inicial
	    */
	    bloqueInferior =unPlaneta.getBloque( unPooglin.getPosicion().puntoRelativo(1,0));
	   
	    durezaInicial=((Tierra)bloqueInferior).getDureza();
	    
	    posicionInicialPooglin=unPooglin.getPosicion();
	    
	    posicionInicialBloque=bloqueInferior.getPosicion();
	    assertTrue(posicionInicialPooglin.puntoRelativo(1,0).equals(posicionInicialBloque));
	    /*Opero*/
	    assertTrue(bloqueInferior instanceof Tierra);
	    for(int i=1;durezaInicial>i;i++){
	    	if(unTaladro.getVueltasDeTorpedo()<=0){
	    		unTaladro= new TaladroUltrasonico(unPooglin);
	    		unPooglin.definirHabilidad(unTaladro);
	    	}
	    	unTaladro.interactuar(unPlaneta);
	    	assertEquals(durezaInicial-i,((Tierra)bloqueInferior).getDureza());
	    }
	    /*aun no avanzo un bloque*/
	    assertTrue(posicionInicialPooglin.equals(unPooglin.getPosicion()));
	    /*rompe el bloque y avanza*/
	    unTaladro.interactuar(unPlaneta);
	    
	    bloqueInferior=unPlaneta.getBloque(posicionInicialBloque);
	    /*Corroboro que ahora hay una bloque traspasable en lugar del 
	     * bloque anterior y que el pooglin avanzo una posicion
	     */
	    assertTrue(bloqueInferior.esTraspasable());
	    assertTrue( unPooglin.getPosicion().equals(posicionInicialPooglin.puntoRelativo(1,0)));
	    /*Corroboro que la posicionFinal es la esperada, decencio de  0,2 al 2,2  (y,x)*/
	    assertTrue(unPooglin.getPosicion().equals(new Punto(2,2)));
	}

 
}
