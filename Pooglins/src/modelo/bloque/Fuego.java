package modelo.bloque;

import modelo.Pooglin;
import modelo.Punto;

import org.dom4j.Element;

public class Fuego extends Bloque implements Apagable {

	private int resistencia = 100;

	public Fuego(Punto punto) {
		super(punto);
	}

	public boolean esTraspasable() {
		return true;
	}

	public boolean esApagable() {
		return true;
	}

	public void interactuar(Pooglin unPooglin) {
		if (this.posicion.equals(unPooglin.getPosicion())) {
			unPooglin.morir();
		}
	}

	public char getLetra() {
		return 'F';
	}

	public boolean esMatable() {
		return true;
	}

	public Element serializar() {
		Element elementFuego = super.serializar();
		elementFuego.addAttribute("resistencia", String
				.valueOf(this.resistencia));
		return elementFuego;
	}

	public void recuperarEstado(Element elementoFuego) {
		super.recuperarEstado(elementoFuego);
		this.resistencia = Integer.parseInt(elementoFuego
				.attributeValue("resistencia"));
	}

	public boolean equals(Object obj) {
		if (obj instanceof Fuego) {
			if (super.equals(obj))
				return (this.resistencia == ((Fuego) obj).resistencia);
		}
		return false;
	}
}
