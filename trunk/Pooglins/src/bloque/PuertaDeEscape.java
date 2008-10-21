package bloque;
import pooglin.Pooglin;
import punto.Punto;


public class PuertaDeEscape extends Bloque {
		
	public PuertaDeEscape(Punto punto) {
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
	public void queEs(){
		System.out.println("Esto es la Puerta de Escape");
	}
}
