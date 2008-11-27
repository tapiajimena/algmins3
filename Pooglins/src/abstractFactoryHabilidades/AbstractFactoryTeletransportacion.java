package abstractFactoryHabilidades;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import habilidad.Habilidad;
import habilidad.Teletransportacion;
import pooglin.Pooglin;

public class AbstractFactoryTeletransportacion extends AbstractFactoryHabilidad{
	
	private int cantidadDisponible;
	
	public AbstractFactoryTeletransportacion(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public void asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new Teletransportacion(pooglin);
			pooglin.definirHabilidad(habilidad);
		}else pooglin.definirHabilidad(null);
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	
	public String toString(){
		return new String("Teletransportacion");
	}
	
	public void recuperarEstado(Element elementoAbstractFactoryTeletransportacion) {
		this.cantidadDisponible = Integer.parseInt(elementoAbstractFactoryTeletransportacion.attributeValue("cantidadDisponible"));
	}

	public Element serializar() {
		Element elementAbstractFactoryTeletransportacion=DocumentHelper.createElement("AbstractFactoryTeletransportacion");
		elementAbstractFactoryTeletransportacion.addAttribute("cantidadDisponible",String.valueOf(this.cantidadDisponible));
		return elementAbstractFactoryTeletransportacion;
	}

}
