package VistaVentana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

import juego.Planeta;
import punto.Punto;
import bloque.Bloque;

public class VistaPlaneta extends JPanel {
	/**
	 * 
	 */
	private int					ancho, alto;

	private Planeta				planeta;
	private BufferedImage		fondo;
	private BufferedImage		frente;
	private static final long	serialVersionUID	= 1L;
	Color						last;

	private void pintarBloque(Bloque bloque) throws IOException {
		Graphics2D gra = frente.createGraphics();
		
		switch (bloque.getLetra()) {
			case 'A': 
				return;
			case 'T':
				gra.drawImage(ImageIO.read(new File("T.png")), 20 * bloque.getPosicionY(), 20 * bloque.getPosicionX(),20+20 * bloque.getPosicionY(), 20+20 * bloque.getPosicionX(), 0, 0,32, 32, null);
			break;
			case 'F':
				gra.setColor(Color.red);gra.fillRect(20 * bloque.getPosicionY(), 20 * bloque.getPosicionX(),20, 20);
			break;
			case 'R':
				gra.setColor(Color.gray);gra.fillRect(20 * bloque.getPosicionY(), 20 * bloque.getPosicionX(),20, 20);
			break;
		}
		
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
		
		alto = elPlaneta.getAlto()*20;
		ancho = elPlaneta.getAncho()*20;
		System.out.println(alto +" "+ancho);
		fondo = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_ARGB);
		frente = new BufferedImage(ancho, alto,BufferedImage.TYPE_INT_ARGB);
		
		pintarFondo();
		pintarPlaneta();
		
		Dimension dim = new Dimension(ancho,alto);
		super.setPreferredSize(dim);
		super.setMaximumSize(dim);
		super.setMinimumSize(dim);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo, 0, 0, ancho,alto, 0, 0, ancho, alto, null);
		g.drawImage(frente, 0, 0, ancho,alto, 0, 0,ancho, alto, null);
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