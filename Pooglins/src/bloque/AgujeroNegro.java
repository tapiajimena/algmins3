package bloque;
import pooglin.Pooglin;
import punto.Punto;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class AgujeroNegro extends Bloque {
	
    public AgujeroNegro(Punto punto) {
		super(punto);
	}
	
    public boolean esTraspasable() {
		return true;
	}
	
    public void interactuar(Pooglin unPooglin) {
		if(this.posicion.distancia(unPooglin.getPosicion()) <= 1){
			unPooglin.morir();
		}
		
	}

    public char getLetra(){
		return 'O';
	}
	
	public boolean esMatable() {
		return true;
	}
	
	public Element serializar(){
		Element elementAgujeroNegro=DocumentHelper.createElement("AgujeroNegro");
		Element elementoPunto=this.posicion.serializar();
		elementAgujeroNegro.add(elementoPunto);
		return elementAgujeroNegro;
	}
	
	public void recuperarEstado(Element elementoAgujeroNegro){
		this.posicion.recuperarEstado(elementoAgujeroNegro.element("Punto"));
	}
	public boolean equals(Object obj){
		if(obj instanceof AgujeroNegro){
			return super.equals(obj);
		}
		return false;
	}
}
 
