package bloque;
import pooglin.Pooglin;
import punto.Punto;


public class Entrada extends Bloque {
	
	public Entrada(Punto punto) {
		super(punto);
	}
	public void interactuar(Pooglin unPooglin) {
		unPooglin.caminar();
	}
	public char getLetra(){
		return 'E';
	}
}
 
