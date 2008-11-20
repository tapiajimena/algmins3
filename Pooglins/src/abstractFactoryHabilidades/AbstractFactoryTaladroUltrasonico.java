package abstractFactoryHabilidades;

import habilidad.Habilidad;
import habilidad.TaladroUltrasonico;
import pooglin.Pooglin;

public class AbstractFactoryTaladroUltrasonico extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public AbstractFactoryTaladroUltrasonico(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public Habilidad asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new TaladroUltrasonico(pooglin);
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
