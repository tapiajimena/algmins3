package bloque;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import pooglin.Pooglin;
import punto.Punto;

public class Tunel extends Bloque {

	private int duracion;
	
	public Tunel(Punto punto){
		super(punto);
		this.duracion = 1;
	}

	public int getDuracion() {
		return duracion;
	}

	public void interactuar(Pooglin unPooglin) {
		unPooglin.caminar();
	}
	
	public boolean esTraspasable(){
	    return false;
	}
	
	public char getLetra(){
		return 'B';
	}
	
	public Element serializar(){
		Element elementTunel=DocumentHelper.createElement("Tunel");
		elementTunel.addAttribute("duracion",String.valueOf(this.duracion));
		Element elementoPunto=this.posicion.serializar();
		elementTunel.add(elementoPunto);
		return elementTunel;
	}
	
	public void recuperarEstado(Element elementoTunel){
		this.posicion.recuperarEstado(elementoTunel.element("Punto"));
		this.duracion = Integer.parseInt(elementoTunel.attributeValue("duracion"));
	}
}
 
