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
			if (this.getVueltasDeTorpedo()> 0){
				Rompible bloqueRompible=(Rompible)unPlaneta.getBloque(posicionBloque);
				bloqueRompible.golpear();
				this.decrementarVueltas();
				if (bloqueRompible.getDureza() <=0){
					unPlaneta.quitarObstaculo(posicionBloque);
					pooglin.caminar();
				}
			}else{
				pooglin.definirHabilidad(null);
			}
		}else pooglin.definirHabilidad(null);
	}

	public void decrementarVueltas(){
		this.vueltasDeTorpedo--;
	}

	public int getVueltasDeTorpedo() {
		return vueltasDeTorpedo;
	}
}