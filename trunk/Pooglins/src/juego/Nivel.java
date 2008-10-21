package juego;

import java.util.ArrayList;

import pooglin.Pooglin;


public class Nivel {
 
	
	private int numero;
	 
	private String nombre;
	 
 
	private Tiempo cantTiempo;
	 
	private Tiempo tiempoTranscurrido;
	 
	private int cantMuertos;
	 
	private int cantInicialPooglins;
	 
	private ArrayList TripulacionSalvada;
	
	private Pooglin[] pooglin;
	 
	private Planeta planeta;
	 
	private Juego juego;
	 
	private PanelDeHabilidades panelDeHabilidades;
	 
	public void liberarTripulacion() {
	 
	}
	
	public void Nivel(String configuracion) {
		 
	}
	public  Nivel() {
	
	 
	}
	 
	public  Nivel(Pooglin[] pooglins,Planeta planeta) {
		this.planeta=planeta;
		this.setPooglin(pooglins);
		
	 
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPooglin(Pooglin[] pooglin) {
		this.pooglin = pooglin;
	}

	public Pooglin[] getPooglin() {
		return pooglin;
	}
	

	
}
 
