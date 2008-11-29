package abstractFactoryHabilidades;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import Modelo.Pooglin;

import habilidad.Congelamiento;
import habilidad.Habilidad;

public class AbstractFactoryCongelamiento extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	
	public AbstractFactoryCongelamiento(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	
	public void asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>=0){
			Habilidad habilidad=new Congelamiento(pooglin);
			pooglin.definirHabilidad(habilidad);
			cantidadDisponible--;
		}else pooglin.definirHabilidad(null);
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	
	public String toString(){
		return new String("Congelamiento");
	}
	
	public void recuperarEstado(Element elementoAbstractFactoryCongelamiento) {
		this.cantidadDisponible = Integer.parseInt(elementoAbstractFactoryCongelamiento.attributeValue("cantidadDisponible"));
	}

	public Element serializar() {
		Element elementAbstractFactoryCongelamiento=DocumentHelper.createElement("AbstractFactoryCongelamiento");
		elementAbstractFactoryCongelamiento.addAttribute("cantidadDisponible",String.valueOf(this.cantidadDisponible));
		return elementAbstractFactoryCongelamiento;
	}
}
