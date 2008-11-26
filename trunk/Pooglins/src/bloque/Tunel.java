package bloque;
import pooglin.Pooglin;
import punto.Punto;

public class Tunel extends Bloque {

	private int duracion;
	
	public Tunel(Punto punto){
		super(punto);
		this.duracion = 1;
	}

	public int getDuracion() {
		return duracion;
	}

	public void interactuar(Pooglin unPooglin) {
		unPooglin.caminar();

	}
	public boolean esTraspasable(){
	    return false;
	}
	
	public char getLetra(){
		return 'B';
	}
}
 
