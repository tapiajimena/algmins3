package habilidad;
import juego.Planeta;
import pooglin.Pooglin;
import punto.Punto;
import bloque.Rompible;

public class TaladroUltrasonico extends Habilidad{
	
	private int vueltasDeTorpedo=25;
	
	public TaladroUltrasonico(Pooglin unPooglin){
		super(unPooglin);
	}
	
	public void interactuar(Planeta unPlaneta){
		Punto posicionBloque=pooglin.getPosicion();
		posicionBloque=pooglin.getPosicion().puntoRelativo(1,0);
		if (unPlaneta.getBloque(posicionBloque) instanceof Rompible ){
			if (this.getVueltasDeTorpedo()!= 0){
				Rompible bloqueRompible=(Rompible)unPlaneta.getBloque(posicionBloque);
				if (bloqueRompible.getDureza() != 0){
					bloqueRompible.golpear();
					this.decrementarVueltas();
				}else{
					unPlaneta.quitarObstaculo(posicionBloque);
					pooglin.definirHabilidad(null);
					pooglin.caminar();
				}
			}else{
				pooglin.caminar();
			}
		}else{
			pooglin.caminar();
		}
	}

	public void decrementarVueltas(){
		this.vueltasDeTorpedo--;
	}

	public int getVueltasDeTorpedo() {
		return vueltasDeTorpedo;
	}
}