package habilidad;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import pooglin.Pooglin;
import punto.Punto;
import juego.Planeta;
public class Teletransportacion extends Habilidad {
	private int contadorPasos=3;
	
	public Teletransportacion(Pooglin unPooglin){
		super(unPooglin);
	}

	public void interactuar(Planeta planeta) {
		if(contadorPasos==0){
			Punto proximaPosicion = pooglin.getPosicion();
			proximaPosicion.setY(proximaPosicion.getY()+6);
			pooglin.setPosicion(proximaPosicion);
			pooglin.definirHabilidad(null);
		}else if(contadorPasos>0)
			contadorPasos--;
		pooglin.caminar();
	}
	
	public Element serializar() {
		Element elementTeletrasportacion=DocumentHelper.createElement("Teletransportacion");
		elementTeletrasportacion.addAttribute("contadorPasos",String.valueOf(this.contadorPasos));
		return elementTeletrasportacion;
	}

	public void recuperarEstado(Element elementoTeletransportacion) {
		this.contadorPasos = Integer.parseInt(elementoTeletransportacion.attributeValue("contadorPasos"));
	}

	 
}
 
