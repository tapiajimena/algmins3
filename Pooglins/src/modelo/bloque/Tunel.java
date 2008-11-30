package modelo.bloque;

import modelo.Pooglin;
import modelo.Punto;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;



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
	public boolean equals(Object obj){
		if(obj instanceof Tunel){
			if(super.equals(obj))
				return (this.duracion==((Tunel)obj).duracion);
		}
		return false;
	}
}
 
