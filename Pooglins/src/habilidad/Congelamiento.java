package habilidad;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import juego.Planeta;
import pooglin.Pooglin;
import bloque.Hielo;


public class Congelamiento extends Habilidad {

	public Congelamiento(Pooglin pooglin) {
		super(pooglin);
	}

	public void interactuar(Planeta planeta) {
		planeta.agregarObstaculo(new Hielo(pooglin.getPosicion()));
		pooglin.morir();
	}

	public void recuperarEstado(Element elementoCongelamiento) {
	}

	public Element serializar() {
		Element elementCongelamiento=DocumentHelper.createElement("Congelamiento");
		return elementCongelamiento;
	}

}
 
