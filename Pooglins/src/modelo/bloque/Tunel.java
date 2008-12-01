package modelo.bloque;

import modelo.Pooglin;
import modelo.Punto;

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
		Element elementTunel=super.serializar();
		elementTunel.addAttribute("duracion",String.valueOf(this.duracion));
		return elementTunel;
	}
	
	public void recuperarEstado(Element elementoTunel){
		super.recuperarEstado(elementoTunel);
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
 
