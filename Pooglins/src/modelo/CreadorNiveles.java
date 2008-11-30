package modelo;

import java.util.ArrayList;

import modelo.abstractFactoryHabilidades.AbstractFactoryCongelamiento;
import modelo.abstractFactoryHabilidades.AbstractFactoryHabilidad;
import modelo.abstractFactoryHabilidades.AbstractFactoryPlatilloVolador;
import modelo.abstractFactoryHabilidades.AbstractFactoryRayoLaser;
import modelo.abstractFactoryHabilidades.AbstractFactoryTaladroUltrasonico;
import modelo.abstractFactoryHabilidades.AbstractFactoryTeletransportacion;
import modelo.abstractFactoryHabilidades.AbstractFactoryTunelEletromagnetico;


public class CreadorNiveles {
	public static Nivel crearNivel() {
		Planeta planeta = CreadorPlanetas.crearPlaneta(1);
		ArrayList<AbstractFactoryHabilidad> fabricasHabilidad = new ArrayList<AbstractFactoryHabilidad>();
		fabricasHabilidad.add(new AbstractFactoryCongelamiento(3));
		fabricasHabilidad.add(new AbstractFactoryRayoLaser(1));
		fabricasHabilidad.add(new AbstractFactoryTeletransportacion(3));
		fabricasHabilidad.add(new AbstractFactoryTaladroUltrasonico(3));
		Nivel nivel = new Nivel(fabricasHabilidad, 3, planeta, 2);
		nivel.setNombre("Nivel:1");
		return nivel;
	}

	public static Nivel crearNivel(int id) {
		Nivel nivel;
		Planeta planeta;
		ArrayList<AbstractFactoryHabilidad> fabricasHabilidad;
		switch (id) {
		case 2:
			// creo el planeta
			planeta = CreadorPlanetas.crearPlaneta(2);
			// creo el array de habilidades
			fabricasHabilidad = new ArrayList<AbstractFactoryHabilidad>();
			fabricasHabilidad.add(new AbstractFactoryPlatilloVolador(8));
			fabricasHabilidad.add(new AbstractFactoryRayoLaser(3));
			fabricasHabilidad.add(new AbstractFactoryTeletransportacion(3));
			fabricasHabilidad.add(new AbstractFactoryTunelEletromagnetico(4));
			// cargo el nivel 
			nivel = new Nivel(fabricasHabilidad, 10, planeta, 2);
			nivel.setNombre("Nivel:2");
			break;
		default:
			planeta = CreadorPlanetas.crearPlaneta(0);
			fabricasHabilidad = new ArrayList<AbstractFactoryHabilidad>();
			fabricasHabilidad.add(new AbstractFactoryCongelamiento(3));
			fabricasHabilidad.add(new AbstractFactoryRayoLaser(3));
			fabricasHabilidad.add(new AbstractFactoryTeletransportacion(3));
			fabricasHabilidad.add(new AbstractFactoryTaladroUltrasonico(3));
			nivel = new Nivel(fabricasHabilidad, 10, planeta, 2);
			nivel.setNombre("Nivel:0");
			break;
		}
		return nivel;
	}
}
