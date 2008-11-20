package abstractFactoryHabilidades;

import habilidad.Habilidad;
import pooglin.Pooglin;

public abstract class AbstractFactoryHabilidad {
	//el contructor debe definir cuantas veces se debe crear la habilidad
	public abstract int cantidadDisponible();
	public abstract Habilidad asignarHabilidad(Pooglin pooglin);
	public String toString(){return "null";};
}
