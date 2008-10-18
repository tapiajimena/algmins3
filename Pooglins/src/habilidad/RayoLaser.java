package habilidad;
import pooglin.Pooglin;
import punto.Punto;
import juego.Planeta;
import bloque.Aire;
import bloque.Bloque;
import bloque.Rompible;

public class RayoLaser extends Habilidad{
 
	private int disparos=20;
	
	public RayoLaser(Pooglin unPooglin){
		super(unPooglin);
	}
	public RayoLaser(Pooglin unPooglin,int cantidadDisparos){
		super(unPooglin);
		this.disparos = cantidadDisparos;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see Habilidad#interactuar(Pooglin, Planeta)
	 * 
	 * Toma la posición del bloque que se encuentra delante del Pooglin, chequea que
	 * sea rompible y en caso afirmativo, comienza a golpear.
	 */
	public void interactuar(Planeta unPlaneta){
		int posicionX = pooglin.getPosicionX();
		int posicionY = pooglin.getPosicionY();
		if (unPlaneta.getBloque(posicionX+1,posicionY) instanceof Rompible){
			if (this.getDisparos()!= 0){
				Rompible bloqueRompible=(Rompible)unPlaneta.getBloque(posicionX+1,posicionY);
				if (bloqueRompible.getDureza() != 0){
					bloqueRompible.golpear();
					this.decremetarDisparos();
					}
					else{
						Punto punto = new Punto(posicionX+1,posicionY);

						Bloque BloqueEliminado = new Aire(punto);
						unPlaneta.agregarObstaculo(BloqueEliminado,posicionX+1,posicionY);
					}
			}
			else{
				pooglin.caminar();
			}
		}
		else{
			pooglin.caminar();
		}
	}
	
	
	public void decremetarDisparos(){
		this.disparos--;
	}
	
	public int getDisparos(){
		return this.disparos;
	}


}
 