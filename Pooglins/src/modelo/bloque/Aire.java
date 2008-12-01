package modelo.bloque;

import modelo.Pooglin;
import modelo.Punto;




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
	public char getLetra(){
		return 'A';
	}
	public boolean equals(Object obj){
		if(obj instanceof Aire){
			return super.equals(obj);
		}
		return false;
	}
}
