package bloque;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import pooglin.Pooglin;
import punto.Punto;

public class Roca extends Bloque{
		
	public Roca(Punto punto){
		super (punto);
	}
	
	public void interactuar(Pooglin unPooglin) {
		if(this.posicion.equals(unPooglin.getPosicion()))
    			unPooglin.morir();
		unPooglin.caminar();
	}
	
	public boolean esTraspasable(){
		return false;
	}
	
	public char getLetra(){
		return 'R';
	}
	
	public Element serializar(){
		Element elementRoca=DocumentHelper.createElement("Roca");
		Element elementoPunto=this.posicion.serializar();
		elementRoca.add(elementoPunto);
		return elementRoca;
	}
	
	public void recuperarEstado(Element elementoRoca){
		this.posicion.recuperarEstado(elementoRoca.element("Punto"));
	}
	public boolean equals(Object obj){
		if(obj instanceof Roca){
			return super.equals(obj);
		}
		return false;
	}
}