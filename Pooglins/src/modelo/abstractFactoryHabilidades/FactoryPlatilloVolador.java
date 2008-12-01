package modelo.abstractFactoryHabilidades;


import modelo.Pooglin;
import modelo.habilidad.Habilidad;
import modelo.habilidad.PlatilloVolador;



public class FactoryPlatilloVolador extends AbstractFactoryHabilidad{
		
	public FactoryPlatilloVolador(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public void asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new PlatilloVolador(pooglin);
			pooglin.definirHabilidad(habilidad);
			cantidadDisponible--;
		}else pooglin.definirHabilidad(null);
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	
	public String toString(){
		return new String("PlatilloVolador");
	}
}
