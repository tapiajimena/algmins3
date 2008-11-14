package tests;
import habilidad.Congelamiento;
import habilidad.Habilidad;
import juego.Nivel;
import juego.Planeta;
import junit.framework.TestCase;
import pooglin.Pooglin;
import punto.Punto;
import bloque.Aire;
import bloque.Hielo;


public class TestCongelamiento extends TestCase {

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
			{'A','A','A','A','A'},
			{'A','A','A','A','A'},
			{'A','A','A','A','A'},
			{'T','T','T','T','T'}
	};
	
	Nivel nivel = new Nivel();
	Punto punto = new Punto(2,2);
	Planeta unPlaneta=new Planeta(4,5,matriz);
	nivel.setPlaneta(unPlaneta);
	Pooglin pooglin = new Pooglin(punto ,nivel);
	/*Referencio el bloque de debajo, para comprobar */
	Habilidad congelamiento=new Congelamiento(pooglin);
	/*Inicialmente el pooglin esta en la posicion de un Bloque del tipo aire*/
	assertTrue( unPlaneta.getBloque(punto) instanceof Aire );
	congelamiento.interactuar(unPlaneta);
	/*luego de aplicar la habilidad el pooglin muere y 
	 * un bloqe de hielo ocupa su lugar en planeta
	 */
	assertTrue(pooglin.estaMuerto());
	assertTrue( unPlaneta.getBloque(punto) instanceof Hielo );

    }
    
}