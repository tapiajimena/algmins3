package bloque;
import pooglin.Pooglin;
import punto.Punto;

public class Roca extends Bloque{
	
	private double dureza;
	public Roca(Punto punto){
		super (punto);
		dureza = 1000;
	}	
	public void interactuar(Pooglin unPooglin) {
		if(this.posicion.equals(unPooglin.getPosicion())){
    		unPooglin.morir();
		}
	}
	public void golpear() {
		dureza = dureza - 0.1;
	}
	
	public boolean esTraspasable(){
		return false;
	}

	public double getDureza() {
		return dureza;
	} 
	public void queEs(){
		System.out.println("Esto es una Roca");
	}
}