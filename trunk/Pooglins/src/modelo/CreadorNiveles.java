package modelo;

import java.util.ArrayList;

import modelo.FactoryHabilidades.AbstractFactoryHabilidad;
import modelo.FactoryHabilidades.FactoryCongelamiento;
import modelo.FactoryHabilidades.FactoryPlatilloVolador;
import modelo.FactoryHabilidades.FactoryRayoLaser;
import modelo.FactoryHabilidades.FactoryTaladroUltrasonico;
import modelo.FactoryHabilidades.FactoryTeletransportacion;
import modelo.FactoryHabilidades.FactoryTunelEletromagnetico;

public class CreadorNiveles {
	
	public static Nivel crearNivel() {
		Planeta planeta = CreadorPlanetas.crearPlaneta(1);
		ArrayList<AbstractFactoryHabilidad> fabricasHabilidad = new ArrayList<AbstractFactoryHabilidad>();
		fabricasHabilidad.add(new FactoryCongelamiento(5));
		fabricasHabilidad.add(new FactoryRayoLaser(5));
		fabricasHabilidad.add(new FactoryTeletransportacion(5));
		fabricasHabilidad.add(new FactoryTaladroUltrasonico(5));
		Nivel nivel = new Nivel(fabricasHabilidad, 5, planeta, 2);
		nivel.setNombre("Nivel:1");
		return nivel;
	}

	public static Nivel crearNivel(int id) {
		Nivel nivel;
		Planeta planeta;
		ArrayList<AbstractFactoryHabilidad> fabricasHabilidad;
		switch (id) {
		
		case 1:
			planeta = CreadorPlanetas.crearPlaneta(1);
			fabricasHabilidad = new ArrayList<AbstractFactoryHabilidad>();
			fabricasHabilidad.add(new FactoryCongelamiento(5));
			fabricasHabilidad.add(new FactoryRayoLaser(5));
			fabricasHabilidad.add(new FactoryTeletransportacion(5));
			fabricasHabilidad.add(new FactoryTaladroUltrasonico(5));
			nivel = new Nivel(fabricasHabilidad, 5, planeta, 2);
			nivel.setNombre("Nivel:1");
			
			break;
		
		case 2:
			// creo el planeta
			planeta = CreadorPlanetas.crearPlaneta(2);
			// creo el array de habilidades
			fabricasHabilidad = new ArrayList<AbstractFactoryHabilidad>();
			fabricasHabilidad.add(new FactoryPlatilloVolador(10));
			fabricasHabilidad.add(new FactoryRayoLaser(10));
			fabricasHabilidad.add(new FactoryTeletransportacion(10));
			fabricasHabilidad.add(new FactoryTunelEletromagnetico(10));
			fabricasHabilidad.add(new FactoryTaladroUltrasonico(10));
			// cargo el nivel 
			nivel = new Nivel(fabricasHabilidad, 10, planeta, 4);
			nivel.setNombre("Nivel:2");
			break;
			
		case 3:
			// creo el planeta
			planeta = CreadorPlanetas.crearPlaneta(2);
			// creo el array de habilidades
			fabricasHabilidad = new ArrayList<AbstractFactoryHabilidad>();
			fabricasHabilidad.add(new FactoryPlatilloVolador(8));
			fabricasHabilidad.add(new FactoryRayoLaser(3));
			fabricasHabilidad.add(new FactoryTeletransportacion(3));
			fabricasHabilidad.add(new FactoryTunelEletromagnetico(4));
			// cargo el nivel 
			nivel = new Nivel(fabricasHabilidad, 10, planeta, 2);
			nivel.setNombre("Nivel:3");
			break;	
			
		default:
			planeta = CreadorPlanetas.crearPlaneta(0);
			fabricasHabilidad = new ArrayList<AbstractFactoryHabilidad>();
			fabricasHabilidad.add(new FactoryCongelamiento(3));
			fabricasHabilidad.add(new FactoryRayoLaser(3));
			fabricasHabilidad.add(new FactoryTeletransportacion(3));
			fabricasHabilidad.add(new FactoryTaladroUltrasonico(3));
			nivel = new Nivel(fabricasHabilidad, 10, planeta, 2);
			nivel.setNombre("Nivel:0");
			break;
		}
		return nivel;
	}
}
