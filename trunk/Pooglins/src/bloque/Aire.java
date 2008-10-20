package bloque;
import pooglin.Pooglin;
import punto.Punto;


public class Aire extends Bloque {
	public Aire(Punto punto) {
		super(punto);
		
	}
	public boolean esTraspasable(){
		return true;
	}
	
	public void interactuar(Pooglin unPooglin) {
	/*	if (unPooglin.getPosicionX()==this.getPosicionX()){
			if(unPooglin.getPosicionY()==this.getPosicionY()){
	    		if (nivel.getPlaneta().getBloque(this.getPosicionX(),this.getPosicionY()+1).esTraspasable()){
	    			unPooglin.caer();
	    		}else unPooglin.caminar();
			}

		}*/
	}
}
