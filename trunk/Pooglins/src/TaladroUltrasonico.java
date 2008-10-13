public class TaladroUltrasonico extends Habilidad{
	
	private int vueltasDeTorpedo = 5;

	public void interactuar(Pooglin unPooglin, Planeta unPlaneta){
		int posicionX = unPooglin.getPosicionX();
		int posicionY = unPooglin.getPosicionY();
		if (unPlaneta.getBloque(posicionX,posicionY+1) instanceof Rompible){
			Rompible bloqueRompible=(Rompible)unPlaneta.getBloque(posicionX,posicionY+1);
			if (bloqueRompible.getDureza() != 0){
				bloqueRompible.golpear();
			}
		}
	}
}