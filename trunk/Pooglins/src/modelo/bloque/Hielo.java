package modelo.bloque;

import modelo.Pooglin;
import modelo.Punto;

import org.dom4j.Element;



public class Hielo extends Bloque implements Rompible{
 
	private int dureza;

	public Hielo(Punto punto) {
		super(punto);
		this.dureza=6;
	}

	public void golpear() {
		decrementarDureza(1);
	}
	
	public boolean esDerretible(){
		 return true;
	}
	
	public boolean esTraspasable(){
		return false;
	}
	
	public void interactuar(Pooglin unPooglin) {
		if(this.posicion.equals(unPooglin.getPosicion()))
			unPooglin.morir();
		unPooglin.caminar();
		unPooglin.caminar();
	}

	public boolean esRomplible() {
		return true;
	}

	public void decrementarDureza(int dec){
		if (dureza>0){
			if (dec<=6){
				this.dureza=dureza-dec;
		}else 
			if (dec>6){
				dureza = 0;
			}
		}
	}
	
	public int getDureza() {
		return dureza;
	} 

	public char getLetra(){
		return 'H';
	}

	public Element serializar(){
		Element elementHielo=super.serializar();
		elementHielo.addAttribute("dureza",String.valueOf(this.dureza));
		return elementHielo;
	}
	
	public void recuperarEstado(Element elementoHielo){
		super.recuperarEstado(elementoHielo);
		this.dureza = Integer.parseInt(elementoHielo.attributeValue("dureza"));
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Hielo){
			if( super.equals(obj))
				return (this.dureza==((Hielo)obj).dureza);
		}
		return false;
	}
}
 
