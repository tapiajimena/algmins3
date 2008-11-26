package bloque;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import pooglin.Pooglin;
import punto.Punto;


public class Aire extends Bloque {
	public Aire(Punto punto) {
		super(punto);
		
	}
	public boolean esTraspasable(){
		return true;
	}
	
	public void interactuar(Pooglin unPooglin) {
		unPooglin.caminar();
			
	}
	public char getLetra(){
		return 'A';
	}
	
	public Element serializar(){
		Element elementAire=DocumentHelper.createElement("Aire");
		Element elementoPunto=this.posicion.serializar();
		elementAire.add(elementoPunto);
		return elementAire;
	}
	
	public void recuperarEstado(Element elementoAire){
		this.posicion.recuperarEstado(elementoAire.element("Punto"));
	}
	public boolean equals(Object obj){
		if(obj instanceof Aire){
			return super.equals(obj);
		}
		return false;
	}
}
