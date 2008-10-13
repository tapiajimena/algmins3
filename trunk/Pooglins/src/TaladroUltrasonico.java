public class TaladroUltrasonico extends Habilidad{
	
	private int vueltasDeTorpedo = 5;

	public void interactuar(Pooglin unPooglin, Planeta unPlaneta){
		int posicionX = unPooglin.getPosicionX();
		int posicionY = unPooglin.getPosicionY();
		if (unPlaneta.getTerreno(posicionX,posicionY+1) instanceof Rompible){
			while (unPlaneta.getTerreno(posicionX,posicionY+1).getDureza() != 0){
				unPlaneta.getTerreno(posicionX,posicionY+1).golpear();
			}
		}
	}
}