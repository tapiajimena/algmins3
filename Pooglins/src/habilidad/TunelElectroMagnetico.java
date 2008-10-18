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
		Punto posicionBloque = pooglin.getPosicion();
		/*el bloque de delante*/
		posicionBloque.setX( posicionBloque.getX()+1);	
		if (unPlaneta.getBloque(posicionBloque) instanceof Aire){
			if (this.getLongitudFaltante()!=0 && this.longitudFaltante>0){
				Bloque BloqueTunel = new Tunel(posicionBloque);
				unPlaneta.agregarObstaculo(BloqueTunel);
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
 
