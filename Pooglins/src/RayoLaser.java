public class RayoLaser extends Habilidad {
 
	private int disparos;
	
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
		if (unPlaneta.getBloque(posicionX+1,posicionY+1) instanceof Rompible){
			if (this.getDisparos()!= 0){
				Rompible bloqueRompible=(Rompible)unPlaneta.getBloque(posicionX,posicionY+1);
				if (bloqueRompible.getDureza() != 0){
					bloqueRompible.golpear();
				}
			}
		}
	}
	
	
	public int getDisparos(){
		return this.disparos;
	}
	
	public void setDisparos(){
		this.disparos = 10;
	}
	
	public RayoLaser(int cantidadDisparos){
		this.disparos = cantidadDisparos;
	}
	 
}
 