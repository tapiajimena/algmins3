package abstractFactoryHabilidades;

import habilidad.Congelamiento;
import habilidad.Habilidad;
import pooglin.Pooglin;

public class AbstractFactoryCongelamiento extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public AbstractFactoryCongelamiento(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public Habilidad asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new Congelamiento(pooglin);
			pooglin.definirHabilidad(habilidad);
		}
		return null;
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	public String toString(){
		return new String("Congelamiento");
	}
}
