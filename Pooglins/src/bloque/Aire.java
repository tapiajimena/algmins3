package bloque;
import pooglin.Pooglin;
import punto.Punto;


public class Aire extends Bloque {
	public Aire(Punto punto) {
		super(punto);
		
	}
	public boolean esTraspasable(){
		return true;
	}
	
	public void interactuar(Pooglin unPooglin) {
		unPooglin.caminar();
			
	}
	
	public void queEs(){
		System.out.println("Esto es Aire");
	}
}
