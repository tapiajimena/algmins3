package bloque;
import pooglin.Pooglin;
import punto.Punto;

public class Roca extends Bloque{
	/*no se usa nunca me parece*/
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
	public boolean esTraspasable(){
		return false;
	}
	/*no es rompible no deberia tenes estos metodos el taladro no usa esRompible() usa instanceof*/
	public void golpear() {
		dureza = dureza - 0.1;
	}
	
	public double getDureza() {
		return dureza;
	} 
	/*-----------------------------------------------*/
	public void queEs(){
		System.out.println("Esto es una Roca");
	}
}