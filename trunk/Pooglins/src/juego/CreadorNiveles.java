package juego;

import java.util.ArrayList;

import abstractFactoryHabilidades.AbstractFactoryHabilidad;


public class CreadorNiveles {
	public static Nivel crearNivel() {
		Planeta planeta = CreadorPlanetas.crearPlaneta(1);
		ArrayList<AbstractFactoryHabilidad> fabricasHabilidad = new ArrayList<AbstractFactoryHabilidad>();
		Nivel nivel = new Nivel(fabricasHabilidad,10, planeta);		
		return nivel;
	}
}
