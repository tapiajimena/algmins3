package VistaVentana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import juego.Planeta;
import punto.Punto;
import bloque.Bloque;

public class VistaPlaneta extends JPanel implements Observer {
	/**
	 * 
	 */
	private int					ancho, alto;

	private Planeta				planeta;
	private BufferedImage		fondo;
	private BufferedImage		frente;
	private static final long	serialVersionUID	= 1L;
	Color						last;

	private void pintarBloque(Bloque bloque) {
		Graphics2D gra = frente.createGraphics();
		switch (bloque.getLetra()) {
			case 'A':
				return;
			case 'T':
				gra.setColor(Color.green);
			break;
			case 'F':
				gra.setColor(Color.red);
			break;
			case 'R':
				gra.setColor(Color.gray);
			break;
		}
		gra.fillRect(10 * bloque.getPosicionY(), 10 * bloque.getPosicionX(),10, 10);
	}
	private void pintarFondo(){
		Graphics2D gra = fondo.createGraphics();
		gra.setColor(Color.cyan);
		gra.fillRect(0, 0, ancho,alto);
		
	}
	private void pintarPlaneta(){
		for (int i = 0; i < planeta.getAlto(); i++) {
			for (int j = 0; j < planeta.getAncho(); j++)
				try{
					pintarBloque(planeta.getBloque(new Punto(i, j)));
				}catch(Exception e){
					e.printStackTrace();
				}
					
		}
	}
	public VistaPlaneta(Planeta elPlaneta) {
		this.planeta = elPlaneta;
		alto = elPlaneta.getAlto()*10;
		ancho = elPlaneta.getAncho()*10;
		fondo = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_ARGB);
		frente = new BufferedImage(ancho, alto,BufferedImage.TYPE_INT_ARGB);
		
		pintarFondo();
		pintarPlaneta();
		
		Dimension dim = new Dimension(500,500);
		super.setPreferredSize(dim);
		super.setMaximumSize(dim);
		super.setMinimumSize(dim);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo, 0, 0, 500,500, 0, 0, ancho, alto, null);
		g.drawImage(frente, 0, 0, 500,500, 0, 0,ancho, alto, null);
		/*
		 * sirve para borrar parte de la imagen referenciada por gra Graphics2D
		 * gra = frente.createGraphics();
		 * gra.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
		 * gra.fillRect(50, 50, 200, 200);
		 */
	}

	public void update(Observable o, Object arg) {
			
	}
}