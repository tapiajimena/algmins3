package modelo.habilidad;

import modelo.Planeta;
import modelo.Pooglin;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public abstract class Habilidad {

	protected Pooglin pooglin;

	public Habilidad(Pooglin pooglin) {
		this.pooglin = pooglin;
	}

	public abstract void interactuar(Planeta planeta);

	public Element serializar() {
		return DocumentHelper.createElement(this.getClass().getName());
	}

	public abstract void recuperarEstado(Element unElemento);

	public char getLetra() {
		return '0';
	}

}
