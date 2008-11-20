package abstractFactoryHabilidades;

import habilidad.Habilidad;
import habilidad.PlatilloVolador;
import pooglin.Pooglin;

public class AbtractFactoryPlatilloVolador extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public AbtractFactoryPlatilloVolador(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public Habilidad asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new PlatilloVolador(pooglin);
			pooglin.definirHabilidad(habilidad);
		}
		return null;
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	public String toString(){
		return new String("PlatilloVolador");
	}

}
