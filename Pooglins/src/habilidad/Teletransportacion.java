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
		if(contadorPasos==0){
			Punto proximaPosicion = pooglin.getPosicion();
			proximaPosicion.setY(proximaPosicion.getY()+19);
			pooglin.setPosicion(proximaPosicion);
		}else if(contadorPasos>0)
			contadorPasos--;
		pooglin.caminar();
		
	}
	 
}
 
