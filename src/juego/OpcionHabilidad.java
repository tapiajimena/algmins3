package juego;
import habilidad.Habilidad;

public class OpcionHabilidad {
 	private PanelDeHabilidades panel;
	private int cantidadDeUsos;
	private Habilidad habilidad;
	public OpcionHabilidad(Habilidad habilidad,int cantidadPermitida,PanelDeHabilidades panel){
		this.habilidad=habilidad;
		this.cantidadDeUsos=cantidadPermitida;
		this.panel=panel;
	}
	public boolean estaVacio() {
		return (cantidadDeUsos<=0);
	}
	public Habilidad obtenerHabilidad() {
		if(cantidadDeUsos<=0)return null;
		this.cantidadDeUsos--;
		return this.habilidad;
	} 
	public void seleccionar(){
		panel.seleccionar(this);
	}
}
 
