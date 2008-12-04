package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import modelo.Nivel;
import modelo.Pooglin;
import modelo.FactoryHabilidades.AbstractFactoryHabilidad;
import VistaVentana.VistaPooglin;

public class Controlador {
	private Nivel nivel;
	private JRadioButton botonSeleccionado = null;

	public Controlador(Nivel nivel) {
		this.nivel = nivel;
	}

	/*
	 * Asocia a este controlador el botonSeleccionHabilidad
	 */
	public void setControlador(JRadioButton botonSeleccionHabilidad) {
		botonSeleccionHabilidad.addActionListener(new EscuchaBoton());
	}

	private class EscuchaBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			botonSeleccionado = (JRadioButton) e.getSource();
			nivel.seleccionarHabilidad(botonSeleccionado.getActionCommand());
		}
	}

	/**/

	public void setPooglin(VistaPooglin vistaPooglin, Pooglin nuevoPooglin) {
		vistaPooglin.addMouseListener(new EscuchadorDePooglin(nuevoPooglin));
	}

	private class EscuchadorDePooglin implements MouseListener {
		private Pooglin pooglin;

		public EscuchadorDePooglin(Pooglin pooglin) {
			this.pooglin = pooglin;
		}

		public void mouseClicked(MouseEvent arg0) {
			AbstractFactoryHabilidad seleccionada = nivel
					.getHabilidadSeleccionada();
			if (seleccionada != null) {
				seleccionada.asignarHabilidad(pooglin);
				botonSeleccionado.setText(seleccionada.cantidadDisponible()
						+ "-" + seleccionada.toString());
			} else {
				JFrame frame = new JFrame("Warning");
				JOptionPane.showMessageDialog(frame,
						"No has seleccionado ninguna habilidad");
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
