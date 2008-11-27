package habilidad;
import org.dom4j.Element;

import pooglin.Pooglin;
import juego.Planeta;


public abstract class Habilidad {
 
	
	protected Pooglin pooglin;

	public Habilidad(Pooglin pooglin){
		this.pooglin=pooglin;
	}
	 
	public abstract void interactuar(Planeta planeta);
	
	public abstract Element serializar();
	
	public abstract void recuperarEstado(Element unElemento);

	public char getLetra() {
		return '0';
	}
	
}
 
