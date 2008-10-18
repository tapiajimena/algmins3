package habilidad;
import Planeta;
import Pooglin;


public abstract class Habilidad {
 
	@SuppressWarnings("unused")
	private Pooglin pooglin;

	public Habilidad(Pooglin pooglin){
		this.pooglin=pooglin;

	 }
	 
	public abstract void interactuar(Planeta planeta);
	
}
 
