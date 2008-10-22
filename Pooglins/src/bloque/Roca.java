package bloque;
import pooglin.Pooglin;
import punto.Punto;

public class Roca extends Bloque{
	/*no se usa nunca me parece*/
	
	
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
	public void queEs(){
		System.out.println("Esto es una Roca");
	}
}