package bloque;
import pooglin.Pooglin;
import punto.Punto;

public class Roca extends Bloque{
		
	public Roca(Punto punto){
		super (punto);
		
	}	
	public void interactuar(Pooglin unPooglin) {
		if(this.posicion.equals(unPooglin.getPosicion())){
    			unPooglin.caminar();
		}
	}
	
	public boolean esTraspasable(){
		return false;
	}
	
	public char getLetra(){
		return 'R';
	}
}