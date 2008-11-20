package abstractFactoryHabilidades;

import habilidad.Habilidad;
import habilidad.RayoLaser;
import pooglin.Pooglin;

public class AbstractFactoryRayoLaser extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public Habilidad asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new RayoLaser(pooglin);
			pooglin.definirHabilidad(habilidad);
		}
		return null;
	}

	public boolean tieneHabilidad() {
		return (cantidadDisponible>0);
	}
	public String toString(){
		return new String("Congelamiento");
	}

}
