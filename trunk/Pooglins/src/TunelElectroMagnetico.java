public class TunelElectroMagnetico extends Habilidad {
 
	private int longitudFaltante;
	
	public TunelElectroMagnetico(){
		this.longitudFaltante = 2;
	}
	
	public void interactuar(Pooglin unPooglin,Planeta unPlaneta){
			int posicionX = unPooglin.getPosicionX();
			int posicionY = unPooglin.getPosicionY();
			if (unPlaneta.getBloque(posicionX+1,posicionY) instanceof Aire){
				if (this.getLongitudFaltante()!=0 && this.longitudFaltante>0){
					Punto punto = new Punto(posicionX+1,posicionY);
					@SuppressWarnings("unused")
					Bloque BloqueTunel = new Tunel(punto);
					unPlaneta.agregarObstaculo(BloqueTunel,posicionX+1,posicionY);
					BloqueTunel.interactuar(unPooglin);
					this.longitudFaltante--;
				}else{
					unPooglin.caminar();
				}
			}else{
				unPooglin.caminar();
			}
	}


	public int getLongitudFaltante() {
		return longitudFaltante;
	}
	 
}
 
