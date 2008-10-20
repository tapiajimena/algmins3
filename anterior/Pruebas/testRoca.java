import junit.framework.TestCase;
public class testRoca extends TestCase {
	
	Punto punto = new Punto(1,1);
	Roca roca = new Roca(punto);
	Pooglin pooglin= new Pooglin(punto);
	
	public void testGolpear(){
		/* Valor inicial de dureza = 1000 por defecto.
		*Golpeamos 100 veces, para cada golpe la dureza
		*se decrementa en 0,1. */
		for (int i=0; i<=99; i++){
			roca.golpear();	
		}
		/*Osea mas o menos se decrementa en 10*/
		assertEquals(990,roca.getDureza(),1);
		
		}
	
	public void testTraspasable(){
		assertEquals(false,roca.esTraspasable());
	}

	public void testInteraccion(){
		//No se que hacer hoy....
		
	}
	
}
