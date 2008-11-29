package abstractFactoryHabilidades;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import Modelo.Pooglin;

import habilidad.Habilidad;
import habilidad.PlatilloVolador;

public class AbstractFactoryPlatilloVolador extends AbstractFactoryHabilidad{
	
	private int cantidadDisponible;
	
	public AbstractFactoryPlatilloVolador(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public void asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new PlatilloVolador(pooglin);
			pooglin.definirHabilidad(habilidad);
			cantidadDisponible--;
		}else pooglin.definirHabilidad(null);
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	
	public String toString(){
		return new String("PlatilloVolador");
	}
	
	public void recuperarEstado(Element elementoAbstractFactoryPlatilloVoladore) {
		this.cantidadDisponible = Integer.parseInt(elementoAbstractFactoryPlatilloVoladore.attributeValue("cantidadDisponible"));
	}

	public Element serializar() {
		Element elementAbstractFactoryPlatilloVolador=DocumentHelper.createElement("AbstractFactoryPlatilloVolador");
		elementAbstractFactoryPlatilloVolador.addAttribute("cantidadDisponible",String.valueOf(this.cantidadDisponible));
		return elementAbstractFactoryPlatilloVolador;
	}

}
