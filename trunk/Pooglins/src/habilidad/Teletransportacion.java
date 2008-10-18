package habilidad;
import pooglin.Pooglin;
import juego.Planeta;

public class Teletransportacion extends Habilidad {
	private int contadorPasos=5;
	public Teletransportacion(Pooglin unPooglin){
		super(unPooglin);
	}
	@Override
	public void interactuar(Planeta planeta) {
		if(contadorPasos<=0){
			pooglin.setPosicionX(pooglin.getPosicionX()+ 20);
			pooglin.definirHabilidad(null);
			//pooglin.caminar();
		}else{
			contadorPasos--;
			//pooglin.caminar();
		}
		
	}
	 
}
 
