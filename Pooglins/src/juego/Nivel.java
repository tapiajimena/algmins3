package juego;

import java.util.ArrayList;

import pooglin.Pooglin;


public class Nivel {
	/*
	 * En esta clase falta la implementacion de algunos metodos que van
	 * a estar para la segunda entrega cuando decimos bien como realizar
	 * el motor del juego y cuestiones relacionadas con el mismo y su
	 * interaccion con la clase Nivel.
	 */
	
	private int numero;
	 
	private String nombre;
	 
 
	@SuppressWarnings("unused")
	//Todavia no lo vamos a usar al tiempo, para mas adelante
	private Tiempo cantTiempo;
	@SuppressWarnings("unused") 
	private Tiempo tiempoTranscurrido;
	 
	private int cantMuertos;
	 
	private int cantInicialPooglins;
	 
	//A implementar mas adelante
	@SuppressWarnings("unchecked")
	private ArrayList TripulacionSalvada;
	
	private Pooglin[] pooglin;
	 
	private Planeta planeta;
	 
	private Juego juego;
	 
	private PanelDeHabilidades panelDeHabilidades;
	 
	public void liberarTripulacion() {
	 
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

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setCantMuertos(int cantMuertos) {
		this.cantMuertos = cantMuertos;
	}

	public int getCantMuertos() {
		return cantMuertos;
	}

	public void setCantInicialPooglins(int cantInicialPooglins) {
		this.cantInicialPooglins = cantInicialPooglins;
	}

	public int getCantInicialPooglins() {
		return cantInicialPooglins;
	}

	@SuppressWarnings("unchecked")
	public void setTripulacionSalvada(ArrayList tripulacionSalvada) {
		TripulacionSalvada = tripulacionSalvada;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getTripulacionSalvada() {
		return TripulacionSalvada;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setPanelDeHabilidades(PanelDeHabilidades panelDeHabilidades) {
		this.panelDeHabilidades = panelDeHabilidades;
	}

	public PanelDeHabilidades getPanelDeHabilidades() {
		return panelDeHabilidades;
	}
	

	
}
 
