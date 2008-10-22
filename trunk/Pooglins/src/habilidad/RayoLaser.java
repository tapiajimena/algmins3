package habilidad;
import juego.Planeta;
import pooglin.Pooglin;
import punto.Punto;
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
	 * Toma la posición del bloque que se encuentra delante del Pooglin, 
	 * chequea que sea rompible y en caso afirmativo, comienza a golpear.
	 */
	public void interactuar(Planeta unPlaneta){
		
		Punto posicionBloque;

		/*el bloque de delante*/
		posicionBloque=pooglin.getPosicion().puntoRelativo(0, pooglin.getVectorDireccion());
		
		if (unPlaneta.getBloque(posicionBloque) instanceof Rompible){
			if (this.getDisparos()!= 0){
				Rompible bloqueRompible=(Rompible)unPlaneta.getBloque(posicionBloque);
				if (bloqueRompible.getDureza() > 0){
					bloqueRompible.golpear();
					this.decremetarDisparos();
				}else{
					unPlaneta.quitarObstaculo(posicionBloque);
					pooglin.caminar();
				}
			}else{
				pooglin.caminar();
			}
		}else{
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
