package modelo.habilidad;

import modelo.Planeta;
import modelo.Pooglin;
import modelo.bloque.Hielo;
import org.dom4j.Element;

public class Congelamiento extends Habilidad {

	private int tiempo = 4;

	public Congelamiento(Pooglin pooglin) {
		super(pooglin);
	}

	public void interactuar(Planeta planeta) {
		if (tiempo > 0)
			tiempo--;
		else {
			planeta.agregar(new Hielo(pooglin.getPosicion()));
			pooglin.morir();
		}
	}

	public void recuperarEstado(Element elementoCongelamiento) {
		this.tiempo = Integer.parseInt(elementoCongelamiento
				.attributeValue("tiempo"));
	}

	public Element serializar() {
		Element elementCongelamiento = super.serializar();
		elementCongelamiento.addAttribute("tiempo", String.valueOf(tiempo));
		return elementCongelamiento;
	}

	public char getLetra() {
		return 'C';
	}
}
