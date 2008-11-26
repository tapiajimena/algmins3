package bloque;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import pooglin.Pooglin;
import punto.Punto;


public class Entrada extends Bloque {
	
	public Entrada(Punto punto) {
		super(punto);
	}
	
	public void interactuar(Pooglin unPooglin) {
		unPooglin.caminar();
	}
	
	public char getLetra(){
		return 'E';
	}
	
	public Element serializar(){
		Element elementoEntrada=DocumentHelper.createElement("Entrada");
		Element elementoPunto=this.posicion.serializar();
		elementoEntrada.add(elementoPunto);
		return elementoEntrada;
	}
	
	public void recuperarEstado(Element elementoEntrada){
		this.posicion.recuperarEstado(elementoEntrada.element("Punto"));
	}
	public boolean equals(Object obj){
		if(obj instanceof Entrada){
			return super.equals(obj);
		}
		return false;
	}
}
 
