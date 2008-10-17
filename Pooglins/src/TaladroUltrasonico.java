public class TaladroUltrasonico extends Habilidad{
	
	private int vueltasDeTorpedo;
	
	public TaladroUltrasonico(int cantidadVueltas){
		this.vueltasDeTorpedo = cantidadVueltas;
	}

	public void interactuar(Pooglin unPooglin, Planeta unPlaneta){
		int posicionX = unPooglin.getPosicionX();
		int posicionY = unPooglin.getPosicionY();
		if (unPlaneta.getBloque(posicionX,posicionY+1) instanceof Rompible ){
			if (this.getVueltasDeTorpedo()!= 0){
				Rompible bloqueRompible=(Rompible)unPlaneta.getBloque(posicionX,posicionY+1);
					if (bloqueRompible.getDureza() != 0){
						bloqueRompible.golpear();
						this.decrementarVueltas();
					}
					else{
						Punto punto = new Punto(posicionX,posicionY+1);
						@SuppressWarnings("unused")
						Bloque BloqueTaladrado = new Aire(punto);
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


	public void decrementarVueltas(){
		this.vueltasDeTorpedo--;
	}
	
	public int getVueltasDeTorpedo() {
		return vueltasDeTorpedo;
	}
}