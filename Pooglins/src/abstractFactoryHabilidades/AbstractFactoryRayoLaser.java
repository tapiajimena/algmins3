package abstractFactoryHabilidades;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import habilidad.Habilidad;
import habilidad.RayoLaser;
import pooglin.Pooglin;

public class AbstractFactoryRayoLaser extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public AbstractFactoryRayoLaser(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public Habilidad asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new RayoLaser(pooglin);
			pooglin.definirHabilidad(habilidad);
		}
		return null;
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
