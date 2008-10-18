package juego;
import habilidad.Habilidad;

public class PanelDeHabilidades {
	private OpcionHabilidad seleccionada=null;
	//private ArrayList opciones;
	//private Nivel nivel;
	
	public void agregar(OpcionHabilidad opcion) {
	
	};
	public void seleccionar(OpcionHabilidad opcion){
		this.seleccionada=opcion;
	};
	public Habilidad obtenerSeleccionada(){
		return this.seleccionada.obtenerHabilidad();
	};
	
}
 
