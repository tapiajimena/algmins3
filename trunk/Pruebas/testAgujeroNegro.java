import junit.framework.TestCase;


public class testAgujeroNegro extends TestCase {

	public void testInteractuar() {
		boolean vivo;
		Bloque agujero=new AgujeroNegro(new Punto(1,1));
		for(int i=0;i<9;i++){
			Pooglin unPooglin=new Pooglin(new Punto(1,1));
			agujero.setPosicionX(i/3);
			agujero.setPosicionY(i%3);
			agujero.interactuar(unPooglin);

			assertEquals(true,unPooglin.EstaMuerto());

			assertEquals(true,unPooglin.EstaMuerto());

		}
			

			Pooglin unPooglin=new Pooglin(new Punto(2,0));
			agujero.setPosicionX(0);
			agujero.setPosicionY(0);
			agujero.interactuar(unPooglin);
			assertEquals(false,unPooglin.EstaMuerto());

		Pooglin unPooglin2=new Pooglin(new Punto(2,0));
		agujero.setPosicionX(0);
		agujero.setPosicionY(0);
		agujero.interactuar(unPooglin2);
		assertEquals(false,unPooglin2.EstaMuerto());

	
	}

	public void testEsTraspasable() {	
	}
	public void testVacio() {	
	}
	public void testDestruir() {

	}

}
