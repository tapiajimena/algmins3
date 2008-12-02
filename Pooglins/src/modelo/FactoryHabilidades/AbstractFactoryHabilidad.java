package modelo.FactoryHabilidades;

import modelo.Pooglin;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public abstract class AbstractFactoryHabilidad {
	//el contructor debe definir cuantas veces se debe crear la habilidad
	int cantidadDisponible=0;
	
	public abstract int cantidadDisponible();
	
	public abstract void asignarHabilidad(Pooglin pooglin);
	
	public String toString(){return "null";};
	
	public Element serializar(){
		Element fabricaHabilidadXML=DocumentHelper.createElement(this.getClass().getName());
		fabricaHabilidadXML.addAttribute("cantidadDisponible", String.valueOf(this.cantidadDisponible));
		return fabricaHabilidadXML;
	};
	
	public void recuperarEstado(Element unElemento){
		this.cantidadDisponible=Integer.parseInt(unElemento.attributeValue("cantidadDisponible"));
	};
}
