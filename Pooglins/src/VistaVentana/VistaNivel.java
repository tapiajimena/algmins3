package VistaVentana;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public /*Usar Singelton? forzar atributos estaticos?, Para cada instancia debe existir un modelo distinto, asociado a la vista , */
//heredo de JFrame o delego ?
class VistaNivel {
	private static JPanel panelHabildad;
	private static ButtonGroup groupHabilidad;
	private static JFrame ventana;
	private static VistaPlaneta escenario;
	
	/*Recibe un conjunto de las habilidades permitidas en el nivel para generar el panel de opciones de las habilidades*/
	@SuppressWarnings("unchecked")
	private JPanel crearPanelHabilidades(Iterable habilidades){
		panelHabildad=new JPanel();
		panelHabildad.setLayout(new BoxLayout(panelHabildad,BoxLayout.PAGE_AXIS));
		
		JRadioButton habilidad0 = new JRadioButton("RayoLaser");
	    JRadioButton habilidad1 = new JRadioButton("Taladro");
	    JRadioButton habilidad2 = new JRadioButton("Platillo");

	    //Group the radio buttons. proporciona exclusion mutua de los botones
	    //detalle group es local, pero debe usarse para definir los eventos creo
	    groupHabilidad = new ButtonGroup();
	    groupHabilidad.add(habilidad0);
	    groupHabilidad.add(habilidad1);
	    groupHabilidad.add(habilidad2);
	    //
	    panelHabildad.add(habilidad0);
	    panelHabildad.add(habilidad1);
	    panelHabildad.add(habilidad2);
	    return panelHabildad;
	}
	
	public void crearMostrarGUI(){
		ventana=new JFrame("Programa");
		/*se le debe pasar una referencia al nivel mas adelante*/
		escenario=new VistaPlaneta();
		escenario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		escenario.setLayout(null);
		
		
		JLabel lab=new JLabel( new ImageIcon("back.gif"));
		lab.setLayout(null);
		lab.setBounds(0,0,200,200);
		
		
		VistaPooglin pooglin=new VistaPooglin(null,0,0);
		VistaPooglin pooglin1=new VistaPooglin(null,50,10);
		//funciona como pila L-A-F-P
		escenario.add(pooglin);
		escenario.add(pooglin1);
		escenario.add(lab);
		//
		JPanel botonera=crearPanelHabilidades(null);
		
		ventana.getContentPane().add(botonera);
		ventana.getContentPane().add(escenario);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//defino es la forma en que se acomodan los componentes
		ventana.getContentPane().setLayout(new BoxLayout(ventana.getContentPane(),BoxLayout.LINE_AXIS));
		//tamaño de la ventana
		//ventana.setResizable(false);
		
		ventana.setPreferredSize(new Dimension(200,200));
		//preparo la venta
		ventana.pack();
		//muestro la ventana
		ventana.setVisible(true);
	}
}

