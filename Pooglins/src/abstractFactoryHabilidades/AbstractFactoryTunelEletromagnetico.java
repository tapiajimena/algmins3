package abstractFactoryHabilidades;

import habilidad.Habilidad;
import habilidad.TunelElectroMagnetico;
import pooglin.Pooglin;

public class AbstractFactoryTunelEletromagnetico extends AbstractFactoryHabilidad{
	private int cantidadDisponible;
	public Habilidad asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new TunelElectroMagnetico(pooglin);
			pooglin.definirHabilidad(habilidad);
		}
		return null;
	}

	public boolean tieneHabilidad() {
		return (cantidadDisponible>0);
	}
	public String toString(){
		return new String("TunelElectromagentico");
	}

}
