package habilidad;
import pooglin.Pooglin;
import punto.Punto;
import juego.Planeta;
import bloque.Aire;
import bloque.Bloque;
import bloque.Tunel;

public class TunelElectroMagnetico extends Habilidad {
 
	private int longitudFaltante;
	
	public TunelElectroMagnetico(Pooglin unPooglin){
		super(unPooglin);
		this.longitudFaltante = 2;
	}
	
	public void interactuar(Planeta unPlaneta){
			int posicionX = pooglin.getPosicionX();
			int posicionY = pooglin.getPosicionY();
			if (unPlaneta.getBloque(posicionX+1,posicionY) instanceof Aire){
				if (this.getLongitudFaltante()!=0 && this.longitudFaltante>0){
					Punto punto = new Punto(posicionX+1,posicionY);
					Bloque BloqueTunel = new Tunel(punto);
					unPlaneta.agregarObstaculo(BloqueTunel,posicionX+1,posicionY);
					BloqueTunel.interactuar(pooglin);
					this.longitudFaltante--;
				}else{
					pooglin.caminar();
				}
			}else{
				pooglin.caminar();
			}
	}


	public int getLongitudFaltante() {
		return longitudFaltante;
	}
	 
}
 
