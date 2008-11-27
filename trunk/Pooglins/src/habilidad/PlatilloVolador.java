package habilidad;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import pooglin.Pooglin;
import punto.Punto;
import juego.Planeta;



public class PlatilloVolador extends Habilidad {

	public PlatilloVolador(Pooglin pooglin) {
		super(pooglin);
	}
	
	public void interactuar(Planeta planeta) {
		Punto posicionBloque=pooglin.getPosicion();
		posicionBloque.setX(posicionBloque.getX()+1);
		if(planeta.getBloque(posicionBloque).esTraspasable())
			pooglin.setPosicion(posicionBloque);
				
		}
	
	public void recuperarEstado(Element unElemento) {
	}

	public Element serializar() {
		Element elementPlatilloVolador=DocumentHelper.createElement("PlatilloVolador");
		return elementPlatilloVolador;
	}
	public char getLetra(){
		return 'V';
	}
}
	 
	
 
 
