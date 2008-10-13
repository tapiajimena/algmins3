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
			assertEquals(true,unPooglin.isEstaMuerto());
		}
			
			Pooglin unPooglin=new Pooglin(new Punto(2,0));
			agujero.setPosicionX(0);
			agujero.setPosicionY(0);
			agujero.interactuar(unPooglin);
			assertEquals(false,unPooglin.isEstaMuerto());
	
	}

	public void testEsTraspasable() {	
	}
	public void testAgujeroNegro() {	
	}
	public void testVacio() {	
	}
	public void testDestruir() {

	}

}
