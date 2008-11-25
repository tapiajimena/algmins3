package juego;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;
import VistaVentana.VistaNivel;


public class Juego {
	// TODO que hacemos? lista de niveles o lista de configuracion de nivel, es
	// decir cargamos todo de una sola vez o a medida q se necesita?
	private String[] configNiveles;
	private Nivel nivel;
	private VistaNivel vista;

	public Juego() {
		this.nivel = CreadorNiveles.crearNivel();
		this.vista = new VistaNivel(nivel);
	}

	// interno para cargar el nivel q sigue
	private void siguienteNivel() {

	}

	// Para ver el nivel actual desde MVC
	public Nivel getNivelActual() {
		return nivel;
	}

	public void gameStart() {
		Action gameLoop = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent evt) {
				nivel.siguienteRonda();
				vista.actualizarVista();

			}
		};
		if(vista==null)System.out.println("ok");
		vista.setVisible(true);
		Timer timer = new Timer(50, gameLoop);
		timer.start();
	}

}
 
