package habilidad;
import pooglin.Pooglin;
import punto.Punto;
import juego.Planeta;

public class Teletransportacion extends Habilidad {
	private int contadorPasos=5;
	public Teletransportacion(Pooglin unPooglin){
		super(unPooglin);
	}
	@Override
	public void interactuar(Planeta planeta) {
		if(contadorPasos<=0){
			Punto proximaPosicion = pooglin.getPosicion();
			proximaPosicion.setX( proximaPosicion.getX()+20);
			pooglin.setPosicion(proximaPosicion);
			pooglin.definirHabilidad(null);
		}else{
			contadorPasos--;
			//pooglin.caminar();
		}
		
	}
	 
}
 
