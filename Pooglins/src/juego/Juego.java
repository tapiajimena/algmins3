package juego;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import VistaVentana.VistaNivel;
import VistaVentana.VistaPresentacion;


public class Juego extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1343048817996491590L;
	// TODO que hacemos? lista de niveles o lista de configuracion de nivel, es
	// decir cargamos todo de una sola vez o a medida q se necesita?
	//private String[] configNiveles;
	private Nivel nivel;
	private VistaNivel vista;
	private int numeroNivel=1;
	
	private JMenu menu;
	private JMenuBar barraDeMenu;
	private JProgressBar progressBar;
	private TiempoNivel tiempo;
	private Timer timerProgressBar;
	private Timer timer;

	public Juego() {
		this.nivel = CreadorNiveles.crearNivel();
		cargarJuego("juegoSalvado.xml");
		this.vista = new VistaNivel(nivel);
		// add funciona como pila L-A-F-P
        //crear
        barraMenu();
        crearProgressBar();
        super.getContentPane().add(vista);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.getContentPane().setLayout( new BoxLayout(super.getContentPane(), BoxLayout.PAGE_AXIS));
        // ventana.setResizable(false);
        super.getContentPane().setBackground(Color.black);
        super.setPreferredSize(new Dimension(1050, 500));
        // preparo la venta
        super.pack();

	}

	// interno para cargar el nivel q sigue
	@SuppressWarnings("unused")
	private void siguienteNivel() {
		numeroNivel++;
		this.nivel=CreadorNiveles.crearNivel(numeroNivel);
	}

	// Para ver el nivel actual desde MVC
	public Nivel getNivelActual() {
		return nivel;
	}
	private void empesar(){
		Action gameLoop = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent evt) {
				nivel.siguienteRonda();
				vista.actualizarVista();
			}
		};
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		timer = new Timer(400, gameLoop);
		timer.start();
	}
	public void gameStart() {
		VistaPresentacion pre=new VistaPresentacion();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pre.dispose();
		empesar();
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
	private JFrame yo(){return this;};
	/*-----------------------------------------------------------------------------**/
	public void barraMenu(){
			ActionListener action=new ActionListener(){
			     public void actionPerformed(ActionEvent e){
			         if (e.getActionCommand().equals("Salir"))
			         {
			              System.exit(0);  
			         }
			         else if (e.getActionCommand().equals("Nuevo"))
			         {
			        	 System.out.println("Pausar");
			         }
			         else if(e.getActionCommand().equals("Guardar")){
			        	 salvarJuego("juegoSalvado.xml");
			         }
			         else if(e.getActionCommand().equals("Abrir")){
			             cargarJuego("juegoSalvado.xml");
			             vista = new VistaNivel(nivel);
			             
			          }
			         else if (e.getActionCommand().equals("Pausa")){
			        	 if(timer.isRunning()) {
			        		 timer.stop();
			        		 timerProgressBar.stop();
			        	 }
			        	 else {
			        		 timer.start();
			        		 timerProgressBar.start();
			        	 }
			         }
			      }
			};
            JMenuItem opcionNuevoJuego = new JMenuItem("Juego Nuevo");
            opcionNuevoJuego.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_N, KeyEvent.CTRL_MASK));
            
            JMenuItem opcionAbrir = new JMenuItem("Abrir");
            opcionAbrir.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_A, KeyEvent.CTRL_MASK));
            
            JMenuItem opcionGuardar = new JMenuItem("Guardar");
            opcionGuardar.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_G, KeyEvent.CTRL_MASK));
            opcionGuardar.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                            
                            
                    }
                    
            });
            JMenuItem pausa= new JMenuItem("Pausa");
            pausa.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_P, KeyEvent.CTRL_MASK));
            JMenuItem opcionDeSalida = new JMenuItem("Salir");
            //crtl+S sale del juego
            opcionDeSalida.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_S, KeyEvent.CTRL_MASK));
    
            opcionNuevoJuego.setActionCommand("Nuevo");
            opcionNuevoJuego.addActionListener(action);
            
            opcionAbrir.setActionCommand("Abrir");
            opcionAbrir.addActionListener(action);
        
            opcionGuardar.setActionCommand("Guardar");
            opcionGuardar.addActionListener(action);
            
            opcionDeSalida.setActionCommand("Salir");
            opcionDeSalida.addActionListener(action);
            
            pausa.setActionCommand("Pausa");
            pausa.addActionListener(action);
             menu = new JMenu("Archivo");
             menu.add(opcionNuevoJuego);
             menu.add(opcionAbrir);
             menu.add(opcionGuardar);
             menu.add(opcionDeSalida);
             menu.add(pausa);
             barraDeMenu = new JMenuBar();
             barraDeMenu.add(menu);
             setJMenuBar(barraDeMenu);
    
    }
	private void closeMyself(){
		this.dispose();
		System.exit(DISPOSE_ON_CLOSE);
		//this.setVisible(false);
	}
	public void crearProgressBar() {
		Action actualizarProgressBar = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;
			
			public void actionPerformed(ActionEvent e) {
				tiempo.setSegundosRestantes(tiempo.getSegundosRestantes() - 1);
				tiempo.setTiempoTrascurrido(tiempo.getTiempoTrascurrido() + 1);

				if (tiempo.getSegundosRestantes() < 0) {
					tiempo.setSegundosRestantes(60);
					tiempo.setMinutosRestantes(tiempo.getMinutosRestantes() - 1);
				}
				if (tiempo.getMinutosRestantes() == 0
						&& tiempo.getSegundosRestantes() == 0) {
					timerProgressBar.stop();
					JFrame frame = new JFrame("Warning");
					JOptionPane.showMessageDialog(frame,"Se ha acabado el tiempo. GAME OVER!");		
					/*for (int i = 0; i < pooglins.size(); i++) {
						pooglins.get(i).getPooglin().morir();
					}*/
					closeMyself();	
					
				}
				progressBar.setValue(tiempo.getTiempoTrascurrido());
				progressBar.setString(tiempo.getMinutosRestantes() + ":"+ tiempo.getSegundosRestantes());
			}
		};
		timerProgressBar = new Timer(1000, actualizarProgressBar);
		timerProgressBar.start();
		tiempo = nivel.getTiempo();
		// progBarPanel = new JPanel();

		progressBar = new JProgressBar(0, tiempo.getMinutosRestantes() * 60);
		progressBar.setStringPainted(true);
		add(progressBar);
		// progBarPanel.add(progressBar);
		// add(progBarPanel);
	}
}
 
