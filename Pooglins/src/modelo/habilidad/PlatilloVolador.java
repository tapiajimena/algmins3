package modelo.habilidad;

import modelo.Planeta;
import modelo.Pooglin;
import modelo.Punto;

import org.dom4j.Element;

public class PlatilloVolador extends Habilidad {

	public PlatilloVolador(Pooglin pooglin) {
		super(pooglin);
	}

	public void interactuar(Planeta planeta) {
		Punto posicionBloque = pooglin.getPosicion();
		posicionBloque.setX(posicionBloque.getX() + 1);
		if (planeta.getBloque(posicionBloque).esTraspasable())
			pooglin.setPosicion(posicionBloque);
		else
			pooglin.caminar();
	}

	public void recuperarEstado(Element unElemento) {
	}

	public Element serializar() {
		Element elementPlatilloVolador = super.serializar();
		return elementPlatilloVolador;
	}

	public char getLetra() {
		return 'V';
	}
}
