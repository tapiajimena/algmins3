package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import abstractFactoryHabilidades.AbstractFactoryHabilidad;

import pooglin.Pooglin;

import VistaVentana.VistaNivel;
import VistaVentana.VistaPooglin;
import juego.Nivel;

public class Controlador {
	private Nivel nivel;
	private VistaNivel vistaNivel;
	
	public Controlador(){
		
	}

	public Controlador(Nivel nivel, VistaNivel vistaNivel){
		this.nivel=nivel;
		this.vistaNivel=vistaNivel;
	}

	
	public void setPooglin(VistaPooglin vistaPooglin, Pooglin nuevoPooglin) {
		
		vistaPooglin.addMouseListener(new EscuchadorDePooglin (nuevoPooglin));
		
	}
	public void setEscuchaHabilidad(JRadioButton boton,AbstractFactoryHabilidad fabrica){
		boton.addActionListener(new EscuchaOpcionesHabilidades(fabrica));
	};
	private class EscuchaOpcionesHabilidades implements ActionListener{
		private AbstractFactoryHabilidad fabrica;
		public EscuchaOpcionesHabilidades(AbstractFactoryHabilidad fabrica){
			this.fabrica=fabrica;
		}
		public void actionPerformed(ActionEvent e) {
			JRadioButton botonHabilidad=(JRadioButton)e.getSource();
			String texto=fabrica.toString()+" "+fabrica.cantidadDisponible();
			botonHabilidad.setText(texto);
		}
		
	}
	
	private class EscuchadorDePooglin implements MouseListener{
		private Pooglin pooglin;

		public EscuchadorDePooglin(Pooglin pooglin){
			this.pooglin=pooglin;
		}
		
		public void mouseClicked(MouseEvent arg0) {
			
			JRadioButton boton=(JRadioButton)vistaNivel.getSeleccionado();
			if(boton!=null){
				int i=Integer.parseInt(boton.getActionCommand());
				nivel.getFabricasHabilidad().get(i).asignarHabilidad(pooglin);		
			}else {
				 JFrame frame = new JFrame("Warning");
	             JOptionPane.showMessageDialog(frame, "No has seleccionado ninguna habilidad");
			}
		}

		public void mouseEntered(MouseEvent arg0) {
		}

		public void mouseExited(MouseEvent arg0) {
		}

		public void mousePressed(MouseEvent arg0) {
		}

		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	};
}
