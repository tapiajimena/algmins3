package abstractFactoryHabilidades;

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

}
