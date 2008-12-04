package modelo.FactoryHabilidades;

import modelo.Pooglin;
import modelo.habilidad.Habilidad;
import modelo.habilidad.RayoLaser;

public class FactoryRayoLaser extends AbstractFactoryHabilidad {

	public FactoryRayoLaser(int cantidadHabilidades) {
		cantidadDisponible = cantidadHabilidades;
	}

	public void asignarHabilidad(Pooglin pooglin) {
		if (cantidadDisponible > 0) {
			Habilidad habilidad = new RayoLaser(pooglin);
			pooglin.definirHabilidad(habilidad);
			cantidadDisponible--;
		} else
			pooglin.definirHabilidad(null);
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}

	public String toString() {
		return new String("RayoLaser");
	}
}
