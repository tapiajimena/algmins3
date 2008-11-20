package abstractFactoryHabilidades;

import habilidad.Habilidad;
import habilidad.Teletransportacion;
import pooglin.Pooglin;

public class AbstractFactoryTeletransportacion extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public AbstractFactoryTeletransportacion(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public Habilidad asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new Teletransportacion(pooglin);
			pooglin.definirHabilidad(habilidad);
		}
		return null;
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	public String toString(){
		return new String("Teletransportacion");
	}

}
