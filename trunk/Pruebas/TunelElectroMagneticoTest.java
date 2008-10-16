import junit.framework.TestCase;


public class TunelElectroMagneticoTest extends TestCase {
	
	Punto punto = new Punto(1,1);
	TunelElectroMagnetico tunel = new TunelElectroMagnetico();
	Pooglin pooglin= new Pooglin(punto);
	
	public void testLongitudFaltante(){
	//Por defecto es 2, asique va a dar la prueba seguro.
	assertEquals(2,tunel.getLongitudFaltante());
	}
	
	
	

}
