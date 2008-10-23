package bloque;
import pooglin.Pooglin;
import punto.Punto;


public class PuertaDeEntrada extends Bloque {
	
	public PuertaDeEntrada(Punto punto) {
		super(punto);
		
	}
	public void interactuar(Pooglin unPooglin) {
		unPooglin.caminar();
		
	}

	public void queEs(){
		System.out.println("Esto es la Nave de Partida");
	}
}
 
