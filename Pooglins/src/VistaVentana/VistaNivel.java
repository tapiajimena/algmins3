package VistaVentana;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import abstractFactoryHabilidades.AbstractFactoryHabilidad;

import Controlador.Controlador;
import juego.Nivel;
import juego.TiempoNivel;
import pooglin.Pooglin;

public class VistaNivel extends JFrame implements ActionListener {
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
	private JMenuItem opcionNuevoJuego;
	private JMenuItem opcionAbrir;
	private JMenuItem opcionGuardar;
	private JMenuItem opcionDeSalida;
	private JMenu menu;
	private JMenuBar barraDeMenu;


	private void cargarPanelHabilidad() {
		panelHabilidad = new JPanel();
		panelHabilidad.setLayout(new BoxLayout(panelHabilidad,
				BoxLayout.X_AXIS));
		panelHabilidad.setBackground(Color.white);
		groupHabilidad = new ButtonGroup();
		
		ArrayList<AbstractFactoryHabilidad> listaFabricasHabilidad=nivel.getFabricasHabilidad();
		if(listaFabricasHabilidad!=null)
		for(int i=0;i<listaFabricasHabilidad.size();i++){
			JRadioButton habilidad = new JRadioButton(listaFabricasHabilidad.get(i).cantidadDisponible()+"-"+listaFabricasHabilidad.get(i).toString());
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
		controlador=new Controlador(this.nivel,this);
		super.setTitle("Pooglins "+nivel.getNombre());
		escenario = new VistaPlaneta(nivel.getPlaneta());
		escenario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		escenario.setLayout(null);

		// add funciona como pila L-A-F-P
		//crear
		barraMenu();
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
		
		super.setPreferredSize(new Dimension(1050, 500));
		// preparo la venta
		super.pack();
	}
	
	public void barraMenu(){		
	
		opcionNuevoJuego = new JMenuItem("Juego Nuevo");
		opcionNuevoJuego.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		
		opcionAbrir = new JMenuItem("Abrir");
		opcionAbrir.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_A, KeyEvent.CTRL_MASK));
		
		opcionGuardar = new JMenuItem("Guardar");
		opcionGuardar.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_G, KeyEvent.CTRL_MASK));
		opcionGuardar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		opcionDeSalida = new JMenuItem("Salir");
		//crtl+S sale del juego
		opcionDeSalida.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_S, KeyEvent.CTRL_MASK));
	
		opcionNuevoJuego.setActionCommand("Nuevo");
		opcionNuevoJuego.addActionListener(this);
		
		opcionAbrir.setActionCommand("Abrir");
		opcionAbrir.addActionListener(this);
	    
		opcionGuardar.setActionCommand("Guardar");
		opcionGuardar.addActionListener(this);
		
		opcionDeSalida.setActionCommand("Salir");
		opcionDeSalida.addActionListener(this);
		
		 menu = new JMenu("Archivo");
		 menu.add(opcionNuevoJuego);
		 menu.add(opcionAbrir);
		 menu.add(opcionGuardar);
		 menu.add(opcionDeSalida);
		 
		 barraDeMenu = new JMenuBar();
		 barraDeMenu.add(menu);
	     setJMenuBar(barraDeMenu);
	
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
		ButtonModel boton=groupHabilidad.getSelection();
		if(boton!=null){
			int i=Integer.parseInt(boton.getActionCommand());
			JRadioButton botonRadio=(JRadioButton)panelHabilidad.getComponent(i);
			botonRadio.setText(nivel.getFabricasHabilidad().get(i).cantidadDisponible()+"-"+nivel.getFabricasHabilidad().get(i).toString());
		}
		
	}
	public VistaPlaneta getVistaPlaneta(){
		return escenario;
	}
	public ButtonModel getSeleccionado(){
		
		return groupHabilidad.getSelection();
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
					for (int i = 0; i < pooglins.size(); i++) {
						pooglins.get(i).getPooglin().morir();
					}
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
	
	

   public void actionPerformed(ActionEvent e)
   {
       if (e.getActionCommand().equals("Salir"))
       {
            System.exit(0);  
       }
       else if (e.getActionCommand().equals("Nuevo"))
       {
 
       }
       else if(e.getActionCommand().equals("Guardar"))
       {
        
       }
       else if(e.getActionCommand().equals("Open"))
       {
           JFileChooser chooser = new JFileChooser();
           int returnVal = chooser.showOpenDialog(this);
           if(returnVal == JFileChooser.APPROVE_OPTION) 
           {
             

           }
        }
    }
}