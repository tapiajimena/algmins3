package modelo.FactoryHabilidades;


import modelo.Pooglin;
import modelo.habilidad.Habilidad;
import modelo.habilidad.Teletransportacion;



public class FactoryTeletransportacion extends AbstractFactoryHabilidad{
	public FactoryTeletransportacion(int cantidadHabilidades){
		cantidadDisponible=cantidadHabilidades;
	}
	public void asignarHabilidad(Pooglin pooglin) {
		if(cantidadDisponible>0){
			Habilidad habilidad=new Teletransportacion(pooglin);
			pooglin.definirHabilidad(habilidad);
			cantidadDisponible--;
		}else pooglin.definirHabilidad(null);
	}

	public int cantidadDisponible() {
		return cantidadDisponible;
	}
	
	public String toString(){
		return new String("Teletransportacion");
	}
}
