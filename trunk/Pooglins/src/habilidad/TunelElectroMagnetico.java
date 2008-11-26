package habilidad;
import juego.Planeta;
import pooglin.Pooglin;
import punto.Punto;
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
		
		posicionBloque=pooglin.getPosicion().puntoRelativo(0,pooglin.getVectorDireccion());
		
		if (unPlaneta.getBloque(posicionBloque).esTraspasable()){
			if (this.longitudFaltante>0){
				unPlaneta.agregarObstaculo(new Tunel(posicionBloque));
				this.longitudFaltante--;
			}
		}
		pooglin.definirHabilidad(null);
	}

	public int getLongitudFaltante() {
		return longitudFaltante;
	}
	 
}
 
