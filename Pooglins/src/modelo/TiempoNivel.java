package modelo;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
;



public class TiempoNivel {

	
	private int minutosRestantes;
	private int segundosRestantes;
	private int tiempoTrascurrido;//en segundos.
	

	public TiempoNivel(){
	
		setMinutosRestantes(0);
		setSegundosRestantes(0);
		setTiempoTrascurrido(0);
	}

	public void setMinutosRestantes(int minutosRestantes) {
		this.minutosRestantes = minutosRestantes;
	}

	public int getMinutosRestantes() {
		return minutosRestantes;
	}

	public void setSegundosRestantes(int segundosRestantes) {
		this.segundosRestantes = segundosRestantes;
	}

	public int getSegundosRestantes() {
		return segundosRestantes;
	}

	public void setTiempoTrascurrido(int tiempoTrascurrido) {
		this.tiempoTrascurrido = tiempoTrascurrido;
	}

	public int getTiempoTrascurrido() {
		return tiempoTrascurrido;
	}
	
	public Element serializar() {
		Element elementTiempoNivel=DocumentHelper.createElement("TiempoNivel");
		elementTiempoNivel.addAttribute("minutosRestantes",String.valueOf(this.minutosRestantes));
		elementTiempoNivel.addAttribute("segundosRestantes",String.valueOf(this.segundosRestantes));
		elementTiempoNivel.addAttribute("tiempoTranscurrido",String.valueOf(this.tiempoTrascurrido));
		return elementTiempoNivel;
	}

	public void recuperarEstado(Element elementoTiempoNivel) {
		this.minutosRestantes = Integer.parseInt(elementoTiempoNivel.attributeValue("minutosRestantes"));
		this.segundosRestantes = Integer.parseInt(elementoTiempoNivel.attributeValue("segundosRestantes"));
		this.tiempoTrascurrido = Integer.parseInt(elementoTiempoNivel.attributeValue("tiempoTranscurrido"));
	}
    
}
