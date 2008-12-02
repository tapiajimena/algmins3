package VistaVentana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



import javax.imageio.ImageIO;
import javax.swing.JPanel;

import modelo.Planeta;
import modelo.Punto;
import modelo.bloque.Bloque;


public class VistaPlaneta extends JPanel {
	/**
	 * 
	 */
	private int					ancho, alto;
	private Planeta				planeta;
	private BufferedImage		fondo;
	private ArrayList<BufferedImage> listaDeImagenes;
	private BufferedImage		frente;
	private static final long	serialVersionUID	= 1L;
	Color						last;
	public void cargarListaImagenes() throws IOException{
		/*
		 * Aca Cargamos imagenes a una lista de BufferedImage, esto
		 * esta hecho asi ya que cargando una vez todo a una lista 
		 * se hace mas rapido cada vez que actualizamos la vista del planeta
		 * que leyendo cada vez del disco.
		 * Por ahi existen otras formas mejores, en internet buscamos
		 * y decia que el metodo drawImage() y leyendo una imagen
		 * era siempre lento.
		 * 
		 */
		listaDeImagenes.add( ImageIO.read(new File( "K.gif")));
		listaDeImagenes.add( ImageIO.read(new File( "B.png")));
		listaDeImagenes.add( ImageIO.read(new File( "F.png")));
		listaDeImagenes.add( ImageIO.read(new File( "P.gif")));
		listaDeImagenes.add( ImageIO.read(new File( "E.gif")));
		listaDeImagenes.add( ImageIO.read(new File( "O.png")));
		listaDeImagenes.add( ImageIO.read(new File( "H.png")));
	
	}
	
	private void pintarBloque(Bloque bloque) throws IOException {
		Graphics2D gra = frente.createGraphics();
		
		switch (bloque.getLetra()) {
			case 'A': 
				gra.drawImage(listaDeImagenes.get(0), 20 * bloque.getPosicionY(), 20 * bloque.getPosicionX(),20+20 * bloque.getPosicionY(), 20+20 * bloque.getPosicionX(), 0, 0,32, 32, null);
				return;
			case 'T':
				gra.drawImage(listaDeImagenes.get(1), 20 * bloque.getPosicionY(), 20 * bloque.getPosicionX(),20+20 * bloque.getPosicionY(), 20+20 * bloque.getPosicionX(), 0, 0,32, 32, null);
				break;
			case 'F':
				gra.drawImage(listaDeImagenes.get(2), 20 * bloque.getPosicionY(), 20 * bloque.getPosicionX(),20+20 * bloque.getPosicionY(), 20+20 * bloque.getPosicionX(), 0, 0,32, 32, null);
				break;
			case 'R':
				gra.drawImage(listaDeImagenes.get(3), 20 * bloque.getPosicionY(), 20 * bloque.getPosicionX(),20+20 * bloque.getPosicionY(), 20+20 * bloque.getPosicionX(), 0, 0,32, 32, null);
				break;
			case 'S':
				gra.drawImage(listaDeImagenes.get(4), 20 * bloque.getPosicionY(), 20 * bloque.getPosicionX(),20+20 * bloque.getPosicionY(), 20+20 * bloque.getPosicionX(), 0, 0,32, 32, null);
				break;
			case 'O':
				gra.drawImage(listaDeImagenes.get(5), 20 * bloque.getPosicionY(), 20 * bloque.getPosicionX(),20+20 * bloque.getPosicionY(), 20+20 * bloque.getPosicionX(), 0, 0,32, 32, null);
				break;
			case 'H':
				gra.drawImage(listaDeImagenes.get(6), 20 * bloque.getPosicionY(), 20 * bloque.getPosicionX(),20+20 * bloque.getPosicionY(), 20+20 * bloque.getPosicionX(), 0, 0,32, 32, null);
				break;
			case 'B':
				gra.drawImage(listaDeImagenes.get(1), 20 * bloque.getPosicionY(), 20 * bloque.getPosicionX(),20+20 * bloque.getPosicionY(), 20+20 * bloque.getPosicionX(), 0, 0,32, 32, null);
				break;
			}
	}
	
	private void pintarFondo(){
		Graphics2D gra = fondo.createGraphics();
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
		listaDeImagenes=new ArrayList<BufferedImage>();//ADD
		try {
			cargarListaImagenes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		alto = elPlaneta.getAlto()*20;
		ancho = elPlaneta.getAncho()*20;
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
	}
	
	public void actualizar(){
		pintarPlaneta();
	}
}