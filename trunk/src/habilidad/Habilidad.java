package habilidad;
import pooglin.Pooglin;
import juego.Planeta;


public abstract class Habilidad {
 
	
	protected Pooglin pooglin;

	public Habilidad(Pooglin pooglin){
		this.pooglin=pooglin;

	 }
	 
	public abstract void interactuar(Planeta planeta);
	
}
 
