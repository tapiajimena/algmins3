package modelo.abstractFactoryHabilidades;


import modelo.Pooglin;
import modelo.habilidad.Habilidad;
import modelo.habilidad.TunelElectroMagnetico;
public class FactoryTunelEletromagnetico extends AbstractFactoryHabilidad{	
	public FactoryTunelEletromagnetico(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	
	public void asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new TunelElectroMagnetico(pooglin);
			pooglin.definirHabilidad(habilidad);
			cantidadDisponible--;
		}else pooglin.definirHabilidad(null);
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	
	public String toString(){
		return new String("TunelElectromagentico");
	}
}
