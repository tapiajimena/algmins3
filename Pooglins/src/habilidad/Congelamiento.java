package habilidad;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import juego.Planeta;
import juego.Pooglin;
import bloque.Hielo;


public class Congelamiento extends Habilidad {
	private int  tiempo=4;
	public Congelamiento(Pooglin pooglin) {
		super(pooglin);
	}

	public void interactuar(Planeta planeta) {
		if(tiempo>0 )tiempo --;
		else {
			planeta.agregar(new Hielo(pooglin.getPosicion()));
			pooglin.morir();
		}
	}

	public void recuperarEstado(Element elementoCongelamiento) {
		this.tiempo = Integer.parseInt(elementoCongelamiento.attributeValue("tiempo"));
	}

	public Element serializar() {
		Element elementCongelamiento=DocumentHelper.createElement("Congelamiento");
		elementCongelamiento.addAttribute("tiempo", String.valueOf(tiempo));
		return elementCongelamiento;
	}
	public char getLetra(){
		return 'C';
	}
}
 
