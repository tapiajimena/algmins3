import pooglin.Pooglin;
import punto.Punto;
import habilidad.Habilidad;
import habilidad.Teletransportacion;
import junit.framework.TestCase;


public class testTeletrasportacion extends TestCase {

	public void testInteractuar() {
		Pooglin unPooglin=new Pooglin(new Punto(0,0));
		Habilidad teletransportacion=new Teletransportacion(unPooglin);
		for(int turno=0;turno<5;turno++){
			teletransportacion.interactuar(null);
		}
		int anteUltimaPosicionX=unPooglin.getPosicionX();
		teletransportacion.interactuar(null);
		assertEquals(anteUltimaPosicionX + 20,unPooglin.getPosicionX());
	}
}
