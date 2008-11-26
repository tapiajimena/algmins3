package bloque;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import pooglin.Pooglin;
import punto.Punto;

public class Tierra extends Bloque implements Rompible {
	
	private int dureza;

	public Tierra(Punto punto) {
		super(punto);
		this.dureza = 20;
	}

	public void golpear() {
		this.decrementarDureza(1);
	}

	public void interactuar(Pooglin unPooglin) {
		unPooglin.caminar();
	}
	
	public boolean esTraspasable(){
		return false;
	}
	
	public boolean esRomplible() {
			return true;
	}

	public void decrementarDureza(int dec){
		if (dec<=4 && dec>=0){
			this.dureza=this.dureza-dec;
		}
			else{
				this.dureza=0;
			}
	}

	public int getDureza() {
		return dureza;
	}
	
	public char getLetra(){
		return 'T';
	}
	
	public Element serializar(){
		Element elementTierra=DocumentHelper.createElement("Tierra");
		elementTierra.addAttribute("dureza",String.valueOf(this.dureza));
		Element elementoPunto=this.posicion.serializar();
		elementTierra.add(elementoPunto);
		return elementTierra;
	}
	
	public void recuperarEstado(Element elementoTierra){
		this.posicion.recuperarEstado(elementoTierra.element("Punto"));
		this.dureza = Integer.parseInt(elementoTierra.attributeValue("dureza"));
	}
	 
}
 
