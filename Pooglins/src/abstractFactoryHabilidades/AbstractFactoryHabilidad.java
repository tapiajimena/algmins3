package abstractFactoryHabilidades;

import habilidad.Habilidad;
import pooglin.Pooglin;

public abstract class AbstractFactoryHabilidad {
	//el contructor debe definir cuantas veces se debe crear la habilidad
	public abstract boolean tieneHabilidad();
	public abstract Habilidad asignarHabilidad(Pooglin pooglin);
	public String toString(){return "null";};
}
