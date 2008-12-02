package modelo.bloque;


import modelo.Pooglin;
import modelo.Punto;

public class AgujeroNegro extends Bloque {
	
	public AgujeroNegro(Punto punto) {
		super(punto);
	}
	
    public boolean esTraspasable() {
		return true;
	}
	
    public void interactuar(Pooglin unPooglin) {
		if(this.posicion.distancia(unPooglin.getPosicion()) <= 1){
			unPooglin.morir();
		}
	}

    public char getLetra(){
		return 'O';
	}
	
	public boolean esMatable() {
		return true;
	}

	public boolean equals(Object obj){
		if(obj instanceof AgujeroNegro){
			return super.equals(obj);
		}
		return false;
	}
}
 
