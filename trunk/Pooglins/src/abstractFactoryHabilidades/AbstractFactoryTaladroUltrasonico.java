package abstractFactoryHabilidades;

import habilidad.Habilidad;
import habilidad.TaladroUltrasonico;
import pooglin.Pooglin;

public class AbstractFactoryTaladroUltrasonico extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public Habilidad asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new TaladroUltrasonico(pooglin);
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
