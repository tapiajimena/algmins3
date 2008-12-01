package modelo.abstractFactoryHabilidades;


import modelo.Pooglin;
import modelo.habilidad.Congelamiento;
import modelo.habilidad.Habilidad;

import org.dom4j.Element;



public class FactoryCongelamiento extends AbstractFactoryHabilidad{

	public FactoryCongelamiento(int cantidadHabilidades){
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
		super.recuperarEstado(elementoAbstractFactoryCongelamiento);
	}

	public Element serializar() {
		return super.serializar();
	}
}
