package abstractFactoryHabilidades;

import habilidad.Habilidad;
import habilidad.TunelElectroMagnetico;
import pooglin.Pooglin;

public class AbstractFactoryTunelEletromagnetico extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public AbstractFactoryTunelEletromagnetico(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public Habilidad asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new TunelElectroMagnetico(pooglin);
			pooglin.definirHabilidad(habilidad);
		}
		return null;
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	public String toString(){
		return new String("TunelElectromagentico");
	}

}
