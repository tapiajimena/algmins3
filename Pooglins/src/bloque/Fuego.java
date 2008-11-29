package bloque;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import Modelo.Pooglin;
import Modelo.Punto;



public class Fuego extends Bloque implements Apagable {
 
	private int resistencia=100;
		
	public Fuego(Punto punto){
		super(punto);
	}
	
	public boolean esTraspasable() {
		return true;
	}
	
	public boolean esApagable(){
		return true;
	}
	
	public void interactuar(Pooglin unPooglin){
	    if(this.posicion.equals(unPooglin.getPosicion())){
	    		unPooglin.morir();
	    }
	}
	
	public char getLetra(){
		return 'F';
	}
	
	public boolean esMatable() {
		return true;
	}
	
	public Element serializar(){
		Element elementFuego=DocumentHelper.createElement("Fuego");
		elementFuego.addAttribute("resistencia",String.valueOf(this.resistencia));
		Element elementoPunto=this.posicion.serializar();
		elementFuego.add(elementoPunto);
		return elementFuego;
	}
	
	public void recuperarEstado(Element elementoFuego){
		this.posicion.recuperarEstado(elementoFuego.element("Punto"));
		this.resistencia = Integer.parseInt(elementoFuego.attributeValue("resistencia"));
	}
	public boolean equals(Object obj){
		if(obj instanceof Fuego){
			if( super.equals(obj))
				return (this.resistencia==((Fuego)obj).resistencia);
		}
		return false;
	}
}
 
