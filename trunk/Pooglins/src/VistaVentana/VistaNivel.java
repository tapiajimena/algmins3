package VistaVentana;


import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import juego.Nivel;
import pooglin.Pooglin;
import Controlador.Controlador;
import abstractFactoryHabilidades.AbstractFactoryHabilidad;

public class VistaNivel extends JPanel  {
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
	private void cargarPanelHabilidad() {
		panelHabilidad = new JPanel();
		panelHabilidad.setLayout(new BoxLayout(panelHabilidad,BoxLayout.X_AXIS));
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
		escenario = new VistaPlaneta(nivel.getPlaneta());
		escenario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		escenario.setLayout(null);
		cargarPanelHabilidad();
		this.add(escenario);
		this.setLayout( new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(panelHabilidad);
		this.setBackground(Color.black);
		super.setPreferredSize(new Dimension(1050, 500));
	}
	
	public void actualizarVista() {
		int nroVivosModelo=nivel.cantidadDePooglinsVivos();
		escenario.actualizar();
		

		
		
		while(nroVivosModelo>this.pooglins.size()){			
			Pooglin nuevoPooglin=nivel.getPooglinsVivos().get(this.pooglins.size());
			VistaPooglin vistaPooglin=new VistaPooglin(nuevoPooglin);
			controlador.setPooglin(vistaPooglin,nuevoPooglin);
			pooglins.add(vistaPooglin);
			escenario.add(vistaPooglin);
		}
		for(int i=0;i<this.pooglins.size();i++){
			pooglins.get(i).actualizar();
			if((pooglins.get(i).getPooglin().EstaSalvado())||(pooglins.get(i).getPooglin().estaMuerto())){
				pooglins.get(i).borrar(); 
				pooglins.remove(i);
			 }
			
		}
		ButtonModel boton=groupHabilidad.getSelection();
		if(boton!=null){
			int i=Integer.parseInt(boton.getActionCommand());
			JRadioButton botonRadio=(JRadioButton)panelHabilidad.getComponent(i);
			botonRadio.setText(nivel.getFabricasHabilidad().get(i).cantidadDisponible()+"-"+nivel.getFabricasHabilidad().get(i).toString());
		}
		
		if(((nivel.getCantSalvados() + nivel.getCantMuertos())==(nivel.getCantInicialPooglins()))){ 
		estadisticas();
	}
		
		
	}
	public VistaPlaneta getVistaPlaneta(){
		return escenario;
	}
	public ButtonModel getSeleccionado(){
		return groupHabilidad.getSelection();
	}

    public void estadisticas(){
		
        JOptionPane.showMessageDialog(this, "Se han salvado: "+nivel.getCantSalvados()+"  Lamentablemente murieron: "+nivel.getCantMuertos());
	   
   }
	

 
}