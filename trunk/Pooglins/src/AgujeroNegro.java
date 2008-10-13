import java.math.*;
public class AgujeroNegro extends Bloque {
	@Override
	public boolean esTraspasable() {
		return true;
	}
	@Override
	public void interactuar(Pooglin unPooglin) {
		if(abs(unPooglin.getPosicionX()-this.getPosicionX())<=1){
			unPooglin.morir();
		}
		if(abs(unPooglin.getPosicionY()-this.getPosicionY())<=1){
			unPooglin.morir();
		}
	}
	
}
 
