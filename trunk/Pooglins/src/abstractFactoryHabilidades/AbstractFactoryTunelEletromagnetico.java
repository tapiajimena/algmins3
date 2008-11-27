package abstractFactoryHabilidades;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import habilidad.Habilidad;
import habilidad.TunelElectroMagnetico;
import pooglin.Pooglin;

public class AbstractFactoryTunelEletromagnetico extends AbstractFactoryHabilidad{
	
	private int cantidadDisponible;
	
	public AbstractFactoryTunelEletromagnetico(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	
	public void asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new TunelElectroMagnetico(pooglin);
			pooglin.definirHabilidad(habilidad);
		}else pooglin.definirHabilidad(null);
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	
	public String toString(){
		return new String("TunelElectromagentico");
	}
	
	public void recuperarEstado(Element elementoAbstractFactoryTunelElectromagnetico) {
		this.cantidadDisponible = Integer.parseInt(elementoAbstractFactoryTunelElectromagnetico.attributeValue("cantidadDisponible"));
	}

	public Element serializar() {
		Element elementAbstractFactoryCongelamiento=DocumentHelper.createElement("AbstractFactoryTunelElectromagnetico");
		elementAbstractFactoryCongelamiento.addAttribute("cantidadDisponible",String.valueOf(this.cantidadDisponible));
		return elementAbstractFactoryCongelamiento;
	}

}
