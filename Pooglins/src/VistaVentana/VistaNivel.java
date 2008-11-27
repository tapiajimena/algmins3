package VistaVentana;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.Timer;

import abstractFactoryHabilidades.AbstractFactoryHabilidad;

import Controlador.Controlador;
import juego.Nivel;
import juego.TiempoNivel;
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
	private Controlador controlador;
	/*
	 * Recibe un conjunto de las habilidades permitidas en el nivel para generar
	 * el panel de opciones de las habilidades
	 */
	private Timer timerProgressBar;
	private TiempoNivel tiempo;
	private JProgressBar progressBar;

	private void cargarPanelHabilidad() {
		panelHabilidad = new JPanel();
		panelHabilidad.setLayout(new BoxLayout(panelHabilidad,
				BoxLayout.X_AXIS));
		panelHabilidad.setBackground(Color.white);
		groupHabilidad = new ButtonGroup();
		
		ArrayList<AbstractFactoryHabilidad> nombres=nivel.getFabricasHabilidad();
		if(nombres!=null)
		for(int i=0;i<nombres.size();i++){
			JRadioButton habilidad = new JRadioButton(nombres.get(i).toString());
			habilidad.setBackground(Color.white);
			habilidad.setActionCommand(new Integer(i).toString());
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
		//super.add(panelHabilidad);
		crearProgressBar();
		super.getContentPane().add(escenario);

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// defino es la forma en que se acomodan los componentes
		super.getContentPane().setLayout( new BoxLayout(super.getContentPane(), BoxLayout.PAGE_AXIS));
		
		add(panelHabilidad);
		
		// tama�o de la ventana
		// ventana.setResizable(false);
		super.getContentPane().setBackground(Color.black);
		controlador=new Controlador(this.nivel,this);
		super.setPreferredSize(new Dimension(1050, 500));
		// preparo la venta
		super.pack();
	}
	
	public void actualizarVista() {
		
		int cantidadVivos=nivel.getPooglinsVivos().size();
		
		escenario.actualizar();
		
		
		if(cantidadVivos>this.pooglins.size()){
			
			
			Pooglin nuevoPooglin=nivel.getPooglinsVivos().get(cantidadVivos-1);
			
			VistaPooglin vistaPooglin=new VistaPooglin(nuevoPooglin);
			
			controlador.setPooglin(vistaPooglin,nuevoPooglin);
			
			pooglins.add(vistaPooglin);
			
			escenario.add(vistaPooglin);
			
			
		}
		
		for(int i=0;i<this.pooglins.size();i++){
			pooglins.get(i).actualizar();
			if((pooglins.get(i).getPooglin().EstaSalvado())||(pooglins.get(i).getPooglin().estaMuerto())){
				pooglins.get(i).borrar(); 
			 }
			
		}
	}
	public VistaPlaneta getVistaPlaneta(){
		return escenario;
	}
	public ButtonModel getSeleccionado(){
		
		return groupHabilidad.getSelection();
	}
	public void crearProgressBar(){
	     timerProgressBar = new Timer(1000,actualizarProgressBar);
	     timerProgressBar.start();
	     tiempo=nivel.getTiempo();
	     //progBarPanel = new JPanel();
	
	     progressBar = new JProgressBar(0, tiempo.getMinutosRestantes()*60);
	     progressBar.setStringPainted(true);     
	     add(progressBar);
	     //progBarPanel.add(progressBar);
	     //add(progBarPanel);
	}
	
	Action actualizarProgressBar = new AbstractAction() {
       /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	public void actionPerformed(ActionEvent e) //this inner class generates an exeption if the player takes to long to finish a level 
       {
           tiempo.setSegundosRestantes(tiempo.getSegundosRestantes() - 1);
           tiempo.setTiempoTrascurrido(tiempo.getTiempoTrascurrido() + 1);
           
           if(tiempo.getSegundosRestantes()<0)
           {
               tiempo.setSegundosRestantes(60);
               tiempo.setMinutosRestantes(tiempo.getMinutosRestantes() - 1); 
           }
       if(tiempo.getMinutosRestantes()==0 && tiempo.getSegundosRestantes()==0)
       {
       	timerProgressBar.stop();
       	JFrame frame = new JFrame("Warning");
           JOptionPane.showMessageDialog(frame, "Se ha acabado el tiempo. GAME OVER!");
           //Borrar toda la otra vista.
          // frame.dispose();
           pack();
           setVisible (true);  
           for (int i = 0; i<pooglins.size();i++){
               pooglins.get(i).getPooglin().morir();
           }
       }
           progressBar.setValue(tiempo.getTiempoTrascurrido());
           progressBar.setString(tiempo.getMinutosRestantes()+":"+tiempo.getSegundosRestantes());
       }
   };
}