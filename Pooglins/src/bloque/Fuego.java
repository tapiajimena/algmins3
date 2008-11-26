package bloque;
import pooglin.Pooglin;
import punto.Punto;


public class Fuego extends Bloque implements Apagable {
 
	@SuppressWarnings("unused")
	private int resistencia=100;
		
	public Fuego(Punto punto){
		super(punto);
			
	}
	
	public boolean esTraspasable() {
		return true;
	}
	
	public boolean esApagable(){
		return true;
	}
	
	public void interactuar(Pooglin unPooglin){
	    if(this.posicion.equals(unPooglin.getPosicion())){
	    		unPooglin.morir();
	    }
	 }
	public char getLetra(){
		return 'F';
	}
	public boolean esMatable() {
		
		return true;
	}
}
 
