package modelo.abstractFactoryHabilidades;


import modelo.Pooglin;
import modelo.habilidad.Habilidad;
import modelo.habilidad.TaladroUltrasonico;



public class FactoryTaladroUltrasonico extends AbstractFactoryHabilidad{
	public FactoryTaladroUltrasonico(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public void asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new TaladroUltrasonico(pooglin);
			pooglin.definirHabilidad(habilidad);
			cantidadDisponible--;
		}else pooglin.definirHabilidad(null);
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	
	public String toString(){
		return new String("TaladroUltrasonico");
	}
}
