package juego;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import VistaVentana.VistaNivel;


public class Juego {
	// TODO que hacemos? lista de niveles o lista de configuracion de nivel, es
	// decir cargamos todo de una sola vez o a medida q se necesita?
	//private String[] configNiveles;
	private Nivel nivel;
	private VistaNivel vista;
	//private int numeroNivel;
	
	public Juego() {
		this.nivel = CreadorNiveles.crearNivel();
		this.vista = new VistaNivel(nivel);
	}

	// interno para cargar el nivel q sigue
	@SuppressWarnings("unused")
	private void siguienteNivel() {
		this.nivel=CreadorNiveles.crearNivel();
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
		vista.setVisible(true);
		Timer timer = new Timer(400, gameLoop);
		timer.start();
	}
	public void salvarJuego(String ruta){
		Document doc=DocumentHelper.createDocument();
		doc.add(nivel.serializar());
		try {
			OutputFormat formato=OutputFormat.createPrettyPrint();
			FileOutputStream archivo = new FileOutputStream(ruta);
			XMLWriter writer = new XMLWriter(archivo,formato);
			writer.write(doc);
			writer.flush();
			writer.close();
			archivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void cargarJuego(String ruta){
		Document doc=DocumentHelper.createDocument();
		SAXReader xmlReader = new SAXReader();
		try {
			doc = xmlReader.read(ruta);
			Element nivelXML=doc.getRootElement();
			nivel.recuperarEstado(nivelXML);		
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
}
 
