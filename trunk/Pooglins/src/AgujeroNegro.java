
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
		if( Math.abs( unPooglin.getPosicionX()-this.getPosicionX() ) <=1 && Math.abs( unPooglin.getPosicionY()-this.getPosicionY() )<=1){
			unPooglin.morir();
		}
	}
	
}
 
