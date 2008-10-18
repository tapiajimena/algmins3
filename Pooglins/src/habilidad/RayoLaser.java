package habilidad;
import Planeta;
import Pooglin;
import Punto;
import bloque.Aire;
import bloque.Bloque;
import bloque.Rompible;

public class RayoLaser extends Habilidad{
 
	private int disparos;
	
	public RayoLaser(int cantidadDisparos){
		this.disparos = cantidadDisparos;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Habilidad#interactuar(Pooglin, Planeta)
	 * 
	 * Toma la posición del bloque que se encuentra delante del Pooglin, chequea que
	 * sea rompible y en caso afirmativo, comienza a golpear.
	 */
	public void interactuar(Pooglin unPooglin, Planeta unPlaneta){
		int posicionX = unPooglin.getPosicionX();
		int posicionY = unPooglin.getPosicionY();
		if (unPlaneta.getBloque(posicionX+1,posicionY) instanceof Rompible){
			if (this.getDisparos()!= 0){
				Rompible bloqueRompible=(Rompible)unPlaneta.getBloque(posicionX+1,posicionY);
				if (bloqueRompible.getDureza() != 0){
					bloqueRompible.golpear();
					this.decremetarDisparos();
					}
					else{
						Punto punto = new Punto(posicionX+1,posicionY);
						@SuppressWarnings("unused")
						Bloque BloqueEliminado = new Aire(punto);
						unPlaneta.agregarObstaculo(BloqueEliminado,posicionX+1,posicionY);
					}
			}
			else{
				unPooglin.caminar();
			}
		}
		else{
			unPooglin.caminar();
		}
	}
	
	
	public void decremetarDisparos(){
		this.disparos--;
	}
	
	public int getDisparos(){
		return this.disparos;
	}
	
}
 