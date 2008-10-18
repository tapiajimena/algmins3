package bloque;
import pooglin.Pooglin;
import punto.Punto;
import juego.Nivel;


public class Aire extends Bloque {
	private Nivel nivel = new Nivel();
	
	public Aire(Punto punto) {
		super(punto);
		
	}
	public boolean esTraspasable(){
		return true;
	}
	
	public void interactuar(Pooglin unPooglin) {
		if (unPooglin.getPosicionX()==this.getPosicionX()){
	    	if(unPooglin.getPosicionY()==this.getPosicionY()){
	    		if (nivel.getPlaneta().getBloque(this.getPosicionX(),this.getPosicionY()+1).esTraspasable()){
	    			unPooglin.caer();
	    		}else{
	    				unPooglin.caminar();
	    		}
	}

}
}
}
