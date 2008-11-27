package abstractFactoryHabilidades;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import habilidad.Habilidad;
import habilidad.TaladroUltrasonico;
import pooglin.Pooglin;

public class AbstractFactoryTaladroUltrasonico extends AbstractFactoryHabilidad{
	
	private int cantidadDisponible;
	
	public AbstractFactoryTaladroUltrasonico(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public void asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new TaladroUltrasonico(pooglin);
			pooglin.definirHabilidad(habilidad);
			cantidadDisponible--;
		}else pooglin.definirHabilidad(null);
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	
	public String toString(){
		return new String("TaladroUltrasonico");
	}
	
	public void recuperarEstado(Element elementoAbstractFactoryTaladroUltrasonico) {
		this.cantidadDisponible = Integer.parseInt(elementoAbstractFactoryTaladroUltrasonico.attributeValue("cantidadDisponible"));
	}

	public Element serializar() {
		Element elementAbstractFactoryTaladroUltrasonico=DocumentHelper.createElement("AbstractFactoryTaladroUltrasonico");
		elementAbstractFactoryTaladroUltrasonico.addAttribute("cantidadDisponible",String.valueOf(this.cantidadDisponible));
		return elementAbstractFactoryTaladroUltrasonico;
	}

}
