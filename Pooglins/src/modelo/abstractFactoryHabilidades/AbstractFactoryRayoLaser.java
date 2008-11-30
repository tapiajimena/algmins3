package modelo.abstractFactoryHabilidades;


import modelo.Pooglin;
import modelo.habilidad.Habilidad;
import modelo.habilidad.RayoLaser;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;



public class AbstractFactoryRayoLaser extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public AbstractFactoryRayoLaser(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public void asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new RayoLaser(pooglin);
			pooglin.definirHabilidad(habilidad);
			cantidadDisponible--;
		}else pooglin.definirHabilidad(null);
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	
	public String toString(){
		return new String("RayoLaser");
	}
	
	public void recuperarEstado(Element elementoAbstractFactoryRayoLaser) {
		this.cantidadDisponible = Integer.parseInt(elementoAbstractFactoryRayoLaser.attributeValue("cantidadDisponible"));
	}

	public Element serializar() {
		Element elementAbstractFactoryRayoLaser=DocumentHelper.createElement("AbstractFactoryCongelamiento");
		elementAbstractFactoryRayoLaser.addAttribute("cantidadDisponible",String.valueOf(this.cantidadDisponible));
		return elementAbstractFactoryRayoLaser;
	}

}
