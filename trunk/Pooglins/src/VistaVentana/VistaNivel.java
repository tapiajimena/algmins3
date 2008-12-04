package VistaVentana;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JProgressBar;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modelo.Nivel;
import modelo.Pooglin;
import modelo.FactoryHabilidades.AbstractFactoryHabilidad;

import Controlador.Controlador;

public class VistaNivel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelHabilidad;
	private ButtonGroup groupHabilidad;
	private VistaPlaneta escenario;
	private Nivel nivel;
	private ArrayList<VistaPooglin> pooglins;
	private Controlador controlador;
	private JProgressBar progressBar;

	/*
	 * Recibe un conjunto de las habilidades permitidas en el nivel para generar
	 * el panel de opciones de las habilidades
	 */
	private void cargarPanelHabilidad() {
		panelHabilidad
				.setLayout(new BoxLayout(panelHabilidad, BoxLayout.X_AXIS));
		panelHabilidad.setBackground(Color.white);
		groupHabilidad = new ButtonGroup();
		ArrayList<AbstractFactoryHabilidad> listaFabricasHabilidad = nivel
				.getFabricasHabilidad();
		if (listaFabricasHabilidad != null)
			for (int i = 0; i < listaFabricasHabilidad.size(); i++) {
				JRadioButton habilidad = new JRadioButton(
						listaFabricasHabilidad.get(i).cantidadDisponible()
								+ "-"
								+ listaFabricasHabilidad.get(i).toString());
				habilidad.setBackground(Color.white);
				habilidad.setActionCommand(listaFabricasHabilidad.get(i)
						.toString());
				controlador.setControlador(habilidad);
				groupHabilidad.add(habilidad);
				panelHabilidad.add(habilidad);
			}
	}

	public VistaNivel(Nivel nivel) {
		super();
		this.pooglins = new ArrayList<VistaPooglin>();
		this.nivel = nivel;
		controlador = new Controlador(this.nivel);
		escenario = new VistaPlaneta(nivel.getPlaneta());
		escenario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		escenario.setLayout(null);
		progressBar = new JProgressBar(0, nivel.getTiempoTotal());
		progressBar.setStringPainted(true);
		add(progressBar);
		panelHabilidad = new JPanel();
		cargarPanelHabilidad();
		this.add(escenario);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(panelHabilidad);
		this.setBackground(Color.black);
		super.setPreferredSize(new Dimension(1050, 500));
	}

	private void actualizarProgress() {
		int segundos = nivel.getTiempoTotal() - nivel.getTiempo();
		progressBar.setValue(segundos);
		progressBar.setString((segundos / 60) + ":" + (segundos % 60));
	}

	public void actualizarVista() {
		int nroVivosModelo = nivel.cantidadDePooglinsVivos();
		escenario.actualizar();
		actualizarProgress();
		while (nroVivosModelo > this.pooglins.size()) {
			Pooglin nuevoPooglin = nivel.getPooglinsVivos().get(
					this.pooglins.size());
			VistaPooglin vistaPooglin = new VistaPooglin(nuevoPooglin);
			controlador.setPooglin(vistaPooglin, nuevoPooglin);
			pooglins.add(vistaPooglin);
			escenario.add(vistaPooglin);
		}
		for (int i = 0; i < this.pooglins.size(); i++) {
			pooglins.get(i).actualizar();
			if ((pooglins.get(i).getPooglin().EstaSalvado())
					|| (pooglins.get(i).getPooglin().estaMuerto())) {
				pooglins.get(i).borrar();
				pooglins.remove(i);
			}
		}

	}
}
