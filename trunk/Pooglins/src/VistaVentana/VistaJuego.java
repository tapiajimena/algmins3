package VistaVentana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import modelo.CreadorNiveles;
import modelo.Nivel;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class VistaJuego extends JFrame {

	private static final long serialVersionUID = 1343048817996491590L;
	private Nivel nivel;
	private VistaNivel vista;
	private int numeroNivel = 1;
	private JMenu menu;
	private JMenuBar barraDeMenu;
	private Timer timer;

	public VistaJuego() {
		this.nivel = CreadorNiveles.crearNivel();
		this.vista = new VistaNivel(nivel);
		barraMenu();
		super.getContentPane().add(vista);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.getContentPane().setLayout(
				new BoxLayout(super.getContentPane(), BoxLayout.PAGE_AXIS));
		super.getContentPane().setBackground(Color.black);
		super.setPreferredSize(new Dimension(1050, 500));
		super.pack();
	}

	public VistaJuego(int i) {
		this.nivel = CreadorNiveles.crearNivel(i);
		this.vista = new VistaNivel(nivel);
		barraMenu();
		super.getContentPane().add(vista);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.getContentPane().setLayout(
				new BoxLayout(super.getContentPane(), BoxLayout.PAGE_AXIS));
		super.getContentPane().setBackground(Color.black);
		super.setPreferredSize(new Dimension(1050, 500));
		super.pack();
	}

	public void gameStart() {
		VistaPresentacion pre = new VistaPresentacion();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pre.dispose();
		empezar();
	}

	private void siguienteNivel() {
		numeroNivel++;
		cargarNivel(numeroNivel);
		empezar();
	}

	public void cargarNivel(int numeroNivel) {
		timer.stop();
		barraMenu();
		this.nivel = CreadorNiveles.crearNivel(numeroNivel);
		remove(vista);
		this.vista = new VistaNivel(nivel);
		add(vista);
	}

	public void empezar() {
		Action gameLoop = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent evt) {
				nivel.siguienteRonda();
				vista.actualizarVista();
				if (nivel.estaFinalizado()) {
					timer.stop();
					if (nivel.getTiempo() == nivel.getTiempoTotal()) {
						alertas(2);
						cargarNivel(numeroNivel);
						empezar();
					} else if (nivel.estaBloqueado()) {
						alertas(1);
						cargarNivel(numeroNivel);
						empezar();
					} else {
						alertas(3);
						siguienteNivel();
					}
				}
			}
		};
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		timer = new Timer(400, gameLoop);
		timer.start();
	}

	public void salvarJuego(String ruta) {
		Document doc = DocumentHelper.createDocument();
		doc.add(nivel.serializar());
		try {
			OutputFormat formato = OutputFormat.createPrettyPrint();
			FileOutputStream archivo = new FileOutputStream(ruta);
			XMLWriter writer = new XMLWriter(archivo, formato);
			writer.write(doc);
			writer.flush();
			writer.close();
			archivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cargarJuego(String ruta) {
		Document doc = null;
		timer.stop();
		SAXReader xmlReader = new SAXReader();
		try {
			doc = xmlReader.read(ruta);
		} catch (DocumentException e) {
			alertas(4);
		}
		if (doc != null) {
			/* recupero nivel */
			Element nivelXML = doc.getRootElement();
			nivel.recuperarEstado(nivelXML);
			/* renuevo la vista */
			remove(vista);
			vista = new VistaNivel(nivel);
			vista.actualizarVista();
			vista.setVisible(true);
			add(vista);
		} else
			timer.start();
	}

	private void barraMenu() {
		ActionListener action = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Salir")) {
					System.exit(0);
				} else if (e.getActionCommand().equals("Nuevo")) {
					cargarNivel(1);
					empezar();
				} else if (e.getActionCommand().equals("Guardar")) {
					salvarJuego("juegoSalvado.xml");
				} else if (e.getActionCommand().equals("IRA")) {
					numeroNivel++;
					cargarNivel(numeroNivel);
					empezar();
				} else if (e.getActionCommand().equals("Salvar")) {
					nivel.salvarATodos();
				} else if (e.getActionCommand().equals("Abrir")) {
					cargarJuego("juegoSalvado.xml");
					empezar();
					timer.stop();
				} else if (e.getActionCommand().equals("Pausa")) {
					if (timer.isRunning()) {
						timer.stop();
					} else {
						timer.start();
					}
				} else if (e.getActionCommand().equals("Velocidad")) {
					JButton boton = (JButton) e.getSource();
					if (boton.getText().equals("MasRapido")) {
						boton.setText("Normal");
						timer.stop();
						timer.setDelay(timer.getDelay() / 4);
						timer.restart();
					} else {
						boton.setText("MasRapido");
						timer.stop();
						timer.setDelay(timer.getDelay() * 4);
						timer.restart();
					}
				}

			}
		};
		JMenuItem opcionNuevoJuego = new JMenuItem("Juego Nuevo");
		opcionNuevoJuego.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				KeyEvent.CTRL_MASK));

		JMenuItem opcionIrA = new JMenuItem("Ir a");
		opcionIrA.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				KeyEvent.CTRL_MASK + KeyEvent.ALT_MASK));
		opcionIrA.setVisible(false);

		JMenuItem opcionSalvar = new JMenuItem("Salvar Todos");
		opcionSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				KeyEvent.CTRL_MASK + KeyEvent.ALT_MASK));
		opcionSalvar.setVisible(false);

		JMenuItem opcionAbrir = new JMenuItem("Abrir");
		opcionAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				KeyEvent.CTRL_MASK));

		JMenuItem opcionGuardar = new JMenuItem("Guardar");
		opcionGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
				KeyEvent.CTRL_MASK));

		JMenuItem opcionDeSalida = new JMenuItem("Salir");
		opcionDeSalida.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				KeyEvent.CTRL_MASK));

		opcionNuevoJuego.setActionCommand("Nuevo");
		opcionNuevoJuego.addActionListener(action);

		opcionAbrir.setActionCommand("Abrir");
		opcionAbrir.addActionListener(action);

		opcionGuardar.setActionCommand("Guardar");
		opcionGuardar.addActionListener(action);

		opcionDeSalida.setActionCommand("Salir");
		opcionDeSalida.addActionListener(action);

		opcionIrA.setActionCommand("IRA");
		opcionIrA.addActionListener(action);

		opcionSalvar.setActionCommand("Salvar");
		opcionSalvar.addActionListener(action);

		JButton pausa = new JButton("Pausa");
		pausa.setBackground(Color.white);
		pausa.setActionCommand("Pausa");
		pausa.addActionListener(action);

		JButton velocidad = new JButton("MasRapido");
		velocidad.setBackground(Color.white);
		velocidad.setActionCommand("Velocidad");
		velocidad.addActionListener(action);

		menu = new JMenu("Archivo");
		menu.add(opcionNuevoJuego);
		menu.add(opcionIrA);
		menu.add(opcionSalvar);
		menu.add(opcionAbrir);
		menu.add(opcionGuardar);
		menu.add(opcionDeSalida);
		barraDeMenu = new JMenuBar();
		barraDeMenu.add(menu);
		barraDeMenu.add(velocidad);
		barraDeMenu.add(pausa);
		setJMenuBar(barraDeMenu);
	}

	private void alertas(int i) {
		String mensaje = new String();

		switch (i) {
		case 1:
			mensaje = "Muerieron todos! Vuelve a empezar!!!";
			break;
		case 2:
			mensaje = "Se acabo el tiempo!!! Lo siento..";
			break;
		case 3:
			mensaje = "Salvaste a:  " + nivel.getCantSalvados()
					+ "  Murieron: " + nivel.getCantMuertos();
			break;
		case 4:
			mensaje = "No existe un juego guardado";
			break;
		default:
			mensaje = "ERROR: Error inesperado, salga y vuelva a iniciar el programa";
			break;
		}
		JOptionPane.showMessageDialog(this, mensaje, "Atencion!",
				JOptionPane.WARNING_MESSAGE);
	}
}
