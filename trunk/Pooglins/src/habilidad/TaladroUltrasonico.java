package habilidad;
import pooglin.Pooglin;
import punto.Punto;
import juego.Planeta;
import bloque.Aire;
import bloque.Bloque;
import bloque.Rompible;

public class TaladroUltrasonico extends Habilidad{
	
	private int vueltasDeTorpedo=20;
	
	public TaladroUltrasonico(Pooglin unPooglin){
		super(unPooglin);
	};
	public TaladroUltrasonico(Pooglin unPooglin,int cantidadVueltas){
		super(unPooglin);
		this.vueltasDeTorpedo = cantidadVueltas;
	}

	public void interactuar(Planeta unPlaneta){
		Punto posicionBloque=pooglin.getPosicion();
		posicionBloque.setY(posicionBloque.getY()+1);
		if (unPlaneta.getBloque(posicionBloque) instanceof Rompible ){
			if (this.getVueltasDeTorpedo()!= 0){
				Rompible bloqueRompible=(Rompible)unPlaneta.getBloque(posicionBloque);
				if (bloqueRompible.getDureza() != 0){
					bloqueRompible.golpear();
					this.decrementarVueltas();
				}else{
					unPlaneta.quitarObstaculo(posicionBloque);
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