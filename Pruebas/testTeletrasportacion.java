import junit.framework.TestCase;


public class testTeletrasportacion extends TestCase {

	public void testInteractuar() {
		Pooglin unPooglin=new Pooglin(new Punto(0,0));
		Habilidad teletransportacion=new Teletransportacion();
		for(int turno=0;turno<5;turno++){
			teletransportacion.interactuar(unPooglin,null);
		}
		int anteUltimaPosicionX=unPooglin.getPosicionX();
		teletransportacion.interactuar(unPooglin,null);
		assertEquals(anteUltimaPosicionX + 20,unPooglin.getPosicionX());
	}
}
