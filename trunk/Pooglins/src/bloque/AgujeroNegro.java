package bloque;
import pooglin.Pooglin;
import punto.Punto;


public class AgujeroNegro extends Bloque {
	
    	public AgujeroNegro(Punto punto) {
		super(punto);
	}
	@Override
	      public boolean esTraspasable() {
		return true;
	}
	@Override
	public void interactuar(Pooglin unPooglin) {
		if(this.posicion.distancia(unPooglin.getPosicion()) <= 1){
			unPooglin.morir();
		}
		
	}
	public void queEs(){
		System.out.println("Esto es un Aujero Negro");
	}
	
	public char getLetra(){
		return 'O';
	}
	public boolean esMatable() {
		
		return true;
	}
}
 
