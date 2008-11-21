package VistaVentana;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import juego.Nivel;
import pooglin.Pooglin;

public class VistaNivel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelHabilidad;
	private ButtonGroup groupHabilidad;
	private VistaPlaneta escenario;
	private Nivel nivel;
	private ArrayList<VistaPooglin> pooglins;
	/*
	 * Recibe un conjunto de las habilidades permitidas en el nivel para generar
	 * el panel de opciones de las habilidades
	 */

	private void cargarPanelHabilidad() {
		panelHabilidad = new JPanel();
		panelHabilidad.setLayout(new BoxLayout(panelHabilidad,
				BoxLayout.PAGE_AXIS));
		groupHabilidad = new ButtonGroup();
		String[] nombres=nivel.getFabricasHabilidad();
		if(nombres!=null)
		for(int i=0;i<nombres.length;i++){
			JRadioButton habilidad = new JRadioButton(nombres[i]);
			groupHabilidad.add(habilidad);
			panelHabilidad.add(habilidad);
			
		}
	}
	
	public VistaNivel(Nivel nivel) {
		super();
		this.pooglins=new ArrayList<VistaPooglin>();
		this.nivel = nivel;
		super.setTitle("Pooglins "+nivel.getNombre());
		escenario = new VistaPlaneta(nivel.getPlaneta());
		escenario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		escenario.setLayout(null);

		// add funciona como pila L-A-F-P
		//crear
		cargarPanelHabilidad();
		super.add(panelHabilidad);
		super.getContentPane().add(escenario);

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// defino es la forma en que se acomodan los componentes
		super.getContentPane().setLayout(
				new BoxLayout(super.getContentPane(), BoxLayout.LINE_AXIS));
		// tama�o de la ventana
		// ventana.setResizable(false);

		super.setPreferredSize(new Dimension(500, 500));
		// preparo la venta
		super.pack();
	}

	public void actualizarVista() {		
		int cantidadVivos=nivel.getPooglinsVivos().size();
		if(cantidadVivos>this.pooglins.size()){
			Pooglin nuevoPooglin=nivel.getPooglinsVivos().get(cantidadVivos-1);
			VistaPooglin vistaPooglin=new VistaPooglin(nuevoPooglin);
			pooglins.add(vistaPooglin);
			escenario.add(vistaPooglin);
		};
		for(int i=0;i<this.pooglins.size();i++){
			pooglins.get(i).actualizar();
		}
	}
}
