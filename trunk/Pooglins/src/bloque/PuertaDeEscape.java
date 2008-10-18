package bloque;
import Pooglin;
import Punto;


public class PuertaDeEscape extends Bloque {
		
	public PuertaDeEscape(Punto punto) {
		super(punto);
		
	}

	public void interactuar(Pooglin unPooglin) {
		  if(unPooglin.getPosicionX()==this.getPosicionX()){
		    	if(unPooglin.getPosicionY()==this.getPosicionY()){
		    		unPooglin.salvar();
	 	
		    	}
		  }
	}
	
}
