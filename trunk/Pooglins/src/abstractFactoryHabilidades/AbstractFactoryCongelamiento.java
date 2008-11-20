package abstractFactoryHabilidades;

import habilidad.Congelamiento;
import habilidad.Habilidad;
import pooglin.Pooglin;

public class AbstractFactoryCongelamiento extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public Habilidad asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new Congelamiento(pooglin);
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
