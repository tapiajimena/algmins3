import pooglin.Pooglin;
import punto.Punto;
import habilidad.TunelElectroMagnetico;
import junit.framework.TestCase;


public class TunelElectroMagneticoTest extends TestCase {
	
	Punto punto = new Punto(1,1);
	Pooglin pooglin= new Pooglin(punto);
	TunelElectroMagnetico tunel = new TunelElectroMagnetico(pooglin);
	
	
	public void testLongitudFaltante(){
	//Por defecto es 2, asique va a dar la prueba seguro.
	assertEquals(2,tunel.getLongitudFaltante());
	}
	
	
	

}
