package abstractFactoryHabilidades;

import habilidad.Habilidad;
import habilidad.Teletransportacion;
import pooglin.Pooglin;

public class AbstractFactoryTeletransportacion extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public Habilidad asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new Teletransportacion(pooglin);
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
