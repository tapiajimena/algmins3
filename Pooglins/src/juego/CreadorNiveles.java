package juego;

import java.util.ArrayList;

import abstractFactoryHabilidades.AbstractFactoryCongelamiento;
import abstractFactoryHabilidades.AbstractFactoryHabilidad;
import abstractFactoryHabilidades.AbstractFactoryRayoLaser;
import abstractFactoryHabilidades.AbstractFactoryTaladroUltrasonico;
import abstractFactoryHabilidades.AbstractFactoryTeletransportacion;


public class CreadorNiveles {
	public static Nivel crearNivel() {
		Planeta planeta = CreadorPlanetas.crearPlaneta(1);
		ArrayList<AbstractFactoryHabilidad> fabricasHabilidad = new ArrayList<AbstractFactoryHabilidad>();
		fabricasHabilidad.add(new AbstractFactoryCongelamiento(3));
		fabricasHabilidad.add(new AbstractFactoryRayoLaser(3));
		fabricasHabilidad.add(new AbstractFactoryTeletransportacion(3));
		fabricasHabilidad.add(new AbstractFactoryTaladroUltrasonico(3));
		Nivel nivel = new Nivel(fabricasHabilidad,4, planeta);		
		nivel.setNombre("Nivel:1");
		return nivel;
	}
}
