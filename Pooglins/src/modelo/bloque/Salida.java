package modelo.bloque;

import modelo.Pooglin;
import modelo.Punto;




public class Salida extends Bloque {
		
	public Salida(Punto punto) {
		super(punto);
	}

	public void interactuar(Pooglin unPooglin) {
		if(this.posicion.equals(unPooglin.getPosicion())){
    		unPooglin.salvar();
		}
	}
	
	public boolean esTraspasable(){
		return true;
	}

	public char getLetra(){
		return 'S';
	}
	public boolean equals(Object obj){
		if(obj instanceof Salida){
			return super.equals(obj);
		}
		return false;
	}
}
