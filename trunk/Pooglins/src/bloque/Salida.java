package bloque;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import Modelo.Pooglin;
import Modelo.Punto;



public class Salida extends Bloque {
		
	public Salida(Punto punto) {
		super(punto);
	}

	public void interactuar(Pooglin unPooglin) {
		if(this.posicion.equals(unPooglin.getPosicion())){
    		unPooglin.salvar();
		}
	}
	
	public boolean esTraspasable(){
		return true;
	}

	public char getLetra(){
		return 'S';
	}
	
	public Element serializar(){
		Element elementoSalida=DocumentHelper.createElement("Salida");
		Element elementoPunto=this.posicion.serializar();
		elementoSalida.add(elementoPunto);
		return elementoSalida;
	}
	
	public void recuperarEstado(Element elementoSalida){
		this.posicion.recuperarEstado(elementoSalida.element("Punto"));
	}
	public boolean equals(Object obj){
		if(obj instanceof Salida){
			return super.equals(obj);
		}
		return false;
	}
}
