package VistaVentana;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VistaPlaneta extends JPanel{
	/**
	 * 
	 */
	private BufferedImage imagen;
	private static final long serialVersionUID = 1L;
	public VistaPlaneta(){
		try{
			imagen= ImageIO.read(new File("stars.jpg"));
		}catch(IOException e){
			e.printStackTrace();
		};
		Dimension dim=new Dimension(400,400);
		super.setPreferredSize(dim);
		super.setMaximumSize(dim);
		super.setMinimumSize(dim);
	}
	public void paintComponent(Graphics g){
		   /*llamada al padre para habilitar look n feel , es necesario?*/
		   super.paintComponent(g);
		   g.drawImage(imagen, 0, 0,400,400,0,0,116,116, null);
	}
}