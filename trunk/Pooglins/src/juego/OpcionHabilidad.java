package juego;
import habilidad.Habilidad;

import pooglin.Pooglin;

public class OpcionHabilidad {
	private int cantidadDeUsos;
	private Habilidad habilidad;
	public OpcionHabilidad(Habilidad habilidad,int cantidadPermitida){
		this.habilidad=habilidad;
		this.cantidadDeUsos=cantidadPermitida;
	}
	public boolean estaVacio() {
		return (cantidadDeUsos<=0);
	}
	public Habilidad obtenerHabilidad(Pooglin poo) {
		if(cantidadDeUsos<=0)return null;
			this.cantidadDeUsos--;
		return this.habilidad;
		
	} 

}
 
